# Automation priority: null
# Automation status: TRANSMITTED
# Test case importance: LOW
# language: en
Feature: Gestion d'un profil Gherkin
In order to adjust an account to my needs
As a registered user
I need to edit some settings

Scenario: changing favourite category
Given that I go to the page and log in
When I go to the page MyAccount
And I change Favourite Category to FISH
And I save account information
Then category is changed to FISH

Scenario: changing banner
Given that I go to the page and log in
When I go to the page MyAccount
And I uncheck checkbox Enable MyBanner
And I save account information
Then checkbox is unchecked