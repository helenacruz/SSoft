package tecnico.ssoft.phpsat.parser;

import java.io.IOException;
import java.util.List;

public interface PHPSATParser
{
    List result();
    void parse() throws IOException;
}
