package utils;

import io.restassured.path.json.JsonPath;

public class JSONUtility {

    public static JsonPath jsonConverter(String test) {
        JsonPath js = new JsonPath(test);
        return js;
    }
}
