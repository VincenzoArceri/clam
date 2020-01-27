package it.univr.domain.tajs.original;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TAJSNumericMul {
	@Test
	public void testTAJSNumericSingleStrings() throws Exception {
		assertEquals(new TAJSNumbers(1).mul(new TAJSNumbers(2)), new TAJSNumbers(2));
		assertEquals(new TAJSNumbers(1).mul(new TAJSNumbers(1.1)), new TAJSNumbers(1.1));
		assertEquals(new TAJSNumbers(1).mul(new TAJSNumbers(-2.2)), new TAJSNumbers(-2.2));
		assertEquals(new TAJSNumbers(2).mul(new TAJSNumbers(-2.1)), new TAJSNumbers(-4.2));
		assertEquals(new TAJSNumbers(5).mul(new TAJSNumbers(5)), new TAJSNumbers(25));
		assertEquals(new TAJSNumbers(2.1).mul(new TAJSNumbers(0)), new TAJSNumbers(0));
	}

	
	@Test
	public void testTAJSNumericUnsignedInt() throws Exception {
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).mul(new TAJSNumbers(2)), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).mul(new TAJSNumbers(1.1)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).mul(new TAJSNumbers(-2.2)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).mul(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).mul(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).mul(new TAJSNumbers(TAJSNumbers.TOP, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).mul(new TAJSNumbers(TAJSNumbers.BOT, true)), new TAJSNumbers(TAJSNumbers.BOT, true));
	}
	
	@Test
	public void testTAJSNumericNotUnsignedInt() throws Exception {
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).mul(new TAJSNumbers(2)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).mul(new TAJSNumbers(1.1)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).mul(new TAJSNumbers(-2.2)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).mul(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).mul(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).mul(new TAJSNumbers(TAJSNumbers.TOP, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).mul(new TAJSNumbers(TAJSNumbers.BOT, true)), new TAJSNumbers(TAJSNumbers.BOT, true));
	}
	
	@Test
	public void testTAJSNumericTop() throws Exception {
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).mul(new TAJSNumbers(2)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).mul(new TAJSNumbers(1.1)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).mul(new TAJSNumbers(-2.2)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).mul(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).mul(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).mul(new TAJSNumbers(TAJSNumbers.TOP, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).mul(new TAJSNumbers(TAJSNumbers.BOT, true)), new TAJSNumbers(TAJSNumbers.BOT, true));
	}
}
