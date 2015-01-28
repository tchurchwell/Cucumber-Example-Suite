Feature: Student takes Assessment - Simple Assessment, SAA

As a Student
When I Login as Student
I should be able to launch and Submit Assessment activity from LPN

@StudLaunchSAdistinct @StuLaunchSubmitDistnct @SmokeGulati @SmokeAnderson
Scenario: Launch Simple Assessment distinct activity as student
	Given I should be on Student's LPN page
	When I click the already linked Simple Assessment activity
	Then I am on Simple Assessment activity page

@StudSubmitSADistinct @StuLaunchSubmitDistnct @SmokeGulati @SmokeAnderson
Scenario: Submit Simple Assessment distinct activity as student
 	Given I should be on Simple Assessment activity page
 	When I launch Activity and answer one Question
 	And I click on Check My Work button
 	And I submit Simple Assessment activity
	Then I am on Student's LPN page
	
@StudLaunchSAA @SmokeGulati @StuLaunchSubmitSAA
Scenario: Launch SAA distinct activity as Student
	Given I should be on Student's LPN page
	When I click the already linked SAA activity
	Then I am on SAA distinct activity page

@StudSubmitSAA @SmokeGulati @StuLaunchSubmitSAA
Scenario: Submit Simple Assessment distinct activity as Student
 	Given I should be on SAA activity page
 	When I click on 'Start Activity' button on overview page
 	And I answer first question
 	And I submit SAA distinct activity
	Then I am on Student's LPN page
