Feature: Delete Operation for Employee Controller in NinzaHRM

  Background:
    Given The delete Base URI for Ninza HRM is set "http://49.249.28.218:8091/"

  Scenario Outline: Delete employee using empId
    When delete user sends DELETE request to "employees/<empId>"
    Then delete response status should be 204
    And delete response time should be less than 5000 ms

    Examples:
      | empId     | 
      | NH_00754  |
      | NH_00755  | 
      | NH_00756  | 
      | NH_00757  | 
      | NH_00758  | 
      