Feature: Search Employee in PIM Module
    Background:
    Given User is logged into OrangeHRM

  Scenario: Search for an employee by name in PIM Module
    When User navigates to the PIM module
    And User enters employee ID "0007" in the search field
    Then Employee details related to "0007" should be displayed
