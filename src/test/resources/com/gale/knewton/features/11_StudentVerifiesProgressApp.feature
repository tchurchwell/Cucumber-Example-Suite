Feature: Student launches the progress app, verifies score, reviews previous takes and view mastery report.

As a Student,
When I login into Mindtap course
I can launch the progress app,
Verify the scores of attempted activities,
Review the previous takes of attempted activities,
and can view mastery report of ESC/USC

@StuLaunchesProgressApp
Scenario: Student launches the Progress App
Given I should be on Student's LPN page
When I click on progress app icon from App dock
Then "My Grades" and "Mastery Report" tabs are displayed
And My Grades tab is active by default


@StuVerifiesSAinProgressApp
Scenario: Student verifies the score of attempted Simple Assessment activity
Given I should be on Student's progress app
And correct score is displayed for attempted Simple Assessment activity


Scenario: Student verifies the score of attempted Inline Simple Assessment activity
Given I should be on Student's progress app
And correct score is displayed for attempted Inline Simple Assessment activity

Scenario: Student verifies the score of attempted SAA activity
Given I should be on Student's progress app
And correct score is displayed for attempted SAA activity

Scenario: Student review the previous take of a Simple Assessment distinct activity.
Given I should be on Student's progress app
When I click on Simple Assessment activity link
Then correct score for the current attempt is displayed for Simple Assessment activity
And View button is displayed
When I click on view button
Then Attempted Simple Assessment activity is displayed

Scenario: Student review the previous take of a inline Simple Assessment distinct activity.
Given I should be on Student's progress app
When I click on inline Simple Assessment activity link
Then correct score for the current attempt is displayed for inline Simple Assessment activity
And View button is displayed
When I click on view button
Then Attempted inline Simple Assessment activity is displayed

Scenario: Student review the previous take of a SAA distinct activity.
Given I should be on Student's progress app
When I click on SAA activity link
Then correct score for the current attempt is displayed for SAA activity
And View button is displayed
When I click on view button
Then Attempted SAA activity is displayed
