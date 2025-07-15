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
#Sample Feature Definition Template
Feature: Invite a user via email

@LoginInfo
Scenario: Invite a single user via email

Given user is logged in as affiliate "dashboard – Jump Spark"
When title is changed to Dashboard
And user enters an email
And clicks on send email
Then email sent pop-up appears

@LoginInfo
Scenario: Add and invite multiple users via email

Given user is logged in as affiliate "dashboard – Jump Spark"
When title is changed to Dashboard
And user enters an email
And clicks on Add Another
And user enters another email
And clicks on send email
Then email sent pop-up appears

@LoginInfo
Scenario: Attempt to send invitation with empty email field

Given user is logged in as affiliate "dashboard – Jump Spark"
When title is changed to Dashboard
And user leaves the email field empty
And clicks on send email
Then error message appears

@LoginInfo
Scenario: Attempt to send invitation with invalid email format

Given user is logged in as affiliate "dashboard – Jump Spark"
When title is changed to Dashboard
And user enters an invalid email
And clicks on send email
Then error message appears

@LoginInfo
Scenario: Remove a user from the invite list before sending

Given user is logged in as affiliate "dashboard – Jump Spark"
When title is changed to Dashboard
And user enters multiple valid emails
And clicks on remove next to one email
And clicks on send email
Then email sent pop-up appears for the remaining email

@LoginInfo
Scenario: Check invitation confirmation message contains the email(s)**

Given user is logged in as affiliate "dashboard – Jump Spark"
When title is changed to Dashboard
And user enters multiple valid emails
And clicks on send email
Then confirmation pop-up displays the list of emails invited

@LoginInfo
Scenario: Try sending more than the allowed number of invites

Given user is logged in as affiliate "dashboard – Jump Spark"
When title is changed to Dashboard
And user enters multiple valid emails
And clicks on send email
Then error message appears
 
