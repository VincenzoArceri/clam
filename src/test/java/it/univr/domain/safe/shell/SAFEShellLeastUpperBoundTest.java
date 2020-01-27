package it.univr.domain.safe.shell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.univr.domain.safe.shell.SAFEShellStrings;

public class SAFEShellLeastUpperBoundTest {


	@Test
	public void testLubSingleStrings() throws Exception {

		/*
		 * First parameter single unsigned integer string
		 */
		assertEquals(new SAFEShellStrings("1").leastUpperBound(
				new SAFEShellStrings("2")), new SAFEShellStrings(SAFEShellStrings.UINT));

		assertEquals(new SAFEShellStrings("1").leastUpperBound(
				new SAFEShellStrings("2.1")), new SAFEShellStrings(SAFEShellStrings.UNUM));

		assertEquals(new SAFEShellStrings("1").leastUpperBound(
				new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON));

		assertEquals(new SAFEShellStrings("5").leastUpperBound(
				new SAFEShellStrings("foo")), new SAFEShellStrings(SAFEShellStrings.TOP));

		assertEquals(new SAFEShellStrings("5").leastUpperBound(
				new SAFEShellStrings("-2")), new SAFEShellStrings(SAFEShellStrings.NUMERIC));

		/*
		 * First parameter single unsigned float string
		 */
		assertEquals(new SAFEShellStrings("1.1").leastUpperBound(
				new SAFEShellStrings("2")), new SAFEShellStrings(SAFEShellStrings.UNUM));

		assertEquals(new SAFEShellStrings("1.1").leastUpperBound(
				new SAFEShellStrings("2.1")), new SAFEShellStrings(SAFEShellStrings.UFLOAT));

		assertEquals(new SAFEShellStrings("1.1").leastUpperBound(
				new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));

		assertEquals(new SAFEShellStrings("5.1").leastUpperBound(
				new SAFEShellStrings("foo")), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));

		assertEquals(new SAFEShellStrings("5.1").leastUpperBound(
				new SAFEShellStrings("-2")), new SAFEShellStrings(SAFEShellStrings.NUMERIC));


		/*
		 * First parameter single signed number string
		 */
		assertEquals(new SAFEShellStrings("-1.155").leastUpperBound(
				new SAFEShellStrings("2")), new SAFEShellStrings(SAFEShellStrings.NUMERIC));

		assertEquals(new SAFEShellStrings("-1.14").leastUpperBound(
				new SAFEShellStrings("2.1")), new SAFEShellStrings(SAFEShellStrings.NUMERIC));

		assertEquals(new SAFEShellStrings("+1.121").leastUpperBound(
				new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.TOP));

