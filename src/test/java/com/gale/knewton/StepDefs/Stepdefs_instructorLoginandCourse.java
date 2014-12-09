package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.CreateCoursePage;
import com.gale.knewton.pageObjects.LoginPage;
import com.gale.knewton.pageObjects.MindTapEulaPage;
import com.gale.knewton.pageObjects.MindTapLPNPage;
import com.gale.knewton.pageObjects.SSOInstructorDashboardPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_instructorLoginandCourse extends BaseWebComponent {

	//##############################---Instructor Login/Logout---####################################
	private SSOInstructorDashboardPage ssoDashBoardPage;
	private LoginPage loginPage;

	@Given("^I am on the Cengage Learning Login Page to login as instructor$")
	public void I_am_on_the_Cengage_Learning_Login_Page() throws Throwable {
		loginPage = new LoginPage();
		loginPage.LaunchLoginpage();
	
	}

	@When("^I provide instructor username as (.*) and password as (.*) and hit login button$")
	public void I_provide_instructor_username_and_password(String username, String password) {
		loginPage.login(username, password);
	}

	@Then("^I should be able to login successfully as an instructor$")
	public void I_should_be_able_to_login_successfully_as_an_instructor()  {
		ssoDashBoardPage = new SSOInstructorDashboardPage();
	 Assert.assertTrue("Login attempt of Instructor failed", ssoDashBoardPage.isUserOnDashboardPage());
	 }

	@Given("^I am on the Cengage Learning Home Page of Instructor$")
	public void I_am_on_the_Cengage_Learning_Home_Page() throws Throwable {
		ssoDashBoardPage = new SSOInstructorDashboardPage();
	}

	@When("^I click the Sign out button on Instructor DashBoard Page$")
	public void I_click_the_Sign_out_button() throws Throwable {
	    ssoDashBoardPage.logout();
	}

	@Then("^I should be able to logout successfully as an Instructor$")
	public void I_should_be_able_to_logout_successfully() throws Throwable {
		loginPage = new LoginPage();
		Assert.assertTrue("Log out did not work", loginPage.isUserOnLoginPage());
	}

	//##############################---CreateCourse---####################################
	private CreateCoursePage createCoursePage;
	private SSOInstructorDashboardPage ssoInstructorDashboardPage;
	private MindTapEulaPage mindTapEulaPage;
	private MindTapLPNPage mindTapLPNPage;

	@Given("^I am on the Cengage Learning instructor's sso dashboard$")
	public void i_am_on_the_Cengage_Learning_instructor_welcome_page() {
		ssoInstructorDashboardPage = new SSOInstructorDashboardPage();
		ssoInstructorDashboardPage.isUserOnDashboardPage();
	}

	@When("^I click Create Course hyperlink and navigate to create course page$")
	public void i_click_Create_Course_hyperlink() {
		
		ssoInstructorDashboardPage.clickOnCreateCourseLink();
	}

	@Then("^I select Create a new course option and click on Continue$")
	public void i_select_Create_a_new_course_option() {
		createCoursePage = new CreateCoursePage();
	    createCoursePage.selectCreateNewCourseRadioBtnAndContinue();
	}

	@Then("^I should be navigated to Course Details page and enter course details$")
	public void i_should_be_navigated_to_Course_Details_page() {
	    createCoursePage.enterCourseInformation();
	}

	@When("^click Create Course button$")
	public void click_Create_Course_button() {
		createCoursePage.clickOnCreateCourseButton();
	}

	@Then("^course should be created$")
	public void course_should_be_created() {
	    Assert.assertTrue("Course creation is failed", createCoursePage.CourseIsCreated());
	    logPassMessage("");
	}

	@Then("^we save the course info and navigate to dashboard$")
	public void we_save_the_course_key() {
		createCoursePage.getCourseKey();
	    createCoursePage.saveCourseNameToFile();
	    createCoursePage.saveCourseKeyToFile();
	    createCoursePage.clickReturnDashboard();
	}
	
	//#########################Accept Eula######################

	@Given("^I click newly created course$")
	public void i_click_newly_created_course() {
		
		ssoInstructorDashboardPage.clickNewCourse();
	}

	@Then("^I am on the MindTap window$")
	public void i_am_on_the_MindTap_window(){
		mindTapEulaPage = new MindTapEulaPage();
		Assert.assertTrue("MindTap window not displayed", mindTapEulaPage.isOnMindTapWindow());
		logPassMessage("MindTap window is displayed");
	}

	@When("^verify presence of Eula and accept EULA if present$")
	public void verify_presence_of_Eula_and_accept_EULA_if_present() {
		mindTapLPNPage = new MindTapLPNPage();
	    
	    	if(mindTapEulaPage.isEulaDisplayed()){
	    		mindTapEulaPage.clickAcceptButton();
	    		logPassMessage("Eula page appeared and Accepted");
		    	mindTapLPNPage.clickEnter();
	    	}
	    	
	    	else{
	    		logMessage("Eula did not appeared");
	    		Assert.assertTrue("Instructor MindTap LPN did not appear",mindTapLPNPage.getInstLPNDisplayed());
	    		logPassMessage("Instructor LPN page displayed");
	    	    }
	}
}
