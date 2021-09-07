package samplejson;

public class CoursesJSON {

    public static String JSONPostBody() {
        return "{\n" +
                "      \"id\": 6,\n" +
                "      \"country\": \"Chennai\",\n" +
                "      \"author\": \"Srivi\"\n" +
                "    }";
    }

    public static String JSONPutBody() {
        return "{\n" +
                "      \"id\": 6,\n" +
                "      \"country\": \"France\",\n" +
                "      \"author\": \"Paris\"\n" +
                "    }";
    }

}