		assertEquals(new SAFEShellStrings("-5.13").leastUpperBound(
				new SAFEShellStrings("foo")), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));

		assertEquals(new SAFEShellStrings("+5.165").leastUpperBound(
				new SAFEShellStrings("-2")), new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM));

		/*
		 * First parameter single not numeric and not empty string
		 */
		assertEquals(new SAFEShellStrings("foo").leastUpperBound(
				new SAFEShellStrings("2")), new SAFEShellStrings(SAFEShellStrings.TOP));

		assertEquals(new SAFEShellStrings("bar").leastUpperBound(
				new SAFEShellStrings("2.1")), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));

		assertEquals(new SAFEShellStrings("asd").leastUpperBound(
				new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC));

		assertEquals(new SAFEShellStrings("aaa").leastUpperBound(
				new SAFEShellStrings("foo")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));

		assertEquals(new SAFEShellStrings("a").leastUpperBound(
				new SAFEShellStrings("-2")), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));


		/*
		 * First parameter empty string
		 */
		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings("2")), new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON));

		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings("2.1")), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));

		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings("")), new SAFEShellStrings(""));

		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings("foo")), new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC));

		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings("-2")), new SAFEShellStrings(SAFEShellStrings.TOP));
	}

	@Test
	public void testLubFirstSingleString() throws Exception {

		/*
		 * First parameter single unsigned integer string
		 */
		assertEquals(new SAFEShellStrings("1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.UINT));
		assertEquals(new SAFEShellStrings("1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON));
		assertEquals(new SAFEShellStrings("1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings("1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings("1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings("1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings("1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));	
		assertEquals(new SAFEShellStrings("1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));	
		assertEquals(new SAFEShellStrings("1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings("1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));	
		assertEquals(new SAFEShellStrings("1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings("1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.TOP));		
		assertEquals(new SAFEShellStrings("1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.BOT)), new SAFEShellStrings("1"));

		/*
		 * First parameter is the empty string
		 */
		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON));
		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON));
		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.TOP));	
		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC));	
		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC));	
		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.TOP));		
		assertEquals(new SAFEShellStrings("").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.BOT)), new SAFEShellStrings(""));


		/*
		 * First parameter is unsigned float string
		 */
		assertEquals(new SAFEShellStrings("1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings("1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings("1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings("1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings("1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings("1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.UFLOAT));
		assertEquals(new SAFEShellStrings("1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));	
		assertEquals(new SAFEShellStrings("1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));	
		assertEquals(new SAFEShellStrings("1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings("1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));	
		assertEquals(new SAFEShellStrings("1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings("1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.TOP));		
		assertEquals(new SAFEShellStrings("1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.BOT)), new SAFEShellStrings("1.1"));


		/*
		 * First parameter is signed number
		 */
		assertEquals(new SAFEShellStrings("+1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings("-1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings("+1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings("+11").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings("-1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings("+1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings("+1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM));	
		assertEquals(new SAFEShellStrings("+1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));	
		assertEquals(new SAFEShellStrings("+1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings("+1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));	
		assertEquals(new SAFEShellStrings("-1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings("-1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.TOP));		
		assertEquals(new SAFEShellStrings("-1.1").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.BOT)), new SAFEShellStrings("-1.1"));

		/*
		 * First parameter is not numeric and not empty
		 */
		assertEquals(new SAFEShellStrings("foo").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings("foo").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings("bar").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings("hello").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings("here").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings("fff").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings("aaa").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));	
		assertEquals(new SAFEShellStrings("helloworol").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings("andy").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings("gff").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));	
		assertEquals(new SAFEShellStrings("asd").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings("-ddd").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.TOP));		
		assertEquals(new SAFEShellStrings("-bbb").leastUpperBound(
				new SAFEShellStrings(SAFEShellStrings.BOT)), new SAFEShellStrings("-bbb"));
	}

	@Test
	public void testLubSecondSingleString() throws Exception {

		/*
		 * Second parameter single unsigned integer string
		 */
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).leastUpperBound(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.UINT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).leastUpperBound(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).leastUpperBound(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).leastUpperBound(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).leastUpperBound(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).leastUpperBound(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).leastUpperBound(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.NUMERIC));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).leastUpperBound(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.TOP));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).leastUpperBound(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).leastUpperBound(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.TOP));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).leastUpperBound(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).leastUpperBound(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.TOP));		
		assertEquals(new SAFEShellStrings(SAFEShellStrings.BOT).leastUpperBound(new SAFEShellStrings("1")), new SAFEShellStrings("1"));

		/*
		 * Second parameter is the empty string
		 */
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).leastUpperBound(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).leastUpperBound(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON));
		assertEquals(new SAFEShellStrings("").leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).leastUpperBound(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).leastUpperBound(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).leastUpperBound(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).leastUpperBound(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.TOP));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).leastUpperBound(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).leastUpperBound(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).leastUpperBound(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).leastUpperBound(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).leastUpperBound(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.TOP));		
		assertEquals(new SAFEShellStrings(SAFEShellStrings.BOT).leastUpperBound(new SAFEShellStrings("")), new SAFEShellStrings(""));


		/*
		 * Second parameter is unsigned float string
		 */
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).leastUpperBound(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).leastUpperBound(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).leastUpperBound(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).leastUpperBound(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).leastUpperBound(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).leastUpperBound(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.UFLOAT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).leastUpperBound(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.NUMERIC));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).leastUpperBound(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).leastUpperBound(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).leastUpperBound(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.TOP));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).leastUpperBound(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).leastUpperBound(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.TOP));		
		assertEquals(new SAFEShellStrings(SAFEShellStrings.BOT).leastUpperBound(new SAFEShellStrings("1.1")), new SAFEShellStrings("1.1"));


		/*
		 * Second parameter is signed number
		 */
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).leastUpperBound(new SAFEShellStrings("+1.1")), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).leastUpperBound(new SAFEShellStrings("-1.1")), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).leastUpperBound(new SAFEShellStrings("+1")), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).leastUpperBound(new SAFEShellStrings("+11")), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).leastUpperBound(new SAFEShellStrings("-1.1")), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).leastUpperBound(new SAFEShellStrings("+1.1")), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).leastUpperBound(new SAFEShellStrings("+1")), new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).leastUpperBound(new SAFEShellStrings("+1.1")), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).leastUpperBound(new SAFEShellStrings("+1.1")), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).leastUpperBound(new SAFEShellStrings("+1.1")), new SAFEShellStrings(SAFEShellStrings.TOP));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).leastUpperBound(new SAFEShellStrings("-1.1")), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).leastUpperBound(new SAFEShellStrings("-1.1")), new SAFEShellStrings(SAFEShellStrings.TOP));		
		assertEquals(new SAFEShellStrings(SAFEShellStrings.BOT).leastUpperBound(new SAFEShellStrings("-1.1")), new SAFEShellStrings("-1.1"));

		/*
		 * Second parameter is not numeric and not empty
		 */
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).leastUpperBound(new SAFEShellStrings("foo")), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).leastUpperBound(new SAFEShellStrings("foo")), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).leastUpperBound(new SAFEShellStrings("bar")), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).leastUpperBound(new SAFEShellStrings("hello")), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).leastUpperBound(new SAFEShellStrings("here")), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).leastUpperBound(new SAFEShellStrings("fff")), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).leastUpperBound(new SAFEShellStrings("aaa")), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).leastUpperBound(new SAFEShellStrings("helloworol")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).leastUpperBound(new SAFEShellStrings("andy")), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).leastUpperBound(new SAFEShellStrings("gff")), new SAFEShellStrings(SAFEShellStrings.TOP));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).leastUpperBound(new SAFEShellStrings("asd")), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).leastUpperBound(new SAFEShellStrings("-ddd")), new SAFEShellStrings(SAFEShellStrings.TOP));		
		assertEquals(new SAFEShellStrings(SAFEShellStrings.BOT).leastUpperBound(new SAFEShellStrings("-bbb")), new SAFEShellStrings("-bbb"));
	}

	@Test
	public void testLubUInt() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.UINT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
	}
	
	@Test
	public void testLubUIntEpsilon() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
	}

	@Test
	public void testLubUNum() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
	}
	
	@Test
	public void testLubUNumEpsilon() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
	}
	

	@Test
	public void testLubUFloat() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.UFLOAT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
	}

	@Test
	public void testLubNumeric() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
	}
	
	@Test
	public void testLubSignedNum() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
	}


	@Test
	public void testLubNotNumNotEmpty() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
	}

	@Test
	public void testLubNotUnsignedNotEmpty() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
	}
	
	@Test
	public void testLubNotNumeric() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
	}
	

	@Test
	public void testLubNotUIntNotEmpty() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).leastUpperBound(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
	}
	

	@Test
	public void testLubTop() throws Exception {
		
		for (SAFEShellStrings v : SAFEShellStrings.toSet()) {
			assertEquals(v.leastUpperBound(new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.TOP));
			assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).leastUpperBound(v), new SAFEShellStrings(SAFEShellStrings.TOP));
		}
	}
	
	@Test
	public void testLubBot() throws Exception {
		
		for (SAFEShellStrings v : SAFEShellStrings.toSet()) {
			assertEquals(v.leastUpperBound(new SAFEShellStrings(SAFEShellStrings.BOT)), v);
			assertEquals(new SAFEShellStrings(SAFEShellStrings.BOT).leastUpperBound(v), v);
		}
	}
}
