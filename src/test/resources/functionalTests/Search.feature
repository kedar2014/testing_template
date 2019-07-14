Feature: Provide a Search feature to the web app
Description: To test the scenario for Search feature.


Scenario: As the user of web app, I should be able to search for results
	 Given user is on the search page
	 When user enters "query" in the search box
	 Then user gets the atleast 1 result in the search	
