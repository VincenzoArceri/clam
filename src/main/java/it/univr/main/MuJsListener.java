// Generated from /home/vincenzo/Scrivania/ictac/mu-js/src/main/java/it/univr/main/MuJs.g4 by ANTLR 4.7.2

    package it.univr.main;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MuJsParser}.
 */
public interface MuJsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ProgramExecution}
	 * labeled alternative in {@link MuJsParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgramExecution(MuJsParser.ProgramExecutionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProgramExecution}
	 * labeled alternative in {@link MuJsParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgramExecution(MuJsParser.ProgramExecutionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Div}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterDiv(MuJsParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitDiv(MuJsParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Length}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterLength(MuJsParser.LengthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Length}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitLength(MuJsParser.LengthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Diff}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterDiff(MuJsParser.DiffContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Diff}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitDiff(MuJsParser.DiffContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterMul(MuJsParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitMul(MuJsParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdAExp}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterIdAExp(MuJsParser.IdAExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdAExp}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitIdAExp(MuJsParser.IdAExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AExpPar}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterAExpPar(MuJsParser.AExpParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AExpPar}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitAExpPar(MuJsParser.AExpParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToNum}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterToNum(MuJsParser.ToNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToNum}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitToNum(MuJsParser.ToNumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterSum(MuJsParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitSum(MuJsParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterInt(MuJsParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitInt(MuJsParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterEquals(MuJsParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitEquals(MuJsParser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterNot(MuJsParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitNot(MuJsParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterOr(MuJsParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitOr(MuJsParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdBExp}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterIdBExp(MuJsParser.IdBExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdBExp}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitIdBExp(MuJsParser.IdBExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterBool(MuJsParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitBool(MuJsParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterAnd(MuJsParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitAnd(MuJsParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Less}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterLess(MuJsParser.LessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Less}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitLess(MuJsParser.LessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BExpPar}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void enterBExpPar(MuJsParser.BExpParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BExpPar}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 */
	void exitBExpPar(MuJsParser.BExpParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Str}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterStr(MuJsParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Str}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitStr(MuJsParser.StrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdSExp}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterIdSExp(MuJsParser.IdSExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdSExp}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitIdSExp(MuJsParser.IdSExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterConcat(MuJsParser.ConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitConcat(MuJsParser.ConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SExpPar}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterSExpPar(MuJsParser.SExpParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SExpPar}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitSExpPar(MuJsParser.SExpParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharAt}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void enterCharAt(MuJsParser.CharAtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharAt}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 */
	void exitCharAt(MuJsParser.CharAtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AeExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAeExp(MuJsParser.AeExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AeExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAeExp(MuJsParser.AeExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SeExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSeExp(MuJsParser.SeExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SeExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSeExp(MuJsParser.SeExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BeExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBeExp(MuJsParser.BeExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BeExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBeExp(MuJsParser.BeExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Composition}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterComposition(MuJsParser.CompositionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Composition}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitComposition(MuJsParser.CompositionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(MuJsParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(MuJsParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(MuJsParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(MuJsParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(MuJsParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(MuJsParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStmt(MuJsParser.AssignmentStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStmt(MuJsParser.AssignmentStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MuJsParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MuJsParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuJsParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MuJsParser.BlockContext ctx);
}