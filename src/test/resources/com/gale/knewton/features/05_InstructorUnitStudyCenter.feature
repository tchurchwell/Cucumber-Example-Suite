Feature: Access Unit Study Center and verify error message as Instructor
  
  As an instructor,
  When I log in to MindTap course,
  I should be able to access Unit Study Center of any one chapter from LPN and verify error message.

   @InstAccessLaunchUSC @SmokeAnderson @SmokeGulati
   Scenario: Access Unit Study Center on LPN as Instructor
     Given I should be on instructor's LPN page
     When I navigate to a chapter from LPN
     Then Unit Exam Center link should be present
     
 @InstAccessLaunchUSC @SmokeAnderson @SmokeGulati  
  Scenario Outline: Launch USC as Instructor and verify error message
     Given I should be on chapter LPN
     When I click on USC link
     Then I should be navigated to USC page and error message displayed as <error>
     
    Examples:
 	|error|
 	|Unable to load Study Center: Instructor Not Allowed to view ESC/USC. To view ESC/USC login with Student Account|