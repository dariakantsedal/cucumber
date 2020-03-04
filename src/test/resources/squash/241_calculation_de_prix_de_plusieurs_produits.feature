# Automation priority: null
# Automation status: TRANSMITTED
# Test case importance: LOW
# language: en
Feature: calculation de prix de plusieurs produits

  Scenario Outline: calculation of the multiple products price
    Given I add to cart a Large Angelfish
    When I select <quantity>
    Then for each <quantity> its <price> is a proper one

    Examples: 
      | quantity | price |
      |        1 | 16.50 |
      |        2 | 32.00 |
