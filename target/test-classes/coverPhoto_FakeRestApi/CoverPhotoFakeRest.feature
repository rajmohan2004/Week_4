Feature: CRUD Operations on Cover Photos API

Background:
   Given The Cover Photos Base API Base URI is set "https://fakerestapi.azurewebsites.net"

Scenario: CRUD on Users

When Cover Photos sends POST request to create user record at "/api/v1/CoverPhotos"
Then Cover Photos the response status should be 200

When Cover Photos sends GET request to fetch the user record at "/api/v1/CoverPhotos/{id}"
Then Cover Photos the response status should be 200

When Cover Photos sends PUT request to modify the user record at "/api/v1/CoverPhotos/{id}"
Then Cover Photos the response status should be 200

When Cover Photos sends DELETE request to remove the user record at "/api/v1/CoverPhotos/{id}"
Then Cover Photos the response status should be 200