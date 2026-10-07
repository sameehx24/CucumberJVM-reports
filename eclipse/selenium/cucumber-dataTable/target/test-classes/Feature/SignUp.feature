@wip
Feature: Validating signup feature

  @smoke
  Scenario: Validating using valid email
    Given User has to enter the correct email id
      | sameehx24@gmail.com     |
      | fathimanasika@gmail.com |
      | santra@gmail.com        |
      | poornadeepa@gmai.com    |
    Then it should navigate to main cart
