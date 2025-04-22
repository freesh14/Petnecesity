Feature: Register user

  Background:
    Given the test starts with this

  Scenario Outline: User registration tests
    Given I am on the registration page using "<browser>"
    When I register with name "<firstname>" "<lastname>", email "<email>" "<confirmemail>", and passwords "<password>" "<confirmpassword>"
    And I "<acceptTerms>"
    Then "<expectedResult>"

    Examples:
      | browser | firstname | lastname | email               | confirmemail        | password        |  confirmpassword       | acceptTerms | expectedResult                                             |
      | chrome | Joe       | Fox      | test1@mailkeesia.com | test1@mailkeesia.com | password123     | password123            | accept      | THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND  |
      | chrome | Joe        |          | test2@mailnesia.com | test2@mailnesia.com |  password123    | password123            | accept      | Last Name is require                                       |
      | firefox  | Joe       | Fox      | test3@mailnesia.com | test3@mailnesia.com | password123     | password1223           | accept      | Password did not match                                     |
      | firefox | Joe       | Fox      | test4@mailnesia.com | test4@mailnesia.com | password123     | password123            | not_accept  | You must confirm that you have read and accepted our Terms |