Feature: instructor access Assessment
  
  As an instructor/student,
  When I log in to MindTap course,
  I land on MindTap LPN for course, access Assessment and its available features

@AccessGDAAndlinkSimpleAssessment @SmokeAnderson @SmokeGulati
 Scenario: I want to access Assessment, create and link Simple Assessment to LPN
 	Given I am on Select Assessment page
 	And Creation type display as "Simple Assessment"
 	When I select Simple Assessment as creation type
	And I publish practice Simple Assessment activity
	And I save distinct Simple Assessment activity with default options
	Then I am on instructor's LPN page
	And verify created Simple Assessment activity should linked to LPN
	
@AccessGDAandlinkSAA @SmokeGulati
Scenario: I want to access Assessment, create and link SAA activity to LPN
	Given I am on Select Assessment page
	And Creation type displayed as "SAA"
	When I select SAA as creation type
	And I publish first SAA activity
	And I save distinct SAA activity with default options
	Then I am on instructor's LPN page
	And verify created SAA activity should linked to LPN
	   

