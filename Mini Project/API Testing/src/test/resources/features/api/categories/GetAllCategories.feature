Feature: Get all categories
  As a admin
  I want to get all categories
  So that I can see all categories

  #positive
  Scenario: As a admin I can get all categories with valid endpoint and method
    Given I set with valid API endpoint and method
    When I send a request to get all categories
    Then I receive a status code 200 OK
    And I get all categories with valid

  #negative
  Scenario: As a admin I can't get all categories with valid endpoint and wrong method
    Given I set with API endpoint and wrong method
    When I send request to get all categories with invalid method
    Then I receive a status code 405 method not allowed
