package it.univr.domain.tajs.shell;

import it.univr.domain.AbstractValue;

public class Top implements AbstractValue {

	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {
		return new Top();
	}

	@Override
	public AbstractValue widening(AbstractValue other) {
		return new Top();
	}

	@Override
	public String toString() {
		return "T";
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof Top ? true : false;
	}
	
	@Override
	public int hashCode() {
		return "T".hashCode();
	}

	@Override
	public Object clone() {
		return new Top();
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue value) {
		if (value instanceof TAJSNumbers) return ((TAJSNumbers) value).clone();
		if (value instanceof Bottom) return new Bottom();
		if (value instanceof TAJSShellStrings) return ((TAJSShellStrings) value).clone();
		if (value instanceof Bool) return ((Bool) value).clone();
		
		return new Top();
	}
	
	@Override
	public AbstractValue narrowing(AbstractValue value) {
		return greatestLowerBound(value);
	}
}
