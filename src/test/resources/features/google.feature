Feature: Google Search

  Scenario: User search after sameting on Google

    Given The user is on the Google homepage
    When The user searches for "OpenAI"
    Then The search results should be displayed