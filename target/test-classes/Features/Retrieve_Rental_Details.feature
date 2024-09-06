Feature: Retrieve Rental Details

Scenario: Retrieve rental details
Given I set the base URI
When I send a GET request to "/rentals/{rentalId}"
Then the response status code should be 200
And the response body should contain the rental details