Feature: Filter Movies by Genre

Scenario: Filter movies by genre
Given I set the base URI
When I send a GET request to "/movies/filter?genre={genreName}"
Then the response status code should be 200
And the response body should contain the filtered movies
