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

public class User_Login {

    private RequestSpecification requestSpec;
    private Response response;
    private Map<String, String> requestBody = new HashMap<>();
    private final String BASE_URI = "http://localhost:3000"; 

    @Given("I set the base URI")
    public void setBaseURI() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType("application/json")
                .build();
    }

    @When("I set the request body for user login")
    public void setRequestBodyForUserLogin() {
        requestBody.put("username", "Pooja");
        requestBody.put("password", "12345");
    }

    @When("I send a POST request to {string}")
    public void sendPostRequest(String endpoint) {
        response = given()
                .spec(requestSpec)
                .body(requestBody)
                .post(endpoint);
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