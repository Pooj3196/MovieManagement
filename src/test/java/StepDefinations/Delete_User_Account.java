package StepDefinations;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class Delete_User_Account {

    private RequestSpecification requestSpec;
    private Response response;

    private final String BASE_URI = "http://localhost:3000"; 

    @Given("I set the base URI")
    public void setBaseURI() {
        requestSpec = given()
                .baseUri(BASE_URI)
                .contentType("application/json");
    }

    @When("I send a DELETE request to \"/users/{userId}\"")
    public void sendDeleteRequest(String endpoint, String userId) {
        response = requestSpec
                .when()
                .delete(endpoint.replace("{userId}", userId));
    }

    @Then("the response status code should be {int}")
    public void verifyResponseStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }
}