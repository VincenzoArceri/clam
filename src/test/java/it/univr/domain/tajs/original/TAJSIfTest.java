package it.univr.domain.tajs.original;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.safe.original.Interval;
import it.univr.domain.safe.original.SAFEStrings;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class TAJSIfTest {

	private TAJSAbstractDomain domain = new TAJSAbstractDomain();


	@Test
	public void testIf001() throws Exception {
		String file = "src/test/resources/if/if001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new TAJSNumbers(1));
	}

	@Test
	public void testIf002() throws Exception {
		String file = "src/test/resources/if/if002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("a")), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
		Assert.assertEquals(state.getValue(new Variable("x")), new Top());
	}

	@Test
	public void testIf003() throws Exception {
		String file = "src/test/resources/if/if003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), TAJSStrings.createNotUnsignedString());
		Assert.assertEquals(state.getValue(new Variable("y")), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
		Assert.assertEquals(state.getValue(new Variable("i")), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
	}

	@Test
	public void testIf004() throws Exception {
		String file = "src/test/resources/if/if004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new TAJSNumbers(2));
	}

	@Test
	public void testIf005() throws Exception {
		String file = "src/test/resources/if/if005.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new TAJSNumbers(2));
	}	

	@Test
	public void testIf006() throws Exception {
		String file = "src/test/resources/if/if006.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new TAJSNumbers(0));
	}	

	@Test
	public void testIf007() throws Exception {
		String file = "src/test/resources/if/if007.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new TAJSNumbers(1));
	}

	@Test
	public void testIf008() throws Exception {
		String file = "src/test/resources/if/if008.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("a")), TAJSNumbers.createUnsigned());
		Assert.assertEquals(state.getValue(new Variable("str")), new TAJSStrings("helloworld"));
		Assert.assertEquals(state.getValue(new Variable("c")), TAJSStrings.createNotUnsignedString());
	}

	@Test
	public void testIf009() throws Exception {
		String file = "src/test/resources/if/if009.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("a")), TAJSNumbers.createUnsigned());
		Assert.assertEquals(state.getValue(new Variable("str")),  TAJSStrings.createNotUnsignedString());
	}

	@Test
	public void testIf010() throws Exception {
		String file = "src/test/resources/if/if010.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("i")), TAJSNumbers.createUnsigned());
		Assert.assertEquals(state.getValue(new Variable("str")),  TAJSStrings.createNotUnsignedString());
	}
	
	@Test
	public void testIf011() throws Exception {
		String file = "src/test/resources/if/if011.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 0);
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("i")), TAJSNumbers.createUnsigned());
		Assert.assertEquals(state.getValue(new Variable("str")),  TAJSStrings.createNotUnsignedString());
		Assert.assertEquals(state.getValue(new Variable("z")),  TAJSNumbers.createTopTAJSNumber());
	}
}
