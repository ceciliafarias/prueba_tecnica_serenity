@purchase
Feature: Purchase

  Background:
    Given Alan open the the browser in the shopping page

  Scenario Outline: Purchase product
    Given is in home page
    When select and add to cart "<products>" item
    And go to shopping cart
    And place order
    And fill billing detail form
    Then the purchase must be successful

    Examples:
      | products                                         |
      | Samsung galaxy s6, Nokia lumia 1520, MacBook Pro |
