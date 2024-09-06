package StepDefinations;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Retrieve_Movie_Details {

    private RequestSpecification requestSpec;
    private Response response;
    private final String BASE_URI = "http://localhost:3000"; 
    private String movieId;

    @Given("I set the base URI")
    public void setBaseURI() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType("application/json")
                .build();
    }

    @When("I send a GET request to \"/movies/{movieId}\"")
    public void sendGetRequest(String movieId) {
        this.movieId = movieId;
        response = given()
                .spec(requestSpec)
                .pathParam("movieId", movieId)
                .get("/movies/{movieId}");
    }

    @Then("the response status code should be {int}")
    public void verifyResponseStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response body should contain the movie details")
    public void verifyResponseBodyContainsMovieDetails() {
        response.then().body("title", notNullValue())
                      .body("director", notNullValue())
                      .body("genre", notNullValue())
                      .body("releaseDate", notNullValue());
    }
}