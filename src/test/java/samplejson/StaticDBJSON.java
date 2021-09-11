package samplejson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StaticDBJSON {

    public static String  JSONToBytes(String JSONPath) throws IOException {
       return new String(Files.readAllBytes(Paths.get(JSONPath)));
    }
}
