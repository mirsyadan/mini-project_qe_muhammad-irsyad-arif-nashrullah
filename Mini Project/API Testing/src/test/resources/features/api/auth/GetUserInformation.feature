Feature: Get user information
  As a admin
  I want to get user information
  So that I can see user information

  #positive
  Scenario: As a admin I can get user information with valid endpoint and method
    Given I set valid API endpoint and method
    When I send a request to get user information
    Then I receive status code 200 OK
    And I get user information with valid

  #negative
  Scenario: As a admin I can't get user information with valid endpoint and wrong method
    Given I set valid API endpoint and wrong method
    When I send request to get user information with invalid method
    Then I receive status code 405 method not allowed