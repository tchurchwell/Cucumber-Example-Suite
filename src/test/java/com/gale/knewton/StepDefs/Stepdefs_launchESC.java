package com.gale.knewton.StepDefs;


import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.ESCActivityPage;
import com.gale.knewton.pageObjects.MindTapLPNPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_launchESC extends BaseWebComponent {
	
	private MindTapLPNPage mindtapLPNPage;
	private ESCActivityPage escActivityPage;
	
	@When("^I click the already linked ESC activity$")
	public void i_click_the_already_linked_ESC_activity(){
	mindtapLPNPage = new MindTapLPNPage();
	mindtapLPNPage.clickESCActivity();
	}
	
	@Then("^I am on Exam Study Center page and error message displayed as (.*)$")
	public void i_am_on_exam_study_center_page(String Error){
		escActivityPage = new ESCActivityPage();
		Assert.assertTrue("Incorrect error message is displayed",escActivityPage.isErrorDisplayed(Error));
		logPassMessage("Error message is displayed successfully on ESC activity page");
		escActivityPage.closeActivity();
	}
}
