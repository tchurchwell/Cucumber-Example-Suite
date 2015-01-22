package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.ESCActivityPage;
import com.gale.knewton.pageObjects.MindTapLPNPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_launchUSC extends BaseWebComponent{

	private MindTapLPNPage mindtaplPN;
	private ESCActivityPage escActivity;
	
	@Given("^I should be on chapter LPN$")
	public void i_should_be_on_chapter_LPN() throws Throwable {
		mindtaplPN = new MindTapLPNPage();
		mindtaplPN.navigateToChapterLPN();
		Assert.assertTrue("Chapter LPN not displayed", mindtaplPN.isUSCDisplayed());
		logPassMessage("Chapter LPN displayed successfully");	  
	}
	
	@When("^I click on USC link$")
	public void i_click_on_USC_link() throws Throwable {
	   mindtaplPN.clickUSCActivity();
	}

	@Then("^I should be navigated to USC page and error message displayed as (.*)$")
	public void i_should_be_navigated_to_USC_page(String Error){
		escActivity = new ESCActivityPage();
		mindtaplPN = new MindTapLPNPage();
		Assert.assertTrue("Incorrect error message is displayed",escActivity.isErrorDisplayed(Error));
		logPassMessage("Error message is displayed successfully on ESC activity page");
		escActivity.closeActivity();
		mindtaplPN.navigateToBaseLPN();
		
	}
	
}
