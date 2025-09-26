#Feature: day14
#  @leftNavigationPageFor3Roles
#  Scenario Outline: left navigate items of Docuport for 3 user
#    Given user is on Docuport login page
#    When user insert "<username>" and "<password>" for "<role>"
#    Then user should be able to see the home page for "<role>"
#    And user see left navigate options for "<role>"
#
#      | supervisor | Home | Received docs | My uploads | Clients | Users       | Leads       | Bookkeeping | 1099 Form       | Reconciliations |                 |
#      | advisor    | Home | Received docs | My uploads | Clients | Invitations | Users       | Leads       | Bookkeeping     | 1099 Form       | Reconciliations |
#      | employee   | Home | Received docs | My uploads | Clients | Users       | Bookkeeping | 1099 Form   | Reconciliations |                 |                 |
#
#    Examples:
#
#      | role       | username                  | password      |
#      | supervisor | b1g2_supervisor@gmail.com | Group2        |
#      | advisor    | b1g2_advisor@gmail.com    | Group2        |
#      | employee   | b1g2_employee@gmail.com   | Group2        |


Feature: Validate Left Navigation per role
@leftNavigationPageFor3Roles
Scenario Outline: Login and validate left navigation for <role>
Given user is on Docuport login page
When user insert "<username>" and "<password>" for "<role>"
Then user should be able to see the home page for "<role>"
And the left navigation for "<role>" should be "<expected>"

Examples:
| role       | username                  | password | expected                                                                                 |
| supervisor | b1g2_supervisor@gmail.com | Group2   | Home,Received docs,My uploads,Clients,Users,Leads,Bookkeeping,1099 Form,Reconciliations  |
| advisor    | b1g2_advisor@gmail.com    | Group2   | Home,Received docs,My uploads,Clients,Invitations,Users,Leads,Bookkeeping,1099 Form,Reconciliations|
| employee   | b1g2_employee@gmail.com   | Group2   | Home,Received docs, My uploads, Clients, Users, Bookkeeping, 1099 Form, Reconciliations|

