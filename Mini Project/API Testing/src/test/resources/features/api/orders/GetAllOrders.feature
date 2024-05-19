Feature: Get all orders
  As a admin
  I want to get all orders
  So that I can see all orders

  #positive
  Scenario: As a admin I can get all orders with valid endpoint and method
    Given I set API endpoint and method with valid
    When I send a request to get all orders
    Then I get status code 200 OK
    And I get all orders with valid

  #negative
  Scenario: As a admin I can't get all orders with valid endpoint and wrong method
    Given I set with valid API endpoint and wrong method
    When I send request to get all orders with invalid method
    Then I get status code 405 method not allowed