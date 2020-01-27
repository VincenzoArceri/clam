package it.univr.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import dnl.utils.text.table.TextTable;
import it.univr.domain.AbstractDomain;
import it.univr.domain.safe.original.SAFEAbstractDomain;
import it.univr.domain.safe.original.SAFEStrings;
import it.univr.domain.safe.shell.SAFEShellAbstractDomain;
import it.univr.domain.safe.shell.SAFEShellStrings;
import it.univr.domain.tajs.original.TAJSAbstractDomain;
import it.univr.domain.tajs.original.TAJSStrings;
import it.univr.domain.tajs.shell.TAJSShellAbstractDomain;
import it.univr.domain.tajs.shell.TAJSShellStrings;
import it.univr.state.AbstractEnvironment;
import it.univr.state.AbstractState;
import it.univr.state.KeyAbstractState;
import it.univr.state.Variable;

public class Analyzer {

	public static void main(String[] args) throws IOException {
		System.out.println(potd());
		String file = args[0];

		boolean narrowing = false;
		boolean printInvariants = true;
		boolean tajsComparison = false;
		boolean safeComparison = false;

		AbstractDomain domain = new SAFEAbstractDomain();

		for (int i = 0; i < args.length; ++i) {
			if (args[i].equals("-narr"))
				narrowing = true;
			else if (args[i].equals("-tajs"))
				domain = new TAJSAbstractDomain();
			else if (args[i].equals("-safe"))
				domain = new SAFEAbstractDomain();
			else if (args[i].equals("-tajs-shell"))
				domain = new TAJSShellAbstractDomain();
			else if (args[i].equals("-safe-shell"))
				domain = new SAFEShellAbstractDomain();
			else if (args[i].equals("-help")) {
				System.out.println(potd()  + "\n\n" + printHelp());
				return;
			}

			else if (args[i].equals("-invariants")) {
				printInvariants = true;
			}

			else if (args[i].equals("-tajs-comp"))
				tajsComparison = true;

			else if (args[i].equals("-safe-comp"))
				safeComparison = true;
		}

		AbstractEnvironment env = null;
		AbstractState state = null;

		try {

			if (tajsComparison) {
				AbstractState tajs = Analyzer.analyzeInvariants(file, new TAJSAbstractDomain(), narrowing);
				AbstractState tajsShell = Analyzer.analyzeInvariants(file, new TAJSShellAbstractDomain(), narrowing);
				printTAJSComparison(tajs, tajsShell);
				return;
			}

			if (safeComparison) {
				AbstractState safe = Analyzer.analyzeInvariants(file, new SAFEAbstractDomain(), narrowing);
				AbstractState safeShell = Analyzer.analyzeInvariants(file, new SAFEShellAbstractDomain(), narrowing);
				printSAFEComparison(safe, safeShell);
				return;
			}


			if (printInvariants) {
				state = Analyzer.analyzeInvariants(file, domain, narrowing);
				System.out.println("\n\n\n");
				System.out.println(state);
			} else {
				env = Analyzer.analyze(file, domain, narrowing);
				System.out.println("\n\n\n");
				System.out.println(env);
			}
		} catch (FileNotFoundException f) {
			System.out.println(printHelp());
		}
	}

	private static void printTAJSComparison(AbstractState tajs, AbstractState tajsShell) {

		String[] columns = {"Variable", "TAJS original domain", "TAJS shell domain", "Precision increment"};

		int tajsPrecisionEntropy = 0;
		int tajsShellPrecisionEntropy = 0;

		for (KeyAbstractState k : tajs.keySet()) {
			System.out.println("Abstract state at Line " + k.getRow() +", Column " + k.getCol() + "\n");
			int n = tajs.get(k).getStore().keySet().size();
			String[][] t = new String[n][4];
			int i = 0;
			
		
			for (Variable v : tajs.get(k).getStore().keySet()) {
				t[i][0] = v.toString();
				t[i][1] = tajs.get(k).getStore().getValue(v).toString();
				t[i][2] = tajsShell.get(k).getStore().getValue(v).toString();
				
				tajsPrecisionEntropy += tajs.get(k).getStore().getValue(v).distanceFromBottom();
				tajsShellPrecisionEntropy += tajsShell.get(k).getStore().getValue(v).distanceFromBottom();
				
				int entropy = tajs.get(k).getStore().getValue(v).distanceFromBottom() - tajsShell.get(k).getStore().getValue(v).distanceFromBottom();
				t[i][3] = String.valueOf((entropy == 0 ? "-" : entropy)) ;
				i++;
			}

			TextTable table = new TextTable(columns, t);
			table.printTable();
			System.out.println("\n");

		}
		
		System.out.println("TAJS string precision entropy: " + tajsPrecisionEntropy);
		System.out.println("TAJS shell string precision entropy: " + tajsShellPrecisionEntropy);
	}
	
