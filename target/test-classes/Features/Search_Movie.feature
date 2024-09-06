Feature: Search Movies by Title

Scenario: Search movies by title
Given I set the base URI
When I send a GET request to "/movies/search?title={movieTitle}"
Then the response status code should be 200
And the response body should contain the movie details