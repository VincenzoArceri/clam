package it.univr.domain.tajs.shell;

import static org.junit.Assert.assertTrue;

import it.univr.domain.AbstractValue;

/**
 * TAJS numbers abstract domain.
 * 
 *  @author <a href="vincenzo.arceri@univr.it">Vincenzo Arceri</a>
 */
public class TAJSNumbers implements AbstractValue {

	public final static int BOT = 0x00000001; 
	public final static int UNSIGNED_INT = 0x00000002;
	public final static int NOT_UNSIGNED_INT = 0x00000003;
	public final static int SINGLE_NUM = 0x00000004;
	public final static int TOP = 0x00000005;

	private Float i;
	private int v;

	public TAJSNumbers(Float i) {
		this.i = i;
		this.v = SINGLE_NUM;
	}

	public TAJSNumbers(double i) {
		this.i = (float) i;
		this.v = SINGLE_NUM;
	}

	public TAJSNumbers(int i) {
		this.i = (float) i;
		this.v = SINGLE_NUM;
	}

	public TAJSNumbers(int v, boolean b) {
		this.i = null;
		this.v = v;
	}

	public static TAJSNumbers createUnsigned() {
		return new TAJSNumbers(UNSIGNED_INT, true);
	}

	public static TAJSNumbers createNotUnsignedInt() {
		return new TAJSNumbers(NOT_UNSIGNED_INT, true);
	}

	public int getAbstractValue() {
		return v;
	}

	public static TAJSNumbers createTopTAJSNumber() {
		return new TAJSNumbers(TOP, true);
	}

	public static TAJSNumbers createBotString() {
		return new TAJSNumbers(BOT, true);
	}

	public boolean isBot() {
		return v == BOT;
	}

	public boolean isTop() {
		return v == TOP;
	}

	public boolean isUnsignedInt() {
		return v == UNSIGNED_INT;
	}

	public boolean isNotUnsignedInt() {
		return v == NOT_UNSIGNED_INT;
	}

	public boolean isSingleNumber() {
		return v == SINGLE_NUM;
	}

	public float getSingleNumber() {
		assertTrue(isSingleNumber());
		return i;
	}

	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {

		if (other instanceof TAJSNumbers) {

			TAJSNumbers that = (TAJSNumbers) other;


			if (isTop() || that.isTop()) 
				return new TAJSNumbers(TOP, true);
			else if (that.isBot())
				return clone();
			else if (isBot())
				return that.clone();

			if (isSingleNumber() && that.isSingleNumber()) {
				if (getSingleNumber() == that.getSingleNumber())
					return clone();
				else if (isSingleNumberNotUnsignedInt() && that.isSingleNumberNotUnsignedInt())
					return new TAJSNumbers(NOT_UNSIGNED_INT, true);
				else if (isSingleNumberUnsignedInt() && that.isSingleNumberUnsignedInt())
					return new TAJSNumbers(UNSIGNED_INT, true);
				else
					return new TAJSNumbers(TOP, true);
			}

			else if (isSingleNumber()) {

				if (isSingleNumberUnsignedInt()) {
					if (that.isUnsignedInt())
						return new TAJSNumbers(UNSIGNED_INT, true);
					else if (that.isNotUnsignedInt())
						return new TAJSNumbers(TOP, true);
				}

				else if (isSingleNumberNotUnsignedInt()) {
					if (that.isUnsignedInt())
						return new TAJSNumbers(TOP, true);
					else if (that.isNotUnsignedInt())
						return new TAJSNumbers(NOT_UNSIGNED_INT, true);
				}
			}

			else if (that.isSingleNumber()) {

				if (that.isSingleNumberUnsignedInt()) {
					if (isUnsignedInt())
						return new TAJSNumbers(UNSIGNED_INT, true);
					else if (isNotUnsignedInt())
						return new TAJSNumbers(TOP, true);
				}

				else if (that.isSingleNumberNotUnsignedInt()) {
					if (isUnsignedInt())
						return new TAJSNumbers(TOP, true);
					else if (isNotUnsignedInt())
						return new TAJSNumbers(NOT_UNSIGNED_INT, true);
				}
			}

			else if (isNotUnsignedInt()) {

				if (that.getAbstractValue() == UNSIGNED_INT)
					return new TAJSNumbers(TOP, true);
				else if (that.getAbstractValue() == NOT_UNSIGNED_INT)
					return new TAJSNumbers(NOT_UNSIGNED_INT, true);
			}

			else if (isUnsignedInt()) {
				if (that.getAbstractValue() == NOT_UNSIGNED_INT)
					return new TAJSNumbers(TOP, true);
				else if (that.getAbstractValue() == UNSIGNED_INT)
					return new TAJSNumbers(UNSIGNED_INT, true);
			}

			else if (that.isNotUnsignedInt()) {

				if (getAbstractValue() == UNSIGNED_INT)
					return new TAJSNumbers(TOP, true);
				else if (getAbstractValue() == NOT_UNSIGNED_INT)
					return new TAJSNumbers(NOT_UNSIGNED_INT, true);
			}

			else if (that.isUnsignedInt()) {
				if (getAbstractValue() == NOT_UNSIGNED_INT)
					return new TAJSNumbers(TOP, true);
				else if (getAbstractValue() == UNSIGNED_INT)
					return new TAJSNumbers(UNSIGNED_INT, true);
			}
		} 

		return new Top();
	}

