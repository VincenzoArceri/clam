package it.univr.domain.safe.original;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.safe.original.Interval;
import it.univr.domain.safe.original.SAFEAbstractDomain;
import it.univr.domain.safe.original.SAFEStrings;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class SAFEConcatTest {
	private SAFEAbstractDomain domain = new SAFEAbstractDomain();

	private String path = "src/test/resources/concat/";
	
	@Test
	public void testConcat001() throws Exception {
		String file = path + "concat001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new SAFEStrings("12"));
	}
	
	@Test
	public void testConcat002() throws Exception {
		String file = path + "concat002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.sizeStore(), 4);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new SAFEStrings("12"));
		Assert.assertEquals(state.getValue(new Variable("y")), new SAFEStrings("35"));
		Assert.assertEquals(state.getValue(new Variable("z")), SAFEStrings.createNumeric());
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "+Inf"));
	}
	
	@Test
	public void testConcat003() throws Exception {
		String file = path + "concat003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.sizeStore(), 4);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new SAFEStrings("12"));
		Assert.assertEquals(state.getValue(new Variable("y")), new SAFEStrings("g5"));
		Assert.assertEquals(state.getValue(new Variable("z")), SAFEStrings.createTopString());
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "+Inf"));
	}
	

	@Test
	public void testConcat004() throws Exception {
		String file = path + "concat004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.sizeStore(), 4);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new SAFEStrings("d2"));
		Assert.assertEquals(state.getValue(new Variable("y")), new SAFEStrings("g5"));
		Assert.assertEquals(state.getValue(new Variable("z")), SAFEStrings.createNotNumeric());
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "+Inf"));
	}
	
	@Test
	public void testConcat005() throws Exception {
		String file = path + "concat005.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), SAFEStrings.createTopString());
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "+Inf"));
	}
}
