	package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.EbookDocumentPage;
import com.gale.knewton.pageObjects.MindTapLPNPage;
import com.gale.knewton.pageObjects.SimpleAssessmentActivityPage;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_launchAndSubmitInlineSA extends BaseWebComponent {

	private SimpleAssessmentActivityPage simpleAssessmentActivityPage;
	private EbookDocumentPage ebookDocumentPage;
	private MindTapLPNPage mindtaplpn;
		
	private boolean flag;
	private String product;
	
		
	@When("^I click start for the linked inline Simple Assessment activity$")
	public void i_click_start_for_the_linked_inline_Simple_Assessment_activity() throws Throwable {
		ebookDocumentPage = new EbookDocumentPage();
		Assert.assertTrue("Saved ESC Activity is not displaying on LPN",ebookDocumentPage.verifySimpleAssessmentOnEbook());
		logPassMessage("Inline Activity is verified on Ebook");
		ebookDocumentPage.clickInlineSA_Activity();
	}

	@Then("^I am on inline Simple Assessment activity page$")
	public void i_am_on_inline_Simple_Assessment_activity_overview_page() throws Throwable {
		simpleAssessmentActivityPage = new SimpleAssessmentActivityPage();
		flag = simpleAssessmentActivityPage.isInlineSimpleAssessmentLaunched();
		if(!flag){
			simpleAssessmentActivityPage.relaunchActivity();
			ebookDocumentPage.clickInlineSA_Activity();
			flag = simpleAssessmentActivityPage.isInlineSimpleAssessmentLaunched();
			}
		Assert.assertTrue("Activity not launched properly", flag);
		logPassMessage("Simple Assessment Activity launched successfully");
	}
	
	// ********************Submit Inline Simple Assessment Activity******************

	@When("^I click Start Activity and submit answer for a Question$")
	public void i_click_Start_Activity_and_submit_answer_for_a_Question() throws Throwable {
		simpleAssessmentActivityPage = new SimpleAssessmentActivityPage();
		simpleAssessmentActivityPage.selectOptionInline();
		logPassMessage("Activity started and one question selected");		
	}
	
	@And("^I click Check My Work button$")
	public void i_click_Check_My_Work_button(){
		simpleAssessmentActivityPage.checkMyWorkInline();
	}
	
	@Then("^Feedback section and Try Another button is displayed$")
	public void feedback_section_and_try_another_button_is_displayed(){
		product = PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath"));
		Assert.assertTrue("Feedback is not displayed",simpleAssessmentActivityPage.isInlineFeedbackDisplayed());
		logPassMessage("Feedback is displayed");
		if(product.equals("Andersen")){
		Assert.assertTrue("Try Another Version button is not displayed",
				simpleAssessmentActivityPage.isInlineTryAnotherVersionbtnDisplayed());
		logPassMessage("Try Another Version button is displayed");
		}
	}
	
	@And("^I submit inline Simple Assessment activity$")
	public void i_submit_inline_Simple_Assessment_activity() throws Throwable {
		simpleAssessmentActivityPage.clickReviewSubmitInline();
		simpleAssessmentActivityPage.GradeAssignmentButton();
		logPassMessage("Activity submitted Successfully");
	}
	
	@Then("^I am on Ebook Document Page$")
	public void i_am_on_ebook_document_page(){
		ebookDocumentPage = new EbookDocumentPage();
		mindtaplpn = new MindTapLPNPage();
		Assert.assertTrue("Not navigated to Ebook Document Page",ebookDocumentPage.isUserOnEbookDocumentPage());
		logPassMessage("Successfully navigated to ebook document page");
		ebookDocumentPage.closeEbook();
		mindtaplpn.navigateToBaseLPN();
	}
}
