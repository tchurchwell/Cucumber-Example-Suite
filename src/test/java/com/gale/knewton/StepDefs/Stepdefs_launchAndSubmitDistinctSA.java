package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.LoginPage;
import com.gale.knewton.pageObjects.MindTapLPNPage;
import com.gale.knewton.pageObjects.SimpleAssessmentActivityPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_launchAndSubmitDistinctSA extends BaseWebComponent {

	boolean flag = false;
	
	private MindTapLPNPage mindTapLPNPage;
	private SimpleAssessmentActivityPage simpleAssessmentActivityPage;

	
	//********************Launch GDA Simple Assessment**************
	@When("^I click the already linked Simple Assessment activity$")
	public void i_click_the_already_linked_Simple_Assessment_activity() {
		mindTapLPNPage = new MindTapLPNPage();
		hardWait(1);
	    mindTapLPNPage.clickDistinctSimpleAssessment_Activity();
	}

	@Then("^I am on Simple Assessment activity page$")
	public void i_am_on_Simple_Assessment_activity_overview_page() {
		simpleAssessmentActivityPage = new SimpleAssessmentActivityPage();
		flag = simpleAssessmentActivityPage.isSimpleAssessmentLaunched();
		if(!flag){
			simpleAssessmentActivityPage.relaunchActivity();
			flag = simpleAssessmentActivityPage.isSimpleAssessmentLaunched();
		}
		Assert.assertTrue("Simple Assessment activity page not displayed", flag);
		logPassMessage("Simple Assessment activity page displayed successfully");
	}

	// ********************Submit Simple Assessment Activity******************

	@When("^I launch Activity and answer one Question$")
	public void i_click_Start_Activity_and_answer_one_Question() {
		simpleAssessmentActivityPage = new SimpleAssessmentActivityPage();
		simpleAssessmentActivityPage.selectOption();
	    logPassMessage("Activity Launched and answered one question");
	}
	
	@And ("^I click on Check My Work button$")
	public void i_click_on_Check_My_Work_button() {
		simpleAssessmentActivityPage = new SimpleAssessmentActivityPage();
		simpleAssessmentActivityPage.checkMyWork();
		Assert.assertTrue("Feedback not displayed", simpleAssessmentActivityPage.isFeedbackDisplayed());
		logPassMessage("Feedback displayed successfully");
		if(LoginPage.product.equals("Anderson")){
		Assert.assertTrue("Try Another Version button not displayed", simpleAssessmentActivityPage.isTryAnotherVersionbtnDisplayed());
		logPassMessage("Try Another Version button displayed");
		}
	}
	
	@And("^I submit Simple Assessment activity$")
	public void i_submit_Simple_Assessment_activity() {
		simpleAssessmentActivityPage = new SimpleAssessmentActivityPage();
		simpleAssessmentActivityPage.clickReviewSubmitGDA();
		Assert.assertTrue("Current Score and Entry Score do not match",simpleAssessmentActivityPage.verifyGradesOnTable());
		logPassMessage("Current Score and Entry Score matches");
		simpleAssessmentActivityPage.submitSimpleAssessmentActivity();
		
	}

}
