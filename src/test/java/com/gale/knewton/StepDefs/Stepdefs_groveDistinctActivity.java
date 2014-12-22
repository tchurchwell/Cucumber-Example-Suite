package com.gale.knewton.StepDefs;

import java.io.IOException;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.AddActivityPanelPage;
import com.gale.knewton.pageObjects.MindTapDescriptionPage;
import com.gale.knewton.pageObjects.MindTapLPNPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_groveDistinctActivity extends BaseWebComponent {
	
	private AddActivityPanelPage addActivityPage = new AddActivityPanelPage();
	private MindTapDescriptionPage mindTapDescriptionPage = new MindTapDescriptionPage();
	private MindTapLPNPage mindTapLPNPage = new MindTapLPNPage();

	@Then("^I select Grove Distinct Activity from the list$")
	public void I_select_Grove_Distinct_Activity_from_the_list() {
		addActivityPage.selectGroveDistinctActivity();
	}
	
	@Then("^Creation type display as \"(.*?)\"$")
	public void verify_the_creation_type_On_Grove_Activity(String actType) {
		Assert.assertTrue("Creation type '"+actType+"' is not displayed", addActivityPage.verifyCreationTypeForGroveActivity().equals(actType));
		logPassMessage(actType + " is displaying as creation type for Grove Distinct Activity");		

	}
	
	
	//****************Link SAA Distinct Activity*****************
	

	@When("^I save the activity with default options$")
	public void save_the_activity_with_default_options() throws IOException {
		mindTapDescriptionPage = new MindTapDescriptionPage();
		mindTapDescriptionPage.enterSaaActivityTitle();
		mindTapDescriptionPage.clickSaveButton();
	}

	
	//*******************Link Simple Assessment********************
	
	
	@When("^I select Simple Assessment as creation type$")
	public void i_select_Simple_Assessment_as_creation_type() {
		addActivityPage = new AddActivityPanelPage();
		addActivityPage.selectSimpleAssessment();
	}
	@When("^I publish first practice Simple Assessment activity$")
	public void I_Publish_First_Practice_SA_Activity() {
		addActivityPage.expandAndSelectRadioForSimpleAssess();
		addActivityPage.clickPublish();
	}

	@When("^I save distinct Simple Assessment activity with default options$")
	public void i_save_distinct_Simple_Assessment_activity_with_default_options() throws IOException {
		mindTapDescriptionPage.enterSimpAssessTitle();
		mindTapDescriptionPage.reorderActivity();
		mindTapDescriptionPage.clickSaveButton();
	}

	@Then("^verify created Simple Assessment activity should linked to LPN$")
	public void verify_created_Simple_Assessment_activity_should_linked_to_LPN() {
		Assert.assertTrue("Simple Assessment is not Published to LPN", mindTapLPNPage.verifySavedSimpleAssessmentOnLPN());
		logPassMessage("Published Simple Assessment is correctly displayed on LPN");
	}
	
}
