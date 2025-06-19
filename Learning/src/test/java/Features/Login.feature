Feature: Login as Affiliate

#simple data driven testing
Scenario: Positive Login

Given User login page
When title is JumpSpark
Then user enters "ruchita.das@omnireach.app" and "JumpSpark#24"
Then user click on login button
Then login as affiliate
Then close the browser

#scenario outline testing
Scenario Outline: Empty Scenario

Given User login page
When title is JumpSpark
Then user enters "<username>" and "<password>"
Then user click on login button
Then login as affiliate
Then close the browser
 
#keyword to give all the values in form of table
#example keyword is help to use the same data everypossible 
Examples: 
		| username | password|
		|          | JumpSpark#24|
		|ruchita.das@omnireach.app|        |
		|ruchita.das@omnireach.app | JumpSpark#24|		
		
#using test data
Scenario: Negative Login

#Given User login page
#When title is JumpSpark
#Then user enters username and password
#|ruchitadas1223| rbeigeruernk|
#|ewrrrrefretgtgthtyhyjfujysrfgefre@gmail.com| fdkrgtuitrgn|
#Then user click on login button
#Then login as affiliate
#Then close the browser
