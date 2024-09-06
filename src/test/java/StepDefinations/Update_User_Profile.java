package StepDefinations;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.HashMap;

public class Update_User_Profile {

    private RequestSpecification requestSpec;
    private Response response;
    private String userId;

    private final String BASE_URI = "http://localhost:3000"; 

    @Given("I set the base URI")
    public void setBaseURI() {
        requestSpec = given()
                .baseUri(BASE_URI)
                .contentType("application/json");
    }

    @When("I set the request body for updating user profile")
    public void setRequestBodyForUpdatingUserProfile() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", "PoojaUpdated");
        requestBody.put("email", "pooja12@gmail.com");

        requestSpec.body(requestBody);
    }

    @When("I send a PUT request to \"/users/{userId}\"")
    public void sendPutRequest(String endpoint, String userId) {
        this.userId = userId;
        response = requestSpec
                .when()
                .put(endpoint.replace("{userId}", userId));
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