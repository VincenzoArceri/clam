package it.univr.domain.tajs.original;

import org.junit.Assert;
import org.junit.Test;

import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class TAJSNumbersTest {

	private TAJSAbstractDomain domain = new TAJSAbstractDomain();
	
	@Test
	public void testSum001() throws Exception {
		String file = "src/test/resources/intervals/sum001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 0);
	
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new TAJSNumbers(7));
		Assert.assertEquals(state.getValue(new Variable("y")), new TAJSNumbers(3));
		Assert.assertEquals(state.getValue(new Variable("z")), new TAJSNumbers(-15));
	}
	
	@Test
	public void testSum002() throws Exception {
		String file = "src/test/resources/intervals/sum002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);
	
		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new TAJSNumbers(3));
	}
	
	@Test
	public void testSum003() throws Exception {
		String file = "src/test/resources/intervals/sum003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("i")), new TAJSNumbers(2));
	}
	
	@Test
	public void testSum004() throws Exception {
		String file = "src/test/resources/intervals/sum004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new TAJSNumbers(1));
	}
	
	@Test
	public void testSum005() throws Exception {
		String file = "src/test/resources/intervals/sum005.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), TAJSNumbers.createUnsigned());
		Assert.assertEquals(state.getValue(new Variable("y")), new Top());
		Assert.assertEquals(state.getValue(new Variable("z")), new Top());
	}
	
	@Test
	public void testMul001() throws Exception {
		String file = "src/test/resources/intervals/mul001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new TAJSNumbers(2));
	}
}
