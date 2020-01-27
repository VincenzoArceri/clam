package it.univr.domain.tajs.shell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TAJSShellToNumTest {

	@Test
	public void testToNumSingleString() throws Exception {
		assertEquals(new TAJSShellStrings("1").toNum(), new TAJSNumbers(1));
		assertEquals(new TAJSShellStrings("1.1").toNum(), new TAJSNumbers(1.1));
		assertEquals(new TAJSShellStrings("foo").toNum(), new TAJSNumbers(0));
		assertEquals(new TAJSShellStrings("-1").toNum(), new TAJSNumbers(-1));
		assertEquals(new TAJSShellStrings("-1.2").toNum(), new TAJSNumbers(-1.2));
		assertEquals(new TAJSShellStrings("+1.2").toNum(), new TAJSNumbers(1.2));
		assertEquals(new TAJSShellStrings("+55").toNum(), new TAJSNumbers(55));
	}
	
	@Test
	public void testToNum() throws Exception {
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).toNum(), TAJSNumbers.createUnsigned());
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).toNum(), new TAJSNumbers(0));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).toNum(), TAJSNumbers.createNotUnsignedInt());
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).toNum(), TAJSNumbers.createUnsigned());
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).toNum(), TAJSNumbers.createTopTAJSNumber());
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).toNum(), TAJSNumbers.createTopTAJSNumber());
	}
}
