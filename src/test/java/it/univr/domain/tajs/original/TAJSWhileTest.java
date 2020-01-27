package it.univr.domain.tajs.original;

import org.junit.Assert;
import org.junit.Test;

import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class TAJSWhileTest {

	private TAJSAbstractDomain domain = new TAJSAbstractDomain();

	@Test
	public void testWhile001() throws Exception {
		String file = "src/test/resources/while/while001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), TAJSNumbers.createUnsigned());
	}

	@Test
	public void testWhile002() throws Exception {
		String file = "src/test/resources/while/while002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), TAJSStrings.createNotUnsignedString());
	}

	@Test
	public void testWhile003() throws Exception {
		String file = "src/test/resources/while/while003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new TAJSStrings(""));
	}

	@Test
	public void testWhile004() throws Exception {
		String file = "src/test/resources/while/while004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), TAJSNumbers.createUnsigned());
	}	

	@Test
	public void testWhile005() throws Exception {
		String file = "src/test/resources/while/while005.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), TAJSNumbers.createUnsigned());
		Assert.assertEquals(state.getValue(new Variable("y")), TAJSNumbers.createUnsigned());
	}


	@Test
	public void testWhile006() throws Exception {
		String file = "src/test/resources/while/while006.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, true);

		// State sizeStore
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 0);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), TAJSNumbers.createUnsigned());
		Assert.assertEquals(state.getValue(new Variable("y")), TAJSNumbers.createUnsigned());
	}
}