	@Override
	public AbstractValue widening(AbstractValue other) {
		return leastUpperBound(other);
	}


	@Override
	public String toString() {
		if (isSingleNumber())
			return String.valueOf(i);
		else if (v == UNSIGNED_INT)
			return "UnsignedInt";
		else if (v == NOT_UNSIGNED_INT)
			return "NotUnsignedInt";
		else if (v == TOP)
			return "Number";

		return "Bot";
	}



	/**
	 * Plus TAJS integers operation.
	 * 
	 * @param other second operand
	 * @return the sum between TAJS integers
	 */
	public TAJSNumbers plus(TAJSNumbers other) {

		if (isBot() || other.isBot())
			return new TAJSNumbers(BOT, true);	

		if (isTop() || other.isTop())
			return new TAJSNumbers(TOP, true);

		if (isSingleNumber() && other.isSingleNumber()) {
			return new TAJSNumbers(getSingleNumber() +  other.getSingleNumber());
		}

		else if (isSingleNumber()) {

			if (isSingleNumberUnsignedInt()) {
				if (other.isUnsignedInt())
					return new TAJSNumbers(UNSIGNED_INT, true);
				else if (other.isNotUnsignedInt())
					return new TAJSNumbers(NOT_UNSIGNED_INT, true);
			}

			if (isSingleNumberNotUnsignedInt()) {
				if (other.isUnsignedInt())
					return new TAJSNumbers(NOT_UNSIGNED_INT, true);
				else if (other.isNotUnsignedInt())
					return new TAJSNumbers(TOP, true);
			}
		}

		else if (other.isSingleNumber()) {

			if (other.isSingleNumberUnsignedInt()) {
				if (isUnsignedInt())
					return new TAJSNumbers(UNSIGNED_INT, true);
				else if (isNotUnsignedInt())
					return new TAJSNumbers(NOT_UNSIGNED_INT, true);
			}

			if (other.isSingleNumberNotUnsignedInt()) {
				if (isUnsignedInt())
					return new TAJSNumbers(NOT_UNSIGNED_INT, true);
				else if (isNotUnsignedInt())
					return new TAJSNumbers(TOP, true);
			}
		}

		else if (other.isUnsignedInt()) {
			if (isUnsignedInt())
				return new TAJSNumbers(UNSIGNED_INT, true);
			else if (isNotUnsignedInt())
				return new TAJSNumbers(NOT_UNSIGNED_INT, true);

		}

		else if (other.isNotUnsignedInt()) {
			if (isUnsignedInt())
				return new TAJSNumbers(NOT_UNSIGNED_INT, true);
			else if (isNotUnsignedInt())
				return new TAJSNumbers(TOP, true);
		}

		return new TAJSNumbers(TOP, true);
	}

	/**
	 * Minus TAJS integers operation.
	 * 
	 * @param other second operand
	 * @return the minus between TAJS integers
	 */
	public TAJSNumbers diff(TAJSNumbers other) {

		if (isBot() || other.isBot())
			return new TAJSNumbers(BOT, true);	

		if (isTop() || other.isTop())
			return new TAJSNumbers(TOP, true);

		if (isSingleNumber() && other.isSingleNumber()) {
			return new TAJSNumbers((double) getSingleNumber() -  other.getSingleNumber());
		}

		else if (isSingleNumber()) {

			if (isSingleNumberUnsignedInt()) {
				if (other.isUnsignedInt())
					return new TAJSNumbers(UNSIGNED_INT, true);
				else if (other.isNotUnsignedInt())
					return new TAJSNumbers(NOT_UNSIGNED_INT, true);
			}

			if (isSingleNumberNotUnsignedInt()) {
				if (other.isUnsignedInt())
					return new TAJSNumbers(NOT_UNSIGNED_INT, true);
				else if (other.isNotUnsignedInt())
					return new TAJSNumbers(TOP, true);
			}
		}

		else if (other.isSingleNumber()) {

			if (other.isSingleNumberUnsignedInt()) {
				if (isUnsignedInt())
					return new TAJSNumbers(UNSIGNED_INT, true);
				else if (isNotUnsignedInt())
					return new TAJSNumbers(NOT_UNSIGNED_INT, true);
			}

			if (other.isSingleNumberNotUnsignedInt()) {
				if (isUnsignedInt())
					return new TAJSNumbers(NOT_UNSIGNED_INT, true);
				else if (isNotUnsignedInt())
					return new TAJSNumbers(TOP, true);
			}
		}

		else if (other.isUnsignedInt()) {
			if (isUnsignedInt())
				return new TAJSNumbers(UNSIGNED_INT, true);
			else if (isNotUnsignedInt())
				return new TAJSNumbers(NOT_UNSIGNED_INT, true);

		}

		else if (other.isNotUnsignedInt()) {
			if (isUnsignedInt())
				return new TAJSNumbers(NOT_UNSIGNED_INT, true);
			else if (isNotUnsignedInt())
				return new TAJSNumbers(TOP, true);
		}

		return new TAJSNumbers(TOP, true);
	}

