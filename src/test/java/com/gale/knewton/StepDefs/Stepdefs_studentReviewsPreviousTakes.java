package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.AssessmentActivityInformation;
import com.gale.knewton.pageObjects.EbookDocumentPage;
import com.gale.knewton.pageObjects.MindTapLPNPage;
import com.gale.knewton.pageObjects.SAA_ActivityPage;
import com.gale.knewton.pageObjects.SimpleAssessmentActivityPage;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_studentReviewsPreviousTakes extends BaseWebComponent {
	
	private MindTapLPNPage mindTAP;
	private AssessmentActivityInformation activityInfo;
	private SimpleAssessmentActivityPage SAactivity;
	private SAA_ActivityPage saaActivity;
	private EbookDocumentPage ebookReader;
	
//******************______Student_Reviews_previous_Simple_Assessment_Take______***************************** 

	@Given("^Attempted Simple Assessment activity is present on LPN$")
	public void attempted_Simple_Assessment_activity_is_present_on_LPN() {
	   mindTAP = new MindTapLPNPage();
	   Assert.assertTrue("Distinct Simple Assessment activity not attempted", mindTAP.isDistinctSAattempted());
	   logPassMessage("Attempted distinct Simple Assessment activity is present on LPN ");
	}

	@When("^I click on attempted Simple Assessment activity$")
	public void i_click_on_attempted_Simple_Assessment_activity() {
		mindTAP = new MindTapLPNPage();
		mindTAP.clickDistinctSimpleAssessment_Activity();	   
	}

	@Then("^I am on Assessment Activity Information page$")
	public void i_am_on_Assessment_Activity_Information_page() {
	   activityInfo = new AssessmentActivityInformation();
	   Assert.assertTrue("Assessment Activity Information page not displayed", 
			   activityInfo.isUserOnAssessmentActivityPage());
	   logPassMessage("Assessment Activity Information page launched successfully");
	}

	@Then("^Recorded Score is displayed same as score on LPN's Simple Assessment activity link$")
	public void recorded_Score_is_displayed_same_as_score_on_LPN_s_activity_link() {
	  activityInfo = new AssessmentActivityInformation();
	  String SALpnScore = PropFileHandler.readProperty("SALpnScore", (YamlReader.getData("propertyfilepath")));
	  Assert.assertEquals("Recorded Score is not same as LPN score", SALpnScore, activityInfo.getRecordedScore());
	  logPassMessage("Recorded score equals LPN score");
	}

	@Then("^Review button is displayed$")
	public void review_button_is_displayed() {
		activityInfo = new AssessmentActivityInformation();
		Assert.assertTrue("Review button not displayed", activityInfo.isReviewButtonDisplayed());
	    logPassMessage("Review button displayed successfully");
	}

	@When("^I click on Review button$")
	public void i_click_on_Review_button() {
		activityInfo = new AssessmentActivityInformation();
	    activityInfo.clickReviewButton();
	}

	@Then("^Attempted Simple Assessment activity is displayed$")
	public void attempted_activity_is_displayed() {
		SAactivity = new SimpleAssessmentActivityPage();
		Assert.assertTrue("Attempted Simple Assessment activity not displayed", SAactivity.isFeedbackDisplayed());
		logPassMessage("Attempted Simple Assessment activity displayed successfully");
		SAactivity.closeSAActivity();
	   }
	

	//******************______Student_Reviews_previous_SAA_Take______***************************** 
	
	@Given("^Attempted SAA activity is present on LPN$")
	public void attempted_SAA_activity_is_present_on_LPN() {
	   mindTAP = new MindTapLPNPage();
	   Assert.assertTrue("Distinct Simple Assessment activity not attempted", mindTAP.isSAAattempted());
	   logPassMessage("Attempted distinct Simple Assessment activity is present on LPN ");
	}
	
	@Then("^Recorded Score is displayed same as score on LPN's SAA activity link$")
	public void recorded_Score_is_displayed_same_as_score_on_LPN_saa_activity_link() {
	  activityInfo = new AssessmentActivityInformation();
	  String SAALpnScore = PropFileHandler.readProperty("SAALpnScore", (YamlReader.getData("propertyfilepath")));
	  Assert.assertEquals("Recorded Score is not same as LPN score", SAALpnScore, activityInfo.getRecordedScore());
	  logPassMessage("Recorded score equals LPN score");
	}
	
	@When("^I click on attempted SAA activity$")
	public void i_click_on_attempted_SAA_activity() {
		mindTAP = new MindTapLPNPage();
		mindTAP.clickAttemptedSAAactivity();	   
	}
	
	@Then("^Attempted SAA activity is displayed$")
	public void attempted_SAA_activity_is_displayed() {
		saaActivity = new SAA_ActivityPage();
		Assert.assertTrue("Attempted SAA activity not displayed", saaActivity.isAttemptedSAADisplayed());
		logPassMessage("Attempted SAA activity displayed successfully");
		saaActivity.closeSAAactivity();
	   }
	
//******************______Student_Reviews_previous_Inline_Simple_Assessment_Take______***************************** 		

	@Given("^Attempted Inline Simple Assessment activity is present on LPN$")
	public void attempted_inline_simple_assessment_activity_is_present_on_LPN() {
	   mindTAP = new MindTapLPNPage();
	   Assert.assertTrue("Inline Simple Assessment activity not attempted", mindTAP.isInlineSAattempted());
	   logPassMessage("Attempted Inline Simple Assessment activity is present on Chapter LPN ");
	   PropFileHandler.writeToFile("LpnScore",mindTAP.getInlineSimpleAssessmentLpnScore(), 
			   (YamlReader.getData("propertyfilepath")));
	}
	
	@Then("^Recorded Score is displayed same as score on LPN's Inline Simple Assessment activity link$")
	public void recorded_Score_is_displayed_same_as_score_on_LPN_inline_activity_link() {
	  activityInfo = new AssessmentActivityInformation();
	  String InlineSALpnScore = PropFileHandler.readProperty("InlineSALpnScore", (YamlReader.getData("propertyfilepath")));
	  Assert.assertEquals("Recorded Score is not same as LPN score", InlineSALpnScore, activityInfo.getRecordedScore());
	  logPassMessage("Recorded score equals LPN score");
	}
	
	@When("^I click on attempted Inline Simple Assessment activity$")
	public void i_click_on_attempted_inline_simple_assessment_activity() {
		mindTAP = new MindTapLPNPage();
		mindTAP.clickAttemptedInlineSAactivity();	   
	}
	
	@Then("^Attempted Inline Simple Assessment activity is displayed$")
	public void attempted_inline_simple_assessment_activity_is_displayed() {
		SAactivity = new SimpleAssessmentActivityPage();
		ebookReader = new EbookDocumentPage();
		Assert.assertTrue("Attempted Inline Simple Assessment activity not displayed", SAactivity.isAttemptedFeedbackDisplayed());
		logPassMessage("Attempted Inline Simple Assessment activity displayed successfully");
		SAactivity.closeSAActivity();
		ebookReader.closeEbook();
		mindTAP.navigateToBaseLPN();
		
	   }

}
