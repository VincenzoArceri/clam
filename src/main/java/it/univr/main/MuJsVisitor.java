// Generated from /home/vincenzo/Scrivania/ictac/mu-js/src/main/java/it/univr/main/MuJs.g4 by ANTLR 4.7.2

    package it.univr.main;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MuJsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MuJsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code ProgramExecution}
	 * labeled alternative in {@link MuJsParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramExecution(MuJsParser.ProgramExecutionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(MuJsParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Length}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLength(MuJsParser.LengthContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Diff}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiff(MuJsParser.DiffContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(MuJsParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdAExp}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAExp(MuJsParser.IdAExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AExpPar}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAExpPar(MuJsParser.AExpParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToNum}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToNum(MuJsParser.ToNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(MuJsParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link MuJsParser#aexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(MuJsParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals(MuJsParser.EqualsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(MuJsParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(MuJsParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdBExp}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdBExp(MuJsParser.IdBExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bool}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(MuJsParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(MuJsParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Less}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLess(MuJsParser.LessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BExpPar}
	 * labeled alternative in {@link MuJsParser#bexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBExpPar(MuJsParser.BExpParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Str}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr(MuJsParser.StrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdSExp}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdSExp(MuJsParser.IdSExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcat(MuJsParser.ConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SExpPar}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSExpPar(MuJsParser.SExpParContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CharAt}
	 * labeled alternative in {@link MuJsParser#sexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharAt(MuJsParser.CharAtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AeExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAeExp(MuJsParser.AeExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SeExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeExp(MuJsParser.SeExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BeExp}
	 * labeled alternative in {@link MuJsParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeExp(MuJsParser.BeExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Composition}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposition(MuJsParser.CompositionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(MuJsParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(MuJsParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(MuJsParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(MuJsParser.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuJsParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MuJsParser.BlockContext ctx);
}