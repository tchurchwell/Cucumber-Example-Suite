Feature: Access Exam Study Center and and verify its linking on LPN
  As an instructor/student,
  When I log in to MindTap course,
  I should be able to access Exam Study Center and and verify its linking on LPN.

   @AccessESCandLinkToLPN @SmokeAnderson @SmokeGulati
   Scenario: Access Exam Study Center Configurations page
     Given I am on Add Activity List
     When I click Exam Study Center from Activities list
     Then I am on Exam Study Center configuration page
     When I save ESC activity after completing required details on Config page and following MindTap Description page
     Then created ESC should be linked to LPN
     