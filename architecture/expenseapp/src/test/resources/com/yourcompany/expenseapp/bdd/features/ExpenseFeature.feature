Feature: list all expenses
  Scenario: get all expenses
    Given there are three expenses in the database
    When I want to consult all the expenses
    Then list with 3 expenses should be returned



Feature: Add a Expense
  Scenario: There is new expense to save in database
    Given there are three expenses in the database
    When I create a new expense with title "test" and amount -15
    Then list with 4 expenses should be returned

