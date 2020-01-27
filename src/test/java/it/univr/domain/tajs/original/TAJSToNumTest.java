package it.univr.domain.tajs.original;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TAJSToNumTest {

	@Test
	public void testToNumSingleString() throws Exception {
		assertEquals(new TAJSStrings("1").toNum(), new TAJSNumbers(1));
		assertEquals(new TAJSStrings("1.1").toNum(), new TAJSNumbers(1.1));
		assertEquals(new TAJSStrings("foo").toNum(), new TAJSNumbers(0));
		assertEquals(new TAJSStrings("-1").toNum(), new TAJSNumbers(-1));
		assertEquals(new TAJSStrings("-1.2").toNum(), new TAJSNumbers(-1.2));
		assertEquals(new TAJSStrings("+1.2").toNum(), new TAJSNumbers(1.2));
		assertEquals(new TAJSStrings("+55").toNum(), new TAJSNumbers(55));
	}
	
	@Test
	public void testToNum() throws Exception {
		assertEquals(TAJSStrings.createUnsignedString().toNum(), TAJSNumbers.createUnsigned());
		assertEquals(TAJSStrings.createNotUnsignedString().toNum(), TAJSNumbers.createTopTAJSNumber());
		assertEquals(TAJSStrings.createTopTAJSString().toNum(), TAJSNumbers.createTopTAJSNumber());
	}
}
