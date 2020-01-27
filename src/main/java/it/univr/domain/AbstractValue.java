package it.univr.domain;

public interface AbstractValue {

	public AbstractValue leastUpperBound(AbstractValue other);
	public AbstractValue widening(AbstractValue other);
	public String toString();
	public AbstractValue greatestLowerBound(AbstractValue value);
	public AbstractValue narrowing(AbstractValue value);
	
	public default int distanceFromBottom() {
		return 0;
	}
	
	public default String distanceFrom(AbstractValue other) {
		return "-";
	}
}
