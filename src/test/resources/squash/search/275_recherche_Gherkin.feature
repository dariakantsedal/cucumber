# Automation priority: null
# Automation status: TRANSMITTED
# Test case importance: LOW
Feature: Search by keyword
  
  Scenario Outline: Searching for an existing product
    Given Not logged in user is on the home page.
    When he searches for <item>
    Then result page contains the word <item>
    Examples:
      | item |
      | bulldog |

 
 Scenario Outline: Searching for an existing product
    Given Not logged in user is on the home page
    When he searches for <item>
    Then there is an empty table
     Examples:
      | item |
      | apple |