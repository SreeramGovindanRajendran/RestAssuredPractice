package runner;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import samplejson.DBJSON;
import utils.JSONUtility;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class DBRunner {

    @Test
    public void validateDBJSONGet() {
        RestAssured.baseURI = "http://localhost:3000";
        given().
                body(DBJSON.JSONPostBody()).
                when().
                get("places").
                then().
                assertThat().
                statusCode(200).
                log().
                all();
    }

    @Test
    public void validateDBJSONPost() {
        RestAssured.baseURI = "http://localhost:3000";
        given().
                header("content-Type", "application/json").
                body(DBJSON.JSONPostBody()).
                when().
                post("places").
                then().
                assertThat().
                statusCode(201).
                log().
                all();
    }

    @Test
    public void validateDBJSONPut() {
        RestAssured.baseURI = "http://localhost:3000";
        given().
                header("content-Type", "application/json").
                body(DBJSON.JSONPutBody()).
                when().
                put("places/7").
                then().
                assertThat().
                statusCode(200).
                log().
                all();
    }

    @Test
    public void validateDBJSONDelete() {
        RestAssured.baseURI = "http://localhost:3000";
        for (int i = 6; i <= 6; i++) {
            when().
                    delete("places/" + i).
                    // delete("places/2").
                            then().
                    assertThat().
                    statusCode(200).log().all();
        }
    }

    @Test
    public void validateDBJSON() {
        RestAssured.baseURI = "http://localhost:3000";

        given().
                header("content-Type", "application/json").
                body(DBJSON.JSONPostBody()).
                when().
                post("places").
                then().
                assertThat().
                statusCode(201);

        JsonPath js1 = JSONUtility.jsonConverter(DBJSON.JSONPostBody());

        String actualCountry = js1.get("country");

        String Place = given().
                when().
                get("places/17").
                then().
                extract().response().asString();

        JsonPath js = JSONUtility.jsonConverter(Place);
        String expectedCountry = js.getString("country");

        Assert.assertEquals(actualCountry, expectedCountry);

    }
}
