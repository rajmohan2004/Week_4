Feature: CRUD Operations on GitHub Repository API

  Background:
    Given The delete base URL for The GitHub is set "https://api.github.com/"
    And the delete user sets authorization token "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"

  Scenario Outline: DELETE operation on GitHub
    When the delete user sends DELETE request to "users/{owner}/{repo}" with "<owner>","<repo>"
    Then the delete response statuscode is 204
    And the delete response time is less than 5000 ms
    
  Example:
|owner       |repo   |
|rajmohan2004|project-alpha|
|rajmohan2004|smart-inventory|
|rajmohan2004|ai-traffic-monitor|
|rajmohan2004|weather-insights|
|rajmohan2004|task-manager-pro|