Feature: Login as Affiliate

#simple data driven testing
Scenario: Positive Login

Given User login page
When title is "login – Jump Spark"
Then user enters "ruchita.das@omnireach.app" and "Tmv@abcdefghi!123"
Then user click on login button
Then login as affiliate "dashboard – Jump Spark"

#scenario outline testing
Scenario Outline: Empty Scenario

Given User login page
When title is "login – Jump Spark"
Then user enters "<username>" and "<password>"
Then user click on login button
Then login as affiliate "dashboard – Jump Spark"
 
#keyword to give all the values in form of table
#example keyword is help to use the same data everypossible 
Examples: 
		| username | password|
		|          | JumpSpark#24|
		|ruchita.das@omnireach.app|        |
		|ruchita.das@omnireach.app | Tmv@abcdefghi!123|		
		

