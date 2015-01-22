Feature: Launch Unit Study Center as Instructor and verify its error message
  As an instructor,
  When I log in to MindTap course,
  I should be able to launch Unit Study Center of any one chapter from LPN and verify error message

@InstLaunchUSC    
  Scenario Outline: Launch USC as Instructor and verify error message
     Given I should be on chapter LPN
     When I click on USC link
     Then I should be navigated to USC page and error message displayed as <error>
     
    Examples:
 	|error|
 	|Unable to load Study Center: Instructor Not Allowed to view ESC/USC. To view ESC/USC login with Student Account|