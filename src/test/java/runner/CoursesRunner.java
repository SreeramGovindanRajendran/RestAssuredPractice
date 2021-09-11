package runner;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import samplejson.DBJSON;
import utils.JSONUtility;

import static io.restassured.RestAssured.given;

public class CoursesRunner {

    @Test
    public void validateCoursesJSON() {
        RestAssured.baseURI = "http://localhost:3000/";

        // Print Purchase Amount
        String dashboard = given().
                when().
                get("dashboard").
                then().
                assertThat().
                statusCode(200).
                extract().asString();

        JsonPath js1 = JSONUtility.jsonConverter(dashboard);

        int totalAmount = js1.getInt("purchaseAmount");

        System.out.println(totalAmount);

        //Print No of courses returned by API
        String courses = given().
                when().
                get("courses").
                then().
                assertThat().
                statusCode(200).
                extract().asString();

        JsonPath js2 = JSONUtility.jsonConverter(courses);

        int coursesNumber = js2.getInt("size()");

        System.out.println(coursesNumber);

        //Print Title of the first course
        String FirstCourseTitle = js2.getString("[0].title");

        System.out.println(FirstCourseTitle);

        //Print All course titles and their respective Prices
        int sumOfPrices = 0;
        for (int i = 0; i < coursesNumber; i++) {
            String CourseTitle = js2.getString("[" + i + "].title");
            int CoursePrice = js2.getInt("[" + i + "].price");
            int CourseCopies = js2.getInt("[" + i + "].copies");
            System.out.println("Title :" + CourseTitle);
            System.out.println("Price :" + CoursePrice);

            //Print no of copies sold by RPA Course
            if (CourseTitle.equals("RPA")) {
                int RPACopies = js2.getInt("[" + i + "].copies");
                System.out.println("RPACopies :" + RPACopies);
            }

            //Verify if Sum of all Course prices matches with Purchase Amount
            sumOfPrices += CoursePrice * CourseCopies;
        }

        Assert.assertEquals(totalAmount, sumOfPrices);
    }
}
