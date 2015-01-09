Feature: Instructor preview Assessment - SAA activity
  
  As an instructor,
  When I log in to MindTap course,
  I can preview - launch and submit SAA activity

 @InstLaunchSAA @SmokeGulati
 Scenario: Launch SAA distinct activity as instructor
 	Given I should be on instructor's LPN page
 	When I click the already linked SAA activity
 	Then I am on SAA distinct activity page
 	 
 @InstSubmitSAA @SmokeGulati
 Scenario: Submit SAA distinct activity as instructor
 	Given I should be on SAA activity page
 	When I click on 'Start Activity' button on overview page
 	And I answer first question
 	And I submit SAA distinct activity
	Then I am on instructor's LPN page