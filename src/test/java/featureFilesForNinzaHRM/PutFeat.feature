Feature: Update Operation for Employee Controller in NinzaHRM

  Background:
    Given The put Base URI for Ninza HRM is set "http://49.249.28.218:8091/"

  Scenario Outline: Update employee details using employeeId
    When put user sends PUT request to "employees/<employeeId>" with "<designation>", "<dob>", "<email>", "<empName>", <experience>, "<mobileNo>", "<project>", "<role>", "<username>"
    Then put response status should be 200
    And put response time should be less than 5000 ms

    Examples:
      | employeeId | designation       | dob        | email                  | empName        | experience | mobileNo   | project              | role            | username        | 
      | NH_00754   | Software Engineer | 12/05/1995 | update1@test.com       | Arjun Kumar    | 5          | 9123456789 | Web Development      | Developer       | arjun_update    | 
      | NH_00755   | QA Lead           | 22/08/1993 | update2@test.com       | Meena Sharma   | 7          | 9234567890 | Test Automation      | QA              | meena_update    | 
      | NH_00756   | Analyst           | 10/10/1998 | update3@test.com       | Rahul Das      | 3          | 9345678901 | Data Analysis        | Analyst         | rahul_update    |
      | NH_00757   | Manager           | 01/01/1990 | update4@test.com       | Kavita Singh   | 10         | 9456789012 | Operations           | Manager         | kavita_update   | 
      | NH_00758   | HR                | 15/03/1996 | update5@test.com       | Nisha Reddy    | 4          | 9567890123 | Recruitment          | HR              | nisha_update    | 