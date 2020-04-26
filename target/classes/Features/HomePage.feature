Feature: ActiTIME homePage feature

Scenario Outline: ActiTIME homePage Test 

Given user enters the login page
When user enters the "<username>" and "<password>"
Then homepage is displayed
Then user clicks on tasks page
Then user clicks on add customer
Then user clicks on new customer
Then user creates new "<customerName>"
Then user closes the browser

Examples: 
	|username|password|customerName|
	|admin|manager|abc|
	|admin|manager|fgh|