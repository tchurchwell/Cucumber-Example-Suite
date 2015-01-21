Feature: Access Unit Study Center as Instructor
  As an instructor,
  When I log in to MindTap course,
  I should be able to access Unit Study Center of any one chapter from LPN.

   @InstAccessUSC
   Scenario: Access Unit Study Center on LPN as Instructor
     Given I should be on instructor's LPN page
     When I navigate to a chapter from LPN
     Then Unit Exam Center link should be present