package it.univr.main;

import it.univr.domain.AbstractDomain;
import it.univr.domain.AbstractValue;

import it.univr.state.AbstractEnvironment;
import it.univr.state.AbstractState;
import it.univr.state.KeyAbstractState;
import it.univr.state.Variable;

public class AbstractInterpreter extends MuJsBaseVisitor<AbstractValue> {

	private AbstractEnvironment env;
	private AbstractDomain domain;
	private AbstractState state;

	private boolean printInvariants;

	public AbstractInterpreter(AbstractDomain domain, boolean narrowing, boolean invariants) {
		this.env = new AbstractEnvironment(domain);
		this.state = new AbstractState();
		this.printInvariants = invariants;
	}

	public AbstractEnvironment getFinalAbstractMemory() {
		return env;
	}

	public AbstractState getAbstractState() {
		return state;
	}

	public void setAbstractState(AbstractEnvironment env) {
		this.env = env;
	}

	public AbstractDomain getAbstractDomain() {
		return domain;
	}

	public void setAbstractDomain(AbstractDomain domain) {
		this.domain = domain;
	}

	

	@Override 
	public AbstractValue visitBlock(MuJsParser.BlockContext ctx) { 
		if (ctx.stmt() != null)
			visit(ctx.stmt());
		
		return domain.makeBottom();
	}

	@Override 
	public AbstractValue visitComposition(MuJsParser.CompositionContext ctx) { 
		visit(ctx.stmt(0));	
		visit(ctx.stmt(1));
		return domain.makeBottom();
	}

