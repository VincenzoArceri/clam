package it.univr.domain.safe.original;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.safe.original.Interval;
import it.univr.domain.safe.original.SAFEAbstractDomain;
import it.univr.domain.safe.original.SAFEStrings;
import it.univr.domain.safe.original.Top;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class SAFEIfTest {

	private SAFEAbstractDomain domain = new SAFEAbstractDomain();


	@Test
	public void testIf001() throws Exception {
		String file = "src/test/resources/if/if001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("1", "1"));
	}

	@Test
	public void testIf002() throws Exception {
		String file = "src/test/resources/if/if002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("a")), new Interval("0", "+Inf"));
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
		Assert.assertEquals(state.getValue(new Variable("x")), SAFEStrings.createNotNumeric());
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "+Inf"));
	}

	@Test
	public void testIf004() throws Exception {
		String file = "src/test/resources/if/if004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("2", "2"));
	}

	@Test
	public void testIf005() throws Exception {
		String file = "src/test/resources/if/if005.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("2", "2"));
	}	

	@Test
	public void testIf006() throws Exception {
		String file = "src/test/resources/if/if006.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0", "0"));
	}	

	@Test
	public void testIf007() throws Exception {
		String file = "src/test/resources/if/if007.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("1", "1"));
	}

	@Test
	public void testIf008() throws Exception {
		String file = "src/test/resources/if/if008.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("a")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("str")), new SAFEStrings("helloworld"));
		Assert.assertEquals(state.getValue(new Variable("c")), SAFEStrings.createNotNumeric());
	}

	@Test
	public void testIf009() throws Exception {
		String file = "src/test/resources/if/if009.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("a")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("str")), SAFEStrings.createNotNumeric());
	}

	@Test
	public void testIf010() throws Exception {
		String file = "src/test/resources/if/if010.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("str")),  SAFEStrings.createNotNumeric());
	}
	
	@Test
	public void testIf011() throws Exception {
		String file = "src/test/resources/if/if011.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 0);
		
		// State values
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("str")),  SAFEStrings.createNotNumeric());
		Assert.assertEquals(state.getValue(new Variable("z")),  new Interval("0", "0"));
	}
}
