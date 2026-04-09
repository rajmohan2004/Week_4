Feature: CRUD Operations on Users API

Background:
   Given The user Base API Base URI is set "https://fakerestapi.azurewebsites.net"

Scenario: CRUD on Users

When user sends POST request to create user record at "/api/v1/Users"
Then user the response status should be 200

When user sends GET request to fetch the user record at "/api/v1/Users/{id}"
Then user the response status should be 200

When user sends PUT request to modify the user record at "/api/v1/Users/{id}"
Then user the response status should be 200

When user sends DELETE request to remove the user record at "/api/v1/Users/{id}"
Then user the response status should be 200