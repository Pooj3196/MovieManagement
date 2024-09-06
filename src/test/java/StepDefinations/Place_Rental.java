package StepDefinations;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.HashMap;

public class Place_Rental {

    private RequestSpecification requestSpec;
    private Response response;

    private final String BASE_URI = "http://localhost:3000"; 

    @Given("I set the base URI")
    public void setBaseURI() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType("application/json")
                .build();
    }

    @When("I set the request body for placing a new rental")
    public void setRequestBodyForPlacingNewRental() {
        // Sample data; you can adjust it based on your API's requirements
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("userId", "123");
        requestBody.put("movieId", "456");
        requestBody.put("rentalDate", "2024-09-10");

        // Set the request body in the request specification
        requestSpec = given().spec(requestSpec).body(requestBody);
    }

    @When("I send a POST request to {string}")
    public void sendPostRequest(String endpoint) {
        response = requestSpec.post(endpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyResponseStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response body should contain {string}")
    public void verifyResponseBody(String expectedMessage) {
        response.then().body("message", equalTo(expectedMessage));
    }
}


