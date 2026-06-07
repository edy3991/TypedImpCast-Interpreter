// Generated from /Users/bladix/Desktop/uni/Linguaggi/laboratorio/Progetto-20260603/TypedImpCastIntp/src/main/antlr4/it/univr/pl/TypedImpCast.g4 by ANTLR 4.13.2

package it.univr.pl;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TypedImpCastParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ADD_ASSIGN=1, SUB_ASSIGN=2, MUL_ASSIGN=3, DIV_ASSIGN=4, INC=5, ADD=6, 
		DECR=7, SUB=8, MUL=9, DIV=10, MOD=11, POW=12, EQQ=13, NEQ=14, LEQ=15, 
		GEQ=16, LT=17, GT=18, NOT=19, AND=20, OR=21, QUESTION=22, CONCAT=23, TOSTR=24, 
		IF=25, ELSE=26, WHILE=27, ASSIGN=28, OUT=29, NOP=30, LPAR=31, RPAR=32, 
		LBRACE=33, RBRACE=34, SEMICOLON=35, BOOL=36, INT=37, DEC=38, STRING=39, 
		TYPE=40, ID=41, COMMENT=42, WS=43;
	public static final int
		RULE_main = 0, RULE_com = 1, RULE_exp = 2, RULE_num = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "com", "exp", "num"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+='", "'-='", "'*='", "'/='", "'++'", "'+'", "'--'", "'-'", "'*'", 
			"'/'", "'mod'", "'^'", "'=='", "'!='", "'<='", "'>='", "'<'", "'>'", 
			"'not'", "'and'", "'or'", "'?'", "':'", "'toStr'", "'if'", "'else'", 
			"'while'", "'='", "'print'", "'nop'", "'('", "')'", "'{'", "'}'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "INC", 
			"ADD", "DECR", "SUB", "MUL", "DIV", "MOD", "POW", "EQQ", "NEQ", "LEQ", 
			"GEQ", "LT", "GT", "NOT", "AND", "OR", "QUESTION", "CONCAT", "TOSTR", 
			"IF", "ELSE", "WHILE", "ASSIGN", "OUT", "NOP", "LPAR", "RPAR", "LBRACE", 
			"RBRACE", "SEMICOLON", "BOOL", "INT", "DEC", "STRING", "TYPE", "ID", 
			"COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "TypedImpCast.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TypedImpCastParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TypedImpCastParser.EOF, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			com(0);
			setState(9);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComContext extends ParserRuleContext {
		public ComContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_com; }
	 
		public ComContext() { }
		public void copyFrom(ComContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PreDecrContext extends ComContext {
		public TerminalNode DECR() { return getToken(TypedImpCastParser.DECR, 0); }
		public TerminalNode ID() { return getToken(TypedImpCastParser.ID, 0); }
		public PreDecrContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterPreDecr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitPreDecr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitPreDecr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ComContext {
		public TerminalNode TYPE() { return getToken(TypedImpCastParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(TypedImpCastParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(TypedImpCastParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public DeclContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostDecrContext extends ComContext {
		public TerminalNode ID() { return getToken(TypedImpCastParser.ID, 0); }
		public TerminalNode DECR() { return getToken(TypedImpCastParser.DECR, 0); }
		public PostDecrContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterPostDecr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitPostDecr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitPostDecr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends ComContext {
		public TerminalNode WHILE() { return getToken(TypedImpCastParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(TypedImpCastParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(TypedImpCastParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(TypedImpCastParser.LBRACE, 0); }
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(TypedImpCastParser.RBRACE, 0); }
		public WhileContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NopContext extends ComContext {
		public TerminalNode NOP() { return getToken(TypedImpCastParser.NOP, 0); }
		public NopContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterNop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitNop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitNop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PreIncContext extends ComContext {
		public TerminalNode INC() { return getToken(TypedImpCastParser.INC, 0); }
		public TerminalNode ID() { return getToken(TypedImpCastParser.ID, 0); }
		public PreIncContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterPreInc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitPreInc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitPreInc(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OutContext extends ComContext {
		public TerminalNode OUT() { return getToken(TypedImpCastParser.OUT, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public OutContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterOut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitOut(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitOut(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostIncContext extends ComContext {
		public TerminalNode ID() { return getToken(TypedImpCastParser.ID, 0); }
		public TerminalNode INC() { return getToken(TypedImpCastParser.INC, 0); }
		public PostIncContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterPostInc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitPostInc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitPostInc(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompAssignContext extends ComContext {
		public Token op;
		public TerminalNode ID() { return getToken(TypedImpCastParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ADD_ASSIGN() { return getToken(TypedImpCastParser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(TypedImpCastParser.SUB_ASSIGN, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(TypedImpCastParser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(TypedImpCastParser.DIV_ASSIGN, 0); }
		public CompAssignContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterCompAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitCompAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitCompAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ComContext {
		public TerminalNode IF() { return getToken(TypedImpCastParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(TypedImpCastParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(TypedImpCastParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(TypedImpCastParser.LBRACE, 0); }
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(TypedImpCastParser.RBRACE, 0); }
		public IfContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfElseContext extends ComContext {
		public TerminalNode IF() { return getToken(TypedImpCastParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(TypedImpCastParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(TypedImpCastParser.RPAR, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(TypedImpCastParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(TypedImpCastParser.LBRACE, i);
		}
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(TypedImpCastParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(TypedImpCastParser.RBRACE, i);
		}
		public TerminalNode ELSE() { return getToken(TypedImpCastParser.ELSE, 0); }
		public IfElseContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitIfElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitIfElse(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SeqContext extends ComContext {
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(TypedImpCastParser.SEMICOLON, 0); }
		public SeqContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitSeq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ComContext {
		public TerminalNode ID() { return getToken(TypedImpCastParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(TypedImpCastParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssignContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComContext com() throws RecognitionException {
		return com(0);
	}

	private ComContext com(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ComContext _localctx = new ComContext(_ctx, _parentState);
		ComContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_com, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new DeclContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(12);
				match(TYPE);
				setState(13);
				match(ID);
				setState(16);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(14);
					match(ASSIGN);
					setState(15);
					exp(0);
					}
					break;
				}
				}
				break;
			case 2:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(18);
				match(ID);
				setState(19);
				match(ASSIGN);
				setState(20);
				exp(0);
				}
				break;
			case 3:
				{
				_localctx = new PostIncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(21);
				match(ID);
				setState(22);
				match(INC);
				}
				break;
			case 4:
				{
				_localctx = new PreIncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				match(INC);
				setState(24);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new PostDecrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(ID);
				setState(26);
				match(DECR);
				}
				break;
			case 6:
				{
				_localctx = new PreDecrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27);
				match(DECR);
				setState(28);
				match(ID);
				}
				break;
			case 7:
				{
				_localctx = new CompAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29);
				match(ID);
				setState(30);
				((CompAssignContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30L) != 0)) ) {
					((CompAssignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(31);
				exp(0);
				}
				break;
			case 8:
				{
				_localctx = new IfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(32);
				match(IF);
				setState(33);
				match(LPAR);
				setState(34);
				exp(0);
				setState(35);
				match(RPAR);
				setState(36);
				match(LBRACE);
				setState(37);
				com(0);
				setState(38);
				match(RBRACE);
				}
				break;
			case 9:
				{
				_localctx = new IfElseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				match(IF);
				setState(41);
				match(LPAR);
				setState(42);
				exp(0);
				setState(43);
				match(RPAR);
				setState(44);
				match(LBRACE);
				setState(45);
				com(0);
				setState(46);
				match(RBRACE);
				setState(47);
				match(ELSE);
				setState(48);
				match(LBRACE);
				setState(49);
				com(0);
				setState(50);
				match(RBRACE);
				}
				break;
			case 10:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				match(WHILE);
				setState(53);
				match(LPAR);
				setState(54);
				exp(0);
				setState(55);
				match(RPAR);
				setState(56);
				match(LBRACE);
				setState(57);
				com(0);
				setState(58);
				match(RBRACE);
				}
				break;
			case 11:
				{
				_localctx = new OutContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60);
				match(OUT);
				setState(61);
				exp(0);
				}
				break;
			case 12:
				{
				_localctx = new NopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62);
				match(NOP);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SeqContext(new ComContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_com);
					setState(65);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(66);
					match(SEMICOLON);
					setState(67);
					com(4);
					}
					} 
				}
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TostrContext extends ExpContext {
		public TerminalNode TOSTR() { return getToken(TypedImpCastParser.TOSTR, 0); }
		public TerminalNode LPAR() { return getToken(TypedImpCastParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(TypedImpCastParser.RPAR, 0); }
		public TostrContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterTostr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitTostr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitTostr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivModContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode MUL() { return getToken(TypedImpCastParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(TypedImpCastParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(TypedImpCastParser.MOD, 0); }
		public MulDivModContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterMulDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitMulDivMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitMulDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExpContext {
		public TerminalNode STRING() { return getToken(TypedImpCastParser.STRING, 0); }
		public StringContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumericContext extends ExpContext {
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public NumericContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterNumeric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitNumeric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitNumeric(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode ADD() { return getToken(TypedImpCastParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(TypedImpCastParser.SUB, 0); }
		public AddSubContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConcatContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode CONCAT() { return getToken(TypedImpCastParser.CONCAT, 0); }
		public ConcatContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitConcat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitConcat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndOrContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode AND() { return getToken(TypedImpCastParser.AND, 0); }
		public TerminalNode OR() { return getToken(TypedImpCastParser.OR, 0); }
		public AndOrContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterAndOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitAndOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitAndOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CastContext extends ExpContext {
		public TerminalNode LPAR() { return getToken(TypedImpCastParser.LPAR, 0); }
		public TerminalNode TYPE() { return getToken(TypedImpCastParser.TYPE, 0); }
		public TerminalNode RPAR() { return getToken(TypedImpCastParser.RPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public CastContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterCast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitCast(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitCast(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends ExpContext {
		public TerminalNode NOT() { return getToken(TypedImpCastParser.NOT, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public NotContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqExpContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode EQQ() { return getToken(TypedImpCastParser.EQQ, 0); }
		public TerminalNode NEQ() { return getToken(TypedImpCastParser.NEQ, 0); }
		public EqExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterEqExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitEqExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitEqExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ExpContext {
		public TerminalNode BOOL() { return getToken(TypedImpCastParser.BOOL, 0); }
		public BooleanContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CmpExpContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode LT() { return getToken(TypedImpCastParser.LT, 0); }
		public TerminalNode LEQ() { return getToken(TypedImpCastParser.LEQ, 0); }
		public TerminalNode GEQ() { return getToken(TypedImpCastParser.GEQ, 0); }
		public TerminalNode GT() { return getToken(TypedImpCastParser.GT, 0); }
		public CmpExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterCmpExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitCmpExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitCmpExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParExpContext extends ExpContext {
		public TerminalNode LPAR() { return getToken(TypedImpCastParser.LPAR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(TypedImpCastParser.RPAR, 0); }
		public ParExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterParExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitParExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitParExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PowContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode POW() { return getToken(TypedImpCastParser.POW, 0); }
		public PowContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitPow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitPow(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ExpContext {
		public TerminalNode ID() { return getToken(TypedImpCastParser.ID, 0); }
		public IdContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TernaryContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode QUESTION() { return getToken(TypedImpCastParser.QUESTION, 0); }
		public TerminalNode CONCAT() { return getToken(TypedImpCastParser.CONCAT, 0); }
		public TernaryContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterTernary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitTernary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitTernary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new NumericContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(74);
				num();
				}
				break;
			case 2:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75);
				match(BOOL);
				}
				break;
			case 3:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				match(STRING);
				}
				break;
			case 4:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new TostrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				match(TOSTR);
				setState(79);
				match(LPAR);
				setState(80);
				exp(0);
				setState(81);
				match(RPAR);
				}
				break;
			case 6:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				match(NOT);
				setState(84);
				exp(3);
				}
				break;
			case 7:
				{
				_localctx = new ParExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85);
				match(LPAR);
				setState(86);
				exp(0);
				setState(87);
				match(RPAR);
				}
				break;
			case 8:
				{
				_localctx = new CastContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				match(LPAR);
				setState(90);
				match(TYPE);
				setState(91);
				match(RPAR);
				setState(92);
				exp(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(122);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new PowContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(95);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(96);
						match(POW);
						setState(97);
						exp(12);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(98);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(99);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(100);
						exp(11);
						}
						break;
					case 3:
						{
						_localctx = new AddSubContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(101);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(102);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(103);
						exp(10);
						}
						break;
					case 4:
						{
						_localctx = new CmpExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(104);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(105);
						((CmpExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 491520L) != 0)) ) {
							((CmpExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(106);
						exp(9);
						}
						break;
					case 5:
						{
						_localctx = new EqExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(107);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(108);
						((EqExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQQ || _la==NEQ) ) {
							((EqExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(109);
						exp(8);
						}
						break;
					case 6:
						{
						_localctx = new AndOrContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(110);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(111);
						((AndOrContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((AndOrContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(112);
						exp(7);
						}
						break;
					case 7:
						{
						_localctx = new TernaryContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(113);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(114);
						match(QUESTION);
						setState(115);
						exp(0);
						setState(116);
						match(CONCAT);
						setState(117);
						exp(5);
						}
						break;
					case 8:
						{
						_localctx = new ConcatContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(119);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(120);
						match(CONCAT);
						setState(121);
						exp(5);
						}
						break;
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumContext extends ParserRuleContext {
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
	 
		public NumContext() { }
		public void copyFrom(NumContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecNumContext extends NumContext {
		public TerminalNode DEC() { return getToken(TypedImpCastParser.DEC, 0); }
		public DecNumContext(NumContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterDecNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitDecNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitDecNum(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntNumContext extends NumContext {
		public TerminalNode INT() { return getToken(TypedImpCastParser.INT, 0); }
		public IntNumContext(NumContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).enterIntNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TypedImpCastListener ) ((TypedImpCastListener)listener).exitIntNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitIntNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_num);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntNumContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(INT);
				}
				break;
			case DEC:
				_localctx = new DecNumContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(DEC);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return com_sempred((ComContext)_localctx, predIndex);
		case 2:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean com_sempred(ComContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001+\u0084\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001\u0011\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001@\b"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001E\b\u0001\n\u0001"+
		"\f\u0001H\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002^\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002{\b\u0002\n\u0002\f\u0002~\t"+
		"\u0002\u0001\u0003\u0001\u0003\u0003\u0003\u0082\b\u0003\u0001\u0003\u0000"+
		"\u0002\u0002\u0004\u0004\u0000\u0002\u0004\u0006\u0000\u0006\u0001\u0000"+
		"\u0001\u0004\u0001\u0000\t\u000b\u0002\u0000\u0006\u0006\b\b\u0001\u0000"+
		"\u000f\u0012\u0001\u0000\r\u000e\u0001\u0000\u0014\u0015\u009c\u0000\b"+
		"\u0001\u0000\u0000\u0000\u0002?\u0001\u0000\u0000\u0000\u0004]\u0001\u0000"+
		"\u0000\u0000\u0006\u0081\u0001\u0000\u0000\u0000\b\t\u0003\u0002\u0001"+
		"\u0000\t\n\u0005\u0000\u0000\u0001\n\u0001\u0001\u0000\u0000\u0000\u000b"+
		"\f\u0006\u0001\uffff\uffff\u0000\f\r\u0005(\u0000\u0000\r\u0010\u0005"+
		")\u0000\u0000\u000e\u000f\u0005\u001c\u0000\u0000\u000f\u0011\u0003\u0004"+
		"\u0002\u0000\u0010\u000e\u0001\u0000\u0000\u0000\u0010\u0011\u0001\u0000"+
		"\u0000\u0000\u0011@\u0001\u0000\u0000\u0000\u0012\u0013\u0005)\u0000\u0000"+
		"\u0013\u0014\u0005\u001c\u0000\u0000\u0014@\u0003\u0004\u0002\u0000\u0015"+
		"\u0016\u0005)\u0000\u0000\u0016@\u0005\u0005\u0000\u0000\u0017\u0018\u0005"+
		"\u0005\u0000\u0000\u0018@\u0005)\u0000\u0000\u0019\u001a\u0005)\u0000"+
		"\u0000\u001a@\u0005\u0007\u0000\u0000\u001b\u001c\u0005\u0007\u0000\u0000"+
		"\u001c@\u0005)\u0000\u0000\u001d\u001e\u0005)\u0000\u0000\u001e\u001f"+
		"\u0007\u0000\u0000\u0000\u001f@\u0003\u0004\u0002\u0000 !\u0005\u0019"+
		"\u0000\u0000!\"\u0005\u001f\u0000\u0000\"#\u0003\u0004\u0002\u0000#$\u0005"+
		" \u0000\u0000$%\u0005!\u0000\u0000%&\u0003\u0002\u0001\u0000&\'\u0005"+
		"\"\u0000\u0000\'@\u0001\u0000\u0000\u0000()\u0005\u0019\u0000\u0000)*"+
		"\u0005\u001f\u0000\u0000*+\u0003\u0004\u0002\u0000+,\u0005 \u0000\u0000"+
		",-\u0005!\u0000\u0000-.\u0003\u0002\u0001\u0000./\u0005\"\u0000\u0000"+
		"/0\u0005\u001a\u0000\u000001\u0005!\u0000\u000012\u0003\u0002\u0001\u0000"+
		"23\u0005\"\u0000\u00003@\u0001\u0000\u0000\u000045\u0005\u001b\u0000\u0000"+
		"56\u0005\u001f\u0000\u000067\u0003\u0004\u0002\u000078\u0005 \u0000\u0000"+
		"89\u0005!\u0000\u00009:\u0003\u0002\u0001\u0000:;\u0005\"\u0000\u0000"+
		";@\u0001\u0000\u0000\u0000<=\u0005\u001d\u0000\u0000=@\u0003\u0004\u0002"+
		"\u0000>@\u0005\u001e\u0000\u0000?\u000b\u0001\u0000\u0000\u0000?\u0012"+
		"\u0001\u0000\u0000\u0000?\u0015\u0001\u0000\u0000\u0000?\u0017\u0001\u0000"+
		"\u0000\u0000?\u0019\u0001\u0000\u0000\u0000?\u001b\u0001\u0000\u0000\u0000"+
		"?\u001d\u0001\u0000\u0000\u0000? \u0001\u0000\u0000\u0000?(\u0001\u0000"+
		"\u0000\u0000?4\u0001\u0000\u0000\u0000?<\u0001\u0000\u0000\u0000?>\u0001"+
		"\u0000\u0000\u0000@F\u0001\u0000\u0000\u0000AB\n\u0003\u0000\u0000BC\u0005"+
		"#\u0000\u0000CE\u0003\u0002\u0001\u0004DA\u0001\u0000\u0000\u0000EH\u0001"+
		"\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000"+
		"G\u0003\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IJ\u0006\u0002"+
		"\uffff\uffff\u0000J^\u0003\u0006\u0003\u0000K^\u0005$\u0000\u0000L^\u0005"+
		"\'\u0000\u0000M^\u0005)\u0000\u0000NO\u0005\u0018\u0000\u0000OP\u0005"+
		"\u001f\u0000\u0000PQ\u0003\u0004\u0002\u0000QR\u0005 \u0000\u0000R^\u0001"+
		"\u0000\u0000\u0000ST\u0005\u0013\u0000\u0000T^\u0003\u0004\u0002\u0003"+
		"UV\u0005\u001f\u0000\u0000VW\u0003\u0004\u0002\u0000WX\u0005 \u0000\u0000"+
		"X^\u0001\u0000\u0000\u0000YZ\u0005\u001f\u0000\u0000Z[\u0005(\u0000\u0000"+
		"[\\\u0005 \u0000\u0000\\^\u0003\u0004\u0002\u0001]I\u0001\u0000\u0000"+
		"\u0000]K\u0001\u0000\u0000\u0000]L\u0001\u0000\u0000\u0000]M\u0001\u0000"+
		"\u0000\u0000]N\u0001\u0000\u0000\u0000]S\u0001\u0000\u0000\u0000]U\u0001"+
		"\u0000\u0000\u0000]Y\u0001\u0000\u0000\u0000^|\u0001\u0000\u0000\u0000"+
		"_`\n\f\u0000\u0000`a\u0005\f\u0000\u0000a{\u0003\u0004\u0002\fbc\n\n\u0000"+
		"\u0000cd\u0007\u0001\u0000\u0000d{\u0003\u0004\u0002\u000bef\n\t\u0000"+
		"\u0000fg\u0007\u0002\u0000\u0000g{\u0003\u0004\u0002\nhi\n\b\u0000\u0000"+
		"ij\u0007\u0003\u0000\u0000j{\u0003\u0004\u0002\tkl\n\u0007\u0000\u0000"+
		"lm\u0007\u0004\u0000\u0000m{\u0003\u0004\u0002\bno\n\u0006\u0000\u0000"+
		"op\u0007\u0005\u0000\u0000p{\u0003\u0004\u0002\u0007qr\n\u0005\u0000\u0000"+
		"rs\u0005\u0016\u0000\u0000st\u0003\u0004\u0002\u0000tu\u0005\u0017\u0000"+
		"\u0000uv\u0003\u0004\u0002\u0005v{\u0001\u0000\u0000\u0000wx\n\u0004\u0000"+
		"\u0000xy\u0005\u0017\u0000\u0000y{\u0003\u0004\u0002\u0005z_\u0001\u0000"+
		"\u0000\u0000zb\u0001\u0000\u0000\u0000ze\u0001\u0000\u0000\u0000zh\u0001"+
		"\u0000\u0000\u0000zk\u0001\u0000\u0000\u0000zn\u0001\u0000\u0000\u0000"+
		"zq\u0001\u0000\u0000\u0000zw\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000"+
		"\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u0005\u0001"+
		"\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0082\u0005%\u0000"+
		"\u0000\u0080\u0082\u0005&\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000"+
		"\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0007\u0001\u0000\u0000\u0000"+
		"\u0007\u0010?F]z|\u0081";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}