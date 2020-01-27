package it.univr.domain.tajs.original;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TAJSNumericDiff {
	
	@Test
	public void testTAJSNumericUnsignedInt() throws Exception {
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).diff(new TAJSNumbers(2)), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).diff(new TAJSNumbers(1.1)), new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).diff(new TAJSNumbers(-2.2)), new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).diff(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).diff(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).diff(new TAJSNumbers(TAJSNumbers.TOP, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).diff(new TAJSNumbers(TAJSNumbers.BOT, true)), new TAJSNumbers(TAJSNumbers.BOT, true));
	}
	
	@Test
	public void testTAJSNumericNotUnsignedInt() throws Exception {
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).diff(new TAJSNumbers(2)), new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).diff(new TAJSNumbers(1.1)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).diff(new TAJSNumbers(-2.2)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).diff(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).diff(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).diff(new TAJSNumbers(TAJSNumbers.TOP, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).diff(new TAJSNumbers(TAJSNumbers.BOT, true)), new TAJSNumbers(TAJSNumbers.BOT, true));
	}
	
	@Test
	public void testTAJSNumericTop() throws Exception {
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).diff(new TAJSNumbers(2)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).diff(new TAJSNumbers(1.1)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).diff(new TAJSNumbers(-2.2)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).diff(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).diff(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).diff(new TAJSNumbers(TAJSNumbers.TOP, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).diff(new TAJSNumbers(TAJSNumbers.BOT, true)), new TAJSNumbers(TAJSNumbers.BOT, true));
	}
}
