$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("01_InstructorSSO.feature");
formatter.feature({
  "id": "login/logout-to-sso,-create,-enroll-and-launch-course",
  "description": "\r\nAs an instructor,\r\nWhen I am using valid username and password on Login screen,\r\nI should be able to login successfully on SSO dashboard and logout successfully\nand able to Create, Enroll and Launch course",
  "name": "Login/Logout to SSO, Create, Enroll and Launch course",
  "keyword": "Feature",
  "line": 1
});
formatter.before({
  "duration": 24794070,
  "status": "passed"
});
formatter.before({
  "duration": 153944,
  "status": "passed"
});
formatter.scenario({
  "id": "login/logout-to-sso,-create,-enroll-and-launch-course;i-want-to-login-as-an-instructor-on-providing-valid-credentials;;2",
  "tags": [
    {
      "name": "@LoginAsInstructor",
      "line": 8
    },
    {
      "name": "@LoginLaunch",
      "line": 8
    },
    {
      "name": "@LogincreateLaunch",
      "line": 8
    },
    {
      "name": "@Smoke",
      "line": 8
    }
  ],
  "description": "",
  "name": "I want to login as an instructor on providing valid credentials",
  "keyword": "Scenario Outline",
  "line": 17,
  "type": "scenario"
});
formatter.step({
  "name": "I am on the Cengage Learning Login Page to login as instructor",
  "keyword": "Given ",
  "line": 10
});
formatter.step({
  "name": "I provide instructor username as knewton_automation_inst01@qai.com and password as A123456 and hit login button",
  "keyword": "When ",
  "line": 11,
  "matchedColumns": [
    0,
    1
  ]
});
formatter.step({
  "name": "I should be able to login successfully as an instructor",
  "keyword": "Then ",
  "line": 12
});
formatter.match({
  "location": "Stepdefs_instructorLoginandCourse.I_am_on_the_Cengage_Learning_Login_Page()"
});
formatter.result({
  "duration": 2673853354,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "knewton_automation_inst01@qai.com",
      "offset": 33
    },
    {
      "val": "A123456",
      "offset": 83
    }
  ],
  "location": "Stepdefs_instructorLoginandCourse.I_provide_instructor_username_and_password(String,String)"
});
formatter.result({
  "duration": 4837965602,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefs_instructorLoginandCourse.I_should_be_able_to_login_successfully_as_an_instructor()"
});
formatter.result({
  "duration": 56563385,
  "status": "passed"
});
formatter.after({
  "duration": 75393,
  "status": "passed"
});
formatter.before({
  "duration": 7681413,
  "status": "passed"
});
formatter.before({
  "duration": 59209,
  "status": "passed"
});
formatter.scenario({
  "id": "login/logout-to-sso,-create,-enroll-and-launch-course;i-want-to-launch-the-course-from-instructor\u0027s-dashboard",
  "tags": [
    {
      "name": "@LaunchCourse",
      "line": 30
    },
    {
      "name": "@LogincreateLaunch",
      "line": 30
    },
    {
      "name": "@LoginLaunch",
      "line": 30
    },
    {
      "name": "@Smoke",
      "line": 30
    }
  ],
  "description": "",
  "name": "I want to launch the course from instructor\u0027s dashboard",
  "keyword": "Scenario",
  "line": 31,
  "type": "scenario"
});
formatter.step({
  "name": "I am on the Cengage Learning instructor\u0027s sso dashboard",
  "keyword": "Given ",
  "line": 32
});
formatter.step({
  "name": "I click newly created course",
  "keyword": "And ",
  "line": 33
});
formatter.step({
  "name": "I am on the MindTap window",
  "keyword": "Then ",
  "line": 34
});
formatter.match({
  "location": "Stepdefs_instructorLoginandCourse.i_am_on_the_Cengage_Learning_instructor_welcome_page()"
});
formatter.result({
  "duration": 69496658,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefs_instructorLoginandCourse.i_click_newly_created_course()"
});
