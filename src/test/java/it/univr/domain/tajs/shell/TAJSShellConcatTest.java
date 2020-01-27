package it.univr.domain.tajs.shell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TAJSShellConcatTest {

	@Test
	public void testConcatSingleStrings() throws Exception {

		/*
		 * First parameter single unsigned integer string
		 */
		assertEquals(new TAJSShellStrings("1").concat(
				new TAJSShellStrings("2")), new TAJSShellStrings("12"));

		assertEquals(new TAJSShellStrings("1").concat(
				new TAJSShellStrings("2.1")), new TAJSShellStrings("12.1"));

		assertEquals(new TAJSShellStrings("1").concat(
				new TAJSShellStrings("")), new TAJSShellStrings("1"));

		assertEquals(new TAJSShellStrings("5").concat(
				new TAJSShellStrings("foo")), new TAJSShellStrings("5foo"));

		assertEquals(new TAJSShellStrings("5").concat(
				new TAJSShellStrings("-2")), new TAJSShellStrings("5-2"));

		/*
		 * First parameter single unsigned float string
		 */
		assertEquals(new TAJSShellStrings("1.1").concat(
				new TAJSShellStrings("2")), new TAJSShellStrings("1.12"));

		assertEquals(new TAJSShellStrings("1.1").concat(
				new TAJSShellStrings("2.1")), new TAJSShellStrings("1.12.1"));

		assertEquals(new TAJSShellStrings("1.1").concat(
				new TAJSShellStrings("")), new TAJSShellStrings("1.1"));

		assertEquals(new TAJSShellStrings("5.1").concat(
				new TAJSShellStrings("foo")), new TAJSShellStrings("5.1foo"));

		assertEquals(new TAJSShellStrings("5.1").concat(
				new TAJSShellStrings("-2")), new TAJSShellStrings("5.1-2"));


		/*
		 * First parameter single signed number string
		 */
		assertEquals(new TAJSShellStrings("-1.155").concat(
				new TAJSShellStrings("2")), new TAJSShellStrings("-1.1552"));

		assertEquals(new TAJSShellStrings("-1.14").concat(
				new TAJSShellStrings("2.1")), new TAJSShellStrings("-1.142.1"));

		assertEquals(new TAJSShellStrings("+1.121").concat(
				new TAJSShellStrings("")), new TAJSShellStrings("+1.121"));

		assertEquals(new TAJSShellStrings("-5.13").concat(
				new TAJSShellStrings("foo")), new TAJSShellStrings("-5.13foo"));

		assertEquals(new TAJSShellStrings("+5.165").concat(
				new TAJSShellStrings("-2")), new TAJSShellStrings("+5.165-2"));

		/*
		 * First parameter single not numeric and not empty string
		 */
		assertEquals(new TAJSShellStrings("foo").concat(
				new TAJSShellStrings("2")), new TAJSShellStrings("foo2"));

		assertEquals(new TAJSShellStrings("bar").concat(
				new TAJSShellStrings("2.1")), new TAJSShellStrings("bar2.1"));

		assertEquals(new TAJSShellStrings("asd").concat(
				new TAJSShellStrings("")), new TAJSShellStrings("asd"));

		assertEquals(new TAJSShellStrings("aaa").concat(
				new TAJSShellStrings("foo")), new TAJSShellStrings("aaafoo"));

		assertEquals(new TAJSShellStrings("a").concat(
				new TAJSShellStrings("-2")), new TAJSShellStrings("a-2"));


		/*
		 * First parameter empty string
		 */
		assertEquals(new TAJSShellStrings("").concat(
				new TAJSShellStrings("2")), new TAJSShellStrings("2"));

		assertEquals(new TAJSShellStrings("").concat(
				new TAJSShellStrings("2.1")), new TAJSShellStrings("2.1"));

		assertEquals(new TAJSShellStrings("").concat(
				new TAJSShellStrings("")), new TAJSShellStrings(""));

		assertEquals(new TAJSShellStrings("").concat(
				new TAJSShellStrings("foo")), new TAJSShellStrings("foo"));

		assertEquals(new TAJSShellStrings("").concat(
				new TAJSShellStrings("-2")), new TAJSShellStrings("-2"));
	}

	@Test
	public void testConcatFirstSingleString() throws Exception {

		/*
		 * First parameter single unsigned integer string
		 */
		assertEquals(new TAJSShellStrings("1").concat(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("1").concat(
				new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));	
		assertEquals(new TAJSShellStrings("1").concat(
				new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("1").concat(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("1").concat(
				new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings("1").concat(
				new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.TOP));

		/*
		 * First parameter is not numeric and not empty
		 */
		assertEquals(new TAJSShellStrings("foo").concat(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("foo").concat(
				new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("bar").concat(
				new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("hello").concat(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("here").concat(
				new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("fff").concat(
				new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.TOP));

		/*
		 * First parameter is the empty string
		 */
		assertEquals(new TAJSShellStrings("").concat(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("").concat(
				new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("").concat(
				new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("").concat(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("").concat(
				new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("").concat(
				new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.TOP));

		/*
		 * First parameter is unsigned float string
		 */
		assertEquals(new TAJSShellStrings("1.1").concat(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS));
		assertEquals(new TAJSShellStrings("1.1").concat(
				new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("1.1").concat(
				new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("1.1").concat(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("1.1").concat(
				new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("1.1").concat(
				new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));

		/*
		 * First parameter is signed number
		 */
		assertEquals(new TAJSShellStrings("+1.1").concat(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS));
		assertEquals(new TAJSShellStrings("-1.1").concat(
				new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("+1").concat(
				new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("+11").concat(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("-1.1").concat(
				new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("+1.1").concat(
				new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
	}

	@Test
	public void testConcatSecondSingleString() throws Exception {

		/*
		 * Second parameter single unsigned integer string
		 */
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).concat(new TAJSShellStrings("1")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).concat(new TAJSShellStrings("1")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).concat(new TAJSShellStrings("1")), new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).concat(new TAJSShellStrings("1")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).concat(new TAJSShellStrings("1")), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).concat(new TAJSShellStrings("1")), new TAJSShellStrings(TAJSShellStrings.TOP));

		/*
		 * Second parameter is the empty string
		 */
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).concat(new TAJSShellStrings("")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).concat(new TAJSShellStrings("")), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).concat(new TAJSShellStrings("")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).concat(new TAJSShellStrings("")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).concat(new TAJSShellStrings("")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).concat(new TAJSShellStrings("")), new TAJSShellStrings(TAJSShellStrings.TOP));



		/*
		 * Second parameter is not numeric and not empty
		 */
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).concat(new TAJSShellStrings("foo")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).concat(new TAJSShellStrings("foo")), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).concat(new TAJSShellStrings("bar")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).concat(new TAJSShellStrings("hello")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).concat(new TAJSShellStrings("here")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).concat(new TAJSShellStrings("fff")), new TAJSShellStrings(TAJSShellStrings.TOP));

		/*
		 * Second parameter is unsigned float string
		 */
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).concat(new TAJSShellStrings("1.1")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).concat(new TAJSShellStrings("1.1")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).concat(new TAJSShellStrings("1.1")), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).concat(new TAJSShellStrings("1.1")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).concat(new TAJSShellStrings("1.1")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).concat(new TAJSShellStrings("1.1")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));


		/*
		 * Second parameter is signed number
		 */
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).concat(new TAJSShellStrings("+1.1")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).concat(new TAJSShellStrings("+1.1")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).concat(new TAJSShellStrings("+1.1")), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).concat(new TAJSShellStrings("+1.1")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).concat(new TAJSShellStrings("+1.1")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).concat(new TAJSShellStrings("+1.1")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
	}

	@Test
	public void testConcatUnsigned() throws Exception {
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).concat(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).concat(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).concat(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).concat(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).concat(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).concat(new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.TOP));
	}

	@Test
	public void testConcatSignedOrFloats() throws Exception {
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).concat(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).concat(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).concat(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).concat(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).concat(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).concat(new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
	}

	@Test
	public void testConcatUnsignedOrNotNumeric() throws Exception {
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).concat(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).concat(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).concat(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).concat(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).concat(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).concat(new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.TOP));
	}

	@Test
	public void testConcatNotUnsignedString() throws Exception {
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).concat(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).concat(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).concat(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).concat(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).concat(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).concat(new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.TOP));
	}

	@Test
	public void testConcatTop() throws Exception {
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).concat(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).concat(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).concat(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).concat(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).concat(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).concat(new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.TOP));	
	}
}
