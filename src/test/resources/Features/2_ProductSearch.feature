@tag
Feature: search product

  @search_product
  Scenario: checks search product is successful
    When user enters the product name in the search bar
    And clicks on the search button
    Then the product results are displayed on the results page
    And user click on details link
