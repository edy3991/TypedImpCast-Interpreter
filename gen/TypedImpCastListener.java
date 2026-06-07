// Generated from /Users/bladix/Desktop/uni/Linguaggi/laboratorio/Progetto-20260603/TypedImpCastIntp/src/main/antlr4/it/univr/pl/TypedImpCast.g4 by ANTLR 4.13.2

package it.univr.pl;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TypedImpCastParser}.
 */
public interface TypedImpCastListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TypedImpCastParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(TypedImpCastParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypedImpCastParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(TypedImpCastParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code preDecr}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void enterPreDecr(TypedImpCastParser.PreDecrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code preDecr}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void exitPreDecr(TypedImpCastParser.PreDecrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decl}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void enterDecl(TypedImpCastParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decl}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void exitDecl(TypedImpCastParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postDecr}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void enterPostDecr(TypedImpCastParser.PostDecrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postDecr}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void exitPostDecr(TypedImpCastParser.PostDecrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void enterWhile(TypedImpCastParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void exitWhile(TypedImpCastParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nop}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void enterNop(TypedImpCastParser.NopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nop}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void exitNop(TypedImpCastParser.NopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code preInc}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void enterPreInc(TypedImpCastParser.PreIncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code preInc}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void exitPreInc(TypedImpCastParser.PreIncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code out}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void enterOut(TypedImpCastParser.OutContext ctx);
	/**
	 * Exit a parse tree produced by the {@code out}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void exitOut(TypedImpCastParser.OutContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postInc}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void enterPostInc(TypedImpCastParser.PostIncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postInc}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void exitPostInc(TypedImpCastParser.PostIncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compAssign}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void enterCompAssign(TypedImpCastParser.CompAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compAssign}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void exitCompAssign(TypedImpCastParser.CompAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void enterIf(TypedImpCastParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void exitIf(TypedImpCastParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifElse}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(TypedImpCastParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifElse}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(TypedImpCastParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code seq}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void enterSeq(TypedImpCastParser.SeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code seq}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void exitSeq(TypedImpCastParser.SeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void enterAssign(TypedImpCastParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link TypedImpCastParser#com}.
	 * @param ctx the parse tree
	 */
	void exitAssign(TypedImpCastParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tostr}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterTostr(TypedImpCastParser.TostrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tostr}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitTostr(TypedImpCastParser.TostrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivMod}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterMulDivMod(TypedImpCastParser.MulDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivMod}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitMulDivMod(TypedImpCastParser.MulDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterString(TypedImpCastParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitString(TypedImpCastParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numeric}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNumeric(TypedImpCastParser.NumericContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numeric}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNumeric(TypedImpCastParser.NumericContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(TypedImpCastParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(TypedImpCastParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code concat}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterConcat(TypedImpCastParser.ConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code concat}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitConcat(TypedImpCastParser.ConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andOr}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAndOr(TypedImpCastParser.AndOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andOr}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAndOr(TypedImpCastParser.AndOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cast}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterCast(TypedImpCastParser.CastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cast}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitCast(TypedImpCastParser.CastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code not}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNot(TypedImpCastParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code not}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNot(TypedImpCastParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExp}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterEqExp(TypedImpCastParser.EqExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExp}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitEqExp(TypedImpCastParser.EqExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(TypedImpCastParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(TypedImpCastParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cmpExp}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterCmpExp(TypedImpCastParser.CmpExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cmpExp}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitCmpExp(TypedImpCastParser.CmpExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExp}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterParExp(TypedImpCastParser.ParExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExp}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitParExp(TypedImpCastParser.ParExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pow}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterPow(TypedImpCastParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pow}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitPow(TypedImpCastParser.PowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterId(TypedImpCastParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitId(TypedImpCastParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ternary}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterTernary(TypedImpCastParser.TernaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ternary}
	 * labeled alternative in {@link TypedImpCastParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitTernary(TypedImpCastParser.TernaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intNum}
	 * labeled alternative in {@link TypedImpCastParser#num}.
	 * @param ctx the parse tree
	 */
	void enterIntNum(TypedImpCastParser.IntNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intNum}
	 * labeled alternative in {@link TypedImpCastParser#num}.
	 * @param ctx the parse tree
	 */
	void exitIntNum(TypedImpCastParser.IntNumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decNum}
	 * labeled alternative in {@link TypedImpCastParser#num}.
	 * @param ctx the parse tree
	 */
	void enterDecNum(TypedImpCastParser.DecNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decNum}
	 * labeled alternative in {@link TypedImpCastParser#num}.
	 * @param ctx the parse tree
	 */
	void exitDecNum(TypedImpCastParser.DecNumContext ctx);
}