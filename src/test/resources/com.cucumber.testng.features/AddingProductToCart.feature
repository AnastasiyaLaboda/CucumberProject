@smoke
Feature: As an open-web user
  I want to add a product to my shopping cart
  So that I can purchase it

  Scenario: User can find a product and add it to the cart
    Given the user is navigated to Onliner website
    When the user enters "Наушники" in Search form
    And the user clicks on the 1 product in the search result
    And the user add the 1 seller's offer product to the cart
    And the user goes to the shopping cart
    Then added to the cart product is displayed
    And the product title is the same
    And the product price is the same




