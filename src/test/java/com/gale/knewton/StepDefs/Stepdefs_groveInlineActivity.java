package com.gale.knewton.StepDefs;

import java.io.IOException;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.AddActivityPanelPage;
import com.gale.knewton.pageObjects.EbookDocumentPage;
import com.gale.knewton.pageObjects.MindTapDescriptionPage;
import com.gale.knewton.pageObjects.MindTapLPNPage;

import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_groveInlineActivity extends BaseWebComponent {
	
	private MindTapLPNPage mindTapLPNPage;
	private EbookDocumentPage eBookDocPage;
	private AddActivityPanelPage addActivityPage;	
	private MindTapDescriptionPage mindTapDescriptionPage;
	
	private boolean flag=false;
	
	//********************** CREATE INILINE ACTIVITY *********************
	
	@And("^I Navigate to the First Ebook Document")
	public void navigate_To_EBookDocument(){
		mindTapLPNPage = new MindTapLPNPage();
		mindTapLPNPage.navigateToEBookDocument();
		eBookDocPage = new EbookDocumentPage();
		flag = eBookDocPage.isUserOnEbookDocumentPage();
		if(!flag){
			refresh();
			flag = eBookDocPage.isUserOnEbookDocumentPage();
		}
		Assert.assertTrue("User is not on the Ebook Document Page", flag);
		logPassMessage("User is successfully navigated to Ebook page");
	}
	
	@And("^I enter the Edit Mode to reach Add Activity Panel")
	public void enter_into_Edit_Mode_And_Open_Add_Activity_Panel(){
		eBookDocPage.openActivityPanelByEditMode();
	}
	
	@Then("^select Grove Inline Activity from the Activity list$")
	public void select_Grove_Distinct_Activity_from_the_list() {
		addActivityPage = new AddActivityPanelPage();
		addActivityPage.selectGrooveInlineActivity();
	}
	
	@Then("^verify creation type display as \"(.*?)\"$")
	public void verify_creation_type_display_as_and(String actType) {
		Assert.assertTrue("Creation type '"+actType+"' is not displayed", addActivityPage.verifyCreationTypeForGroveActivity().equals(actType));
		logPassMessage(actType + " is displaying as creation type for Grove Inline Activity");		
	}
	
	
	@When("^I save inline Simple Assessment activity with default options$")
	public void i_save_distinct_Simple_Assessment_activity_with_default_options() throws IOException {
		mindTapDescriptionPage = new MindTapDescriptionPage();
		mindTapDescriptionPage.enterinlineSimpAssessTitle();
		mindTapDescriptionPage.clickSaveButton();
	}
	
	@Then("^verify created Simple Assessment activity should linked to the Ebook Document$")
	public void verify_created_Simple_Assessment_activity_on_Ebook() {
		eBookDocPage.verifySimpleAssessmentOnEbook(); 
		eBookDocPage.closeEbook();
		mindTapLPNPage.navigateToBaseLPN();
	}
	
}
