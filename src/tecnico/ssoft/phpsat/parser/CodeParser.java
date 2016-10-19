package tecnico.ssoft.phpsat.parser;

import tecnico.ssoft.phpsat.parser.ast.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CodeParser implements Parser
{
    private String _file;
    private List<Node> _result;

    public CodeParser(String file)
    {
        _file = file;
        _result = new ArrayList<Node>();
    }

    @Override
    public List<Node> result()
    {
        return _result;
    }

    @Override
    public void parse()
    {
        try {
            int i;
            char c;
            BufferedReader file = new BufferedReader(new FileReader(_file));

            while ((i = file.read()) != -1) {
                c = (char) i;
                if (c == '$') {
                    file = doVariable(file);
                  //  c = (char) file.read();
                }
                else if (c == '<') {
                    file = doTags(file);
                 //   c = (char) file.read();
                }
                else if (Character.isAlphabetic(c)) {
                    file = doFunction(file, c);
                  //  c = (char) file.read();
                }
            }

            file.close();
        }
        catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
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
                return doAssignment(file, variable);
            }
            if (c == ';' || c == ',' || c == ')' || c == '\'' || c == '[') {
                break;
            }
            res += c;
            res = res.trim();
        }

        _result.add(variable);
        return file;
    }

    private BufferedReader doAssignment(BufferedReader file, Variable variable)
            throws IOException
    {
        int i;
        char c;
        boolean first = true;
        String res = "";

        while ((i = file.read()) != -1) {
            c = (char) i;
            if (c == ';') {
                break;
            }
            res += c;
        }

        Value value = new Value(res);
        Assignment assignment = new Assignment(variable, value);

        _result.add(assignment);

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
                file = doFunction(file, c);
            }
        }

        return file;
    }

    private BufferedReader doFunction(BufferedReader file, char c)
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
                _result.add(function);
                file = doEcho(file, function);
                return file;
            }
            if (c == ' ' || c == '(') {
                name = name.substring(0, name.length() - 1);
                function = new Function(name);
                _result.add(function);
            }
            if (c == '(') {
                do {
                    c = (char) file.read();
                    if (c != ')') {
                        args += c;
                    }
                } while (c != ')');
                doArgs(function, args);
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
                function.addArg(new Value(res));
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

}
