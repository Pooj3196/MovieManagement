Feature: Update User Profile

Scenario: Update user profile
Given I set the base URI
When I set the request body for updating user profile
And I send a PUT request to "/users/{userId}"
Then the response status code should be 200
And the response body should contain "User updated successfully"
