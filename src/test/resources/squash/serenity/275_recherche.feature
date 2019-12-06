# Automation priority: null
# Automation status: TRANSMITTED
# Test case importance: LOW
@driver:chrome
Feature: Search by keyword
  Scenario: Searching for a term
    Given Not logged in user is on the home page
    When he searches for "bulldog"
    Then result page contains the word "bulldog"