	/**
	 * Multiplication TAJS integers operation.
	 * 
	 * @param other second operand
	 * @return the multiplication between the intervals, i,e. [l1,h1] * [l2,h2].
	 */
	public TAJSNumbers mul(TAJSNumbers other) {
		if (isBot() || other.isBot())
			return new TAJSNumbers(BOT, true);	

		if (isTop() || other.isTop())
			return new TAJSNumbers(TOP, true);

		if (isSingleNumber() && other.isSingleNumber()) {
			return new TAJSNumbers((double) getSingleNumber() *  other.getSingleNumber());
		}

		if (isSingleNumber() && getSingleNumber() == 0)
			return new TAJSNumbers(0);

		else if (isSingleNumber()) {

			if (isSingleNumberUnsignedInt()) {
				if (other.isUnsignedInt())
					return new TAJSNumbers(UNSIGNED_INT, true);
				else if (other.isNotUnsignedInt())
					return new TAJSNumbers(TOP, true);
			}

			if (isSingleNumberNotUnsignedInt()) {
				if (other.isUnsignedInt())
					return new TAJSNumbers(TOP, true);
				else if (other.isNotUnsignedInt())
					return new TAJSNumbers(TOP, true);
			}
		}

		else if (other.isSingleNumber()) {

			if (other.isSingleNumberUnsignedInt()) {
				if (isUnsignedInt())
					return new TAJSNumbers(UNSIGNED_INT, true);
				else if (isNotUnsignedInt())
					return new TAJSNumbers(TOP, true);
			}

			if (other.isSingleNumberNotUnsignedInt()) {
				if (isUnsignedInt())
					return new TAJSNumbers(TOP, true);
				else if (isNotUnsignedInt())
					return new TAJSNumbers(TOP, true);
			}
		}

		// Both the abstract values are not single integers

		else if (other.isUnsignedInt()) {
			if (isUnsignedInt())
				return new TAJSNumbers(UNSIGNED_INT, true);
			else if (isNotUnsignedInt())
				return new TAJSNumbers(TOP, true);

		}

		else if (other.isNotUnsignedInt()) {
			if (isUnsignedInt())
				return new TAJSNumbers(TOP, true);
			else if (isNotUnsignedInt())
				return new TAJSNumbers(TOP, true);
		}

		return new TAJSNumbers(TOP, true);
	}

	@Override
	public TAJSNumbers clone() {
		return isSingleNumber() ? new TAJSNumbers(getSingleNumber()) : new TAJSNumbers(getAbstractValue(), true);
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof TAJSNumbers) {
			if (isSingleNumber() && ((TAJSNumbers) other).isSingleNumber()) {
				if (getSingleNumber() == ((TAJSNumbers) other).getSingleNumber())
					return true;
				else return false;
			}

			else if (!isSingleNumber() && !((TAJSNumbers) other).isSingleNumber()) {
				if (getAbstractValue() == ((TAJSNumbers) other).getAbstractValue())
					return true;
				else 
					return false;
			}
		}
		return false;
	}

	public Bool greater(TAJSNumbers other) {

		if (v == TOP || other.getAbstractValue() == TOP)
			return new Bool(2);

		else if (isSingleNumber() && other.isSingleNumber()) {
			if (getSingleNumber() > other.getSingleNumber())
				return new Bool(1);
			else
				return new Bool(0);
		}

		return new Bool(2);
	}

	public Bool less(TAJSNumbers other) {

		if (v == TOP || other.getAbstractValue() == TOP)
			return new Bool(2);

		else if (isSingleNumber() && other.isSingleNumber()) {
			if (getSingleNumber() < other.getSingleNumber())
				return new Bool(1);
			else
				return new Bool(0);
		}

		return new Bool(2);
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue o) {
		// TODO
		return null;
	}

	public Bool isEqual(TAJSNumbers other) {

		if (isSingleNumber() && other.isSingleNumber()) {
			if (getSingleNumber() == other.getSingleNumber())
				return new Bool(1);
			else
				return new Bool(0);
		}
		
		return new Bool(2);
	}

	@Override
	public AbstractValue narrowing(AbstractValue value) {
		return greatestLowerBound(value);
	}

	private boolean isSingleNumberUnsignedInt() {
		assertTrue(isSingleNumber());
		return getSingleNumber() >= 0 && getSingleNumber() == Math.ceil(getSingleNumber());
	}

	private boolean isSingleNumberNotUnsignedInt() {
		assertTrue(isSingleNumber());
		return i < 0 || getSingleNumber() != Math.ceil(getSingleNumber());
	}	

}
