Feature:Post Operation for Employee Controller in NinzaHRM

Background:
 Given The Base URI for Ninza HRM is set "http://49.249.28.218:8091/"

  Scenario Outline: Create employee with different data
    Given request body is prepared with "<designation>", "<dob>", "<email>", "<empName>", <experience>, "<mobileNo>", "<project>", "<role>", "<username>"
    When user sends POST request to "employees"
    Then response status should be 201
    And response time should be less than 5000 ms

Examples:
| designation           | dob        | email                          | empName           | experience | mobileNo   | project                      | role            | username            |
| Backend Engineer      | 13/02/1995 | backend.eng@techmail.com       | Suresh Kumar      | 5          | 9876543210 | Microservices Development    | Engineer        | suresh_backend      |
| UI/UX Developer       | 25/10/1997 | uiux.dev@techmail.com          | Divya Narayanan   | 3          | 9765432109 | Mobile App Redesign          | Developer       | divya_uiux          |
| System Administrator  | 08/06/1991 | sys.admin@techmail.com         | Manish Yadav      | 8          | 9654321098 | Server Maintenance           | Administrator   | manish_sys          |
| Data Engineer         | 19/01/1993 | data.eng@techmail.com          | Pooja Chatterjee  | 6          | 9543210987 | Data Pipeline Optimization   | Engineer        | pooja_data          |
| Technical Writer      | 30/09/1996 | tech.writer@techmail.com       | Aakash Jain       | 4          | 9432109876 | Documentation Management     | Writer          | aakash_writer       | 