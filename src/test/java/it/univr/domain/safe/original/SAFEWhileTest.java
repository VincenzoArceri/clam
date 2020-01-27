package it.univr.domain.safe.original;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.safe.original.Interval;
import it.univr.domain.safe.original.SAFEAbstractDomain;
import it.univr.domain.safe.original.SAFEStrings;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class SAFEWhileTest {

	private SAFEAbstractDomain domain = new SAFEAbstractDomain();

	@Test
	public void testWhile001() throws Exception {
		String file = "src/test/resources/while/while001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0", "+Inf"));
	}

	@Test
	public void testWhile002() throws Exception {
		String file = "src/test/resources/while/while002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), SAFEStrings.createNotNumeric());
	}

	@Test
	public void testWhile003() throws Exception {
		String file = "src/test/resources/while/while003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new SAFEStrings(""));
	}

	@Test
	public void testWhile004() throws Exception {
		String file = "src/test/resources/while/while004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("-Inf", "100"));
	}	

	@Test
	public void testWhile005() throws Exception {
		String file = "src/test/resources/while/while005.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("0", "+Inf"));
	}


	@Test
	public void testWhile006() throws Exception {
		String file = "src/test/resources/while/while006.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("0", "+Inf"));
	}
}
