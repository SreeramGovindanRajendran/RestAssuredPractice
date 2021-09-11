package samplejson;

public class DynamicDBJSON {

    public static String JSONDBPostBody(String country, String author) {
        return "{\n" +
                "      \"id\": 8,\n" +
                "      \"country\": \"" + country + "\",\n" +
                "      \"author\": \"" + author + "\"\n" +
                "    }";
    }

    public static String JSONDBPostBodies(int id, String country, String author) {
        return "{\n" +
                "      \"id\": "+id+",\n" +
                "      \"country\": \"" + country + "\",\n" +
                "      \"author\": \"" + author + "\"\n" +
                "    }";
    }
}
