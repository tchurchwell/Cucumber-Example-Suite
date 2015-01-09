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

}
