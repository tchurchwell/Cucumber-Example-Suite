Feature: Student takes Assessments - SAA

As a Student
When I Login as Student
I should be able to launch and Submit SAA Assessment from LPN

@StudLaunchSAA @SmokeGulati
Scenario: Launch SAA distinct activity as Student
	Given I should be on Student's LPN page
	When I click the already linked SAA activity
	Then I am on SAA distinct activity page

@StudSubmitSAA @SmokeGulati
Scenario: Submit Simple Assessment distinct activity as Student
 	Given I should be on SAA activity page
 	When I click on 'Start Activity' button on overview page
 	And I answer first question
 	And I submit SAA distinct activity
	Then I am on Student's LPN page
