package it.univr.domain.safe.original;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SAFEToNumTest {

	@Test
	public void testToNumSingleString() throws Exception {

		assertEquals(new SAFEStrings("1").toNum(), new Interval("1", "1"));
		assertEquals(new SAFEStrings("1.1").toNum(), new Interval("1.1", "1.1"));
		assertEquals(new SAFEStrings("foo").toNum(), new Interval("0", "0"));
		assertEquals(new SAFEStrings("-1").toNum(), new Interval("-1", "-1"));
		assertEquals(new SAFEStrings("-1.2").toNum(), new Interval("-1.2", "-1.2"));
		assertEquals(new SAFEStrings("+1.2").toNum(), new Interval("1.2", "1.2"));
		assertEquals(new SAFEStrings("+55").toNum(), new Interval("55", "55"));
	}
	
	@Test
	public void testToNum() throws Exception {

		assertEquals(SAFEStrings.createNumeric().toNum(), new Interval("-Inf", "+Inf"));
		assertEquals(SAFEStrings.createTopString().toNum(), new Interval("-Inf", "+Inf"));
		assertEquals(SAFEStrings.createNotNumeric().toNum(), new Interval("0", "0"));
	}
}
