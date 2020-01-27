package it.univr.domain.tajs.original;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TAJSNumericLeastUpperBound {
	
	@Test
	public void testTAJSNumericSingleUnsignedInteger() throws Exception {

		/*
		 * First parameter single unsigned integer
		 */
		assertEquals(new TAJSNumbers( 1).leastUpperBound(new TAJSNumbers( 2)), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers( 1).leastUpperBound(new TAJSNumbers( 1)), new TAJSNumbers( 1));
		assertEquals(new TAJSNumbers( 1).leastUpperBound(new TAJSNumbers( 2.2)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers( 1).leastUpperBound(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers( 1).leastUpperBound(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers( 1).leastUpperBound(new TAJSNumbers(TAJSNumbers.TOP, true)), new TAJSNumbers(TAJSNumbers.TOP, true));

		
		/*
		 * Second parameter single unsigned integer
		 */
		assertEquals(new TAJSNumbers( 2).leastUpperBound(new TAJSNumbers( 1)), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers( 1).leastUpperBound(new TAJSNumbers( 1)), new TAJSNumbers( 1));
		assertEquals(new TAJSNumbers( 2.2).leastUpperBound(new TAJSNumbers( 1)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).leastUpperBound(new TAJSNumbers( 1)), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).leastUpperBound(new TAJSNumbers( 1)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).leastUpperBound(new TAJSNumbers( 1)), new TAJSNumbers(TAJSNumbers.TOP, true));
	}
	
	@Test
	public void testTAJSNumericSingleNotUnsignedInteger() throws Exception {

		/*
		 * First parameter single unsigned integer
		 */
		assertEquals(new TAJSNumbers( 1.1).leastUpperBound(new TAJSNumbers( 2)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers( 1.1).leastUpperBound(new TAJSNumbers( 1.1)), new TAJSNumbers( 1.1));
		assertEquals(new TAJSNumbers( 1.1).leastUpperBound(new TAJSNumbers( -2.2)), new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers( 1.1).leastUpperBound(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers( 1.1).leastUpperBound(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers( 1.1).leastUpperBound(new TAJSNumbers(TAJSNumbers.TOP, true)), new TAJSNumbers(TAJSNumbers.TOP, true));

		/*
		 * Second parameter single unsigned integer
		 */
		assertEquals(new TAJSNumbers( 2).leastUpperBound(new TAJSNumbers( 1.1)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers( -1.1).leastUpperBound(new TAJSNumbers( -1.1)), new TAJSNumbers( -1.1));
		assertEquals(new TAJSNumbers( 2.2).leastUpperBound(new TAJSNumbers( -1.1)), new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).leastUpperBound(new TAJSNumbers( 1.1)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).leastUpperBound(new TAJSNumbers( 1.1)), new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).leastUpperBound(new TAJSNumbers( 1.1)), new TAJSNumbers(TAJSNumbers.TOP, true));
	}
	
	@Test
	public void testTAJSNumericUnsignedInteger() throws Exception {

		/*
		 * First parameter unsigned integer
		 */
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).leastUpperBound(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).leastUpperBound(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true)),  new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).leastUpperBound(new TAJSNumbers(TAJSNumbers.BOT, true)), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true).leastUpperBound(new TAJSNumbers(TAJSNumbers.TOP, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
	}	
	
	@Test
	public void testTAJSNumericNotUnsignedInteger() throws Exception {

		/*
		 * First parameter not unsigned integer
		 */
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).leastUpperBound(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).leastUpperBound(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true)),  new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).leastUpperBound(new TAJSNumbers(TAJSNumbers.BOT, true)), new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true).leastUpperBound(new TAJSNumbers(TAJSNumbers.TOP, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
	}
	
	@Test
	public void testTAJSNumericTop() throws Exception {

		/*
		 * First parameter not unsigned integer
		 */
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).leastUpperBound(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).leastUpperBound(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true)),  new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).leastUpperBound(new TAJSNumbers(TAJSNumbers.BOT, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.TOP, true).leastUpperBound(new TAJSNumbers(TAJSNumbers.TOP, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
	}
	
	@Test
	public void testTAJSNumericBot() throws Exception {

		/*
		 * First parameter not unsigned integer
		 */
		assertEquals(new TAJSNumbers(TAJSNumbers.BOT, true).leastUpperBound(new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true)), new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.BOT, true).leastUpperBound(new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true)),  new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.BOT, true).leastUpperBound(new TAJSNumbers(TAJSNumbers.BOT, true)), new TAJSNumbers(TAJSNumbers.BOT, true));
		assertEquals(new TAJSNumbers(TAJSNumbers.BOT, true).leastUpperBound(new TAJSNumbers(TAJSNumbers.TOP, true)), new TAJSNumbers(TAJSNumbers.TOP, true));
	}
	
}