	private static void printSAFEComparison(AbstractState safe, AbstractState safeShell) {

		String[] columns = {"Variable", "SAFE original domain", "SAFE shell domain", "Precision increment"};

		int safePrecisionEntropy = 0;
		int safeShellPrecisionEntropy = 0;

		for (KeyAbstractState k : safe.keySet()) {
			System.out.println("Abstract state at Line " + k.getRow() +", Column " + k.getCol() + "\n");
			int n = safe.get(k).getStore().keySet().size();
			String[][] t = new String[n][4];
			int i = 0;
			
			for (Variable v : safe.get(k).getStore().keySet()) {
				t[i][0] = v.toString();
				t[i][1] = safe.get(k).getStore().getValue(v).toString();
				t[i][2] = safeShell.get(k).getStore().getValue(v).toString();

				safePrecisionEntropy += safe.get(k).getStore().getValue(v).distanceFromBottom();
				safeShellPrecisionEntropy += safeShell.get(k).getStore().getValue(v).distanceFromBottom();
				
				int entropy = safe.get(k).getStore().getValue(v).distanceFromBottom() - safeShell.get(k).getStore().getValue(v).distanceFromBottom();
				t[i][3] = String.valueOf((entropy == 0 ? "-" : entropy)) ;
				
				
				t[i][3] = safeShell.get(k).getStore().getValue(v).distanceFrom(safe.get(k).getStore().getValue(v));
				i++;
			}

			TextTable table = new TextTable(columns, t);
			table.printTable();
			System.out.println("\n");
		}
		
		System.out.println("SAFE string precision entropy: " + safePrecisionEntropy);
		System.out.println("SAFE string shell precision entropy: " + safeShellPrecisionEntropy);
	}

	public static AbstractEnvironment analyze(String file, AbstractDomain domain, boolean narrowing) throws IOException {
		AbstractInterpreter interpreter = new AbstractInterpreter(domain, narrowing, false);

		interpreter.setAbstractDomain(domain);
		InputStream stream = new FileInputStream(file);

		MuJsLexer lexer = new MuJsLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));

		MuJsParser parser = new MuJsParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.program();
		interpreter.visit(tree);

		return interpreter.getFinalAbstractMemory();
	}

	public static AbstractState analyzeInvariants(String file, AbstractDomain domain, boolean narrowing) throws IOException {
		AbstractInterpreter interpreter = new AbstractInterpreter(domain, narrowing, true);

		interpreter.setAbstractDomain(domain);
		InputStream stream = new FileInputStream(file);
		MuJsLexer lexer = new MuJsLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));

		MuJsParser parser = new MuJsParser(new CommonTokenStream(lexer));
		ParseTree tree = parser.program();
		interpreter.visit(tree);

		return interpreter.getAbstractState();
	}

	private static String printHelp() {
		String result = "";
		result += "MuJS static analyzer.\n";
		result += "Usage:";
		result +="java -jar mujs.jar <file> (<opt>)*\n\n";
		result +="where <opt> is one of:\n\n";
		result += "\t -narr \t\t\t enables narrowing operator (default: disabled)\n";
		result += "\t -widening n \t\t set the parametric widening to n\n";
		result += "\t -coalesced \t\t enable the coalesced sum abstract domain (default)\n";
		result += "\t -lifted \t\t enable the lifted union abstract domain\n";
		result += "\t -invarians \t\t prints the invariants for each statement program point.\n";
		result += "\t\t\t\t By default, it prints only the memory holding at the end of the abstract execution\n";
		result += "\t -help \t\t\t print the menu\n";

		return result;
	}

	private static String potd() {
		return "MMMMMMMM               MMMMMMMM                            JJJJJJJJJJJ   SSSSSSSSSSSSSSS \n" +
				"M:::::::M             M:::::::M                            J:::::::::J SS:::::::::::::::S\n"+
				"M::::::::M           M::::::::M                            J:::::::::JS:::::SSSSSS::::::S\n"+
				"M:::::::::M         M:::::::::M                            JJ:::::::JJS:::::S     SSSSSSS\n"+
				"M::::::::::M       M::::::::::Muuuuuu    uuuuuu              J:::::J  S:::::S            \n"+
				"M:::::::::::M     M:::::::::::Mu::::u    u::::u              J:::::J  S:::::S            \n"+
				"M:::::::M::::M   M::::M:::::::Mu::::u    u::::u              J:::::J   S::::SSSS         \n"+
				"M::::::M M::::M M::::M M::::::Mu::::u    u::::u              J:::::j    SS::::::SSSSS    \n"+
				"M::::::M  M::::M::::M  M::::::Mu::::u    u::::u              J:::::J      SSS::::::::SS  \n"+
				"M::::::M   M:::::::M   M::::::Mu::::u    u::::u  JJJJJJJ     J:::::J         SSSSSS::::S \n"+
				"M::::::M    M:::::M    M::::::Mu::::u    u::::u  J:::::J     J:::::J              S:::::S\n"+
				"M::::::M     MMMMM     M::::::Mu:::::uuuu:::::u  J::::::J   J::::::J              S:::::S\n"+
				"M::::::M               M::::::Mu:::::::::::::::uuJ:::::::JJJ:::::::J  SSSSSSS     S:::::S\n"+
				"M::::::M               M::::::M u:::::::::::::::u JJ:::::::::::::JJ   S::::::SSSSSS:::::S\n"+
				"M::::::M               M::::::M  uu::::::::uu:::u   JJ:::::::::JJ     S:::::::::::::::SS \n"+
				"MMMMMMMM               MMMMMMMM    uuuuuuuu  uuuu     JJJJJJJJJ        SSSSSSSSSSSSSSS\n";
	}
}
