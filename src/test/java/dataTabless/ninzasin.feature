#Author:Rajmohan T
Feature: NinjaHRM CRUD operations with new data

Scenario: Full CRUD flow with new project
  Given NinjaHRM base URL
  When I create a project
    | createdBy | projectName       | status     | teamSize |
    | Raj       | New01ProjectV1    | Created    | 0        |
  Then the response code should be 201
  And the response time should be less than 2500 ms

  When I retrieve the project
  Then the response code should be 200
  And the response time should be less than 2500 ms

  When I update the project
    | createdBy | projectName         | status      | teamSize |
    | Raj       | New02ProjectV2      | Completed   | 0        |
  Then the response code should be 200
  And the response time should be less than 2500 ms

  When I delete the project
  Then the response code should be 204
  And the response time should be less than 2500 ms