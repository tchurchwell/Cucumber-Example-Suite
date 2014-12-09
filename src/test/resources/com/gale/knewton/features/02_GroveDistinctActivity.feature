Feature: instructor access Groove Distinct Activity
  
  As an instructor/student,
  When I log in to MindTap course,
  I land on MindTap LPN for course, access Groove Distinct Activity and its available features

@AccessGDAAndlinkSimpleAssessment @Smoke
 Scenario: I want to access Grove Distinct Activity and want to create and link Simple Assessment to LPN
 	Given I am on Select Grove Distinct Activity page
 	And Creation type display as "Simple Assessment"
 	When I select Simple Assessment as creation type
	And I publish first practice Simple Assessment activity
	And I save distinct Simple Assessment activity with default options
	Then I am on instructor's LPN page
	And verify created Simple Assessment activity should linked to LPN

