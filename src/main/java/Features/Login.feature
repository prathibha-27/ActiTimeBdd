Feature: ActiTIME login feature

#Scenario: ActiTIME login test scenario

#Given user is on login page
#When title of login page is actitime
#Then user enters "admin" and "manager"
#Then user clicks on login 


#with Example keyword
Scenario Outline: ActiTIME login test scenario

Given user is on login page
When title of login page is actitime
Then user enters "<username>" and "<password>"
Then user clicks on login 

Examples:
	| username | password|
	| admin | manager |
	| trainee | trainee |