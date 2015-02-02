Feature: Login/Logout to SSO, Create, Enroll and Launch course
  
  As an instructor,
  When I am using valid username and password on Login screen,
  I should be able to login successfully on SSO dashboard and logout successfully
  and able to Create, Enroll and Launch course

  @LoginAsInstructor @LoginAnderson @SmokeAnderson
  Scenario Outline: I want to login as an instructor on providing valid credentials 
    Given I am on the Cengage Learning Login Page to login as instructor
    When I provide instructor username as <username> and password as <password> and hit login button
    Then I should be able to login successfully as an instructor
 
 Examples:
 
 	| username            | password |
 	| knewton_automation_inst04@qai.com | A123456  |
 
 @SmokeGulati @LoginGulati
  Scenario Outline: I want to login as an instructor on providing valid credentials 
    Given I am on the Cengage Learning Login Page to login as instructor
    When I provide instructor username as <username> and password as <password> and hit login button
    Then I should be able to login successfully as an instructor
 
 Examples:
 
 	| username            | password |
 	| knewton_inst06@qai.com | A123456  |
 		
 
 @CreateCourse @LogincreateLaunch @SmokeAnderson @SmokeGulati
 Scenario: I want to create a new course
 	Given I am on the Cengage Learning instructor's sso dashboard
 	When I click Create Course hyperlink and navigate to create course page
	And I select Create a new course option and click on Continue
	Then I should be navigated to Course Details page and enter course details
	And click Create Course button
	Then course should be created
	And we save the course info and navigate to dashboard

 @LaunchCourse @LogincreateLaunch @LoginLaunch @SmokeAnderson @SmokeGulati
 Scenario: I want to launch the course from instructor's dashboard
	Given I am on the Cengage Learning instructor's sso dashboard
 	When I click newly created course
 	Then I am on the MindTap window
	 
 @AcceptEulaIfAppears @LogincreateLaunch @SmokeAnderson @SmokeGulati
 Scenario: I want to accept EULA page for the newly created course
 	Given I am on the MindTap window
 	When verify presence of Eula and accept EULA if present
 	Then I am on instructor's LPN page
 
 @LogoutInstructor 
  Scenario: I want to logout successfully
    Given I am on the Cengage Learning Home Page of Instructor
    When I click the Sign out button on Instructor DashBoard Page
    Then I should be able to logout successfully as an Instructor