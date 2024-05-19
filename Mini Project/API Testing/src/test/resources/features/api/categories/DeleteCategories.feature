Feature: Delete a categories
  As a admin
  I want to delete a categories
  So that I can see categories has delete

  #positive
  Scenario: As a admin I can delete a categories with valid endpoint and method
    Given I set valid endpoint and method
    When I send a request to delete a categories
    Then I receive in status code 200 OK
    And I see categories has delete with valid

  #negative
  Scenario: As a admin I can't delete a categories with valid endpoint and wrong method
    Given I set valid endpoint and wrong method
    When I send request to delete a categories with invalid method
    Then I receive in status code 405 method not allowed
