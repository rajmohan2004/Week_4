Feature: Update Repository on GitHub API

  Background:
    Given The patch base URL for The GitHub is set "https://api.github.com/"
    And the patch user sets authorization token "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"

  Scenario Outline: PATCH operation on GitHub
    When the patch user sends PATCH request to "repos/<username>/<repo>" with "<description>"
    Then the patch response statuscode is 200
    And the patch response time is less than 5000 ms

  Examples:
    | username        | repo               | description                              |
    | rajmohan2004   | project-alpha      | Updated alpha testing repository         |
    | rajmohan2004  | smart-inventory    | Updated inventory management system      |
    | rajmohan2004    | ai-traffic-monitor | Improved AI traffic monitoring system    |
    | rajmohan2004    | weather-insights   | Enhanced weather analytics tool          |
    | rajmohan2004    | task-manager-pro   | Advanced task manager with new features  |