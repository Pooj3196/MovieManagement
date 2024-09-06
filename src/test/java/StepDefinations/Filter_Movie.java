package StepDefinations;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Filter_Movie {

    private RequestSpecification requestSpec;
    private Response response;

    private final String BASE_URI = "http://localhost:3000"; 

    @Given("I set the base URI")
    public void setBaseURI() {
        requestSpec = given()
                .baseUri(BASE_URI)
                .contentType("application/json");
    }

    @When("I send a GET request to \"/movies/filter?genre={genreName}\"")
    public void sendGetRequest(String genreName) {
        response = requestSpec
                .when()
                .get("/movies/filter?genre=" + genreName);
    }

    @Then("the response status code should be {int}")
    public void verifyResponseStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response body should contain the filtered movies")
    public void verifyResponseBody() {
        response.then().body("movies", not(empty())); // Ensure that the 'movies' field is not empty
        // You can add more assertions to validate specific details about the filtered movies
    }
}