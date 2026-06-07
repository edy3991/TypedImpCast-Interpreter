// Generated from it/univr/pl/TypedImpCast.g4 by ANTLR 4.13.2
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
		FUN=1, MAIN=2, RETURN=3, VAL=4, REF=5, COMMA=6, ADD_ASSIGN=7, SUB_ASSIGN=8, 
		MUL_ASSIGN=9, DIV_ASSIGN=10, INC=11, ADD=12, DECR=13, SUB=14, MUL=15, 
		DIV=16, MOD=17, POW=18, EQQ=19, NEQ=20, LEQ=21, GEQ=22, LT=23, GT=24, 
		NOT=25, AND=26, OR=27, QUESTION=28, CONCAT=29, TOSTR=30, IF=31, ELSE=32, 
		WHILE=33, ASSIGN=34, OUT=35, NOP=36, LPAR=37, RPAR=38, LBRACE=39, RBRACE=40, 
		SEMICOLON=41, BOOL=42, INT=43, DEC=44, STRING=45, TYPE=46, ID=47, COMMENT=48, 
		WS=49;
	public static final int
		RULE_main = 0, RULE_com = 1, RULE_exp = 2, RULE_num = 3, RULE_funDecl = 4, 
		RULE_params = 5, RULE_param = 6, RULE_paramMode = 7, RULE_args = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "com", "exp", "num", "funDecl", "params", "param", "paramMode", 
			"args"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'fun'", "'main'", "'return'", "'val'", "'ref'", "','", "'+='", 
			"'-='", "'*='", "'/='", "'++'", "'+'", "'--'", "'-'", "'*'", "'/'", "'mod'", 
			"'^'", "'=='", "'!='", "'<='", "'>='", "'<'", "'>'", "'not'", "'and'", 
			"'or'", "'?'", "':'", "'toStr'", "'if'", "'else'", "'while'", "'='", 
			"'print'", "'nop'", "'('", "')'", "'{'", "'}'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FUN", "MAIN", "RETURN", "VAL", "REF", "COMMA", "ADD_ASSIGN", "SUB_ASSIGN", 
			"MUL_ASSIGN", "DIV_ASSIGN", "INC", "ADD", "DECR", "SUB", "MUL", "DIV", 
			"MOD", "POW", "EQQ", "NEQ", "LEQ", "GEQ", "LT", "GT", "NOT", "AND", "OR", 
			"QUESTION", "CONCAT", "TOSTR", "IF", "ELSE", "WHILE", "ASSIGN", "OUT", 
			"NOP", "LPAR", "RPAR", "LBRACE", "RBRACE", "SEMICOLON", "BOOL", "INT", 
			"DEC", "STRING", "TYPE", "ID", "COMMENT", "WS"
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
		public TerminalNode MAIN() { return getToken(TypedImpCastParser.MAIN, 0); }
		public TerminalNode LBRACE() { return getToken(TypedImpCastParser.LBRACE, 0); }
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(TypedImpCastParser.RBRACE, 0); }
		public TerminalNode EOF() { return getToken(TypedImpCastParser.EOF, 0); }
		public List<FunDeclContext> funDecl() {
			return getRuleContexts(FunDeclContext.class);
		}
		public FunDeclContext funDecl(int i) {
			return getRuleContext(FunDeclContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(18);
				funDecl();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
			match(MAIN);
			setState(25);
			match(LBRACE);
			setState(26);
			com(0);
			setState(27);
			match(RBRACE);
			setState(28);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitIfElse(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnContext extends ComContext {
		public TerminalNode RETURN() { return getToken(TypedImpCastParser.RETURN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ReturnContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitReturn(this);
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
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				_localctx = new DeclContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(31);
				match(TYPE);
				setState(32);
				match(ID);
				setState(35);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(33);
					match(ASSIGN);
					setState(34);
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
				setState(37);
				match(ID);
				setState(38);
				match(ASSIGN);
				setState(39);
				exp(0);
				}
				break;
			case 3:
				{
				_localctx = new PostIncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				match(ID);
				setState(41);
				match(INC);
				}
				break;
			case 4:
				{
				_localctx = new PreIncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42);
				match(INC);
				setState(43);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new PostDecrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44);
				match(ID);
				setState(45);
				match(DECR);
				}
				break;
			case 6:
				{
				_localctx = new PreDecrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(46);
				match(DECR);
				setState(47);
				match(ID);
				}
				break;
			case 7:
				{
				_localctx = new CompAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
				match(ID);
				setState(49);
				((CompAssignContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1920L) != 0)) ) {
					((CompAssignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(50);
				exp(0);
				}
				break;
			case 8:
				{
				_localctx = new IfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				match(IF);
				setState(52);
				match(LPAR);
				setState(53);
				exp(0);
				setState(54);
				match(RPAR);
				setState(55);
				match(LBRACE);
				setState(56);
				com(0);
				setState(57);
				match(RBRACE);
				}
				break;
			case 9:
				{
				_localctx = new IfElseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59);
				match(IF);
				setState(60);
				match(LPAR);
				setState(61);
				exp(0);
				setState(62);
				match(RPAR);
				setState(63);
				match(LBRACE);
				setState(64);
				com(0);
				setState(65);
				match(RBRACE);
				setState(66);
				match(ELSE);
				setState(67);
				match(LBRACE);
				setState(68);
				com(0);
				setState(69);
				match(RBRACE);
				}
				break;
			case 10:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				match(WHILE);
				setState(72);
				match(LPAR);
				setState(73);
				exp(0);
				setState(74);
				match(RPAR);
				setState(75);
				match(LBRACE);
				setState(76);
				com(0);
				setState(77);
				match(RBRACE);
				}
				break;
			case 11:
				{
				_localctx = new OutContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				match(OUT);
				setState(80);
				exp(0);
				}
				break;
			case 12:
				{
				_localctx = new NopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81);
				match(NOP);
				}
				break;
			case 13:
				{
				_localctx = new ReturnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				match(RETURN);
				setState(83);
				exp(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SeqContext(new ComContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_com);
					setState(86);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(87);
					match(SEMICOLON);
					setState(88);
					com(5);
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitConcat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunCallContext extends ExpContext {
		public TerminalNode ID() { return getToken(TypedImpCastParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(TypedImpCastParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(TypedImpCastParser.RPAR, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public FunCallContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitFunCall(this);
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
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new NumericContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(95);
				num();
				}
				break;
			case 2:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				match(BOOL);
				}
				break;
			case 3:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				match(STRING);
				}
				break;
			case 4:
				{
				_localctx = new FunCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				match(ID);
				setState(99);
				match(LPAR);
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 206846732271616L) != 0)) {
					{
					setState(100);
					args();
					}
				}

				setState(103);
				match(RPAR);
				}
				break;
			case 5:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104);
				match(ID);
				}
				break;
			case 6:
				{
				_localctx = new TostrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105);
				match(TOSTR);
				setState(106);
				match(LPAR);
				setState(107);
				exp(0);
				setState(108);
				match(RPAR);
				}
				break;
			case 7:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110);
				match(NOT);
				setState(111);
				exp(3);
				}
				break;
			case 8:
				{
				_localctx = new ParExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112);
				match(LPAR);
				setState(113);
				exp(0);
				setState(114);
				match(RPAR);
				}
				break;
			case 9:
				{
				_localctx = new CastContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				match(LPAR);
				setState(117);
				match(TYPE);
				setState(118);
				match(RPAR);
				setState(119);
				exp(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(149);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new PowContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(122);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(123);
						match(POW);
						setState(124);
						exp(12);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(125);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(126);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(127);
						exp(11);
						}
						break;
					case 3:
						{
						_localctx = new AddSubContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(128);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(129);
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
						setState(130);
						exp(10);
						}
						break;
					case 4:
						{
						_localctx = new CmpExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(131);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(132);
						((CmpExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31457280L) != 0)) ) {
							((CmpExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(133);
						exp(9);
						}
						break;
					case 5:
						{
						_localctx = new EqExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(134);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(135);
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
						setState(136);
						exp(8);
						}
						break;
					case 6:
						{
						_localctx = new AndOrContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(137);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(138);
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
						setState(139);
						exp(7);
						}
						break;
					case 7:
						{
						_localctx = new TernaryContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(140);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(141);
						match(QUESTION);
						setState(142);
						exp(0);
						setState(143);
						match(CONCAT);
						setState(144);
						exp(5);
						}
						break;
					case 8:
						{
						_localctx = new ConcatContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(146);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(147);
						match(CONCAT);
						setState(148);
						exp(5);
						}
						break;
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitIntNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_num);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntNumContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(INT);
				}
				break;
			case DEC:
				_localctx = new DecNumContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunDeclContext extends ParserRuleContext {
		public TerminalNode FUN() { return getToken(TypedImpCastParser.FUN, 0); }
		public TerminalNode TYPE() { return getToken(TypedImpCastParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(TypedImpCastParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(TypedImpCastParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(TypedImpCastParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(TypedImpCastParser.LBRACE, 0); }
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(TypedImpCastParser.RBRACE, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FunDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitFunDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunDeclContext funDecl() throws RecognitionException {
		FunDeclContext _localctx = new FunDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(FUN);
			setState(159);
			match(TYPE);
			setState(160);
			match(ID);
			setState(161);
			match(LPAR);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAL || _la==REF) {
				{
				setState(162);
				params();
				}
			}

			setState(165);
			match(RPAR);
			setState(166);
			match(LBRACE);
			setState(167);
			com(0);
			setState(168);
			match(RBRACE);
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
	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TypedImpCastParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TypedImpCastParser.COMMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			param();
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(171);
				match(COMMA);
				setState(172);
				param();
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class ParamContext extends ParserRuleContext {
		public ParamModeContext paramMode() {
			return getRuleContext(ParamModeContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(TypedImpCastParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(TypedImpCastParser.ID, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			paramMode();
			setState(179);
			match(TYPE);
			setState(180);
			match(ID);
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
	public static class ParamModeContext extends ParserRuleContext {
		public TerminalNode VAL() { return getToken(TypedImpCastParser.VAL, 0); }
		public TerminalNode REF() { return getToken(TypedImpCastParser.REF, 0); }
		public ParamModeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramMode; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitParamMode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamModeContext paramMode() throws RecognitionException {
		ParamModeContext _localctx = new ParamModeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_paramMode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_la = _input.LA(1);
			if ( !(_la==VAL || _la==REF) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
	public static class ArgsContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TypedImpCastParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TypedImpCastParser.COMMA, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TypedImpCastVisitor ) return ((TypedImpCastVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			exp(0);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(185);
				match(COMMA);
				setState(186);
				exp(0);
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
			return precpred(_ctx, 4);
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
		"\u0004\u00011\u00c1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0005\u0000\u0014\b\u0000\n\u0000\f\u0000\u0017"+
		"\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001$\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001U\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005"+
		"\u0001Z\b\u0001\n\u0001\f\u0001]\t\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002f\b"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002y\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u0096"+
		"\b\u0002\n\u0002\f\u0002\u0099\t\u0002\u0001\u0003\u0001\u0003\u0003\u0003"+
		"\u009d\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00a4\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00ae\b\u0005"+
		"\n\u0005\f\u0005\u00b1\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u00bc\b"+
		"\b\n\b\f\b\u00bf\t\b\u0001\b\u0000\u0002\u0002\u0004\t\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0000\u0007\u0001\u0000\u0007\n\u0001\u0000\u000f"+
		"\u0011\u0002\u0000\f\f\u000e\u000e\u0001\u0000\u0015\u0018\u0001\u0000"+
		"\u0013\u0014\u0001\u0000\u001a\u001b\u0001\u0000\u0004\u0005\u00db\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0002T\u0001\u0000\u0000\u0000\u0004x\u0001"+
		"\u0000\u0000\u0000\u0006\u009c\u0001\u0000\u0000\u0000\b\u009e\u0001\u0000"+
		"\u0000\u0000\n\u00aa\u0001\u0000\u0000\u0000\f\u00b2\u0001\u0000\u0000"+
		"\u0000\u000e\u00b6\u0001\u0000\u0000\u0000\u0010\u00b8\u0001\u0000\u0000"+
		"\u0000\u0012\u0014\u0003\b\u0004\u0000\u0013\u0012\u0001\u0000\u0000\u0000"+
		"\u0014\u0017\u0001\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000\u0000"+
		"\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0018\u0001\u0000\u0000\u0000"+
		"\u0017\u0015\u0001\u0000\u0000\u0000\u0018\u0019\u0005\u0002\u0000\u0000"+
		"\u0019\u001a\u0005\'\u0000\u0000\u001a\u001b\u0003\u0002\u0001\u0000\u001b"+
		"\u001c\u0005(\u0000\u0000\u001c\u001d\u0005\u0000\u0000\u0001\u001d\u0001"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0006\u0001\uffff\uffff\u0000\u001f"+
		" \u0005.\u0000\u0000 #\u0005/\u0000\u0000!\"\u0005\"\u0000\u0000\"$\u0003"+
		"\u0004\u0002\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000"+
		"$U\u0001\u0000\u0000\u0000%&\u0005/\u0000\u0000&\'\u0005\"\u0000\u0000"+
		"\'U\u0003\u0004\u0002\u0000()\u0005/\u0000\u0000)U\u0005\u000b\u0000\u0000"+
		"*+\u0005\u000b\u0000\u0000+U\u0005/\u0000\u0000,-\u0005/\u0000\u0000-"+
		"U\u0005\r\u0000\u0000./\u0005\r\u0000\u0000/U\u0005/\u0000\u000001\u0005"+
		"/\u0000\u000012\u0007\u0000\u0000\u00002U\u0003\u0004\u0002\u000034\u0005"+
		"\u001f\u0000\u000045\u0005%\u0000\u000056\u0003\u0004\u0002\u000067\u0005"+
		"&\u0000\u000078\u0005\'\u0000\u000089\u0003\u0002\u0001\u00009:\u0005"+
		"(\u0000\u0000:U\u0001\u0000\u0000\u0000;<\u0005\u001f\u0000\u0000<=\u0005"+
		"%\u0000\u0000=>\u0003\u0004\u0002\u0000>?\u0005&\u0000\u0000?@\u0005\'"+
		"\u0000\u0000@A\u0003\u0002\u0001\u0000AB\u0005(\u0000\u0000BC\u0005 \u0000"+
		"\u0000CD\u0005\'\u0000\u0000DE\u0003\u0002\u0001\u0000EF\u0005(\u0000"+
		"\u0000FU\u0001\u0000\u0000\u0000GH\u0005!\u0000\u0000HI\u0005%\u0000\u0000"+
		"IJ\u0003\u0004\u0002\u0000JK\u0005&\u0000\u0000KL\u0005\'\u0000\u0000"+
		"LM\u0003\u0002\u0001\u0000MN\u0005(\u0000\u0000NU\u0001\u0000\u0000\u0000"+
		"OP\u0005#\u0000\u0000PU\u0003\u0004\u0002\u0000QU\u0005$\u0000\u0000R"+
		"S\u0005\u0003\u0000\u0000SU\u0003\u0004\u0002\u0000T\u001e\u0001\u0000"+
		"\u0000\u0000T%\u0001\u0000\u0000\u0000T(\u0001\u0000\u0000\u0000T*\u0001"+
		"\u0000\u0000\u0000T,\u0001\u0000\u0000\u0000T.\u0001\u0000\u0000\u0000"+
		"T0\u0001\u0000\u0000\u0000T3\u0001\u0000\u0000\u0000T;\u0001\u0000\u0000"+
		"\u0000TG\u0001\u0000\u0000\u0000TO\u0001\u0000\u0000\u0000TQ\u0001\u0000"+
		"\u0000\u0000TR\u0001\u0000\u0000\u0000U[\u0001\u0000\u0000\u0000VW\n\u0004"+
		"\u0000\u0000WX\u0005)\u0000\u0000XZ\u0003\u0002\u0001\u0005YV\u0001\u0000"+
		"\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001"+
		"\u0000\u0000\u0000\\\u0003\u0001\u0000\u0000\u0000][\u0001\u0000\u0000"+
		"\u0000^_\u0006\u0002\uffff\uffff\u0000_y\u0003\u0006\u0003\u0000`y\u0005"+
		"*\u0000\u0000ay\u0005-\u0000\u0000bc\u0005/\u0000\u0000ce\u0005%\u0000"+
		"\u0000df\u0003\u0010\b\u0000ed\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000"+
		"\u0000fg\u0001\u0000\u0000\u0000gy\u0005&\u0000\u0000hy\u0005/\u0000\u0000"+
		"ij\u0005\u001e\u0000\u0000jk\u0005%\u0000\u0000kl\u0003\u0004\u0002\u0000"+
		"lm\u0005&\u0000\u0000my\u0001\u0000\u0000\u0000no\u0005\u0019\u0000\u0000"+
		"oy\u0003\u0004\u0002\u0003pq\u0005%\u0000\u0000qr\u0003\u0004\u0002\u0000"+
		"rs\u0005&\u0000\u0000sy\u0001\u0000\u0000\u0000tu\u0005%\u0000\u0000u"+
		"v\u0005.\u0000\u0000vw\u0005&\u0000\u0000wy\u0003\u0004\u0002\u0001x^"+
		"\u0001\u0000\u0000\u0000x`\u0001\u0000\u0000\u0000xa\u0001\u0000\u0000"+
		"\u0000xb\u0001\u0000\u0000\u0000xh\u0001\u0000\u0000\u0000xi\u0001\u0000"+
		"\u0000\u0000xn\u0001\u0000\u0000\u0000xp\u0001\u0000\u0000\u0000xt\u0001"+
		"\u0000\u0000\u0000y\u0097\u0001\u0000\u0000\u0000z{\n\f\u0000\u0000{|"+
		"\u0005\u0012\u0000\u0000|\u0096\u0003\u0004\u0002\f}~\n\n\u0000\u0000"+
		"~\u007f\u0007\u0001\u0000\u0000\u007f\u0096\u0003\u0004\u0002\u000b\u0080"+
		"\u0081\n\t\u0000\u0000\u0081\u0082\u0007\u0002\u0000\u0000\u0082\u0096"+
		"\u0003\u0004\u0002\n\u0083\u0084\n\b\u0000\u0000\u0084\u0085\u0007\u0003"+
		"\u0000\u0000\u0085\u0096\u0003\u0004\u0002\t\u0086\u0087\n\u0007\u0000"+
		"\u0000\u0087\u0088\u0007\u0004\u0000\u0000\u0088\u0096\u0003\u0004\u0002"+
		"\b\u0089\u008a\n\u0006\u0000\u0000\u008a\u008b\u0007\u0005\u0000\u0000"+
		"\u008b\u0096\u0003\u0004\u0002\u0007\u008c\u008d\n\u0005\u0000\u0000\u008d"+
		"\u008e\u0005\u001c\u0000\u0000\u008e\u008f\u0003\u0004\u0002\u0000\u008f"+
		"\u0090\u0005\u001d\u0000\u0000\u0090\u0091\u0003\u0004\u0002\u0005\u0091"+
		"\u0096\u0001\u0000\u0000\u0000\u0092\u0093\n\u0004\u0000\u0000\u0093\u0094"+
		"\u0005\u001d\u0000\u0000\u0094\u0096\u0003\u0004\u0002\u0005\u0095z\u0001"+
		"\u0000\u0000\u0000\u0095}\u0001\u0000\u0000\u0000\u0095\u0080\u0001\u0000"+
		"\u0000\u0000\u0095\u0083\u0001\u0000\u0000\u0000\u0095\u0086\u0001\u0000"+
		"\u0000\u0000\u0095\u0089\u0001\u0000\u0000\u0000\u0095\u008c\u0001\u0000"+
		"\u0000\u0000\u0095\u0092\u0001\u0000\u0000\u0000\u0096\u0099\u0001\u0000"+
		"\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000"+
		"\u0000\u0000\u0098\u0005\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000"+
		"\u0000\u0000\u009a\u009d\u0005+\u0000\u0000\u009b\u009d\u0005,\u0000\u0000"+
		"\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000"+
		"\u009d\u0007\u0001\u0000\u0000\u0000\u009e\u009f\u0005\u0001\u0000\u0000"+
		"\u009f\u00a0\u0005.\u0000\u0000\u00a0\u00a1\u0005/\u0000\u0000\u00a1\u00a3"+
		"\u0005%\u0000\u0000\u00a2\u00a4\u0003\n\u0005\u0000\u00a3\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0005&\u0000\u0000\u00a6\u00a7\u0005\'"+
		"\u0000\u0000\u00a7\u00a8\u0003\u0002\u0001\u0000\u00a8\u00a9\u0005(\u0000"+
		"\u0000\u00a9\t\u0001\u0000\u0000\u0000\u00aa\u00af\u0003\f\u0006\u0000"+
		"\u00ab\u00ac\u0005\u0006\u0000\u0000\u00ac\u00ae\u0003\f\u0006\u0000\u00ad"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ae\u00b1\u0001\u0000\u0000\u0000\u00af"+
		"\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0"+
		"\u000b\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0003\u000e\u0007\u0000\u00b3\u00b4\u0005.\u0000\u0000\u00b4\u00b5"+
		"\u0005/\u0000\u0000\u00b5\r\u0001\u0000\u0000\u0000\u00b6\u00b7\u0007"+
		"\u0006\u0000\u0000\u00b7\u000f\u0001\u0000\u0000\u0000\u00b8\u00bd\u0003"+
		"\u0004\u0002\u0000\u00b9\u00ba\u0005\u0006\u0000\u0000\u00ba\u00bc\u0003"+
		"\u0004\u0002\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00bf\u0001"+
		"\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001"+
		"\u0000\u0000\u0000\u00be\u0011\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001"+
		"\u0000\u0000\u0000\f\u0015#T[ex\u0095\u0097\u009c\u00a3\u00af\u00bd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}