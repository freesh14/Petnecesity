Feature: Register user

  Background: Happens before each test
    Given the test starts with this

  Scenario: Create user-everything goes as expected
    Given I am on the registration page
    When I fill in the correct user data
    Then the user should be created and I get a confirmation message

  Scenario: Create user with missing last name
    Given I am on the registration page
    When I fill in the correct user data without a last name
    Then I should see an error message about the missing last name

  Scenario: Create user – passwords do not match
    Given I am on the registration page
    When I fill in invalid passwords (the two passwords do not match)
    And I accept the terms and conditions
    And I click on "Confirm and join"
    Then I should see an error message stating that the passwords do not match

  Scenario: Create user – terms and conditions are not accepted
    Given I am on the registration page
    When  I fill in the correct user data again
    And  I do not accept the terms and conditions
    Then I should see an error message stating that the terms and conditions must be accepted