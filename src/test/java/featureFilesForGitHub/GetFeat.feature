Feature: CRUD Operations on GitHub Repository API

  Background:
    Given The get base URL for The GitHub is set "https://api.github.com/"
    And the get user sets authorization token "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"

  Scenario Outline: GET operation on GitHub
    When the get user sends GET request to "users/{username}/repos" with "<username>"
    Then the get response statuscode is 200
    And the get response time is less than 5000 ms

  Examples:
    | username       |
    | rajmohan2004   |
    
