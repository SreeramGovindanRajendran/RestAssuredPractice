package runner;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import samplejson.DBJSON;
import samplejson.DynamicDBJSON;

import static io.restassured.RestAssured.given;

public class DynamicDBRunner {
    @Test
    public void validateDBJSONPost() {

        RestAssured.baseURI = "http://localhost:3000";
        given().
                header("content-Type", "application/json").
                body(DynamicDBJSON.JSONDBPostBody("India", "Sree")).
                when().
                post("places").
                then().
                assertThat().
                statusCode(201).
                log().
                all();
    }

    @Test(dataProvider = "MultipleValues")
    public void validateDBJSONPosts(int id, String country, String capital) {

        RestAssured.baseURI = "http://localhost:3000";
        given().
                header("content-Type", "application/json").
                body(DynamicDBJSON.JSONDBPostBodies(id, country, capital)).
                when().
                post("places").
                then().
                assertThat().
                statusCode(201).
                log().
                all();
    }

    @DataProvider(name="MultipleValues")
    public Object[][] passValues(){

        return new Object[][]{
                {
                   15, "France","Paris"
                },
                {
                    16, "Japan", "Tokyo"
                },
                {
                    17, "Berlin","Italy"
                }
        };
    }
}
