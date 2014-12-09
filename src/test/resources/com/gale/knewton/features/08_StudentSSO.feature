Feature: Login/Logout to SSO as student, Enroll and Launch course
  
  As a student,
  When I am using valid username and password on Login screen,
  I should be able to login successfully on SSO dashboard and logout successfully
  and also be able to Enroll and Launch courses from the dashboard


 @LoginStudent @LoginEnrollAndAcceptEula @StudentLoginAndLaunchCourse @Smoke
 Scenario Outline: I want to login successfully as a student on providing valid credentials
    Given I am on the Cengage Learning Login Page to login as student
    When I provide student username as <username> and password as <password> and hit login button
    Then I should be able to login successfully as a student
    
 Examples:
 
 	| username            | password |
 	| knewton_automation_stu01@qai.com | A123456  |

 @EnrollCourse @LoginEnrollAndAcceptEula @Smoke
 Scenario: I want to enroll into a course successfully
 	Given I am on the Cengage Learning student's sso dashboard
 	When I enter Course Key and click Register
 	And confirm the course on Confirm Course Information page
 	Then I should be able to see the Course on dashboard under My Courses & Materials
 
 @LaunchCourseAsStudent @LoginEnrollAndAcceptEula @StudentLoginAndLaunchCourse @Smoke
 Scenario: I want to launch course successfully
 	Given I am on the Cengage Learning student's sso dashboard
 	When I open the course and click launch
 	Then I accept Eula if appears and redirected to MindTap LPN page
  
 @LogoutStudent
 Scenario: I want to logout successfully as a student
    Given I am on the Cengage Learning Home Page of Student
    When I click the Log out link on Student DashBoard Page
    Then I should be able to logout successfully as a student
 
 
 