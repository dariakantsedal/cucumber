# Automation priority: null
# Automation status: TRANSMITTED
# Test case importance: LOW
Feature: Gestion d'un panier
Background:
Given that I go to the page and log in

Scenario: adding a product to cart
When I choose produit Angelfish dans category FISH
Then produit is in the cart

Scenario: changing quantity
Given I choose produit Angelfish dans category FISH
When I change quantity for 2
Then price is changed accordingly

Scenario: proceed to checkout
Given I choose produit Angelfish dans category FISH
When I checkout
Then page of the order is on the screen