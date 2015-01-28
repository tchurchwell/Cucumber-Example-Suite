package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.MindTapLPNPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_unitStudyCenter extends BaseWebComponent {

	private MindTapLPNPage mindtapLPN; 
	
	@When("^I navigate to a chapter from LPN$")
	public void i_navigate_to_a_chapter_from_LPN() {
		mindtapLPN = new MindTapLPNPage();
		mindtapLPN.navigateToChapterLPN();
		logPassMessage("Navigated to course LPN");
	}
	
	@Then("^Unit Exam Center link should be present$")
	public void unit_Exam_Center_link_should_be_present() {
	   mindtapLPN = new MindTapLPNPage();
	   Assert.assertTrue("Unit Study Center link not displayed", mindtapLPN.isUSCLinkDisplayed());
	   logPassMessage("Unity Study Center link displayed successfully");
	   mindtapLPN.navigateToBaseLPN();
	}
}
