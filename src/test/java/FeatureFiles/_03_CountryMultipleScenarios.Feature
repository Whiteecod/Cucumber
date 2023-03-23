Feature: Country Multi Scenario

  Background:  # Before Scenario
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login succesfully
    And Navigate to country page

  Scenario: Create country
    When create a country
    Then Success message should be displayed

    Scenario: Create a country 2
      When Create a country name as "ismUlk113456" code as "is13312"
      Then Success message should be displayed