package it.univr.domain;

public abstract class AbstractDomain {

	public abstract AbstractValue leastUpperBound(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue greatestLowerBound(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue widening(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue less(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue sum(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue diff(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue mul(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue concat(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue not(AbstractValue v1);
	public abstract AbstractValue equals(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue and(AbstractValue first, AbstractValue second);
	public abstract AbstractValue or(AbstractValue first, AbstractValue second);
	public abstract AbstractValue div(AbstractValue left, AbstractValue right);
	public abstract AbstractValue toNum(AbstractValue par);
	public abstract AbstractValue charAt(AbstractValue str, AbstractValue idx);
	public abstract AbstractValue makeIntegerAbstractValue(Integer v);
	public abstract AbstractValue makeStringAbstractValue(String v);
	public abstract AbstractValue makeBooleanAbstractValue(int v);
	public abstract AbstractValue makeBottom();
	public abstract AbstractValue length(AbstractValue other);
	public abstract boolean isTrue(AbstractValue v);
	public abstract boolean isFalse(AbstractValue v);
	public abstract boolean isTopBool(AbstractValue v);

}
