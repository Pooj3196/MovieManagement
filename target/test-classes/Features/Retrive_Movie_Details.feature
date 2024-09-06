Feature: Retrieve Movie Details

Scenario: Retrieve movie details
Given I set the base URI
When I send a GET request to "/movies/{movieId}"
Then the response status code should be 200
And the response body should contain the movie details