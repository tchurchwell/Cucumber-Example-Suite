Feature: instructor access Inline Assessment and its linking on Ebook Document
  
  As an instructor/student,
  When I log in to MindTap course,
  I land on MindTap LP for course, navigate to Ebook document and access Inline Assessment and its available features

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


