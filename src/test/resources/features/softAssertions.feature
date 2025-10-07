Feature: Practice soft assertions

  @soft
  Scenario: Soft assertions practice
    Given user is on Docuport login page
    Then user validates "Login" text is displayed
    Then user validates "Docuport" text is displayed
    When user insert "b1g1_client@gmail.com" to "username" field on "Login" page
    When user insert "Group1" to "password" field on "Login" page
    And user clicks "Login" button on "Login" page
    And user validates "Choose account" text is displayed
    And user clicks "continue" button on "Choose account" page
    And user clicks "home" button on "Left navigate" page
    And user clicks "invitation" button on "Left navigate" page
    And user validates all assertions



