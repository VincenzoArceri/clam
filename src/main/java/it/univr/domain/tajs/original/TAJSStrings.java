package it.univr.domain.tajs.original;

import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import it.univr.domain.AbstractValue;
import it.univr.domain.tajs.shell.TAJSShellStrings;

public class TAJSStrings implements AbstractValue {

	static private final Pattern NUMBER = Pattern.compile("((-|\\+)?)(([0-9]+(\\.[0-9]*)?)([eE][-+][0-9]+)?)"); 

	
	private final static int BOT = 0x00000001; 
	private final static int SINGLE_STRING = 0x00000002;
	private final static int UNSIGNED_STR = 0x00000003;
	private final static int NOT_UNSIGNED_STR = 0x00000004;
	private final static int TOP = 0x00000005;


	private String str;
	private int v;

	public TAJSStrings(String str) {
		this.str = str;
		this.v = SINGLE_STRING;
	}

	public TAJSStrings(int v) {
		this.str = null;
		this.v = v;
	}

	public static TAJSStrings createUnsignedString() {
		return new TAJSStrings(UNSIGNED_STR);
	}

	public static TAJSStrings createNotUnsignedString() {
		return new TAJSStrings(NOT_UNSIGNED_STR);
	}

	public int getAbstractValue() {
		return v;
	}

	public static TAJSStrings createTopTAJSString() {
		return new TAJSStrings(TOP);
	}

