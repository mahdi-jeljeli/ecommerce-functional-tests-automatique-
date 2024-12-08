@tag
Feature: login

  @login
  Scenario: checks login is succceful
    Given user on login page
    When user enters username and password
    And Clicks on login Button
    Then user is navigated to home page
