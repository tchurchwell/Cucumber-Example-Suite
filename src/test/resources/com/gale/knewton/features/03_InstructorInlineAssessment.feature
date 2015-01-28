Feature: instructor access Inline Assessment, link it on Ebook and Preview it
  
  As an instructor/student,
  When I log in to MindTap course,
  I land on MindTap LP for course, access inline Assessment on Ebook, create activity, link and preview it

 @AccessinlineSAAndlinkToEBook @SmokeAnderson @SmokeGulati
 Scenario: I want to access Inline Assessment and link as inline activity
 	Given I should be on instructor's LPN page
 	And I Navigate to the First Ebook Document
 	And I enter the Edit Mode to reach Add Activity Panel
	Then select Inline Assessment from the Activity list
	Then verify creation type display as "Simple Assessment"
	When I select Simple Assessment as creation type
	And I publish practice Simple Assessment activity
	And I save inline Simple Assessment activity with default options
	Then verify created Simple Assessment activity should linked to the Ebook Document
	
 @InstLaunchInlineSA @LaunchSubmitInlineSA @SmokeAnderson @SmokeGulati
 Scenario: Instructor launches inline Simple Assessment distinct activity
 	Given I should be on instructor's LPN page
 	And I Navigate to the First Ebook Document
 	When I click start for the linked inline Simple Assessment activity
 	Then I am on inline Simple Assessment activity page
 	
 @InstSubmitInlineSA @LaunchSubmitInlineSA @SmokeAnderson @SmokeGulati
 Scenario: Instructor submits inline Simple Assessment distinct activity
 	Given I should be on inline Simple Assessment activity page
 	When I click Start Activity and submit answer for a Question
 	And I click Check My Work button
 	Then Feedback section and Try Another button is displayed
 	And I submit inline Simple Assessment activity
	Then I am on Ebook Document Page



