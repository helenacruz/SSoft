package tecnico.ssoft.phpsat.core;

import tecnico.ssoft.phpsat.parser.CodeParser;
import tecnico.ssoft.phpsat.parser.VulnerabilitiesParser;
import tecnico.ssoft.phpsat.parser.ast.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Analyser
{
    private boolean _vulnerable;

    private String _result;

    private List<Vulnerability> _vulnerabilities;
    private List<String> _sanitizationFunctions;
    private List<String> _sinks;

    private List<Node> _code;

    private List<CodeVulnerability> _codeVulnerabilities;

    public Analyser(String file)
    {
        _vulnerable = false;
        _codeVulnerabilities = new ArrayList<>();
        _result = "";

        VulnerabilitiesParser vulnerabilitiesParser = new VulnerabilitiesParser();
        vulnerabilitiesParser.parse();
        _vulnerabilities = vulnerabilitiesParser.result();
        _sanitizationFunctions = vulnerabilitiesParser.getSanitizationFunctions();
        _sinks = vulnerabilitiesParser.getSinks();

        CodeParser codeParser = new CodeParser(file);
        codeParser.parse();
        _code = codeParser.result();
    }

    public List<CodeVulnerability> getCodeVulnerabilities()
    {
        return _codeVulnerabilities;
    }

    public void analyse()
    {
        analyseCode();
        analyseVulnerabilities();
    }

    public void analyseCode()
    {
        for (Node node : _code) {
            if (node instanceof Assignment) {
                Assignment assignment = (Assignment) node;
                analyseAssignment(assignment);
            }
            else if (node instanceof Function) {
                Function function = (Function) node;
                analyseFunction(function);
            }
            else {
                System.out.println("Should not happen... what am i?");
                System.out.println(node.toString());
            }
        }
    }

    public void analyseAssignment(Assignment assignment)
    {
        /*
         * let's start by the right value
         * - variable: if it's tainted, then left value is tainted too
         * - variable: if it comes from an entry point, tainted
         * - function: analyse function
         * - value: if it contains tainted variables, tainted
         */
        if (assignment.getRight() instanceof Variable) {
            Variable variable = (Variable) assignment.getRight();
            if (variable.isGlobal()) {
                assignment.getLeft().taint();
                addCodeVulnerability(assignment.getLeft(), variable);
            }
            if (!variable.isTainted()) {
                assignment.getLeft().untaint();
            }
        }
        else if (assignment.getRight() instanceof Value) {
            Value value = (Value) assignment.getRight();
            for (Variable variable : value.getVariables()) {
                assignment.getLeft().untaint(); // if one of the variables are tainted then it will be tainted in the next step
                if (variable.isTainted()) {
                    addCodeVulnerability(assignment.getLeft(), variable);
                    assignment.getLeft().taint();
                }
            }
        }
        else if (assignment.getRight() instanceof Function) {
            Function function = (Function) assignment.getRight();
            analyseFunction(function);
        }
    }

    public void addCodeVulnerability(Variable variable1, Variable variable2)
    {
        CodeVulnerability codeVulnerability = new CodeVulnerability(variable1);
        codeVulnerability.addEntryPoint(variable2.getGlobalName());
        variable1.setGlobal(true);
        variable1.setGlobalName(variable2.getGlobalName());
        _codeVulnerabilities.add(codeVulnerability);
    }

    public void addCodeVulnerability(Function function, Variable variable, boolean isSink)
    {
        CodeVulnerability codeVulnerability = new CodeVulnerability(variable);
        if (isSink) {
            codeVulnerability.addSink(function.getName());
        }
        else {
            codeVulnerability.addSanitizationFunction(function.getName());
        }
        if (variable.isGlobal()) {
            codeVulnerability.addEntryPoint(variable.getGlobalName());
        }
        _codeVulnerabilities.add(codeVulnerability);
    }

    public void analyseFunction(Function function)
    {
        if (function.isThisFunction(_sinks)) {
            for (RightValue rv : function.getArgs()) {
                if (rv instanceof Variable) {
                    Variable variable = (Variable) rv;
                    addCodeVulnerability(function, variable, true);
                }
            }
        }
        else if (function.isThisFunction(_sanitizationFunctions)) {
            for (RightValue rv : function.getArgs()) {
                if (rv instanceof Variable) {
                    Variable variable = (Variable) rv;
                    addCodeVulnerability(function, variable, false);
                }
            }
        }
        // else do nothing
    }

    public void analyseVulnerabilities()
    {
        for (Vulnerability vulnerability : _vulnerabilities) {
            for (CodeVulnerability codeVulnerability : _codeVulnerabilities) {
                // they have an entry point in common
                if (!Collections.disjoint(vulnerability.getEntryPoints(), codeVulnerability.getEntryPoints())) {
                    // they have a sink in common
                    if (!Collections.disjoint(vulnerability.getSinks(), codeVulnerability.getSinks())) {
                        // if they don't have a sanitization function in common, oopsy, its vulnerable
                        if (Collections.disjoint(vulnerability.getSanitizationFunctions(),
                                codeVulnerability.getSanitizationFunctions())) {
                            if (_vulnerable) {
                                _result += "- " + vulnerability.type() + "\n";
                            }
                            else {
                                _vulnerable = true;
                                _result = vulnerability.type() + "\n";
                            }
                        }
                        else {
                            if (!_vulnerable) {
                                _result += inCommon(vulnerability.getSanitizationFunctions(),
                                        codeVulnerability.getSanitizationFunctions()) + "\n";
                            }
                        }
                    }
                }
            }
        }
    }

    public String inCommon(List<String> list1, List<String> list2)
    {
        for (String string1 : list1) {
            for (String string2 : list2) {
                if (string1.equals(string2)) {
                    return string1;
                }
            }
        }

        return null;
    }

    public String result()
    {
        if (_vulnerable) {
            return "The program is vulnerable to:\n" + _result;
        }
        else {
            return "The program is not vulnerable because of the following sanitization functions:\n" + _result;
        }
    }

}
