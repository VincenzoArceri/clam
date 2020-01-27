package it.univr.domain.safe.original;

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
		if (value instanceof Interval) return ((Interval) value).clone();
		if (value instanceof Bottom) return new Bottom();
		if (value instanceof SAFEStrings) return ((SAFEStrings) value).clone();
		if (value instanceof Bool) return ((Bool) value).clone();
		
		return new Top();
	}
	
	@Override
	public AbstractValue narrowing(AbstractValue value) {
		return greatestLowerBound(value);
	}
}
