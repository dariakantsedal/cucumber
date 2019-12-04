# Automation priority: null
# Automation status: TRANSMITTED
# Test case importance: LOW
Feature: Entrepot de données Personne
 
 
  Scenario: Creation
    Given Lentrepot contient N Personnes
    When Je cree une Personne
    Then Jobtiens lID de la Personne creee et lentrepot contient plus de N Personnes
 

  Scenario: Suppression
    Given Lentrepot contient la Personnes Anakin Skywalker
    When Je supprime la Personne 1
    Then Lentrepôt contient moins de N Personnes
 

  Scenario Outline: Lecture
    Given Lentrepot contient N Personnes
    When Je recupere la Personne <id>
    Then Jobtiens la Personne didentifiant <id> contenant les donnees <name>, <surname>, <age>
 
    Examples:
      | id | name | surname         | age |
      | 1  | Anakin | Skywalker   | 41.9BBY  |
      | 2  | Luke   | Skywalker   | 19BBY    |
      | 3  | Leia   | Organa Solo | 19BBY    |
 

  Scenario Outline: Modification
    Given Lentrepot contient les Personnes suivantes
      | id | name | surname         | age |
      | 3  | Leia   | Organa Solo | 19BBY    |
   When Je modifie la Personne <id> avec <name>
    Then Jobtiens la Personne didentifiant <id> contenant les donnees <name>, <surname>, <age>
 
    Examples:
     | id | name | surname                   | age |
     | 3  | Leia   | Organa Solo Skywalker | 19BBY    |