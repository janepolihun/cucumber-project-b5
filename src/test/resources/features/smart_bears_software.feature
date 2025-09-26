Feature: SmartBearsSoftware page  Functionality Title Validation
  User Story: As a user, when I am on the SmartBearsSoftware page
  I should be able to search whatever I want and see the relevant result


@smart_bear_software
Scenario: Search functionality result title validation
Given user is on SmartBearsSoftware page
When user enter username and user enter password and click login button
Then user should be able to see Web Orders in the google title
  And user should print out count of all the links on landing page
