Feature: Get product ratings
  As a admin
  I want to get product ratings
  So that I can see product ratings

  #positive
  Scenario: As a admin I can get product ratings with valid endpoint and method
    Given I set with API endpoint and method
    When I send a request to get product ratings
    Then I receive is status code 200 OK
    And I get product ratings with valid

  #negative
  Scenario: As a admin I can't get product ratings with valid endpoint and wrong method
    Given I set API endpoint and wrong method
    When I send request to get product ratings with invalid method
    Then I receive is status code 405 method not allowed