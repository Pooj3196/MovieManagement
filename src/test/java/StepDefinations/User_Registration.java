package StepDefinations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class User_Registration {

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

    @When("I set the request body for user registration")
    public void setRequestBodyForUserRegistration() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", "Pooja");
        requestBody.put("password", "12345");
        requestBody.put("email", "poojagosavi318@gmail.com");

        // Set the request body
        given().spec(requestSpec).body(requestBody);
    }

    @When("I send a POST request to {string}")
    public void sendPostRequest(String endpoint) {
        response = given().spec(requestSpec)
                .body(BASE_URI) // Ensure this line is included if the body is not set earlier
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