Feature: Take ESC activity as a Student

As a Student,
When I login into Mindtap course
I can Take - Launch and submit ESC activity

@StudLaunchESC @Smoke
Scenario: Student Launches ESC activity
Given I should be on Student's LPN page
When I click the already linked ESC activity
Then I am on Exam Study Center page

@StudSubmitsESC
Scenario: Student submits ESC activity
Given I should be on Exam Study Center page
When I answer one question
And I click on Submit button
  



 	 