Feature: Delete a product
  As a admin
  I want to delete a product
  So that I can see product has delete

  #positive
  Scenario: As a admin I can delete a product with valid endpoint and method
    Given I set endpoint and method with valid
    When I send a request to delete a product
    Then I get a status code 200 OK
    And I see product has delete with valid

  #negative
  Scenario: As a admin I can't delete a products with valid endpoint and wrong method
    Given I set with valid endpoint and wrong method
    When I send request to delete a product with invalid method
    Then I get a status code 405 method not allowed