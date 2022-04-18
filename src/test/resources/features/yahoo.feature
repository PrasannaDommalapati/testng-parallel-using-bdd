Feature: YahooDemo
  As a Yahoo user
  I want to search by keyword
  So that i can see the results

@Regression @Sanity
  Scenario: Search by text positive in yahoo
    Given I am in "https://www.google.co.uk"
    When I enter a keyword "Selenium"
    Then I should see the page title contains "Selenium"