Feature: PGE Home Page Features

Scenario: Home page options validation
	Given validate home page
	And page has sign in text
	When home page title
	Then user closed pop message
	Then user click on sign in link
	Then user clicks Residential option
#But user not able to click menu options
	Then validate menu options
	Then clicked emergencies


#Scenario: Existing user validation 
#	#Given user is on login page
#	Then user enters username testuer@gmail.com and password test@123
#	Then click sign in button 
#	Then check account user name
#	Then user clicks on account dropdown 
#	Then finally user clicks on signout
#	Then close browser
