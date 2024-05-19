Feature: Get all products
  As a admin
  I want to get all products
  So that I can see all products

  #positive
  Scenario: As a admin I can get all products with valid endpoint and method
    Given I set API endpoint and method with correctly
    When I send a request to get all products
    Then I receive the status code 200 OK
    And I get all products with valid

  #negative
  Scenario: As a admin I can't get all products with valid endpoint and wrong method
    Given I set the API endpoint and wrong method
    When I send request to get all products with invalid method
    Then I receive the status code 405 method not allowed