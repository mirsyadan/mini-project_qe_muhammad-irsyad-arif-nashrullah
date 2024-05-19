Feature: Get product comments
  As a admin
  I want to get product comments
  So that I can see product comments

  #positive
  Scenario: As a admin I can get product comments with valid endpoint and method
    Given I set API endpoint and method
    When I send a request to get product comments
    Then I receive on status code 200 OK
    And I get product comments with valid

  #negative
  Scenario: As a admin I can't get product comments with valid endpoint and wrong method
    Given I set a API endpoint and wrong method
    When I send request to get product comments with invalid method
    Then I receive on status code 405 method not allowed
