// Generated from C:/Users/helcr/Documents/IST/MEIC/SS/SSoft/src/tecnico/ssoft/phpsat/parser\PHPGrammar.g4 by ANTLR 4.5.3
package tecnico.ssoft.phpsat.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PHPGrammarParser}.
 */
public interface PHPGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(PHPGrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(PHPGrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(PHPGrammarParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(PHPGrammarParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PHPGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PHPGrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PHPGrammarParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PHPGrammarParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(PHPGrammarParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(PHPGrammarParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#echo}.
	 * @param ctx the parse tree
	 */
	void enterEcho(PHPGrammarParser.EchoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#echo}.
	 * @param ctx the parse tree
	 */
	void exitEcho(PHPGrammarParser.EchoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#regularFunction}.
	 * @param ctx the parse tree
	 */
	void enterRegularFunction(PHPGrammarParser.RegularFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#regularFunction}.
	 * @param ctx the parse tree
	 */
	void exitRegularFunction(PHPGrammarParser.RegularFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(PHPGrammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(PHPGrammarParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(PHPGrammarParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(PHPGrammarParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#stringValues}.
	 * @param ctx the parse tree
	 */
	void enterStringValues(PHPGrammarParser.StringValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#stringValues}.
	 * @param ctx the parse tree
	 */
	void exitStringValues(PHPGrammarParser.StringValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#stringValue}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(PHPGrammarParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#stringValue}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(PHPGrammarParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(PHPGrammarParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(PHPGrammarParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(PHPGrammarParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(PHPGrammarParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#html}.
	 * @param ctx the parse tree
	 */
	void enterHtml(PHPGrammarParser.HtmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#html}.
	 * @param ctx the parse tree
	 */
	void exitHtml(PHPGrammarParser.HtmlContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(PHPGrammarParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(PHPGrammarParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(PHPGrammarParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(PHPGrammarParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#htmlStatements}.
	 * @param ctx the parse tree
	 */
	void enterHtmlStatements(PHPGrammarParser.HtmlStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#htmlStatements}.
	 * @param ctx the parse tree
	 */
	void exitHtmlStatements(PHPGrammarParser.HtmlStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PHPGrammarParser#htmlStatement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlStatement(PHPGrammarParser.HtmlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PHPGrammarParser#htmlStatement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlStatement(PHPGrammarParser.HtmlStatementContext ctx);
}