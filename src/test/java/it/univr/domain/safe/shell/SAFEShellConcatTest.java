package it.univr.domain.safe.shell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.univr.domain.safe.shell.SAFEShellStrings;

public class SAFEShellConcatTest {
	
	@Test
	public void testConcatSingleStrings() throws Exception {

		/*
		 * First parameter single unsigned integer string
		 */
		assertEquals(new SAFEShellStrings("1").concat(
				new SAFEShellStrings("2")), new SAFEShellStrings("12"));

		assertEquals(new SAFEShellStrings("1").concat(
				new SAFEShellStrings("2.1")), new SAFEShellStrings("12.1"));

		assertEquals(new SAFEShellStrings("1").concat(
				new SAFEShellStrings("")), new SAFEShellStrings("1"));

		assertEquals(new SAFEShellStrings("5").concat(
				new SAFEShellStrings("foo")), new SAFEShellStrings("5foo"));

		assertEquals(new SAFEShellStrings("5").concat(
				new SAFEShellStrings("-2")), new SAFEShellStrings("5-2"));

		/*
		 * First parameter single unsigned float string
		 */
		assertEquals(new SAFEShellStrings("1.1").concat(
				new SAFEShellStrings("2")), new SAFEShellStrings("1.12"));

		assertEquals(new SAFEShellStrings("1.1").concat(
				new SAFEShellStrings("2.1")), new SAFEShellStrings("1.12.1"));

		assertEquals(new SAFEShellStrings("1.1").concat(
				new SAFEShellStrings("")), new SAFEShellStrings("1.1"));

		assertEquals(new SAFEShellStrings("5.1").concat(
				new SAFEShellStrings("foo")), new SAFEShellStrings("5.1foo"));

		assertEquals(new SAFEShellStrings("5.1").concat(
				new SAFEShellStrings("-2")), new SAFEShellStrings("5.1-2"));


		/*
		 * First parameter single signed number string
		 */
		assertEquals(new SAFEShellStrings("-1.155").concat(
				new SAFEShellStrings("2")), new SAFEShellStrings("-1.1552"));

		assertEquals(new SAFEShellStrings("-1.14").concat(
				new SAFEShellStrings("2.1")), new SAFEShellStrings("-1.142.1"));

		assertEquals(new SAFEShellStrings("+1.121").concat(
				new SAFEShellStrings("")), new SAFEShellStrings("+1.121"));

		assertEquals(new SAFEShellStrings("-5.13").concat(
				new SAFEShellStrings("foo")), new SAFEShellStrings("-5.13foo"));

		assertEquals(new SAFEShellStrings("+5.165").concat(
				new SAFEShellStrings("-2")), new SAFEShellStrings("+5.165-2"));

		/*
		 * First parameter single not numeric and not empty string
		 */
		assertEquals(new SAFEShellStrings("foo").concat(
				new SAFEShellStrings("2")), new SAFEShellStrings("foo2"));

		assertEquals(new SAFEShellStrings("bar").concat(
				new SAFEShellStrings("2.1")), new SAFEShellStrings("bar2.1"));

		assertEquals(new SAFEShellStrings("asd").concat(
				new SAFEShellStrings("")), new SAFEShellStrings("asd"));

		assertEquals(new SAFEShellStrings("aaa").concat(
				new SAFEShellStrings("foo")), new SAFEShellStrings("aaafoo"));

		assertEquals(new SAFEShellStrings("a").concat(
				new SAFEShellStrings("-2")), new SAFEShellStrings("a-2"));


		/*
		 * First parameter empty string
		 */
		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings("2")), new SAFEShellStrings("2"));

		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings("2.1")), new SAFEShellStrings("2.1"));

		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings("")), new SAFEShellStrings(""));

		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings("foo")), new SAFEShellStrings("foo"));

		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings("-2")), new SAFEShellStrings("-2"));
	}

	@Test
	public void testConcatFirstSingleString() throws Exception {

		/*
		 * First parameter single unsigned integer string
		 */
		assertEquals(new SAFEShellStrings("1").concat(
				new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.UINT));
		assertEquals(new SAFEShellStrings("1").concat(
				new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UINT));
		assertEquals(new SAFEShellStrings("1").concat(
				new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings("1").concat(
				new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings("1").concat(
				new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings("1").concat(
				new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.UFLOAT));
		assertEquals(new SAFEShellStrings("1").concat(
				new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings("1").concat(
				new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings("1").concat(
				new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings("1").concat(
				new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));	
		assertEquals(new SAFEShellStrings("1").concat(
				new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings("1").concat(
				new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.TOP));		
		assertEquals(new SAFEShellStrings("1").concat(
				new SAFEShellStrings(SAFEShellStrings.BOT)), new SAFEShellStrings(SAFEShellStrings.BOT));

		/*
		 * First parameter is the empty string
		 */
		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.UINT));
		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON));
		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.UFLOAT));
		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM));	
		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC));	
		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.TOP));		
		assertEquals(new SAFEShellStrings("").concat(
				new SAFEShellStrings(SAFEShellStrings.BOT)), new SAFEShellStrings(SAFEShellStrings.BOT));


		/*
		 * First parameter is unsigned float string
		 */
		assertEquals(new SAFEShellStrings("1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.UFLOAT));
		assertEquals(new SAFEShellStrings("1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UFLOAT));
		assertEquals(new SAFEShellStrings("1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings("1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings("1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings("1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings("1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings("1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings("1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings("1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));	
		assertEquals(new SAFEShellStrings("1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings("1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));		
		assertEquals(new SAFEShellStrings("1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.BOT)), new SAFEShellStrings(SAFEShellStrings.BOT));


		/*
		 * First parameter is signed number
		 */
		assertEquals(new SAFEShellStrings("+1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM));
		assertEquals(new SAFEShellStrings("-1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM));
		assertEquals(new SAFEShellStrings("+1").concat(
				new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings("+11").concat(
				new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings("-1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings("+1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings("+1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings("+1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings("+1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings("+1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));	
		assertEquals(new SAFEShellStrings("-1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings("-1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));		
		assertEquals(new SAFEShellStrings("-1.1").concat(
				new SAFEShellStrings(SAFEShellStrings.BOT)), new SAFEShellStrings(SAFEShellStrings.BOT));

		/*
		 * First parameter is not numeric and not empty
		 */
		assertEquals(new SAFEShellStrings("foo").concat(
				new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings("foo").concat(
				new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings("bar").concat(
				new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings("hello").concat(
				new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings("here").concat(
				new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings("fff").concat(
				new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings("aaa").concat(
				new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings("helloworol").concat(
				new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings("andy").concat(
				new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings("gff").concat(
				new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings("asd").concat(
				new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings("-ddd").concat(
				new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));		
		assertEquals(new SAFEShellStrings("-bbb").concat(
				new SAFEShellStrings(SAFEShellStrings.BOT)), new SAFEShellStrings(SAFEShellStrings.BOT));
	}

	@Test
	public void testConcatSecondSingleString() throws Exception {

		/*
		 * Second parameter single unsigned integer string
		 */
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.UINT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.UINT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).concat(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.UFLOAT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.TOP));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.TOP));		
		assertEquals(new SAFEShellStrings(SAFEShellStrings.BOT).concat(new SAFEShellStrings("1")), new SAFEShellStrings(SAFEShellStrings.BOT));

		/*
		 * Second parameter is the empty string
		 */
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.UINT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).concat(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.UFLOAT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.TOP));		
		assertEquals(new SAFEShellStrings(SAFEShellStrings.BOT).concat(new SAFEShellStrings("")), new SAFEShellStrings(SAFEShellStrings.BOT));


		/*
		 * Second parameter is unsigned float string
		 */
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.UFLOAT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.UFLOAT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).concat(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));		
		assertEquals(new SAFEShellStrings(SAFEShellStrings.BOT).concat(new SAFEShellStrings("1.1")), new SAFEShellStrings(SAFEShellStrings.BOT));


		/*
		 * Second parameter is signed number
		 */
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings("+1.1")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings("-1.1")), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings("+1")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).concat(new SAFEShellStrings("+11")), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings("-1.1")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings("+1.1")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings("+1")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings("+1.1")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings("+1.1")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings("+1.1")), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings("-1.1")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings("-1.1")), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));		
		assertEquals(new SAFEShellStrings(SAFEShellStrings.BOT).concat(new SAFEShellStrings("-1.1")), new SAFEShellStrings(SAFEShellStrings.BOT));

		/*
		 * Second parameter is not numeric and not empty
		 */
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings("foo")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings("foo")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings("bar")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).concat(new SAFEShellStrings("hello")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings("here")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings("fff")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings("aaa")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings("helloworol")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings("andy")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings("gff")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));	
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings("asd")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings("-ddd")), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));		
		assertEquals(new SAFEShellStrings(SAFEShellStrings.BOT).concat(new SAFEShellStrings("-bbb")), new SAFEShellStrings(SAFEShellStrings.BOT));
	}

	@Test
	public void testConcatUInt() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.UINT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UINT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.UFLOAT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT).concat(new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.TOP));
	}
	
	@Test
	public void testConcatUIntEpsilon() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.UINT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.UFLOAT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.TOP));
	}

	@Test
	public void testConcatUNum() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM).concat(new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.TOP));
	}
	
	@Test
	public void testConcatUNumEpsilon() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.UNUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON).concat(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
	}
	
	@Test
	public void testConcatUFloat() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.UFLOAT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.UFLOAT));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.UFLOAT).concat(new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
	}

	@Test
	public void testConcatNumeric() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.TOP));
	}
	
	@Test
	public void testConcatSignedNum() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM).concat(new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
	}


	@Test
	public void testLubNotNumNotEmpty() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
	}

	@Test
	public void testLubNotUnsignedNotEmpty() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
	}
	
	@Test
	public void testConcatNotNumeric() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC).concat(new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.TOP));
	}
	

	@Test
	public void testConcatNotUIntNotEmpty() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY).concat(new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
	}
	

	@Test
	public void testConcatTop() throws Exception {
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings(SAFEShellStrings.UINT)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings(SAFEShellStrings.UNUM)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings(SAFEShellStrings.UNUM_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings(SAFEShellStrings.UINT_EPSILON)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings(SAFEShellStrings.UFLOAT)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings(SAFEShellStrings.SIGNED_NUM)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTNUM_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUNSIGNED_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings(SAFEShellStrings.NOT_NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY)), new SAFEShellStrings(SAFEShellStrings.NOTUINT_NOTEMPTY));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings(SAFEShellStrings.NUMERIC)), new SAFEShellStrings(SAFEShellStrings.TOP));
		assertEquals(new SAFEShellStrings(SAFEShellStrings.TOP).concat(new SAFEShellStrings(SAFEShellStrings.TOP)), new SAFEShellStrings(SAFEShellStrings.TOP));
	
	}
	
	@Test
	public void testConcatBot() throws Exception {
		
		for (SAFEShellStrings v : SAFEShellStrings.toSet()) {
			assertEquals(v.concat(new SAFEShellStrings(SAFEShellStrings.BOT)), new SAFEShellStrings(SAFEShellStrings.BOT));
			assertEquals(new SAFEShellStrings(SAFEShellStrings.BOT).concat(v), new SAFEShellStrings(SAFEShellStrings.BOT));
		}
	}
}
