Scenario: Register a new user

Given I set the base URI
When I set the request body for user registration
And I send a POST request to "/users/register"
Then the response status code should be 201
And the response body should contain "User registered successfully"