	public static TAJSStrings createBotString() {
		return new TAJSStrings(BOT);
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
		if (other instanceof TAJSStrings) { 
			TAJSStrings that = ((TAJSStrings) other).clone();

			if (isTop() || that.isTop())
				return createTopTAJSString();
			else if (isBot()) // if this is bot return that
				return that; 
			else if (that.isBot()) // if that is bot return this
				return clone();
			else if (isString() && that.isString())	{ // both abstract value are single strings
				if (getSingleString().equals(that.getSingleString())) // if strings are equals returns this
					return clone();
				else 
					return isUnsignedInteger() && that.isUnsignedInteger() ? createUnsignedString() 
							: (!isUnsignedInteger() && !that.isUnsignedInteger() ? createNotUnsignedString() : createTopTAJSString());
			}

			else if (isString()) {
				// this is single string and it is numeric
				if (isUnsignedInteger()) {
					if (that.isNotUnsignedString())
						return createTopTAJSString();

					if (that.isUnsignedString())
						return that;
				} 
				// this is single string and it is not numeric
				else {
					if (that.isNotUnsignedString())
						return that;

					if (that.isUnsignedString())
						return createTopTAJSString();

				}	
			}

			else if (that.isString()) {

				// that is single string and it is numeric
				if (that.isUnsignedInteger()) {
					if (isNotUnsignedString())
						return createTopTAJSString();

					if (isUnsignedString())
						return clone();
				} 
				// that is single string and it is not numeric
				else {
					if (isNotUnsignedString())
						return clone();

					if (isUnsignedString())
						return createTopTAJSString();

				}	
			}

			else if (isUnsignedString() && that.isUnsignedString() || isNotUnsignedString() && that.isNotUnsignedString())
				return that;
			else if (isUnsignedString() && that.isNotUnsignedString() || isNotUnsignedString() && that.isUnsignedString())
				return createTopTAJSString();
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
	public TAJSStrings clone() {
		return isString() ?  new TAJSStrings(str) :  new TAJSStrings(v);
	}

	@Override
	public String toString() {
		if (isString())
			return "\"" + getSingleString() + "\"";
		else if (isUnsignedString())
			return "UnsignedString";
		else if (isNotUnsignedString())
			return "NotUnsignedString";
		else
			return "String";
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof TAJSStrings) {
			return isString() && ((TAJSStrings) other).isString() ? getSingleString().equals(((TAJSStrings) other).getSingleString()) : v == ((TAJSStrings) other).getAbstractValue();
		}

		return false;
	}

	public TAJSNumbers toNum() {

		if (isUnsignedString())
			return TAJSNumbers.createUnsigned();
		else if (isNotUnsignedString() || isTop())
			return TAJSNumbers.createTopTAJSNumber();
		else if (isBot())
			return TAJSNumbers.createBotString();
		else {

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
	}

	public TAJSStrings concat(TAJSStrings that) {

		if (isBot() || that.isBot()) // bottom cases
			return new TAJSStrings(BOT);

		if (isString() && that.isString())
			return new TAJSStrings(getSingleString() + that.getSingleString());

		if (isString()) {

			if (isUnsignedInteger()) {

				if (that.isUnsignedString())
					return TAJSStrings.createUnsignedString();
				
				if (that.isNotUnsignedString() || that.isTop())
					return TAJSStrings.createTopTAJSString();
				
			} else {
				return TAJSStrings.createNotUnsignedString();
			}

		}

		if (that.isString()) {

			if (that.isUnsignedInteger()) {
				
				if (isUnsignedString())
					return TAJSStrings.createUnsignedString();
				
				if (isNotUnsignedString() || isTop())
					return TAJSStrings.createTopTAJSString();
				
			} else {
				return TAJSStrings.createNotUnsignedString();
			}
		}

		if (isUnsignedString() && that.isUnsignedString())
			return TAJSStrings.createUnsignedString();

		if (isNotUnsignedString() && that.isNotUnsignedString())
			return TAJSStrings.createNotUnsignedString();
		
		if (isUnsignedString() && that.isNotUnsignedString())
			return TAJSStrings.createTopTAJSString();
		
		if (that.isUnsignedString() && isNotUnsignedString())
			return TAJSStrings.createTopTAJSString();
		
		if (isTop() || that.isUnsignedString())
			return TAJSStrings.createTopTAJSString();
		
		if (that.isTop() || isUnsignedString())
			return TAJSStrings.createTopTAJSString();
		
		if (isTop() || that.isNotUnsignedString())
			return TAJSStrings.createTopTAJSString();
		
		if (that.isTop() || isNotUnsignedString())
			return TAJSStrings.createTopTAJSString();
		
		return TAJSStrings.createBotString();		
	}
	
	private boolean isNotNumericAndNotEmpty() {
		assertTrue(isString());
		return !isNumericString() && !getSingleString().isEmpty();
	}
	
	private boolean isNumericString() {
		assertTrue(isString());
		return NUMBER.matcher(str).matches();
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

	public int distanceFromBottom() {

		if (isString())
			return 1;

		switch (v) {
		case UNSIGNED_STR: return 2;

		case NOT_UNSIGNED_STR: return 3;

		case BOT: return 0;
		default: return 4;
		}
	}


	public TAJSShellStrings castToShell() {

		if (isString())
			return new TAJSShellStrings(getSingleString());

		else if (isUnsignedString())
			return new TAJSShellStrings(TAJSShellStrings.UNSIGNED_STR);

		else if (isNotUnsignedString())
			return new TAJSShellStrings(TAJSShellStrings.NOT_UNSIGNED_STR);

		else if (isTop())
			return new TAJSShellStrings(TAJSShellStrings.TOP);

		return new TAJSShellStrings(TAJSShellStrings.BOT);
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
					return new TAJSStrings(String.valueOf(s.charAt(i)));
				else 
					return new TAJSStrings("");
			}
			
			else if (isUnsignedString())
				return new TAJSStrings(UNSIGNED_STR);
			
			else if (isNotUnsignedString())
				return new TAJSStrings(TOP);
		}
		
		else if (idx.isUnsignedInt() || idx.isNotUnsignedInt() || idx.isTop()) {
			if (isString()) {
				if (isUnsignedInteger())
					return new TAJSStrings(UNSIGNED_STR);
				else if (!containsNumbers())
					return new TAJSStrings(NOT_UNSIGNED_STR);
				else
					return new TAJSStrings(TOP);
			}
			
			else if (isUnsignedString())
				return new TAJSStrings(UNSIGNED_STR);
			
			else if (isNotUnsignedString())
				return new TAJSStrings(TOP);
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
