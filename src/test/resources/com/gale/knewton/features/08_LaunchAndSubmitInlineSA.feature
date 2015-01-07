Feature: Instructor preview Groove Inline Activity - Simple Assessment Activity
  
  As an instructor,
  When I log in to MindTap course,
  I can preview - launch and submit inline Simple Assessment activity

 @InstLaunchInlineSA @LaunchSubmitInlineSA @Smoke
 Scenario: Instructor launches inline Simple Assessment distinct activity
 	Given I should be on instructor's LPN page
 	And I Navigate to the First Ebook Document
 	When I click start for the linked inline Simple Assessment activity
 	Then I am on inline Simple Assessment activity page
 	
 @InstSubmitInlineSA @LaunchSubmitInlineSA @Smoke
 Scenario: Instructor submits inline Simple Assessment distinct activity
 	Given I should be on inline Simple Assessment activity page
 	When I click Start Activity and submit answer for a Question
 	And I click Check My Work button
 	Then Feedback section and Try Another button is displayed
 	And I submit inline Simple Assessment activity
	Then I am on Ebook Document Page