	@Override 
	public AbstractValue visitIfStmt(MuJsParser.IfStmtContext ctx) { 
		AbstractValue guard = visit(ctx.bexp());
		if (domain.isTrue(guard)) 
			return visit(ctx.block(0));

		if (domain.isFalse(guard))
			return visit(ctx.block(1));

		AbstractEnvironment previous = (AbstractEnvironment) env.clone();

		visit(ctx.block(0));

		AbstractEnvironment trueBranch = (AbstractEnvironment) env.clone();
		env = previous;

		visit(ctx.block(1));

		env = env.leastUpperBound(trueBranch);

		if (printInvariants) {
			KeyAbstractState key = new KeyAbstractState(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
			state.add(key, env.clone());
		}		

		return domain.makeBottom();
	}

	@Override 
	public AbstractValue visitProgramExecution(MuJsParser.ProgramExecutionContext ctx) {
		return visit(ctx.stmt()); 
	}

	@Override
	public AbstractValue visitLength(MuJsParser.LengthContext ctx) {
		AbstractValue par = visit(ctx.sexp());
		return domain.length(par);
	}
	
	@Override
	public AbstractValue visitCharAt(MuJsParser.CharAtContext ctx) {
		AbstractValue str = visit(ctx.sexp());
		AbstractValue idx = visit(ctx.aexp());
		return domain.charAt(str, idx);
	}



	@Override public AbstractValue visitEquals(MuJsParser.EqualsContext ctx) { 
		AbstractValue left = visit(ctx.aexp(0));
		AbstractValue right = visit(ctx.aexp(1));

		return domain.equals(left, right);
	}

	@Override 
	public AbstractValue visitLess(MuJsParser.LessContext ctx) { 
		AbstractValue left = visit(ctx.aexp(0));
		AbstractValue right = visit(ctx.aexp(1));

		return domain.less(left, right);
	}

	@Override 
	public AbstractValue visitDiff(MuJsParser.DiffContext ctx) { 
		AbstractValue left = visit(ctx.aexp(0));
		AbstractValue right = visit(ctx.aexp(1));

		return domain.diff(left, right);
	}

	@Override 
	public AbstractValue visitMul(MuJsParser.MulContext ctx) {
		AbstractValue left = visit(ctx.aexp(0));
		AbstractValue right = visit(ctx.aexp(1));

		return domain.mul(left, right);
	}


	@Override 
	public AbstractValue visitSum(MuJsParser.SumContext ctx) { 
		AbstractValue left = visit(ctx.aexp(0));
		AbstractValue right = visit(ctx.aexp(1));

		return domain.sum(left, right);
	}

	//TODO: division
	@Override 
	public AbstractValue visitDiv(MuJsParser.DivContext ctx) { 
		AbstractValue left = visit(ctx.aexp(0));
		AbstractValue right = visit(ctx.aexp(1));

		return domain.div(left, right);
	}

	@Override 
	public AbstractValue visitNot(MuJsParser.NotContext ctx) { 
		AbstractValue v = visit(ctx.bexp());
		return domain.not(v);		
	}


	@Override 
	public AbstractValue visitConcat(MuJsParser.ConcatContext ctx) { 
		AbstractValue first = visit(ctx.sexp(0));
		AbstractValue second = visit(ctx.sexp(1));

		return domain.concat(first, second);
	}

	@Override 
	public AbstractValue visitAnd(MuJsParser.AndContext ctx) { 
		AbstractValue first = visit(ctx.bexp(0));
		AbstractValue second = visit(ctx.bexp(1));

		return domain.and(first, second);
	}

	@Override 
	public AbstractValue visitOr(MuJsParser.OrContext ctx) { 
		AbstractValue first = visit(ctx.bexp(0));
		AbstractValue second = visit(ctx.bexp(1));

		return domain.or(first, second);
	}
	
	@Override
	public AbstractValue visitIdBExp(MuJsParser.IdBExpContext ctx) { 
		Variable v = new Variable(ctx.ID().getText());

		if (env.getStore().containsKey(v))
			return env.getStore().get(v);
		else
			return domain.makeBottom();
	}
	
	@Override 
	public AbstractValue visitInt(MuJsParser.IntContext ctx) { 
		return domain.makeIntegerAbstractValue(Integer.valueOf(ctx.INT().getText()));
	}
	@Override 
	public AbstractValue visitStr(MuJsParser.StrContext ctx) { 
		return domain.makeStringAbstractValue(ctx.STRING().getText().substring(0, ctx.STRING().getText().length()-1).substring(1));
	}	
	
	@Override public AbstractValue visitBool(MuJsParser.BoolContext ctx) { 
		return domain.makeBooleanAbstractValue(ctx.BOOL().getText().equals("true") ? 1 : 0);
	}
	
	@Override 
	public AbstractValue visitBExpPar(MuJsParser.BExpParContext ctx) { 
		return visit(ctx.bexp()); 
	}

	@Override 
	public AbstractValue visitSExpPar(MuJsParser.SExpParContext ctx) { 
		return visit(ctx.sexp()); 
	}

	@Override 
	public AbstractValue visitAExpPar(MuJsParser.AExpParContext ctx) { 
		return visit(ctx.aexp()); 
	}

	
	@Override 
	public AbstractValue visitWhileStmt(MuJsParser.WhileStmtContext ctx) { 

		AbstractEnvironment previous = (AbstractEnvironment) env.clone();

		do {
			AbstractValue guard =  visit(ctx.bexp());

			/**
			 * True
			 */
			if (domain.isTrue(guard)) {
				visit(ctx.block());
				env = previous.widening(env);
			} 

			/**
			 * False
			 */
			else if (domain.isFalse(guard)) {
				break;
			} 

			/**
			 * Top
			 */
			else {
				visit(ctx.block());
				env = previous.widening(previous.leastUpperBound(env));
			}

			AbstractEnvironment e =  env.clone();


			if (previous.equals(e))
				break;
			else
				previous = e.clone();
		} while (true);


		if (printInvariants) {
			KeyAbstractState key = new KeyAbstractState(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
			state.add(key, env.clone());
		}

		return domain.makeBottom();
	}

	@Override 
	public AbstractValue visitIdAExp(MuJsParser.IdAExpContext ctx) { 
		Variable v = new Variable(ctx.ID().getText());

		if (env.getStore().containsKey(v))
			return env.getStore().get(v);
		else
			return domain.makeBottom();
	}
	
	@Override 
	public AbstractValue visitBlockStmt(MuJsParser.BlockStmtContext ctx) { 
		if (ctx.block() != null)
			visit(ctx.block());

		return domain.makeBottom();
	}
	
	@Override 
	public AbstractValue visitToNum(MuJsParser.ToNumContext ctx) { 
		AbstractValue par = visit(ctx.sexp());
		return domain.toNum(par);
	}

	@Override 
	public AbstractValue visitAssignmentStmt(MuJsParser.AssignmentStmtContext ctx) { 
		Variable v = new Variable(ctx.getChild(0).getText());
		env.put(v, visit(ctx.exp()));

		if (printInvariants) {
			KeyAbstractState key = new KeyAbstractState(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
			state.add(key, env.clone());
		}
		
		return domain.makeBottom();
	}

	@Override 
	public AbstractValue visitIdSExp(MuJsParser.IdSExpContext ctx) {
		Variable v = new Variable(ctx.ID().getText());

		if (env.getStore().containsKey(v))
			return env.getStore().get(v);
		else
			return domain.makeBottom();
	}
	
	@Override 
	public AbstractValue visitBeExp(MuJsParser.BeExpContext ctx) { 
		return visit(ctx.bexp()); 
	}
	
	@Override 
	public AbstractValue visitAeExp( MuJsParser.AeExpContext ctx) { 
		return visit(ctx.aexp()); 
	}
	
	@Override 
	public AbstractValue visitSeExp( MuJsParser.SeExpContext ctx) { 
		return visit(ctx.sexp()); 
	}
}
