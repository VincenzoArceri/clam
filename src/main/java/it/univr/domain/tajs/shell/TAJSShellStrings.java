package it.univr.domain.tajs.shell;

import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import it.univr.domain.AbstractValue;
import it.univr.domain.tajs.original.TAJSStrings;

public class TAJSShellStrings implements AbstractValue {

	static private final Pattern UNSIGNED_FLOAT = Pattern.compile("[0-9]+\\.([0-9]*)"); 
	static private final Pattern NUMBER = Pattern.compile("((-|\\+)?)(([0-9]+(\\.[0-9]*)?)([eE][-+][0-9]+)?)"); 

	public final static int BOT = 0x00000001; 
	public final static int SINGLE_STRING = 0x00000002;
	public final static int UNSIGNED_STR = 0x00000003;
	public final static int NOT_UNSIGNED_STR = 0x00000004;
	public final static int NOT_NUMERIC = 0x00000006;
	public final static int SIGNED_OR_FLOATS = 0x00000007;
	public final static int UNSIGNED_OR_NOT_NUMERIC = 0x00000008;
	public final static int TOP = 0x0000009;

	private String str;
	private int v;

	public static void main(String args[]) {
		TAJSShellStrings a = new TAJSShellStrings(TAJSShellStrings.TOP).concat(new TAJSShellStrings("1"));
		TAJSShellStrings b = new TAJSShellStrings(TAJSShellStrings.TOP);
		System.err.println(a.getAbstractValue() + " " +  b.getAbstractValue());
	}

	public TAJSShellStrings(String str) {
		this.str = str;
		this.v = SINGLE_STRING;
	}

	public TAJSShellStrings(int v) {
		this.str = null;
		this.v = v;
	}

	public static TAJSShellStrings createUnsignedString() {
		return new TAJSShellStrings(UNSIGNED_STR);
	}

	public static TAJSShellStrings createNotUnsignedString() {
		return new TAJSShellStrings(NOT_UNSIGNED_STR);
	}

	public int getAbstractValue() {
		return v;
	}

	public static TAJSShellStrings createTopTAJSString() {
		return new TAJSShellStrings(TOP);
	}

	public static TAJSShellStrings createBotString() {
		return new TAJSShellStrings(BOT);
	}

	public boolean isBot() {
		return v == BOT;
	}

	public boolean isTop() {
		return v == TOP;
	}

	public boolean isUnsignedString() {
		return v == UNSIGNED_STR;
	}

	public boolean isNotUnsignedString() {
		return v == NOT_UNSIGNED_STR;
	}

	public boolean isString() {
		return v == SINGLE_STRING;
	}

