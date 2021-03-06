Feature: Student takes Inline Activity - Simple Assessment Activity
  
  As a Student,
  When I log in to MindTap course,
  I can take - launch and submit inline Simple Assessment activity

 @StudLaunchInlineSA @StuLaunchSubmitInline @SmokeAndersen @SmokeGulati
 Scenario: Student launches inline Simple Assessment distinct activity
 	Given I should be on Student's LPN page
 	And I Navigate to the First Ebook Document
 	When I click start for the linked inline Simple Assessment activity
 	Then I am on inline Simple Assessment activity page
 	
 @StudSubmitInlineSA @StuLaunchSubmitInline @SmokeAndersen @SmokeGulati
 Scenario: Student submits inline Simple Assessment distinct activity
 	Given I should be on inline Simple Assessment activity page
 	When I click Start Activity and submit answer for a Question
 	And I click Check My Work button
 	Then Feedback section and Try Another button is displayed
 	And I submit inline Simple Assessment activity
	Then I am on Ebook Document Page
	And LPN score is displayed on Inline Simple Assessment activity link