Feature: Take USC activity as a Student

As a Student,
When I login into Mindtap course
I can Take - Launch and submit USC activity

@StuTakesUSC 
Scenario: Student Launches USC activity
	Given I should be on chapter LPN
	When I click on USC link
	Then I am on Unit Study Center page

  



 	 