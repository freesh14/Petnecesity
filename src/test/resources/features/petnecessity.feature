Feature: tRST OF PETNECCITY

  Scenario: Create on account

    Given I am at petnecessity page <"browser">
    When I create an account "<email>"
    Then The account is successfully created

    Scenario Outline: Login thru different Browsers
      Given
      When
      Then

      Examples:
      |  browser | email   |
      |  chrome| @mailnesia.com  |
      |  browser | @mailnesia.com  |