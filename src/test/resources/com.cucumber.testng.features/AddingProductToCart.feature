@smoke
Feature: As an open-web user
  I want to add a product to my shopping cart
  So that I can purchase it

  Scenario: User can find a product and add it to the cart
    Given the user is navigated to Onliner website
    When the user enters "Телевизор" in Search form
    And the user clicks on the 1 product in the search result
    And the user clicks on the first seller's offer to_cart_button
    And the user clicks on go_to_cart_button
    Then the user can see the product's title
    And the user can see the product's count
    And the user can see the product's price
    And the user can see the product's description





