package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.MindTapLPNPage;
import com.gale.knewton.pageObjects.SAA_ActivityPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_launchAndSubmitDistinctSAA extends BaseWebComponent {
private MindTapLPNPage mindtapLPN;
private SAA_ActivityPage SaaActivity;

private boolean flag;

// ****************** LAUNCH DISTINCT SAA*************************
	@When("^I click the already linked SAA activity$")
	public void i_click_the_already_linked_SAA_activity() {
	 mindtapLPN = new MindTapLPNPage();
	 mindtapLPN.clickDistinctSAA_Activity();
	}
	
	@Then("^I am on SAA distinct activity page$")
	public void i_am_on_SAA_activity_page() {
		SaaActivity = new SAA_ActivityPage();
		flag = SaaActivity.isSAA_OverviewTabDisplayed();
		if(!flag){
			SaaActivity.relaunchSaaActivity();
			flag = SaaActivity.isSAA_OverviewTabDisplayed();
		}
		Assert.assertTrue("SAA activity overview page not displayed", flag);
		logPassMessage("SAA activity overview page displayed successfully");
	}

	
//	****************** SUBMIT DISTINCT SAA*************************
	@Given("^I should be on SAA activity page$")
	public void i_should_be_on_SAA_activity_page() {
		SaaActivity = new SAA_ActivityPage();
		
		if(SaaActivity.isSAA_OverviewTabDisplayed()){
	 	  logPassMessage("SAA activity overview page displayed successfully");
		}else{
			logWarningMessage("SAA activity overview page not displayed");
			mindtapLPN = new MindTapLPNPage();
			mindtapLPN.getInstLPNDisplayed();
			hardWait(1);
			mindtapLPN.clickDistinctSAA_Activity();
			Assert.assertTrue("SAA activity ovewview page still not displayed",
					SaaActivity.isSAA_OverviewTabDisplayed());
			logPassMessage("SAA activity page overview displayed successfully");
			}
	}

	@When("^I click on 'Start Activity' button on overview page$")
	public void i_click_on_Start_Activity_button_on_overview_page(){
	 SaaActivity.clickStartActivity();
	}

	@When("^I answer first question$")
	public void i_answer_first_question() {
		SaaActivity.selectRadioBtn();
		SaaActivity.submitSaaQuestion();
		Assert.assertTrue("Incorrect feedback displayed",SaaActivity.verifySAAfeedback());
		logPassMessage("Correct Feedback is displayed for SAA activity");
	}

	@When("^I submit SAA distinct activity$")
	public void i_submit_SAA_activity() {
	SaaActivity.clickSubmitLabelSaa();
	Assert.assertTrue("Current score do not matches with the score obtained", SaaActivity.verifySaaGrades());
	logPassMessage("Current score matches with the score obtained");
	SaaActivity.submitSAA();
	}

}