	public String getSingleString() {
		assertTrue(isString());
		return str;
	}

	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {
		// TODO

		if (other instanceof TAJSShellStrings) { 
			TAJSShellStrings that = ((TAJSShellStrings) other).clone();

			if (isTop() || that.isTop())
				return createTopTAJSString();
			else if (isBot()) // if this is bot return that
				return that; 
			else if (that.isBot()) // if that is bot return this
				return clone();
			else if (isString() && that.isString())	{ // both abstract value are single strings
				if (getSingleString().equals(that.getSingleString())) // if strings are equals returns this
					return clone();
				else {
					if (isUnsignedInteger() && that.isUnsignedInteger())
						return new TAJSShellStrings(UNSIGNED_STR);
					else if (isNotNumericString() && that.isNotNumericString())
						return new TAJSShellStrings(NOT_NUMERIC);
					else if (isSignedOrFloatsString() && that.isSignedOrFloatsString())
						return new TAJSShellStrings(SIGNED_OR_FLOATS);

					// Unsigned integer
					else if (isUnsignedInteger() && that.isNotNumericString())
						return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);
					else if (that.isUnsignedInteger() && isNotNumericString())
						return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);


					else if (isUnsignedInteger() && that.isSignedOrFloatsString())
						return new TAJSShellStrings(TOP);
					else if (that.isUnsignedInteger() && isSignedOrFloatsString())
						return new TAJSShellStrings(TOP);

					// Not numeric
					else if (isNotNumericString() && that.isSignedOrFloatsString())
						return new TAJSShellStrings(NOT_UNSIGNED_STR);
					else if (that.isNotNumericString() && isSignedOrFloatsString())
						return new TAJSShellStrings(NOT_UNSIGNED_STR);

					else if (isNotNumericString() && that.isUnsignedInteger())
						return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);
					else if (that.isNotNumericString() && isUnsignedInteger())
						return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

					// Signed float
					else if (isSignedOrFloatsString() && that.isNotNumericString())
						return new TAJSShellStrings(NOT_UNSIGNED_STR);
					else if (that.isSignedOrFloatsString() && isNotNumericString())
						return new TAJSShellStrings(NOT_UNSIGNED_STR);

					else if (isSignedOrFloatsString() && that.isUnsignedInteger())
						return new TAJSShellStrings(TOP);
					else if (that.isSignedOrFloatsString() && isUnsignedInteger())
						return new TAJSShellStrings(TOP);

				}
			}

			else if (isString()) {

				if (isUnsignedInteger()) {

					if (that.getAbstractValue() == UNSIGNED_STR)
						return new TAJSShellStrings(UNSIGNED_STR);

					else if (that.getAbstractValue() == NOT_NUMERIC)
						return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

					else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
						return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);


					else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
						return new TAJSShellStrings(TOP);

					else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
						return new TAJSShellStrings(TOP);

					else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
						return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				} else if (isNotNumericString()) {

					if (that.getAbstractValue() == UNSIGNED_STR)
						return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

					else if (that.getAbstractValue() == NOT_NUMERIC)
						return new TAJSShellStrings(NOT_NUMERIC);

					else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
						return new TAJSShellStrings(NOT_UNSIGNED_STR);

					else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
						return new TAJSShellStrings(NOT_UNSIGNED_STR);

					else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
						return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				} else if (isSignedOrFloatsString()) {

					if (that.getAbstractValue() == UNSIGNED_STR)
						return new TAJSShellStrings(TOP);

					else if (that.getAbstractValue() == NOT_NUMERIC)
						return new TAJSShellStrings(NOT_UNSIGNED_STR);

					else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
						return new TAJSShellStrings(SIGNED_OR_FLOATS);

					else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
						return new TAJSShellStrings(NOT_UNSIGNED_STR);

					else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
						return new TAJSShellStrings(TOP);

				}
			}

			else if (that.isString()) {

				if (that.isUnsignedInteger()) {

					if (getAbstractValue() == UNSIGNED_STR)
						return new TAJSShellStrings(UNSIGNED_STR);

					else if (getAbstractValue() == NOT_NUMERIC)
						return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

					else if (getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
						return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

					else if (getAbstractValue() == NOT_UNSIGNED_STR)
						return new TAJSShellStrings(TOP);	

					else if (getAbstractValue() == SIGNED_OR_FLOATS)
						return new TAJSShellStrings(TOP);

					else if (getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
						return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				} else if (that.isNotNumericString()) {

					if (getAbstractValue() == UNSIGNED_STR)
						return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

					else if (getAbstractValue() == NOT_NUMERIC)
						return new TAJSShellStrings(NOT_NUMERIC);

					else if (getAbstractValue() == SIGNED_OR_FLOATS)
						return new TAJSShellStrings(NOT_UNSIGNED_STR);

					else if (getAbstractValue() == NOT_UNSIGNED_STR)
						return new TAJSShellStrings(NOT_UNSIGNED_STR);

					else if (getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
						return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				} else if (that.isSignedOrFloatsString()) {

					if (getAbstractValue() == UNSIGNED_STR)
						return new TAJSShellStrings(TOP);

					else if (getAbstractValue() == NOT_NUMERIC)
						return new TAJSShellStrings(NOT_UNSIGNED_STR);

					else if (getAbstractValue() == SIGNED_OR_FLOATS)
						return new TAJSShellStrings(SIGNED_OR_FLOATS);

					else if (getAbstractValue() == NOT_UNSIGNED_STR)
						return new TAJSShellStrings(NOT_UNSIGNED_STR);

					else if (getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
						return new TAJSShellStrings(TOP);

				}
			}

			else if (getAbstractValue() == UNSIGNED_STR) {

				if (that.getAbstractValue() == UNSIGNED_STR)
					return new TAJSShellStrings(UNSIGNED_STR);

				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
					return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
					return new TAJSShellStrings(TOP);

				else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
					return new TAJSShellStrings(TOP);
			}

			else if (getAbstractValue() == NOT_NUMERIC) {

				if (that.getAbstractValue() == UNSIGNED_STR)
					return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new TAJSShellStrings(NOT_NUMERIC);

				else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
					return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);
			}

			else if (getAbstractValue() == SIGNED_OR_FLOATS) {

				if (that.getAbstractValue() == UNSIGNED_STR)
					return new TAJSShellStrings(TOP);

				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
					return new TAJSShellStrings(TOP);

				else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);
			}

			else if (getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC) {

				if (that.getAbstractValue() == UNSIGNED_STR)
					return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
					return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
					return new TAJSShellStrings(TOP);

				else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
					return new TAJSShellStrings(TOP);
			}

			else if (getAbstractValue() == NOT_UNSIGNED_STR) {

				if (that.getAbstractValue() == UNSIGNED_STR)
					return new TAJSShellStrings(TOP);

				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
					return new TAJSShellStrings(TOP);

				else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);
			}	
		}

		return new Top();
	}

	@Override
	public AbstractValue widening(AbstractValue other) {
		return leastUpperBound(other);
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractValue narrowing(AbstractValue value) {
		return greatestLowerBound(value);
	}

	@Override
	public TAJSShellStrings clone() {
		return isString() ?  new TAJSShellStrings(str) :  new TAJSShellStrings(v);
	}

	@Override
	public String toString() {
		if (isString())
			return "\"" + getSingleString() + "\"";
		else if (isUnsignedString())
			return "UnsignedString";
		else if (isNotUnsignedString())
			return "NotUnsignedString";
		else if (getAbstractValue() == SIGNED_OR_FLOATS)
			return "SignedOrFloat";
		else if (getAbstractValue() == NOT_NUMERIC)
			return "NotNumeric";
		else if (getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
			return "UnsignedOrNotNumeric";
		else
			return "String";
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof TAJSShellStrings) {

			if (isString() && ((TAJSShellStrings) other).isString())
				return  getSingleString().equals(((TAJSShellStrings) other).getSingleString());

			if (!isString() && !((TAJSShellStrings) other).isString())
				return  v == ((TAJSShellStrings) other).getAbstractValue();
		}

		return false;
	}

	public TAJSNumbers toNum() {
		if (isString()) {
			try {
				Integer i = Integer.parseInt(str);
				return new TAJSNumbers(i);
			} catch (Exception e) {

				try {
					Float f = Float.parseFloat(getSingleString());
					return new TAJSNumbers(f);
				} catch (Exception e1) {
					return new TAJSNumbers(0);

				}
			}
		}

		else if (getAbstractValue() == UNSIGNED_STR) 
			return new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true);

		else if (getAbstractValue() == NOT_NUMERIC) 
			return new TAJSNumbers(0);

		else if (getAbstractValue() == SIGNED_OR_FLOATS) 
			return new TAJSNumbers(TAJSNumbers.NOT_UNSIGNED_INT, true);

		else if (getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC) 
			return new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true);

		else if (getAbstractValue() == NOT_UNSIGNED_STR) 
			return new TAJSNumbers(TAJSNumbers.TOP, true);

		else 
			return new TAJSNumbers(TAJSNumbers.TOP, true);
	}

	public TAJSShellStrings concat(TAJSShellStrings that) {

		if (isBot() || that.isBot()) // bottom cases
			return new TAJSShellStrings(BOT);

		else if (isString() && that.isString())
			return new TAJSShellStrings(getSingleString() + that.getSingleString());

		else if (isString()) {

			if (isUnsignedInteger()) {
				if (that.getAbstractValue() == UNSIGNED_STR)
					return new TAJSShellStrings(UNSIGNED_STR);

				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
					return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
					return new TAJSShellStrings(TOP);

				else if (that.getAbstractValue() == TOP)
					return new TAJSShellStrings(TAJSShellStrings.TOP);
			}

			else if (isNotNumericString()) {

				if (that.getAbstractValue() == UNSIGNED_STR)
					return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new TAJSShellStrings(NOT_NUMERIC);

				else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
					return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (that.getAbstractValue() == TOP)
					return new TAJSShellStrings(TAJSShellStrings.TOP);
			}

			else if (isSignedOrFloatsString()) {

				if (that.getAbstractValue() == UNSIGNED_STR)
					return new TAJSShellStrings(SIGNED_OR_FLOATS);

				else if (that.getAbstractValue() == NOT_NUMERIC)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
					return new TAJSShellStrings(NOT_NUMERIC);

				else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (that.getAbstractValue() == TOP)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);
			}
		}

		else if (that.isString()) {

			if (that.isUnsignedInteger()) {
				if (getAbstractValue() == UNSIGNED_STR)
					return new TAJSShellStrings(UNSIGNED_STR);

				else if (getAbstractValue() == NOT_NUMERIC)
					return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				else if (getAbstractValue() == SIGNED_OR_FLOATS)
					return new TAJSShellStrings(SIGNED_OR_FLOATS);

				else if (getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
					return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				else if (getAbstractValue() == NOT_UNSIGNED_STR)
					return new TAJSShellStrings(TOP);

				else if (getAbstractValue() == TOP)
					return new TAJSShellStrings(TAJSShellStrings.TOP);
			}

			else if (that.isNotNumericString()) {

				if (getAbstractValue() == UNSIGNED_STR)
					return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				else if (getAbstractValue() == NOT_NUMERIC)
					return new TAJSShellStrings(NOT_NUMERIC);

				else if (getAbstractValue() == SIGNED_OR_FLOATS)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
					return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

				else if (getAbstractValue() == NOT_UNSIGNED_STR)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (getAbstractValue() == TOP)
					return new TAJSShellStrings(TOP);
			}

			else if (that.isSignedOrFloatsString()) {

				if (getAbstractValue() == UNSIGNED_STR)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (getAbstractValue() == NOT_NUMERIC)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (getAbstractValue() == SIGNED_OR_FLOATS)
					return new TAJSShellStrings(NOT_NUMERIC);

				else if (getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (getAbstractValue() == NOT_UNSIGNED_STR)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);

				else if (getAbstractValue() == TOP)
					return new TAJSShellStrings(NOT_UNSIGNED_STR);
			}
		}

		else if (getAbstractValue() == UNSIGNED_STR) {

			if (that.getAbstractValue() == UNSIGNED_STR)
				return new TAJSShellStrings(UNSIGNED_STR);

			else if (that.getAbstractValue() == NOT_NUMERIC)
				return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

			else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
				return new TAJSShellStrings(NOT_UNSIGNED_STR);

			else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
				return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

			else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
				return new TAJSShellStrings(TOP);

			else if (that.getAbstractValue() == TOP)
				return new TAJSShellStrings(TOP);
		}

		else if (getAbstractValue() == NOT_NUMERIC) {

			if (that.getAbstractValue() == UNSIGNED_STR)
				return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

			else if (that.getAbstractValue() == NOT_NUMERIC)
				return new TAJSShellStrings(NOT_NUMERIC);

			else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
				return new TAJSShellStrings(NOT_UNSIGNED_STR);

			else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
				return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

			else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
				return new TAJSShellStrings(NOT_UNSIGNED_STR);

			else if (that.getAbstractValue() == TOP)
				return new TAJSShellStrings(TOP);
		}

		else if (getAbstractValue() == SIGNED_OR_FLOATS) {

			if (that.getAbstractValue() == UNSIGNED_STR)
				return new TAJSShellStrings(SIGNED_OR_FLOATS);

			else if (that.getAbstractValue() == NOT_NUMERIC)
				return new TAJSShellStrings(NOT_UNSIGNED_STR);

			else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
				return new TAJSShellStrings(NOT_NUMERIC);

			else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
				return new TAJSShellStrings(NOT_UNSIGNED_STR);

			else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
				return new TAJSShellStrings(NOT_UNSIGNED_STR);

			else if (that.getAbstractValue() == TOP)
				return new TAJSShellStrings(NOT_UNSIGNED_STR);
		}

		else if (getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC) {

			if (that.getAbstractValue() == UNSIGNED_STR)
				return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

			else if (that.getAbstractValue() == NOT_NUMERIC)
				return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

			else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
				return new TAJSShellStrings(NOT_UNSIGNED_STR);

			else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
				return new TAJSShellStrings(UNSIGNED_OR_NOT_NUMERIC);

			else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
				return new TAJSShellStrings(TOP);

			else if (that.getAbstractValue() == TOP)
				return new TAJSShellStrings(TOP);

		}

		else if (getAbstractValue() == NOT_UNSIGNED_STR) {

			if (that.getAbstractValue() == UNSIGNED_STR)
				return new TAJSShellStrings(NOT_UNSIGNED_STR);

			else if (that.getAbstractValue() == NOT_NUMERIC)
				return new TAJSShellStrings(NOT_UNSIGNED_STR);

			else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
				return new TAJSShellStrings(NOT_UNSIGNED_STR);

			else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
				return new TAJSShellStrings(TOP);

			else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
				return new TAJSShellStrings(NOT_UNSIGNED_STR);

			else if (that.getAbstractValue() == TOP)
				return new TAJSShellStrings(TAJSShellStrings.TOP);
		}

		else if (getAbstractValue() == TOP) {

			if (that.getAbstractValue() == UNSIGNED_STR)
				return new TAJSShellStrings(TOP);

			else if (that.getAbstractValue() == NOT_NUMERIC)
				return new TAJSShellStrings(TOP);

			else if (that.getAbstractValue() == SIGNED_OR_FLOATS)
				return new TAJSShellStrings(NOT_UNSIGNED_STR);

			else if (that.getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
				return new TAJSShellStrings(TOP);

			else if (that.getAbstractValue() == NOT_UNSIGNED_STR)
				return new TAJSShellStrings(TOP);

			else if (that.getAbstractValue() == TOP)
				return new TAJSShellStrings(TAJSShellStrings.TOP);
		}

		return new TAJSShellStrings(BOT);
	}

	private  boolean isUnsignedInteger() {
		if (getSingleString().isEmpty())
			return false;
		long val = 0L;
		for (int i = 0; i < getSingleString().length(); i++) {
			char c = getSingleString().charAt(i);
			if (c < '0' || c > '9')
				return false;
			val = 10 * val + Character.digit(c, 10);
			if (val > 2 * (long) Integer.MAX_VALUE)
				return false;
		}

		return true;
	}

	private boolean isSignedOrFloatsString() {
		assertTrue(isString());

		if (NUMBER.matcher(str).matches())
			if (UNSIGNED_FLOAT.matcher(str).matches() || str.charAt(0) == '-' || str.charAt(0) == '+')
				return true;

		return false;
	}

	private boolean isNotNumericString() {
		return str.isEmpty() || (!isUnsignedInteger() && !isSignedOrFloatsString());
	}

	@Override
	public int distanceFromBottom() {

		if (isString())
			return 1;

		switch (v) {
		case UNSIGNED_STR:
		case NOT_NUMERIC:
		case SIGNED_OR_FLOATS: return 2;

		case NOT_UNSIGNED_STR:
		case UNSIGNED_OR_NOT_NUMERIC: return 3;

		case BOT: return 0;
		default: return 4;
		}
	}

	@Override
	public String distanceFrom(AbstractValue other) {

		if (other instanceof TAJSStrings) {
			TAJSShellStrings that = ((TAJSStrings) other).castToShell();


			if (equals(that))
				return "-";

			if (isString()) {

				if (isUnsignedInteger()) {
					if (that.getAbstractValue() == UNSIGNED_STR)
						return "1";
					else if (that.getAbstractValue() == TOP)
						return "2";
				}

				else if (isNotNumericString()) {
					if (that.getAbstractValue() == NOT_UNSIGNED_STR)
						return "1";
					else if (that.getAbstractValue() == TOP)
						return "2";
				}

				else if (isSignedOrFloatsString()) {
					if (that.getAbstractValue() == NOT_UNSIGNED_STR)
						return "1";
					else if (that.getAbstractValue() == TOP)
						return "2";
				}
			}

			else if (getAbstractValue() == UNSIGNED_STR) {
				if (that.getAbstractValue() == UNSIGNED_STR)
					return "-";
				else if (that.getAbstractValue() == TOP)
					return "1";
			}

			else if (getAbstractValue() == NOT_NUMERIC) {
				if (that.getAbstractValue() == NOT_UNSIGNED_STR)
					return "1";
				else if (that.getAbstractValue() == TOP)
					return "2";
			}

			else if (getAbstractValue() == SIGNED_OR_FLOATS) {
				if (that.getAbstractValue() == NOT_UNSIGNED_STR)
					return "1";
				else if (that.getAbstractValue() == TOP)
					return "2";
			}

			else if (getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC) {
				if (that.getAbstractValue() == TOP)
					return "2";
			}

			else if (getAbstractValue() == NOT_UNSIGNED_STR) {
				if (that.getAbstractValue() == NOT_UNSIGNED_STR)
					return "-";
				else if (that.getAbstractValue() == TOP)
					return "1";
			}

			else if (getAbstractValue() == TOP) {
				if (that.getAbstractValue() == TOP)
					return "-";
			}		
		}

		return "-";
	}

	public AbstractValue length() {
		if (isString())
			return new TAJSNumbers(getSingleString().length());
		else
			return new TAJSNumbers(TAJSNumbers.UNSIGNED_INT, true);
	}

	public AbstractValue charAt(TAJSNumbers idx) {
		if (idx.isSingleNumber()) {
			if (isString()) {
				String s = getSingleString();
				int i = idx.getSingleNumber() < 0 ? 0 : (int) idx.getSingleNumber();

				if (i < s.length())
					return new TAJSShellStrings(String.valueOf(s.charAt(i)));
				else 
					return new TAJSShellStrings("");
			}

			else if (isUnsignedString())
				return new TAJSShellStrings(UNSIGNED_STR);

			else if (getAbstractValue() == NOT_NUMERIC 
					|| getAbstractValue() == SIGNED_OR_FLOATS 
					|| getAbstractValue() == NOT_UNSIGNED_STR 
					|| getAbstractValue() == TOP 
					|| getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)

				return new TAJSShellStrings(TOP);
		}

		else if (idx.isUnsignedInt() || idx.isNotUnsignedInt() || idx.isTop()) {
			if (isString()) {
				if (isUnsignedInteger())
					return new TAJSShellStrings(UNSIGNED_STR);
				else if (!containsNumbers())
					return new TAJSShellStrings(NOT_UNSIGNED_STR);
				else 
					return new TAJSShellStrings(TOP);
			}

			else if (isUnsignedString())
				return new TAJSShellStrings(UNSIGNED_STR);

			else if (getAbstractValue() == NOT_NUMERIC 
					|| getAbstractValue() == SIGNED_OR_FLOATS 
					|| getAbstractValue() == NOT_UNSIGNED_STR 
					|| getAbstractValue() == TOP 
					|| getAbstractValue() == UNSIGNED_OR_NOT_NUMERIC)
				return new TAJSShellStrings(TOP);

		}

		return new Bottom();
	}

	private boolean containsNumbers() {
		assertTrue(isString());
		return str.contains("0")
				|| str.contains("1")
				|| str.contains("2")
				|| str.contains("3")
				|| str.contains("4")
				|| str.contains("5")
				|| str.contains("6")
				|| str.contains("7")
				|| str.contains("8")
				|| str.contains("9");
	}
}
