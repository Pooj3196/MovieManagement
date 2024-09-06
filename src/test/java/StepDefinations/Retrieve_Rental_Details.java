package StepDefinations;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Retrieve_Rental_Details {

    private RequestSpecification requestSpec;
    private Response response;
    private String rentalId;

    private final String BASE_URI = "http://localhost:3000"; 

    @Given("I set the base URI")
    public void setBaseURI() {
        requestSpec = given()
                .baseUri(BASE_URI)
                .contentType("application/json");
    }

    @When("I send a GET request to \"/rentals/{rentalId}\"")
    public void sendGetRequest(String endpoint, String rentalId) {
        this.rentalId = rentalId;
        response = requestSpec
                .when()
                .get(endpoint.replace("{rentalId}", rentalId));
    }

    @Then("the response status code should be {int}")
    public void verifyResponseStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response body should contain the rental details")
    public void verifyResponseBodyContainsRentalDetails() {
        // Adjust the validation based on your API's response structure
        response.then().body("rentalId", equalTo(rentalId))
                .body("userId", notNullValue())
                .body("movieId", notNullValue())
                .body("rentalDate", notNullValue());
    }
}