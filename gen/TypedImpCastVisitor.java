// Generated from /Users/bladix/Desktop/uni/Linguaggi/laboratorio/Progetto-20260603/TypedImpCastIntp/src/main/antlr4/it/univr/pl/TypedImpCast.g4 by ANTLR 4.13.2

package it.univr.pl;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TypedImpCastParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TypedImpCastVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TypedImpCastParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(TypedImpCastParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code preDecr}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecr(TypedImpCastParser.PreDecrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decl}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(TypedImpCastParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postDecr}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecr(TypedImpCastParser.PostDecrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(TypedImpCastParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nop}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNop(TypedImpCastParser.NopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code preInc}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreInc(TypedImpCastParser.PreIncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code out}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOut(TypedImpCastParser.OutContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postInc}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostInc(TypedImpCastParser.PostIncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compAssign}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompAssign(TypedImpCastParser.CompAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(TypedImpCastParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifElse}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(TypedImpCastParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seq}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeq(TypedImpCastParser.SeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(TypedImpCastParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tostr}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTostr(TypedImpCastParser.TostrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivMod}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivMod(TypedImpCastParser.MulDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(TypedImpCastParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numeric}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric(TypedImpCastParser.NumericContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(TypedImpCastParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code concat}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcat(TypedImpCastParser.ConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andOr}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOr(TypedImpCastParser.AndOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cast}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCast(TypedImpCastParser.CastContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(TypedImpCastParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExp}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(TypedImpCastParser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(TypedImpCastParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cmpExp}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmpExp(TypedImpCastParser.CmpExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExp}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExp(TypedImpCastParser.ParExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pow}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(TypedImpCastParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(TypedImpCastParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ternary}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernary(TypedImpCastParser.TernaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intNum}
	 * labeled alternative in {@link TypedImpCastParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntNum(TypedImpCastParser.IntNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decNum}
	 * labeled alternative in {@link TypedImpCastParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecNum(TypedImpCastParser.DecNumContext ctx);
}