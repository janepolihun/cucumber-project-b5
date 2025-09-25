Feature: SmartBearsSoftware page  Functionality Title Validation
  User Story: As a user, when I am on the SmartBearsSoftware page
  I should be able to search whatever I want and see the relevant result

  Background: user is on SmartBearsSoftware page
    Given user is on SmartBearsSoftware page
    When user enter username and user enter password and click login button


  @smart_bear_software @smoke
  Scenario: Search functionality result title validation

    Then user should be able to see Web Orders in the google title
    And user should print out count of all the links on landing page


  @smart_bear_software_order

  Scenario Outline: user should be able to place order and see it in the table
    When user selects product type "<productType>"
    And user enters quantity "<quantity>"
    And user enters customer name "<name>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zip "<zip>"
    And user selects credit card type "<cardType>"
    And user enters credit card number "<cardNumber>"
    And user enters expiration date "<expiration>"
    And user clicks process order button
    Then user should see "<name>" in the first row of the table

    Examples:
      | productType | quantity | name         | street           | city      | state    | zip   | cardType         | cardNumber       | expiration |
      | FamilyAlbum | 2        | Chuck Norris | 1100 Long way dr | Chantilly | Virginia | 22011 | American Express | 1111222233334444 | 12/25      |