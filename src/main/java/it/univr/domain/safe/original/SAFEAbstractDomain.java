package it.univr.domain.safe.original;

import it.univr.domain.AbstractDomain;
import it.univr.domain.AbstractValue;
import it.univr.domain.safe.original.Bool;
import it.univr.domain.safe.original.Bottom;
import it.univr.domain.safe.original.Interval;
import it.univr.domain.safe.original.SAFEStrings;
import it.univr.domain.safe.original.Top;

public class SAFEAbstractDomain extends AbstractDomain {

	@Override
	public AbstractValue leastUpperBound(AbstractValue v1, AbstractValue v2) {
		if (v1.getClass().equals(v2.getClass()))
			return v1.leastUpperBound(v2);
		return new Top();
	}

	@Override
	public AbstractValue widening(AbstractValue v1, AbstractValue v2) {

		if (v1.getClass().equals(v2.getClass()))
			return v1.widening(v2);
		return new Top();
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue v1, AbstractValue v2) {

		if (v1.getClass().equals(v2.getClass()))
			return v1.greatestLowerBound(v2);
		return new Top();
	}



	@Override
	public AbstractValue less(AbstractValue left, AbstractValue right) {
		if (left instanceof Interval && right instanceof Interval ) 
			return ((Interval) left).less((Interval) right);		

		return new Top();
	}

	@Override
	public AbstractValue sum(AbstractValue left, AbstractValue right) {
		if (left instanceof Interval && right instanceof Interval ) 
			return ((Interval) left).plus((Interval) right);		
		return new Top();
	}

	@Override
	public AbstractValue diff(AbstractValue left, AbstractValue right) {
		if (left instanceof Interval && right instanceof Interval ) 
			return ((Interval) left).diff((Interval) right);		
		return new Top();
	}

	@Override
	public AbstractValue mul(AbstractValue left, AbstractValue right) {
		if (left instanceof Interval && right instanceof Interval ) 
			return ((Interval) left).mul((Interval) right);		
		return new Top();
	}

	@Override
	public AbstractValue not(AbstractValue v1) {
		return ((Bool) v1).not();
	}

	@Override
	public AbstractValue makeIntegerAbstractValue(Integer v) {
		return new Interval(v.toString(), v.toString());
	}

	@Override
	public  AbstractValue makeStringAbstractValue(String v) {
		return new SAFEStrings(v);
	}

	@Override
	public  AbstractValue makeBooleanAbstractValue(int v) {
		return new Bool(v);
	}

	@Override
	public AbstractValue equals(AbstractValue left, AbstractValue right) {
		if (left instanceof Interval && right instanceof Interval)
			return ((Interval) left).isEqual((Interval) right);
		return new Top();
	}

	@Override
	public AbstractValue and(AbstractValue first, AbstractValue second) {
		if (first instanceof Bool && second instanceof Bool)
			return ((Bool) first).and((Bool) second);
		return new Bottom();
	}

	@Override
	public AbstractValue or(AbstractValue first, AbstractValue second) {
		if (first instanceof Bool && second instanceof Bool)
			return ((Bool) first).or((Bool) second);
		return new Bottom();
	}

	@Override
	public AbstractValue div(AbstractValue left, AbstractValue right) {
		//TODO:div
		return new Top();
	}

	@Override
	public AbstractValue concat(AbstractValue left, AbstractValue right) {
		if (left instanceof SAFEStrings && right instanceof SAFEStrings) 
			return ((SAFEStrings) left).concat((SAFEStrings) right);		
		return new Bottom();
	}

	@Override
	public AbstractValue makeBottom() {
		return new Bottom();
	}

	@Override
	public boolean isTrue(AbstractValue v) {
		return v instanceof Bool && ((Bool) v).isTrue();
	}

	public boolean isFalse(AbstractValue v) {
		return v instanceof Bool && ((Bool) v).isFalse();
	}

	public boolean isTopBool(AbstractValue v) {
		return v instanceof Bool && ((Bool) v).isTopBool();
	}

	@Override
	public AbstractValue toNum(AbstractValue par) {

		if (par instanceof SAFEStrings) 
			return ((SAFEStrings) par).toNum();
			
		return new Bottom();
	}

	@Override
	public AbstractValue length(AbstractValue other) {
		if (other instanceof SAFEStrings) 
			return ((SAFEStrings) other).length();
			
		return new Bottom();
	}

	@Override
	public AbstractValue charAt(AbstractValue str, AbstractValue idx) {
		if (str instanceof SAFEStrings && idx instanceof Interval)
			return ((SAFEStrings) str).charAt((Interval) idx);
		return new Bottom();
	}

}
