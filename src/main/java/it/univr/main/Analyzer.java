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
import it.univr.domain.safe.shell.SAFEShellAbstractDomain;
import it.univr.domain.tajs.original.TAJSAbstractDomain;
import it.univr.domain.tajs.shell.TAJSShellAbstractDomain;
import it.univr.state.AbstractEnvironment;
import it.univr.state.AbstractState;
import it.univr.state.KeyAbstractState;
import it.univr.state.Variable;

public class Analyzer {

	public static void main(String[] args) throws IOException {
		System.out.println(potd());

		if (args.length == 0) {
			System.out.println(printHelp());
			return;
		}
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
		result += "MuDyn static analyzer\n";
		result += "Usage:";
		result +=" java -jar mudyn.jar <file> (<opt>)*\n\n";
		result +="where <opt> is one of:\n\n";
		result += "\t -tajs \t\t\t set the TAJS string abstract domain (default)\n";
		result += "\t -safe \t\t\t set the SAFE string abstract domain \n";
		result += "\t -tajs-shell \t\t set the TAJS complete shell string abstract domain\n";
		result += "\t -safe-shell \t\t set the SAFE complete shell string abstract domain \n";
		result += "\t -tajs-comp \t\t performs the analysis with both the TAJS string domain and its complete shell (showing precision entropy information)\n";
		result += "\t -safe-comp \t\t performs the analysis with both the SAFE string domain and its complete shell (showing precision entropy information)\n";
		result += "\t -invarians \t\t prints the invariants for each program point.\n";
		result += "\t\t\t\t By default, it prints only the abstract state holding at the exit program point\n";
		result += "\t -help \t\t\t print the help menu\n";

		return result;
	}

	private static String potd() {
		return 
				"___  ___     ______             \n"+
				"|  \\/  |     |  _  \\           \n"+ 
				"| .  . |_   _| | | |_   _ _ __ \n"+ 
				"| |\\/| | | | | | | | | | | '_ \\ \n"+
				"| |  | | |_| | |/ /| |_| | | | |\n"+
				"\\_|  |_/\\__,_|___/  \\__, |_| |_|\n"+
				"                     __/ |      \n"+
				"                    |___/       \n";
	}
}
