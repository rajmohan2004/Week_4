Feature: CRUD Operations on Authors API

Background:
   Given API Base URL is set "https://fakerestapi.azurewebsites.net"
   
Scenario: CRUD on Authors

When send POST request to create author at "/api/v1/Authors"
Then response status should be 200

When send GET request to get the author at "/api/v1/Authors/{id}"
Then response status should be 200

When send PUT request to update author at "/api/v1/Authors/{id}"
Then response status should be 200

When send DELETE request to delete the author at "/api/v1/Authors/{id}"
Then response status should be 200