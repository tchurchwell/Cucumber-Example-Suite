Feature: Student takes Grove Distinct Activity - Simple Assessment

As a Student
When I Login as Student
I should be able to launch and Submit GDA Simple Assessment activity from LPN

@StudLaunchSAdistinct @StuLaunchSubmitDistnct @Smoke
Scenario: Launch Simple Assessment distinct activity as student
Given I should be on Student's LPN page
When I click the already linked Simple Assessment activity
Then I am on Simple Assessment activity page

@StudSubmitSADistinct @StuLaunchSubmitDistnct @Smoke
Scenario: Submit Simple Assessment distinct activity as student
 	Given I should be on Simple Assessment activity page
 	When I launch Activity and answer one Question
 	And I click on Check My Work button
 	And I submit Simple Assessment activity
	Then I am on Student's LPN page
