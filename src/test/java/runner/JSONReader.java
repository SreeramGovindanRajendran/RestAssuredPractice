package runner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JSONReader {

    /**Read the json file and write the same contents in another json **/
    public static void main(String[] args) throws IOException, ParseException {
        StringBuilder stringBuilder = new StringBuilder();
        JSONParser jsonParser = new JSONParser();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("json\\sample.json"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        JSONObject jSONObject = (JSONObject) jsonParser.parse(stringBuilder.toString());

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("json\\write.json"));
        bufferedWriter.write(jSONObject.toJSONString());
        bufferedWriter.flush();
        bufferedWriter.close();
    }


}
