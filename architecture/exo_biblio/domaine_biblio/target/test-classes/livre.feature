Feature: Find All Books
  Scenario: get All Books
    Given there are some books in the library
    When I ask for all books
    Then all books should be returned


Feature: Delete One Book
  Scenario: delete one selected book
    Given there are three books with id 1 2 3
    When I want to remove book with ID 2
    Then the book list size should be 2