package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.MindTapLPNPage;
import com.gale.knewton.pageObjects.ProgressApp;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_StudentVerifiesProgressApp extends BaseWebComponent {

	private MindTapLPNPage mindTapLpn;
	private ProgressApp progressApp = new ProgressApp();;
	
	@When("^I click on progress app icon from App dock$")
	public void i_click_on_progress_app_icon_from_App_dock() {
	mindTapLpn = new MindTapLPNPage();
	mindTapLpn.clickProgressApp();
	}

	@Then("^My Grades tab is active by default$")
	public void my_Grades_tab_is_active_by_default() {
	   Assert.assertTrue("My Grade tab is not selected by default", progressApp.verifyMyGradeAsDefaultTab());
	   logPassMessage("My Grade tab is selected by default");
	   progressApp.closeProgressApp();
	}
	
	@Then("^\"(.*?)\" and \"(.*?)\" tabs are displayed$")
	public void tabs_displayed_are(String myGrade, String masteryReport) {

	}
	
	@Then("^I should be on Student's progress app$")
	public void i_should_be_on_progress_app()  {
	     
	    
	}

	@Then("^correct score is displayed for attempted Simple Assessment activity$")
	public void correct_score_is_displayed_for_attempted_Simple_Assessment_activity()  {
	     
	    
	}

	@When("^I click on Simple Assessment activity link$")
	public void i_click_on_Simple_Assessment_activity_link()  {
	     
	    
	}

	@Then("^correct score for the current attempt is displayed for Simple Assessment activity$")
	public void correct_score_for_the_current_attempt_is_displayed_for_Simple_Assessment_activity()  {
	     
	    
	}

	@Then("^View button is displayed$")
	public void view_button_is_displayed()  {
	     
	    
	}

	@When("^I click on view button$")
	public void i_click_on_view_button()  {
	   
	}

	@Then("^Attempted Simple Assessment activity is displayed$")
	public void attempted_Simple_Assessment_activity_is_displayed()  {
	     
	    
	}
}
