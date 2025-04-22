Feature:  Inloggning

  Scenario: Lyckad inloggning
    Given I am on the login page
    When I enter test@example.com
    And I enter "password123"
    And I click on login
    Then I should see the message "Welcome"