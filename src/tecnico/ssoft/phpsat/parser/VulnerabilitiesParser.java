package tecnico.ssoft.phpsat.parser;

import tecnico.ssoft.phpsat.core.SQLInjectionVulnerability;
import tecnico.ssoft.phpsat.core.Vulnerability;
import tecnico.ssoft.phpsat.core.XSSVulnerability;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VulnerabilitiesParser implements Parser
{
    private static final String SQL_INJECTION_DIR = "docs/sql_injection.txt";
    private static final String XSS_DIR = "docs/xss.txt";

    private List<Vulnerability> _vulnerabilities;

    public VulnerabilitiesParser()
    {
        _vulnerabilities = new ArrayList<Vulnerability>();
    }

    private List<Vulnerability> getVulnerabilities()
    {
        return _vulnerabilities;
    }

    @Override
    public List result()
    {
        return getVulnerabilities();
    }

    @Override
    public void parse()
    {
        try {
            BufferedReader SQLInjectionFIle = new BufferedReader(new FileReader(SQL_INJECTION_DIR));
            BufferedReader XSSFile = new BufferedReader(new FileReader(XSS_DIR));

            while (SQLInjectionFIle.readLine() != null) {
                Vulnerability vulnerability = new SQLInjectionVulnerability();
                parseVulnerability(vulnerability, SQLInjectionFIle);
            }

            SQLInjectionFIle.close();

            while (XSSFile.readLine() != null) {
                Vulnerability vulnerability = new XSSVulnerability();
                parseVulnerability(vulnerability, XSSFile);
            }

            XSSFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseVulnerability(Vulnerability vulnerability, BufferedReader file)
            throws java.io.IOException
    {
        String entryPoints = file.readLine().replaceAll("\\s", ""); // deletes spaces
        String sanitizationFunctions = file.readLine().replaceAll("\\s", "");
        String sinks = file.readLine().replaceAll("\\s", "");
        file.readLine(); // reads the \n between vulnerabilities

        String[] entryPointsArray = entryPoints.split(",");
        String[] sanitizationFunctionsArray = sanitizationFunctions.split(",");
        String[] sinksArray = sinks.split(",");

        for (String entryPoint : entryPointsArray) {
            vulnerability.addEntryPoint(entryPoint);
        }

        for (String sanitizationFunction : sanitizationFunctionsArray) {
            vulnerability.addSanitizationFunction(sanitizationFunction);
        }

        for (String sink : sinksArray) {
            vulnerability.addSink(sink);
        }

        _vulnerabilities.add(vulnerability);
    }
}
