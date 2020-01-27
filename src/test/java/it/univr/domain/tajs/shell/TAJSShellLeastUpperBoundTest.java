package it.univr.domain.tajs.shell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TAJSShellLeastUpperBoundTest {


	@Test
	public void testLubSingleStrings() throws Exception {

		/*
		 * First parameter single unsigned integer string
		 */
		assertEquals(new TAJSShellStrings("1").leastUpperBound(
				new TAJSShellStrings("2")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR));

		assertEquals(new TAJSShellStrings("1").leastUpperBound(
				new TAJSShellStrings("2.1")), new TAJSShellStrings(TAJSShellStrings.TOP));

		assertEquals(new TAJSShellStrings("1").leastUpperBound(
				new TAJSShellStrings("")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));

		assertEquals(new TAJSShellStrings("5").leastUpperBound(
				new TAJSShellStrings("foo")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));

		assertEquals(new TAJSShellStrings("5").leastUpperBound(
				new TAJSShellStrings("-2")), new TAJSShellStrings(TAJSShellStrings.TOP));

		/*
		 * First parameter single unsigned float string
		 */
		assertEquals(new TAJSShellStrings("1.1").leastUpperBound(
				new TAJSShellStrings("2")), new TAJSShellStrings(TAJSShellStrings.TOP));

		assertEquals(new TAJSShellStrings("1.1").leastUpperBound(
				new TAJSShellStrings("2.1")), new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS));

		assertEquals(new TAJSShellStrings("1.1").leastUpperBound(
				new TAJSShellStrings("")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));

		assertEquals(new TAJSShellStrings("5.1").leastUpperBound(
				new TAJSShellStrings("foo")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));

		assertEquals(new TAJSShellStrings("5.1").leastUpperBound(
				new TAJSShellStrings("-2")), new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS));


		/*
		 * First parameter single signed number string
		 */
		assertEquals(new TAJSShellStrings("-1.155").leastUpperBound(
				new TAJSShellStrings("2")), new TAJSShellStrings(TAJSShellStrings.TOP));

		assertEquals(new TAJSShellStrings("-1.14").leastUpperBound(
				new TAJSShellStrings("2.1")), new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS));

		assertEquals(new TAJSShellStrings("+1.121").leastUpperBound(
				new TAJSShellStrings("")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));

		assertEquals(new TAJSShellStrings("-5.13").leastUpperBound(
				new TAJSShellStrings("foo")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));

		assertEquals(new TAJSShellStrings("+5.165").leastUpperBound(
				new TAJSShellStrings("-2")), new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS));

		/*
		 * First parameter single not numeric and not empty string
		 */
		assertEquals(new TAJSShellStrings("foo").leastUpperBound(
				new TAJSShellStrings("2")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));

		assertEquals(new TAJSShellStrings("bar").leastUpperBound(
				new TAJSShellStrings("2.1")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));

		assertEquals(new TAJSShellStrings("asd").leastUpperBound(
				new TAJSShellStrings("")), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));

		assertEquals(new TAJSShellStrings("aaa").leastUpperBound(
				new TAJSShellStrings("foo")), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));

		assertEquals(new TAJSShellStrings("a").leastUpperBound(
				new TAJSShellStrings("-2")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));


		/*
		 * First parameter empty string
		 */
		assertEquals(new TAJSShellStrings("").leastUpperBound(
				new TAJSShellStrings("2")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));

		assertEquals(new TAJSShellStrings("").leastUpperBound(
				new TAJSShellStrings("2.1")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));

		assertEquals(new TAJSShellStrings("").leastUpperBound(
				new TAJSShellStrings("")), new TAJSShellStrings(""));

		assertEquals(new TAJSShellStrings("").leastUpperBound(
				new TAJSShellStrings("foo")), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));

		assertEquals(new TAJSShellStrings("").leastUpperBound(
				new TAJSShellStrings("-2")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
	}

	@Test
	public void testLubFirstSingleString() throws Exception {

		/*
		 * First parameter single unsigned integer string
		 */
		assertEquals(new TAJSShellStrings("1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings("1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings("1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.TOP));

		/*
		 * First parameter is the empty string
		 */
		assertEquals(new TAJSShellStrings("").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.TOP));


		/*
		 * First parameter is unsigned float string
		 */
		assertEquals(new TAJSShellStrings("1.1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings("1.1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("1.1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS));
		assertEquals(new TAJSShellStrings("1.1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings("1.1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("1.1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.TOP));

		/*
		 * First parameter is signed number
		 */
		assertEquals(new TAJSShellStrings("+1.1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings("-1.1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("+1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS));
		assertEquals(new TAJSShellStrings("+11").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings("-1.1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("+1.1").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.TOP));

		/*
		 * First parameter is not numeric and not empty
		 */
		assertEquals(new TAJSShellStrings("foo").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("foo").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("bar").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("hello").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings("here").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings("fff").leastUpperBound(
				new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.TOP));
	}

	@Test
	public void testLubSecondSingleString() throws Exception {

		/*
		 * Second parameter single unsigned integer string
		 */
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).leastUpperBound(new TAJSShellStrings("1")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).leastUpperBound(new TAJSShellStrings("1")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).leastUpperBound(new TAJSShellStrings("1")), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).leastUpperBound(new TAJSShellStrings("1")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).leastUpperBound(new TAJSShellStrings("1")), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).leastUpperBound(new TAJSShellStrings("1")), new TAJSShellStrings(TAJSShellStrings.TOP));
		
		/*
		 * Second parameter is the empty string
		 */
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).leastUpperBound(new TAJSShellStrings("")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).leastUpperBound(new TAJSShellStrings("")), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).leastUpperBound(new TAJSShellStrings("")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).leastUpperBound(new TAJSShellStrings("")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).leastUpperBound(new TAJSShellStrings("")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).leastUpperBound(new TAJSShellStrings("")), new TAJSShellStrings(TAJSShellStrings.TOP));	
		
		/*
		 * Second parameter is unsigned float string
		 */
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).leastUpperBound(new TAJSShellStrings("1.1")), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).leastUpperBound(new TAJSShellStrings("1.1")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).leastUpperBound(new TAJSShellStrings("1.1")), new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).leastUpperBound(new TAJSShellStrings("1.1")), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).leastUpperBound(new TAJSShellStrings("1.1")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).leastUpperBound(new TAJSShellStrings("1.1")), new TAJSShellStrings(TAJSShellStrings.TOP));
		
		/*
		 * Second parameter is signed number
		 */
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).leastUpperBound(new TAJSShellStrings("+1.1")), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).leastUpperBound(new TAJSShellStrings("-1.1")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).leastUpperBound(new TAJSShellStrings("+1")), new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).leastUpperBound(new TAJSShellStrings("+11")), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).leastUpperBound(new TAJSShellStrings("-1.1")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).leastUpperBound(new TAJSShellStrings("+1.1")), new TAJSShellStrings(TAJSShellStrings.TOP));
	
		/*
		 * Second parameter is not numeric and not empty
		 */
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).leastUpperBound(new TAJSShellStrings("foo")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).leastUpperBound(new TAJSShellStrings("foo")), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS).leastUpperBound(new TAJSShellStrings("bar")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).leastUpperBound(new TAJSShellStrings("hello")), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).leastUpperBound(new TAJSShellStrings("here")), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.TOP).leastUpperBound(new TAJSShellStrings("fff")), new TAJSShellStrings(TAJSShellStrings.TOP));
	}

	@Test
	public void testLubUInt() throws Exception {
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.BOT)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR));
	}

	@Test
	public void testLubNotNumeric() throws Exception {
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.BOT)), new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC));
	}

	@Test
	public void testLubUnsignedOrNotNumeric() throws Exception {
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.BOT)), new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC));
	}

	@Test
	public void testLubNotUnsignedString() throws Exception {
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.SIGNED_OR_FLOATS)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.UNSIGNED_OR_NOT_NUMERIC)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.TOP)), new TAJSShellStrings(TAJSShellStrings.TOP));
		assertEquals(new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR).leastUpperBound(new TAJSShellStrings(TAJSShellStrings.BOT)), new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR));
	}
}
