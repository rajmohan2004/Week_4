#Author :Rajmohan T
Feature: NinjaHRM CRUD operations with multiple data

Scenario: Full CRUD flow for multiple projects

  Given NinjaHRM base URL for multiple projects

  When I create multiple project records
    | createdBy     | projectName   | status    | teamSize |
    | Rajmohan      | AProjectNew   | Created   | 0        |
    | Rajmohan      | BProjectNew   | Ongoing   | 0        |

  Then I should get response code 201

  When I fetch all created projects
  Then I should get response code 200

  When I modify all created projects
    | createdBy | projectName         | status    | teamSize |
    | Rajmohan  | AProjectUpdated     | Completed | 0        |
    | Rajmohan  | BProjectUpdated     | Completed | 0        |

  Then I should get response code 200

  When I remove all created projects
  Then I should get response code 204

  And I verify response time is below 2500 ms