#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
Feature: Login as a Lead
Scenario Outline: Login page data  
Given User want started the lead process
When title is JumpSpark FleetManagement
Then user click on started
Then user enters details in the file
|FirstName |LastName|email|Number|city|CompanyName|BusinessYear|numberFleet|
|ruchita|das|tani123@gmail.com|7777777777|Bhopal|WeeTech|24|5|
Then user select the options "<value1>" and "<value2>"
Then user can click submit
#Then message prompted
Then close the fleet browser

Examples:
      | value1                     | value2            |
      | New to leasing             | Immediate Need    |
      | Very familiar with leasing | 4-6 Months        |

