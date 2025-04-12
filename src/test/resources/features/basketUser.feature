Feature: Register user

  Background:
    Given the test starts with this

  Scenario Outline: User registration tests
    Given I am on the registration page using "<browser>"
    When I register with name "<firstname>" "<lastname>", email "<email>", and passwords "<password>" "<confirmpassword>"
    And I <acceptTerms>
    Then <expectedResult>

    Examples:
      | browser | firstname | lastname | email               | password    | confirmpassword | acceptTerms | expectedResult                                                                 |
      | chrome  | Joe       | Fox      | test1@mailnesia.com | password123 | password123      | accept      | THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND                     |
      | chrome  | Joe       |          | test2@mailnesia.com | password123 | password123      | accept      | The "Last Name is required" is displayed                                      |
      | chrome  | Joe       | Fox      | test3@mailnesia.com | password123 | password1223     | accept      | The "Password did not match" is displayed                                     |
      | chrome  | Joe       | Fox      | test4@mailnesia.com | password123 | password123      | not_accept  | The "You must confirm that you have read and accepted our Terms" is displayed |