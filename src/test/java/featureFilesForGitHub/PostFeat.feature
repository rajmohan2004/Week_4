Feature: CRUD Operations on GitHub Repository API

  Background:
    Given The post base URL for The GitHub is set "https://api.github.com/"
    And the post user sets authorization token "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"

  Scenario Outline: POST operation on GitHub
    When the post user sends POST request to "user/repos" with "<name>","<description>"
    Then the post response statuscode is 201
    And the post response time is less than 5000 ms


Examples:
  | name               | description                          |
  | project-alpha      | Repository for alpha testing         |
  | smart-inventory    | Inventory management system project  |
  | ai-traffic-monitor | AI-based traffic monitoring system   |
  | weather-insights   | Weather prediction analytics tool    |
  | task-manager-pro   | Advanced task management application |
 


