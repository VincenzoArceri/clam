package it.univr.domain.safe.shell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SAFEShellToNumTest {

	@Test
	public void testToNumSingleString() throws Exception {

		assertEquals(new SAFEShellStrings("1").toNum(), new Interval("1", "1"));
		assertEquals(new SAFEShellStrings("1.1").toNum(), new Interval("1.1", "1.1"));
		assertEquals(new SAFEShellStrings("foo").toNum(), new Interval("0", "0"));
		assertEquals(new SAFEShellStrings("-1").toNum(), new Interval("-1", "-1"));
		assertEquals(new SAFEShellStrings("-1.2").toNum(), new Interval("-1.2", "-1.2"));
		assertEquals(new SAFEShellStrings("+1.2").toNum(), new Interval("1.2", "1.2"));
		assertEquals(new SAFEShellStrings("+55").toNum(), new Interval("55", "55"));
	}
	
	@Test
	public void testToNum() throws Exception {

		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).toNum(), new Interval("0", "+Inf"));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).toNum(), new Interval("0", "+Inf"));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).toNum(), new Interval("0", "+Inf"));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).toNum(), new Interval("0", "+Inf"));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).toNum(), new Interval("0", "+Inf"));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).toNum(), new Interval("-Inf", "+Inf"));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).toNum(), new Interval("-Inf", "+Inf"));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).toNum(), new Interval("-Inf", "+Inf"));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).toNum(), new Interval("-Inf", "+Inf"));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).toNum(), new Interval("0", "0"));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).toNum(), new Interval("0", "0"));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).toNum(), new Interval("-Inf", "+Inf"));
	}
}
