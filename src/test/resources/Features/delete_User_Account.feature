Feature: Delete User Account

Scenario: Delete user account
Given I set the base URI
When I send a DELETE request to "/users/{userId}"
Then the response status code should be 204