Feature: passing multiple parameters to the same step

  @google_search_data_table
  Scenario: Searching multiple items
    Given user is on Google search page
    Then user search for following items

      | loop academy |
      | java         |
      | selenium     |
      | sql          |
      | Taras        |
      | Suidum       |
      | Halina       |
      | Polina       |
      | Alex         |
    And we love Loop Academy