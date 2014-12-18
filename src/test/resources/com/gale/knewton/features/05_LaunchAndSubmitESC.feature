 Feature: Instructor preview Exam Study Center-ESC Activity
  
  As an instructor,
  When I log in to MindTap course,
  I can preview i.e. - launch Exam Study Center(ESC) Activity

 @InstLaunchESC 
 Scenario Outline: Launch ESC Activity
 	Given I should be on instructor's LPN page
 	When I click the already linked ESC activity
 	Then I am on Exam Study Center page and error message displayed as <error> 
 	
 	Examples:
 	|error|
 	|Unable to load Study Center: Instructor Not Allowed to view ESC/USC. To view ESC/USC login with Student Account|
 	
 	