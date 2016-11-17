// Generated from C:/Users/helcr/Documents/IST/MEIC/SS/SSoft/src/tecnico/ssoft/phpsat/parser\PHPGrammar.g4 by ANTLR 4.5.3
package tecnico.ssoft.phpsat.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PHPGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, ECHO=7, STAR=8, EQUAL=9, 
		DOUBLE_QUOTES=10, COMMA=11, DOT=12, CODE_START=13, CODE_END=14, LESS=15, 
		GREATER=16, ID=17, INT=18, VAR=19, SINGLE_QUOTE=20, WS=21;
	public static final int
		RULE_prog = 0, RULE_statements = 1, RULE_statement = 2, RULE_assignment = 3, 
		RULE_function = 4, RULE_echo = 5, RULE_regularFunction = 6, RULE_variable = 7, 
		RULE_value = 8, RULE_stringValues = 9, RULE_stringValue = 10, RULE_args = 11, 
		RULE_arg = 12, RULE_html = 13, RULE_tag = 14, RULE_option = 15, RULE_htmlStatements = 16, 
		RULE_htmlStatement = 17;
	public static final String[] ruleNames = {
		"prog", "statements", "statement", "assignment", "function", "echo", "regularFunction", 
		"variable", "value", "stringValues", "stringValue", "args", "arg", "html", 
		"tag", "option", "htmlStatements", "htmlStatement"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "'['", "']'", "'/'", "'echo'", "'*'", "'='", 
		"'\"'", "','", "'.'", "'<?php'", "'?>'", "'<'", "'>'", null, null, null, 
		"'''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "ECHO", "STAR", "EQUAL", "DOUBLE_QUOTES", 
		"COMMA", "DOT", "CODE_START", "CODE_END", "LESS", "GREATER", "ID", "INT", 
		"VAR", "SINGLE_QUOTE", "WS"
	};
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
	public String getGrammarFileName() { return "PHPGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PHPGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			statements(0);
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

	public static class StatementsContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		return statements(0);
	}

	private StatementsContext statements(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementsContext _localctx = new StatementsContext(_ctx, _parentState);
		StatementsContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_statements, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(39);
			statement();
			}
			_ctx.stop = _input.LT(-1);
			setState(45);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_statements);
					setState(41);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(42);
					statement();
					}
					} 
				}
				setState(47);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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

	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public HtmlContext html() {
			return getRuleContext(HtmlContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(55);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				assignment();
				setState(49);
				match(T__0);
				}
				break;
			case ECHO:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				function();
				setState(52);
				match(T__0);
				}
				break;
			case LESS:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				html(0);
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

	public static class AssignmentContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				variable();
				setState(58);
				match(EQUAL);
				setState(59);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				variable();
				setState(62);
				match(EQUAL);
				setState(63);
				value();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				variable();
				setState(66);
				match(EQUAL);
				setState(67);
				function();
				}
				break;
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

	public static class FunctionContext extends ParserRuleContext {
		public RegularFunctionContext regularFunction() {
			return getRuleContext(RegularFunctionContext.class,0);
		}
		public EchoContext echo() {
			return getRuleContext(EchoContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function);
		try {
			setState(73);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				regularFunction();
				}
				break;
			case ECHO:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				echo();
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

	public static class EchoContext extends ParserRuleContext {
		public TerminalNode ECHO() { return getToken(PHPGrammarParser.ECHO, 0); }
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public EchoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_echo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterEcho(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitEcho(this);
		}
	}

	public final EchoContext echo() throws RecognitionException {
		EchoContext _localctx = new EchoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_echo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(ECHO);
			setState(76);
			arg();
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

	public static class RegularFunctionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PHPGrammarParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public RegularFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regularFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterRegularFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitRegularFunction(this);
		}
	}

	public final RegularFunctionContext regularFunction() throws RecognitionException {
		RegularFunctionContext _localctx = new RegularFunctionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_regularFunction);
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(ID);
				setState(79);
				match(T__1);
				setState(80);
				args(0);
				setState(81);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				match(ID);
				setState(84);
				match(T__1);
				setState(85);
				match(T__2);
				}
				break;
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(PHPGrammarParser.VAR, 0); }
		public List<TerminalNode> SINGLE_QUOTE() { return getTokens(PHPGrammarParser.SINGLE_QUOTE); }
		public TerminalNode SINGLE_QUOTE(int i) {
			return getToken(PHPGrammarParser.SINGLE_QUOTE, i);
		}
		public TerminalNode ID() { return getToken(PHPGrammarParser.ID, 0); }
		public List<TerminalNode> DOUBLE_QUOTES() { return getTokens(PHPGrammarParser.DOUBLE_QUOTES); }
		public TerminalNode DOUBLE_QUOTES(int i) {
			return getToken(PHPGrammarParser.DOUBLE_QUOTES, i);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variable);
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				match(VAR);
				setState(89);
				match(T__3);
				setState(90);
				match(SINGLE_QUOTE);
				setState(91);
				match(ID);
				setState(92);
				match(SINGLE_QUOTE);
				setState(93);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(VAR);
				setState(95);
				match(T__3);
				setState(96);
				match(DOUBLE_QUOTES);
				setState(97);
				match(ID);
				setState(98);
				match(DOUBLE_QUOTES);
				setState(99);
				match(T__4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				match(VAR);
				}
				break;
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

	public static class ValueContext extends ParserRuleContext {
		public StringValuesContext stringValues() {
			return getRuleContext(StringValuesContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(DOUBLE_QUOTES);
			setState(104);
			stringValues(0);
			setState(105);
			match(DOUBLE_QUOTES);
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

	public static class StringValuesContext extends ParserRuleContext {
		public StringValueContext stringValue() {
			return getRuleContext(StringValueContext.class,0);
		}
		public StringValuesContext stringValues() {
			return getRuleContext(StringValuesContext.class,0);
		}
		public StringValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringValues; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterStringValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitStringValues(this);
		}
	}

	public final StringValuesContext stringValues() throws RecognitionException {
		return stringValues(0);
	}

	private StringValuesContext stringValues(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StringValuesContext _localctx = new StringValuesContext(_ctx, _parentState);
		StringValuesContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_stringValues, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(108);
			stringValue();
			}
			_ctx.stop = _input.LT(-1);
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StringValuesContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stringValues);
					setState(110);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(111);
					stringValue();
					}
					} 
				}
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class StringValueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PHPGrammarParser.ID, 0); }
		public TerminalNode INT() { return getToken(PHPGrammarParser.INT, 0); }
		public TerminalNode DOT() { return getToken(PHPGrammarParser.DOT, 0); }
		public TerminalNode STAR() { return getToken(PHPGrammarParser.STAR, 0); }
		public TerminalNode EQUAL() { return getToken(PHPGrammarParser.EQUAL, 0); }
		public TerminalNode COMMA() { return getToken(PHPGrammarParser.COMMA, 0); }
		public TerminalNode SINGLE_QUOTE() { return getToken(PHPGrammarParser.SINGLE_QUOTE, 0); }
		public TerminalNode DOUBLE_QUOTES() { return getToken(PHPGrammarParser.DOUBLE_QUOTES, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public StringValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterStringValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitStringValue(this);
		}
	}

	public final StringValueContext stringValue() throws RecognitionException {
		StringValueContext _localctx = new StringValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stringValue);
		try {
			setState(126);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				match(ID);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				match(INT);
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				match(DOT);
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				match(STAR);
				}
				break;
			case EQUAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(121);
				match(EQUAL);
				}
				break;
			case COMMA:
				enterOuterAlt(_localctx, 6);
				{
				setState(122);
				match(COMMA);
				}
				break;
			case SINGLE_QUOTE:
				enterOuterAlt(_localctx, 7);
				{
				setState(123);
				match(SINGLE_QUOTE);
				}
				break;
			case DOUBLE_QUOTES:
				enterOuterAlt(_localctx, 8);
				{
				setState(124);
				match(DOUBLE_QUOTES);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 9);
				{
				setState(125);
				variable();
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

	public static class ArgsContext extends ParserRuleContext {
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PHPGrammarParser.COMMA, 0); }
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		return args(0);
	}

	private ArgsContext args(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgsContext _localctx = new ArgsContext(_ctx, _parentState);
		ArgsContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_args, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(129);
			arg();
			}
			_ctx.stop = _input.LT(-1);
			setState(136);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_args);
					setState(131);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(132);
					match(COMMA);
					setState(133);
					arg();
					}
					} 
				}
				setState(138);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class ArgContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitArg(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arg);
		try {
			setState(142);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				variable();
				}
				break;
			case DOUBLE_QUOTES:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				value();
				}
				break;
			case ECHO:
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				function();
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

	public static class HtmlContext extends ParserRuleContext {
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public HtmlContext html() {
			return getRuleContext(HtmlContext.class,0);
		}
		public HtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_html; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterHtml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitHtml(this);
		}
	}

	public final HtmlContext html() throws RecognitionException {
		return html(0);
	}

	private HtmlContext html(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		HtmlContext _localctx = new HtmlContext(_ctx, _parentState);
		HtmlContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_html, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(145);
			tag();
			}
			_ctx.stop = _input.LT(-1);
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new HtmlContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_html);
					setState(147);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(148);
					tag();
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class TagContext extends ParserRuleContext {
		public TerminalNode LESS() { return getToken(PHPGrammarParser.LESS, 0); }
		public TerminalNode ID() { return getToken(PHPGrammarParser.ID, 0); }
		public TerminalNode GREATER() { return getToken(PHPGrammarParser.GREATER, 0); }
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitTag(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tag);
		int _la;
		try {
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(LESS);
				setState(155);
				match(ID);
				setState(156);
				match(GREATER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				match(LESS);
				setState(158);
				match(T__5);
				setState(159);
				match(ID);
				setState(160);
				match(GREATER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
				match(LESS);
				setState(162);
				match(ID);
				setState(164); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(163);
					option();
					}
					}
					setState(166); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(168);
				match(GREATER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				match(LESS);
				setState(171);
				match(ID);
				setState(173); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(172);
					option();
					}
					}
					setState(175); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(177);
				match(T__5);
				setState(178);
				match(GREATER);
				}
				break;
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

	public static class OptionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PHPGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PHPGrammarParser.ID, i);
		}
		public TerminalNode CODE_START() { return getToken(PHPGrammarParser.CODE_START, 0); }
		public HtmlStatementsContext htmlStatements() {
			return getRuleContext(HtmlStatementsContext.class,0);
		}
		public TerminalNode CODE_END() { return getToken(PHPGrammarParser.CODE_END, 0); }
		public HtmlStatementContext htmlStatement() {
			return getRuleContext(HtmlStatementContext.class,0);
		}
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitOption(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_option);
		try {
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				match(ID);
				setState(183);
				match(EQUAL);
				setState(184);
				match(DOUBLE_QUOTES);
				setState(185);
				match(CODE_START);
				setState(186);
				htmlStatements(0);
				setState(187);
				match(CODE_END);
				setState(188);
				match(DOUBLE_QUOTES);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(ID);
				setState(191);
				match(EQUAL);
				setState(192);
				match(DOUBLE_QUOTES);
				setState(193);
				match(CODE_START);
				setState(194);
				htmlStatement();
				setState(195);
				match(T__0);
				setState(196);
				match(CODE_END);
				setState(197);
				match(DOUBLE_QUOTES);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				match(ID);
				setState(200);
				match(EQUAL);
				setState(201);
				match(DOUBLE_QUOTES);
				setState(202);
				match(ID);
				setState(203);
				match(DOUBLE_QUOTES);
				}
				break;
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

	public static class HtmlStatementsContext extends ParserRuleContext {
		public HtmlStatementContext htmlStatement() {
			return getRuleContext(HtmlStatementContext.class,0);
		}
		public HtmlStatementsContext htmlStatements() {
			return getRuleContext(HtmlStatementsContext.class,0);
		}
		public HtmlStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterHtmlStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitHtmlStatements(this);
		}
	}

	public final HtmlStatementsContext htmlStatements() throws RecognitionException {
		return htmlStatements(0);
	}

	private HtmlStatementsContext htmlStatements(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		HtmlStatementsContext _localctx = new HtmlStatementsContext(_ctx, _parentState);
		HtmlStatementsContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_htmlStatements, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(207);
			htmlStatement();
			}
			_ctx.stop = _input.LT(-1);
			setState(214);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new HtmlStatementsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_htmlStatements);
					setState(209);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(210);
					match(T__0);
					setState(211);
					htmlStatement();
					}
					} 
				}
				setState(216);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class HtmlStatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public HtmlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).enterHtmlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PHPGrammarListener ) ((PHPGrammarListener)listener).exitHtmlStatement(this);
		}
	}

	public final HtmlStatementContext htmlStatement() throws RecognitionException {
		HtmlStatementContext _localctx = new HtmlStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_htmlStatement);
		try {
			setState(219);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				assignment();
				}
				break;
			case ECHO:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				function();
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
			return statements_sempred((StatementsContext)_localctx, predIndex);
		case 9:
			return stringValues_sempred((StringValuesContext)_localctx, predIndex);
		case 11:
			return args_sempred((ArgsContext)_localctx, predIndex);
		case 13:
			return html_sempred((HtmlContext)_localctx, predIndex);
		case 16:
			return htmlStatements_sempred((HtmlStatementsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean statements_sempred(StatementsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean stringValues_sempred(StringValuesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean args_sempred(ArgsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean html_sempred(HtmlContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean htmlStatements_sempred(HtmlStatementsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\27\u00e0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4:\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\5\5H\n\5\3\6\3\6\5\6L\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\5\bY\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\th\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\7\13s\n\13\f\13\16"+
		"\13v\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0081\n\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\7\r\u0089\n\r\f\r\16\r\u008c\13\r\3\16\3\16\3\16\5\16\u0091"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\7\17\u0098\n\17\f\17\16\17\u009b\13\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\6\20\u00a7\n\20\r\20"+
		"\16\20\u00a8\3\20\3\20\3\20\3\20\3\20\6\20\u00b0\n\20\r\20\16\20\u00b1"+
		"\3\20\3\20\3\20\5\20\u00b7\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00cf\n\21\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00d7\n\22\f\22\16"+
		"\22\u00da\13\22\3\23\3\23\5\23\u00de\n\23\3\23\2\7\4\24\30\34\"\24\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\2\u00ec\2&\3\2\2\2\4(\3\2\2"+
		"\2\69\3\2\2\2\bG\3\2\2\2\nK\3\2\2\2\fM\3\2\2\2\16X\3\2\2\2\20g\3\2\2\2"+
		"\22i\3\2\2\2\24m\3\2\2\2\26\u0080\3\2\2\2\30\u0082\3\2\2\2\32\u0090\3"+
		"\2\2\2\34\u0092\3\2\2\2\36\u00b6\3\2\2\2 \u00ce\3\2\2\2\"\u00d0\3\2\2"+
		"\2$\u00dd\3\2\2\2&\'\5\4\3\2\'\3\3\2\2\2()\b\3\1\2)*\5\6\4\2*/\3\2\2\2"+
		"+,\f\4\2\2,.\5\6\4\2-+\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\5"+
		"\3\2\2\2\61/\3\2\2\2\62\63\5\b\5\2\63\64\7\3\2\2\64:\3\2\2\2\65\66\5\n"+
		"\6\2\66\67\7\3\2\2\67:\3\2\2\28:\5\34\17\29\62\3\2\2\29\65\3\2\2\298\3"+
		"\2\2\2:\7\3\2\2\2;<\5\20\t\2<=\7\13\2\2=>\5\20\t\2>H\3\2\2\2?@\5\20\t"+
		"\2@A\7\13\2\2AB\5\22\n\2BH\3\2\2\2CD\5\20\t\2DE\7\13\2\2EF\5\n\6\2FH\3"+
		"\2\2\2G;\3\2\2\2G?\3\2\2\2GC\3\2\2\2H\t\3\2\2\2IL\5\16\b\2JL\5\f\7\2K"+
		"I\3\2\2\2KJ\3\2\2\2L\13\3\2\2\2MN\7\t\2\2NO\5\32\16\2O\r\3\2\2\2PQ\7\23"+
		"\2\2QR\7\4\2\2RS\5\30\r\2ST\7\5\2\2TY\3\2\2\2UV\7\23\2\2VW\7\4\2\2WY\7"+
		"\5\2\2XP\3\2\2\2XU\3\2\2\2Y\17\3\2\2\2Z[\7\25\2\2[\\\7\6\2\2\\]\7\26\2"+
		"\2]^\7\23\2\2^_\7\26\2\2_h\7\7\2\2`a\7\25\2\2ab\7\6\2\2bc\7\f\2\2cd\7"+
		"\23\2\2de\7\f\2\2eh\7\7\2\2fh\7\25\2\2gZ\3\2\2\2g`\3\2\2\2gf\3\2\2\2h"+
		"\21\3\2\2\2ij\7\f\2\2jk\5\24\13\2kl\7\f\2\2l\23\3\2\2\2mn\b\13\1\2no\5"+
		"\26\f\2ot\3\2\2\2pq\f\4\2\2qs\5\26\f\2rp\3\2\2\2sv\3\2\2\2tr\3\2\2\2t"+
		"u\3\2\2\2u\25\3\2\2\2vt\3\2\2\2w\u0081\7\23\2\2x\u0081\7\24\2\2y\u0081"+
		"\7\16\2\2z\u0081\7\n\2\2{\u0081\7\13\2\2|\u0081\7\r\2\2}\u0081\7\26\2"+
		"\2~\u0081\7\f\2\2\177\u0081\5\20\t\2\u0080w\3\2\2\2\u0080x\3\2\2\2\u0080"+
		"y\3\2\2\2\u0080z\3\2\2\2\u0080{\3\2\2\2\u0080|\3\2\2\2\u0080}\3\2\2\2"+
		"\u0080~\3\2\2\2\u0080\177\3\2\2\2\u0081\27\3\2\2\2\u0082\u0083\b\r\1\2"+
		"\u0083\u0084\5\32\16\2\u0084\u008a\3\2\2\2\u0085\u0086\f\4\2\2\u0086\u0087"+
		"\7\r\2\2\u0087\u0089\5\32\16\2\u0088\u0085\3\2\2\2\u0089\u008c\3\2\2\2"+
		"\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\31\3\2\2\2\u008c\u008a"+
		"\3\2\2\2\u008d\u0091\5\20\t\2\u008e\u0091\5\22\n\2\u008f\u0091\5\n\6\2"+
		"\u0090\u008d\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091\33"+
		"\3\2\2\2\u0092\u0093\b\17\1\2\u0093\u0094\5\36\20\2\u0094\u0099\3\2\2"+
		"\2\u0095\u0096\f\4\2\2\u0096\u0098\5\36\20\2\u0097\u0095\3\2\2\2\u0098"+
		"\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\35\3\2\2"+
		"\2\u009b\u0099\3\2\2\2\u009c\u009d\7\21\2\2\u009d\u009e\7\23\2\2\u009e"+
		"\u00b7\7\22\2\2\u009f\u00a0\7\21\2\2\u00a0\u00a1\7\b\2\2\u00a1\u00a2\7"+
		"\23\2\2\u00a2\u00b7\7\22\2\2\u00a3\u00a4\7\21\2\2\u00a4\u00a6\7\23\2\2"+
		"\u00a5\u00a7\5 \21\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a6"+
		"\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\7\22\2\2"+
		"\u00ab\u00b7\3\2\2\2\u00ac\u00ad\7\21\2\2\u00ad\u00af\7\23\2\2\u00ae\u00b0"+
		"\5 \21\2\u00af\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7\b\2\2\u00b4\u00b5\7\22"+
		"\2\2\u00b5\u00b7\3\2\2\2\u00b6\u009c\3\2\2\2\u00b6\u009f\3\2\2\2\u00b6"+
		"\u00a3\3\2\2\2\u00b6\u00ac\3\2\2\2\u00b7\37\3\2\2\2\u00b8\u00b9\7\23\2"+
		"\2\u00b9\u00ba\7\13\2\2\u00ba\u00bb\7\f\2\2\u00bb\u00bc\7\17\2\2\u00bc"+
		"\u00bd\5\"\22\2\u00bd\u00be\7\20\2\2\u00be\u00bf\7\f\2\2\u00bf\u00cf\3"+
		"\2\2\2\u00c0\u00c1\7\23\2\2\u00c1\u00c2\7\13\2\2\u00c2\u00c3\7\f\2\2\u00c3"+
		"\u00c4\7\17\2\2\u00c4\u00c5\5$\23\2\u00c5\u00c6\7\3\2\2\u00c6\u00c7\7"+
		"\20\2\2\u00c7\u00c8\7\f\2\2\u00c8\u00cf\3\2\2\2\u00c9\u00ca\7\23\2\2\u00ca"+
		"\u00cb\7\13\2\2\u00cb\u00cc\7\f\2\2\u00cc\u00cd\7\23\2\2\u00cd\u00cf\7"+
		"\f\2\2\u00ce\u00b8\3\2\2\2\u00ce\u00c0\3\2\2\2\u00ce\u00c9\3\2\2\2\u00cf"+
		"!\3\2\2\2\u00d0\u00d1\b\22\1\2\u00d1\u00d2\5$\23\2\u00d2\u00d8\3\2\2\2"+
		"\u00d3\u00d4\f\4\2\2\u00d4\u00d5\7\3\2\2\u00d5\u00d7\5$\23\2\u00d6\u00d3"+
		"\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"#\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00de\5\b\5\2\u00dc\u00de\5\n\6\2"+
		"\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de%\3\2\2\2\23/9GKXgt\u0080"+
		"\u008a\u0090\u0099\u00a8\u00b1\u00b6\u00ce\u00d8\u00dd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}