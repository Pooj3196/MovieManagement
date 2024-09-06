Feature: User Login

Scenario: Login a user
Given I set the base URI
When I set the request body for user login
And I send a POST request to "/users/login"
Then the response status code should be 200
And the response body should contain "Login succes