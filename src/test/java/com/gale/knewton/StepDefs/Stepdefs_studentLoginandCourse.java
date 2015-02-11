package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.ConfirmCourseInfoPage;
import com.gale.knewton.pageObjects.CoursePaymentPage;
import com.gale.knewton.pageObjects.LoginPage;
import com.gale.knewton.pageObjects.SSOStudentDashBoardPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_studentLoginandCourse extends BaseWebComponent {
	private SSOStudentDashBoardPage ssoDashBoardPage;
	private LoginPage loginPage;
	private ConfirmCourseInfoPage confirmCourseInfoPage;
	private CoursePaymentPage coursePaymentPage;

	
	// ************************* Student Login *******************************

	@Given("^I am on the Cengage Learning Login Page to login as student$")
	public void I_am_on_the_Cengage_Learning_Login_Page() throws Throwable {
		loginPage = new LoginPage();
		loginPage.LaunchLoginpage();
	}

	@When("^I provide student username as (.*) and password as (.*) and hit login button$")
	public void I_provide_student_username_and_password(String username,
			String password) {
		loginPage.login(username, password);
	}

	@Then("^I should be able to login successfully as a student$")
	public void I_should_be_able_to_login_successfully_as_a_student() {
		ssoDashBoardPage = new SSOStudentDashBoardPage();
		Assert.assertTrue("Login attempt of Student failed",
				ssoDashBoardPage.isUserOnDashboardPage());
		logPassMessage("Student's SSO dashboard displayed");
	}

	// *************************Student LogOut*********************************

	@Given("^I am on the Cengage Learning Home Page of Student$")
	public void I_am_on_the_Cengage_Learning_Home_Page() throws Throwable {
		ssoDashBoardPage = new SSOStudentDashBoardPage();

	}

	@When("^I click the Log out link on Student DashBoard Page$")
	public void I_click_the_Sign_out_Link() throws Throwable {
		ssoDashBoardPage.logout();
	}

	@Then("^I should be able to logout successfully as a student$")
	public void I_should_be_able_to_logout_successfully() throws Throwable {
		loginPage = new LoginPage();
		Assert.assertTrue("Log out did not work", loginPage.isUserOnLoginPage());
	}

	// *********************Enroll Course *************************

	@Given("^I am on the Cengage Learning student's sso dashboard$")
	public void i_am_on_the_Cengage_Learning_students_sso_dashboard()
			throws Throwable {
		ssoDashBoardPage = new SSOStudentDashBoardPage();
		Assert.assertTrue("Login attempt of Student failed",
				ssoDashBoardPage.isUserOnDashboardPage());
		logPassMessage("Student SSO dashboard displayed");
	}

	@When("^I enter Course Key and click Register$")
	public void i_enter_Course_Key_and_click_Register() throws Throwable {
		ssoDashBoardPage.enterCourseKey();
		ssoDashBoardPage.clickRegister();
	}

	@When("^confirm the course on Confirm Course Information page$")
	public void confirm_the_course_on_Confirm_Course_Information_page()
			throws Throwable {
		confirmCourseInfoPage = new ConfirmCourseInfoPage();
		Assert.assertTrue("Enrolling to the Course failed",
				confirmCourseInfoPage.isOnCourseInfoPage());
		confirmCourseInfoPage.clickContinue();
	}

	@Then("^I should be able to see the Course on dashboard under My Courses & Materials$")
	public void i_should_be_able_to_see_the_Course_on_dashboard_under_My_Courses_Materials()
			throws Throwable {
		Assert.assertTrue("Course is not diaplayed on Student's dashboard",
				ssoDashBoardPage.isCourseDisplayed());
	}

	// **********************Launch Course As Student**********************

	@When("^I open the course and click launch$")
	public void i_open_the_course_and_click_launch() throws Throwable {
		ssoDashBoardPage = new SSOStudentDashBoardPage();
		ssoDashBoardPage.clickOpen();

		coursePaymentPage = new CoursePaymentPage();
		coursePaymentPage.clickTakeMeToMyCourse();
	}
}
