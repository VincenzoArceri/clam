package it.univr.domain.tajs.original;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TAJSNumericPlus {
	
	@Test
	public void testTAJSNumericSingleStrings() throws Exception {
		assertEquals(new TAJSNumbers(1).plus(new TAJSNumbers(2)), new TAJSNumbers(3));
		assertEquals(new TAJSNumbers(1).plus(new TAJSNumbers(1.1)), new TAJSNumbers(2.1));
		assertEquals(new TAJSNumbers(1).plus(new TAJSNumbers(-2.2)), new TAJSNumbers(-1.2));
		assertEquals(new TAJSNumbers(2.1).plus(new TAJSNumbers(-2.1)), new TAJSNumbers(0));
		assertEquals(new TAJSNumbers(2.1).plus(new TAJSNumbers(2.1)), new TAJSNumbers(4.2));
		assertEquals(new TAJSNumbers(2.1).plus(new TAJSNumbers(0.9)), new TAJSNumbers(3));
	}

	
	@Test
	public void testTAJSNumericUnsignedInt() throws Exception {
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).plus(new TAJSNumbers(2)), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).plus(new TAJSNumbers(1.1)), new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).plus(new TAJSNumbers(-2.2)), new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).plus(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).plus(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).plus(new TAJSNumbers(TAJSNumbers.TOP, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).plus(new TAJSNumbers(TAJSNumbers.BOT, true)), new TAJSNumbers(TAJSNumbers.BOT, true));
	}
	
	@Test
	public void testTAJSNumericNotUnsignedInt() throws Exception {
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).plus(new TAJSNumbers(2)), new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).plus(new TAJSNumbers(1.1)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).plus(new TAJSNumbers(-2.2)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).plus(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).plus(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).plus(new TAJSNumbers(TAJSNumbers.TOP, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).plus(new TAJSNumbers(TAJSNumbers.BOT, true)), new TAJSNumbers(TAJSNumbers.BOT, true));
	}
	
	@Test
	public void testTAJSNumericTop() throws Exception {
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).plus(new TAJSNumbers(2)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).plus(new TAJSNumbers(1.1)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).plus(new TAJSNumbers(-2.2)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).plus(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).plus(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).plus(new TAJSNumbers(TAJSNumbers.TOP, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).plus(new TAJSNumbers(TAJSNumbers.BOT, true)), new TAJSNumbers(TAJSNumbers.BOT, true));
	}
}
