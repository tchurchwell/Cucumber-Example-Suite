Feature: Student verifies score in progres app for Distinct SA, Inline SA and SAA activity

As a Student,
When I login into Mindtap course
I can verify the scores of attempted activities in progress app

Scenario: Student verifies the score of attempted Simple Assessment activity
Given I should be on Student's LPN page
When I click on progress app icon from App dock
Then My Grades tab is active by default
And correct score is displayed for attempted Simple Assessment activity
When I click on Simple Assessment activity link
Then correct score for the current attempt is displayed for Simple Assessment activity
And View button is displayed
When I click on view button
Then Attempted Simple Assessment activity is displayed

Scenario: Student verifies the score of attempted Inline Simple Assessment activity
Given I should be on Student's LPN page
When I click on progress app icon from App dock
Then My Grades tab is active by default
And correct score is displayed for attempted inline Simple Assessment activity
When I click on inline Simple Assessment activity link
Then correct score for the current attempt is displayed for inline Simple Assessment activity
And View button is displayed
When I click on view button
Then Attempted inline Simple Assessment activity is displayed

Scenario: Student verifies the score of attempted SAA activity
Given I should be on Student's LPN page
When I click on progress app icon from App dock
Then My Grades tab is active by default
And correct score is displayed for attempted SAA activity
When I click on SAA activity link
Then correct score for the current attempt is displayed for SAA activity
And View button is displayed
When I click on view button
Then Attempted SAA activity is displayed
