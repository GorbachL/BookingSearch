Feature: Booking Search

  Scenario: Validation of Hotel rating
    Given Keyword for search is "Hotel Da Vinci"
    When User performs search
    Then Hotel "Hotel Da Vinci" appears in the search page
    And Hotel "Hotel Da Vinci" has rating "8.0"
