Feature: Place a New Rental

Scenario: Place a new rental
Given I set the base URI
When I set the request body for placing a new rental
And I send a POST request to "/rentals"
Then the response status code should be 201
And the response body should contain "Rental placed successfully"