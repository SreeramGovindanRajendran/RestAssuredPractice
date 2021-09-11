package runner;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import samplejson.DBJSON;
import samplejson.GoogleMapJSON;
import utils.JSONUtility;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class Runner {

    @Test
    public void validateGoogleMapPost(){
        RestAssured.baseURI="https://rahulshettyacademy.com";
        given().
                queryParam("key","qaclick123").
                header("content-Type","application/json").
                body(GoogleMapJSON.JSONbody()).
        when().
                post("maps/api/place/add/json").
        then().
                assertThat().
                statusCode(200).
                body("scope",equalTo("APP")).
                log().
                all();
    }

    @Test
    public void validateLocalJSONGet() {
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
    public void validateLocalJSONPost() {
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
    public void validateLocalJSONPut() {
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
   /* @Test
    public void validateLocalJSONPatch(){
        RestAssured.baseURI="http://localhost:3000";
        given().
                header("content-Type","application/json").
                body(LocalJSON.JSONPatchBody()).
                when().
                patch("places/7").
                then().
                assertThat().
                statusCode(200).
                log().
                all();
    }*/

    @Test
    public void validateLocalJSONDelete() {
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
    public void validateLocalJSON() {
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
