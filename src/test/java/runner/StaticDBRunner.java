package runner;

import org.testng.annotations.Test;
import samplejson.StaticDBJSON;

import java.io.IOException;

public class StaticDBRunner {

    @Test
    public void validateDBJSONPost() throws IOException {
        System.out.println(StaticDBJSON.JSONToBytes("C:/Dev/json/db.json"));
    }
}
