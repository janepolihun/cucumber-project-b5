Feature: product data table practice

  @ListOfMap
  Scenario: varify each product price
  # practice List<Map<String, String>>
    Given User is on the HomePage
    Then User should be able to see expected prices in the following products
      | Category | Product           | expectedPrice |
      | Phones   | Samsung galaxy s6 | 360           |
      | Phones   | Nokia lumia 1520  | 820           |
      | Phones   | Nexus 6           | 650           |
      | Laptops  | Sony vaio i5      | 790           |
      | Laptops  | Sony vaio i7      | 790           |
      | Laptops  | MacBook air       | 700           |
      | Monitors | Apple monitor 24  | 400           |
      | Monitors | ASUS Full HD      | 230           |


  @ListOfLists
  # practice List<List<String>>
  Scenario: varify each product price ListOfLists
    Given User is on the HomePage
    Then User should be able to see expected prices in the following products with listOfLists
      | Phones   | Samsung galaxy s6 | 360 |
      | Phones   | Nokia lumia 1520  | 820 |
      | Phones   | Nexus 6           | 650 |
      | Laptops  | Sony vaio i5      | 790 |
      | Laptops  | Sony vaio i7      | 790 |
      | Laptops  | MacBook air       | 700 |
      | Monitors | Apple monitor 24  | 400 |
      | Monitors | ASUS Full HD      | 230 |


  @mapList
  # Map<String, List<String>>
  Scenario: verify student names
    Then user should be able to see the names
      | Group 2 | nadir | feyruz | Jane   |
      | Group 3 | vika  | suidum | savlat |

  @mapListProduct
  Scenario: varify each product price map
    Given User is on the HomePage
    Then User should be able to see expected prices in the following product whith map
      | Phones   | Samsung galaxy s6 - 360  | Nokia lumia 1520 - 820 | Nexus 6 - 650     |
      | Laptops  | Sony vaio i5 - 790       | Sony vaio i7 - 790   | MacBook air - 700 |
      | Monitors | Apple monitor 24 - 400 | ASUS Full HD -230      |                   |