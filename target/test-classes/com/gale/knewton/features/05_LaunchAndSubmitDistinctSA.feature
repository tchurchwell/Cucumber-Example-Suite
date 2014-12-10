 Feature: Instructor preview Groove Distinct Activity - Simple Assessment Activity
  
  As an instructor,
  When I log in to MindTap course,
  I can preview - launch and submit Simple Assessment activity

 @InstLaunchSimpleAssessment @LaunchSubmitSA @Smoke
 Scenario: Launch Simple Assessment distinct activity
 	Given I should be on instructor's LPN page
 	When I click the already linked Simple Assessment activity
 	Then I am on Simple Assessment activity page
 	
 @InstSubmitSimpleAssessment @LaunchSubmitSA @Smoke
 Scenario: Submit Simple Assessment distinct activity
 	Given I should be on Simple Assessment activity page
 	When I launch Activity and answer one Question
 	And I click on Check My Work button
 	And I submit Simple Assessment activity
	Then I am on instructor's LPN page
	