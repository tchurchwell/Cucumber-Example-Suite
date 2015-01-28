Feature: Instructor access Exam Study Center, verify its linking on LPN and Preview it

  As an instructor/student,
  When I log in to MindTap course,
  I should be able to access Exam Study Center verify its linking on LPN and preview it.

   @AccessESCandLinkToLPN @SmokeAnderson @SmokeGulati
 Scenario: Access Exam Study Center Configurations page
	 Given I am on Add Activity List
	 When I click Exam Study Center from Activities list
	 Then I am on Exam Study Center configuration page
	 When I save ESC activity after completing required details on Config page and following MindTap Description page
	 Then created ESC should be linked to LPN
	 
	@InstLaunchESC @SmokeAnderson @SmokeGulati
  Scenario Outline: Launch ESC Activity as Instructor
 	Given I should be on instructor's LPN page
 	When I click the already linked ESC activity
 	Then I am on Exam Study Center page and error message displayed as <error> 
 	
 	Examples:
 	|error|
 	|Unable to load Study Center: Instructor Not Allowed to view ESC/USC. To view ESC/USC login with Student Account|
   
     