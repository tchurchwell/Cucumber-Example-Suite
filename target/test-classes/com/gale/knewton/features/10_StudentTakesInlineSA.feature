Feature: Student takes Groove Inline Activity - Simple Assessment Activity
  
  As a Student,
  When I log in to MindTap course,
  I can take - launch and submit inline Simple Assessment activity

 @StudLaunchInlineSA @StuLaunchSubmitDistnctInline @Smoke
 Scenario: Launch inline Simple Assessment distinct activity
 	Given I should be on Student's LPN page
 	And I Navigate to the First Ebook Document
 	When I click start for the linked inline Simple Assessment activity
 	Then I am on inline Simple Assessment activity page
 	
 	@StudSubmitInlineSA @StuLaunchSubmitDistnctInline @Smoke
 Scenario: Submit inline Simple Assessment distinct activity
 	Given I should be on inline Simple Assessment activity overview page
 	When I click Start Activity and submit answer for a Question
 	And I click Check My Work button
 	Then Feedback section and Try Another button is displayed
 	And I submit inline Simple Assessment activity
	Then I am on Ebook Document Page
 	