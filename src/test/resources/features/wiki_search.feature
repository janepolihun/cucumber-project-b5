Feature: Wikipedia Search Functionality Title Verification

  @wikiSearch
  Scenario Outline: Search functionality result title validation
    Given user is on Wikipedia home page
    When user types "<full_name>" in the google search box and clicks wiki search button
    Then user should be able to see "<full_name>" in the "<variation>"
    Examples:
      | full_name  | variation    |
      | Steve Jobs | wiki title   |
      | Steve Jobs | main header  |
      | Steve Jobs | image header |


