package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.MindTapLPNPage;
import com.gale.knewton.pageObjects.ProgressApp;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_studentVerifiesProgressApp extends BaseWebComponent {

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
	  Assert.assertEquals("My Grade tab not displayed", myGrade, progressApp.getMyGrade());
	  logPassMessage("My Grade tab displayed successfully");
	  Assert.assertEquals("Mastery Report tab not displayed", masteryReport, progressApp.getMasteryReport());
	  logPassMessage("Mastery Report tab displayed successfully");
	}
	
	@Then("^I should be on Student's progress app$")
	public void i_should_be_on_progress_app()  {
	  mindTapLpn = new MindTapLPNPage();
      mindTapLpn.clickProgressApp();
	  Assert.assertTrue("Student's progress app not displayed", progressApp.isStudentProgressAppDisplayed());
	  logPassMessage("Student's progress app displayed successfully");	    
	}
}
