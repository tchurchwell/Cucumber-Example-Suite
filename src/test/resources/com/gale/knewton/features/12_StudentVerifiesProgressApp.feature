Feature: Student launches the progress app, verifies score, reviews previous takes and view mastery report.

As a Student,
When I login into Mindtap course
I can launch the progress app,
Verify the scores of attempted activities,
Review the previous takes of attempted activities,
and can view mastery report of ESC/USC

@StuLaunchesProgressApp @StuProgressApp @SmokeAndersen @SmokeGulati
Scenario: Student launches the Progress App
Given I should be on Student's LPN page
When I click on progress app icon from App dock
Then "My Grades" and "Mastery Report" tabs are displayed
And My Grades tab is active by default

@SmokeAndersen @SmokeGulati
Scenario: Student verifies the score of attempted Simple Assessment activity
Given I should be on Student's progress app
And Correct score is displayed for attempted Simple Assessment activity





