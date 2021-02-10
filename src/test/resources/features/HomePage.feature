@home
Feature: to verify the home page

  Scenario: To verify the home page and breadcrums title at the top of the page
    Given I load the policy expert website
    And I am on the home page
    Then I should be able to see the breadcrum at the top of the page
