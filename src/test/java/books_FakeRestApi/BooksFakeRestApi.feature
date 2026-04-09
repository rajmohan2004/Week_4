Feature: CRUD Operations on Books API

Background:
   Given The book Base API Base URI is set "https://fakerestapi.azurewebsites.net"

Scenario: CRUD on Books

When book sends POST request to create book record at "/api/v1/Books"
Then book the response status should be 200

When book sends GET request to fetch the book record at "/api/v1/Books/{id}"
Then book the response status should be 200

When book sends PUT request to modify the book record at "/api/v1/Books/{id}"
Then book the response status should be 200

When book sends DELETE request to remove the book record at "/api/v1/Books/{id}"
Then book the response status should be 200