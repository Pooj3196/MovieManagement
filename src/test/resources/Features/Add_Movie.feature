Feature: Add a New Movie

Scenario: Add a new movie
Given I set the base URI
When I set the request body for adding a new movie
And I send a POST request to "/movies"
Then the response status code should be 201
And the response body should contain "Movie added successfully"
