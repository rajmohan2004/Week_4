Feature: Get Operation for Employee Controller in NinzaHRM

  Background:
    Given The get Base URI for Ninza HRM is set "http://49.249.28.218:8091/"

  Scenario Outline: Fetch employee details using empId
    When get user sends GET request to "employees/<empId>"
    Then get response status should be 200
    And get response time should be less than 5000 ms
    
     Examples:
      | empId     | 
      | NH_00754  |
      | NH_00755  | 
      | NH_00756  | 
      | NH_00757  | 
      | NH_00758  | 