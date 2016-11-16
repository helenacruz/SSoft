package tecnico.ssoft.phpsat.parser;

import tecnico.ssoft.phpsat.parser.ast.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class CodeParser implements PHPSATParser
{
    private String file;
    private List<Node> result;
    private List<String> entryPoints;
    private TreeMap<String, Variable> variables;

    public CodeParser(String file)
            throws IOException
    {
        this.file = file;
        this.result = new ArrayList<>();
        this.variables = new TreeMap<>();

        VulnerabilitiesParser vulnerabilitiesParser = new VulnerabilitiesParser();
        vulnerabilitiesParser.parse();
        this.entryPoints = vulnerabilitiesParser.getEntryPoints();
    }

    @Override
    public List<Node> result()
    {
        findVariables();
        return result;
    }

    @Override
    public void parse()
            throws IOException
    {
        int i;
        char c;
        BufferedReader file = new BufferedReader(new FileReader(this.file));

        while ((i = file.read()) != -1) {
            c = (char) i;
            if (c == '$') {
                file = doVariable(file);
            }
            else if (c == '<') {
                file = doTags(file);
            }
            else if (Character.isAlphabetic(c)) {
                file = doFunction(file, null, c);
            }
        }

        file.close();
    }

    private BufferedReader doVariable(BufferedReader file)
            throws IOException
    {
        int i;
        char c;
        String res = "";
        Variable variable = new Variable();

        while ((i = file.read()) != -1) {
            c = (char) i;
            if (c == '=') {
                variable = new Variable(res);
                variables.put(variable.getName(), variable);
                return doAssignment(file, variable);
            }
            if (c == ';' || c == ',' || c == ')' || c == '\'' || c == '[') {
                break;
            }
            res += c;
            res = res.trim();
        }

        result.add(variable);
        return file;
    }

    private BufferedReader doAssignment(BufferedReader file, Variable variable)
            throws IOException
    {
        int i;
        char c;
        boolean first = true;
        boolean function = false;
        String res = "";
        Assignment assignment = new Assignment(variable);

        while ((i = file.read()) != -1) {
            c = (char) i;
            if (first) {
                first = false;
                if (Character.isAlphabetic(c)) {
                    function = true;
                    file = doFunction(file, assignment, c);
                }
            }
            else if (c == ';') {
                break;
            }
            res += c;
        }

        if (!function) {
            Value value = new Value(res);
            assignment.setRight(value);
            result.add(assignment);
        }

        return file;
    }

    private BufferedReader doTags(BufferedReader file)
            throws IOException
    {
        int i;
        char c;
        boolean first = true;
        int openingTags = 1; // the one that got us here
        int closingTags = 0; // none yet
        String res = "";

        while ((i = file.read()) != -1) {
            c = (char) i;
            res = res.trim();
            if (c == '<') {
                openingTags++;
            }
            if (c == '>') {
                closingTags++;
            }
            if (res.length() >= 4) {
                if (res.substring(res.length() - 4).equals("?php")) {
                    file = doPHPCode(file);
                }
            }
            if (openingTags == closingTags) {
                return file;
            }
            res += c;
        }

        return file;
    }

    private BufferedReader doPHPCode(BufferedReader file)
            throws IOException
    {
        int i;
        char c;
        String res = "";

        while ((i = file.read()) != -1) {
            c = (char) i;
            res += c;
            res = res.trim();

            if (res.length() >= 1) {
                if (res.substring(res.length() - 1).equals(">")) {
                    return file;
                }
            }
            if (res.length() >= 2) {
                if (res.substring(res.length() - 2).equals("?>")) {
                    return file;
                }
            }
            if (c == '$') {
                res = res.substring(0, res.length() - 1);
                file = doVariable(file);
            }
            if (c == '<') {
                res = res.substring(0, res.length() - 1);
                file = doTags(file);
            }
            if (Character.isAlphabetic(c)) {
                file = doFunction(file, null, c);
            }
        }

        return file;
    }

    private BufferedReader doFunction(BufferedReader file, Assignment assignment, char c)
            throws IOException
    {
        int i;
        String name = Character.toString(c);
        String args = "";
        Function function = new Function();

        while ((i = file.read()) != -1) {
            c = (char) i;
            name += c;
            if (name.equals("echo")) {
                function = new Function(name);
                result.add(function);
                file = doEcho(file, function);
                return file;
            }
            if (c == ' ' || c == '(') {
                name = name.substring(0, name.length() - 1);
                function = new Function(name);
            }
            if (c == '(') {
                do {
                    c = (char) file.read();
                    if (c != ')') {
                        args += c;
                    }
                } while (c != ')');
                doArgs(function, args);

                if (assignment != null) {
                    assignment.setRight(function);
                    result.add(assignment);
                }
                else {
                    result.add(function);
                }

                return file;
            }
        }

        return file;
    }

    private BufferedReader doEcho(BufferedReader file, Function function)
            throws IOException
    {
        int i;
        char c;
        String res = "";

        while ((i = file.read()) != -1) {
            c = (char) i;
            if (c == '>' || c == ';' || c == '?') {
                if (!res.contains("$_")) {
                    function.addArg(findVariableByName(res.replace("$", "")));
                }
                else {
                    function.addArg(findVariableByName(res));
                }
                return file;
            }
            res += c;
        }

        return file;
    }

    private void doArgs(Function function, String args)
    {
        args = args.trim();
        if (!args.isEmpty()) {
            String[] argsArray = args.split(",");
            for (String arg : argsArray) {
                arg = arg.trim();
                function.addArg(new Value(arg));
            }
        }
    }

    private void findVariables()
    {
        for (Node node : result) {
            if (node instanceof Assignment) {
                findVariables((Assignment) node);
            }
            else if (node instanceof Function) {
                findVariables((Function) node);
            }
            else {
                System.out.println("Should not happen... what am i?");
                System.out.println(node.toString());
            }
        }
    }

    private void findVariables(Assignment assignment)
    {
        /*
         * Right can be:
         * - variable: no more needs to be done
         * - entry point: change the name to its entry point, the rest doesn't really matter
         * - function call: we need to process the args of the function then
         */
        if (assignment.getRight().isVariable()) {
            if (assignment.getRight() instanceof Value) {
                Value value = (Value) assignment.getRight();
                for (String entryPoint : entryPoints) {
                    if (value.getValue().contains(entryPoint)) {
                        Variable variable = new Variable(entryPoint, true);
                        variables.put(variable.getName(), variable);
                        variable.setEntryPointName(entryPoint);
                        value.addVariable(variable);
                        assignment.setRight(variable);
                        return;
                    }
                }
            }
        }

        if (assignment.getRight() instanceof Value) {
            Value value = (Value) assignment.getRight();
            findVariables(value);
        }

        if (assignment.getRight() instanceof Function) {
            Function function = (Function) assignment.getRight();
            findVariables(function);
        }
    }

    private void findVariables(Function function)
    {
        if (function.getArgs() == null) {
            return;
        }

        List<RightValue> args = new ArrayList<>();

        for (RightValue rv : function.getArgs()) {
            if (rv instanceof Value) {
                Value value = (Value) rv;
                args.add(findVariableByName(value.getValue()));
            }
            else if (rv instanceof Variable) {
                Variable variable = (Variable) rv;
                for (String entryPoint : entryPoints) {
                    if (variable.getName().contains(entryPoint)) {
                        variable.setEntryPointName(entryPoint);
                        variable.setEntryPoint(true);
                    }
                }
                args.add(variable);
            }
        }
        function.setArgs(args);
    }

    private ArrayList<String> splitDollar(String string)
    {
        char c;
        boolean variable = false;
        int len = string.length();
        String elem = "";
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            c = string.charAt(i);
            if (c == '$') {
                elem += Character.toString(c);
                variable = true;
            }
            else if (c == '"' && variable) {
                result.add(elem);
                elem = "";
                variable = false;
            }
            else if (c == '\'' && variable) {
                result.add(elem);
                elem = "";
                variable = false;
            }
            else if (variable) {
                elem += Character.toString(c);
            }
        }

        return result;
    }

    private void findVariables(Value value)
    {
        if (value.isVariable())
            return;

        ArrayList<String> vars = splitDollar(value.getValue());

        for (String string : vars) {
            value.addVariable(findVariableByName(string));
        }
    }

    private Variable findVariableByName(String name)
    {
        name = name.replace("[", "");

        for (String entryPoint : entryPoints) {
            if (name.contains(entryPoint)) {
                return new Variable(entryPoint, true, entryPoint);
            }
        }

        name = name.substring(1, name.length()).trim();

        if (variables.containsKey(name)) {
            return variables.get(name);
        }
        else {
            Variable variable = new Variable(name);
            variables.put(variable.getName(), variable);
            return variable;
        }
    }

}
