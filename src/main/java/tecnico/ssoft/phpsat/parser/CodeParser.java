package tecnico.ssoft.phpsat.parser;

import tecnico.ssoft.phpsat.parser.ast.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CodeParser extends PHPGrammarBaseListener
{
    private List<Node> program;
    private Map<String, Variable> variables;
    private List<RightValue> args;

    private List<String> entryPoints;

    private Assignment assignment;
    private Function function;
    private Value value;
    private Variable variable;
    private RightValue rightValue;
    private String stringValue;

    private boolean inAssignment;
    private boolean inValue;
    private boolean inArgs;

    public CodeParser() throws IOException
    {
        program = new ArrayList<>();
        variables = new TreeMap<>();
        args = new ArrayList<>();

        VulnerabilitiesParser vulnerabilitiesParser = new VulnerabilitiesParser();
        vulnerabilitiesParser.parse();
        entryPoints = vulnerabilitiesParser.getEntryPoints();

        assignment = null;
        function = null;
        value = null;
        variable = null;
        rightValue = null;
        stringValue = null;

        inAssignment = false;
        inValue = false;
        inArgs = false;
    }

    public List<Node> result()
    {
        return program;
    }

    @Override
    public void enterProg(PHPGrammarParser.ProgContext ctx)
    {

    }

    @Override
    public void exitProg(PHPGrammarParser.ProgContext ctx)
    {

    }

    @Override
    public void enterStatements(PHPGrammarParser.StatementsContext ctx)
    {

    }

    @Override
    public void exitStatements(PHPGrammarParser.StatementsContext ctx)
    {

    }

    @Override
    public void enterStatement(PHPGrammarParser.StatementContext ctx)
    {

    }

    @Override
    public void exitStatement(PHPGrammarParser.StatementContext ctx)
    {

    }

    @Override
    public void enterAssignment(PHPGrammarParser.AssignmentContext ctx)
    {
        assignment = new Assignment();
        inAssignment = true;
    }

    @Override
    public void exitAssignment(PHPGrammarParser.AssignmentContext ctx)
    {
        assignment.setLeft(variable);
        assignment.setRight(rightValue);
        program.add(assignment);

        inAssignment = false;
        assignment = null;
        variable = null;
        rightValue = null;
    }

    @Override
    public void enterFunction(PHPGrammarParser.FunctionContext ctx)
    {
        function = new Function();
        inArgs = true;
    }

    @Override
    public void exitFunction(PHPGrammarParser.FunctionContext ctx)
    {
        if (!inAssignment) {
            program.add(function);
        }
        else {
            rightValue = function;
        }

        args = new ArrayList<>();
        inArgs = false;
    }

    @Override
    public void enterEcho(PHPGrammarParser.EchoContext ctx)
    {
        function.setName("echo");
    }

    @Override
    public void exitEcho(PHPGrammarParser.EchoContext ctx)
    {
        function.setArgs(args);
    }

    @Override
    public void enterRegularFunction(PHPGrammarParser.RegularFunctionContext ctx)
    {
        function.setName(ctx.ID().getText());
    }

    @Override
    public void exitRegularFunction(PHPGrammarParser.RegularFunctionContext ctx)
    {
        function.setArgs(args);
    }

    @Override
    public void enterVariable(PHPGrammarParser.VariableContext ctx)
    {
        String name = ctx.VAR().getText();
        Variable var = getVariable(name);

        if (inArgs) {
            args.add(var);
        }
        else if (inValue) {
            stringValue += name;
            value.addVariable(var);
        }
        else if (inAssignment) {
            if (variable == null) { // we're defining left
                variable = var;
            }
            else { // defining right
                rightValue = var;
            }
        }
    }

    private Variable getVariable(String name)
    {
        for (String entryPoint : entryPoints) {
            if (entryPoint.equals(name)) {
                return new Variable(name, true, name);
            }
        }

        if (variables.containsKey(name)) {
            return variables.get(name);
        }

        Variable variable = new Variable(name);
        variables.put(name, variable);

        return variable;
    }

    @Override
    public void exitVariable(PHPGrammarParser.VariableContext ctx)
    {

    }

    @Override
    public void enterValue(PHPGrammarParser.ValueContext ctx)
    {
        value = new Value();
        stringValue = "";
        inValue = true;
    }

    @Override
    public void exitValue(PHPGrammarParser.ValueContext ctx)
    {
        value.setValue(stringValue);
        rightValue = value;

        inValue = false;
        value = null;
        stringValue = "";
    }

    @Override
    public void enterStringValues(PHPGrammarParser.StringValuesContext ctx)
    {

    }

    @Override
    public void exitStringValues(PHPGrammarParser.StringValuesContext ctx)
    {

    }

    @Override
    public void enterStringValue(PHPGrammarParser.StringValueContext ctx)
    {
        if (ctx.ID() != null) {
            stringValue += ctx.ID().getText();
        }
        if (ctx.INT() != null) {
            stringValue += ctx.INT().getText();
        }
        if (ctx.DOT() != null) {
            stringValue += ctx.DOT().getText();
        }
        if (ctx.STAR() != null) {
            stringValue += ctx.STAR().getText();
        }
        if (ctx.EQUAL() != null) {
            stringValue += ctx.EQUAL().getText();
        }
        if (ctx.COMMA() != null) {
            stringValue += ctx.COMMA().getText();
        }
        if (ctx.SINGLE_QUOTE() != null) {
            stringValue += ctx.SINGLE_QUOTE().getText();
        }
        if (ctx.DOUBLE_QUOTES() != null) {
            stringValue += ctx.DOUBLE_QUOTES().getText();
        }

        stringValue += " ";
    }

    @Override
    public void exitStringValue(PHPGrammarParser.StringValueContext ctx)
    {

    }

    @Override
    public void enterArgs(PHPGrammarParser.ArgsContext ctx)
    {

    }

    @Override
    public void exitArgs(PHPGrammarParser.ArgsContext ctx)
    {

    }

    @Override
    public void enterArg(PHPGrammarParser.ArgContext ctx)
    {

    }

    @Override
    public void exitArg(PHPGrammarParser.ArgContext ctx)
    {

    }

    @Override
    public void enterHtml(PHPGrammarParser.HtmlContext ctx)
    {

    }

    @Override
    public void exitHtml(PHPGrammarParser.HtmlContext ctx)
    {

    }

    @Override
    public void enterTag(PHPGrammarParser.TagContext ctx)
    {

    }

    @Override
    public void exitTag(PHPGrammarParser.TagContext ctx)
    {

    }

    @Override
    public void enterOption(PHPGrammarParser.OptionContext ctx)
    {

    }

    @Override
    public void exitOption(PHPGrammarParser.OptionContext ctx)
    {

    }

    @Override
    public void enterHtmlStatements(PHPGrammarParser.HtmlStatementsContext ctx)
    {

    }

    @Override
    public void exitHtmlStatements(PHPGrammarParser.HtmlStatementsContext ctx)
    {

    }

    @Override
    public void enterHtmlStatement(PHPGrammarParser.HtmlStatementContext ctx)
    {

    }

    @Override
    public void exitHtmlStatement(PHPGrammarParser.HtmlStatementContext ctx)
    {

    }

}
