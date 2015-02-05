package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.AssessmentActivityInformation;
import com.gale.knewton.pageObjects.MindTapLPNPage;
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

	//******************______Student_Reviews_previous_Simple_Assessment_Take______***************************** 

		@Given("^Attempted Simple Assessment activity is present on LPN$")
		public void attempted_Simple_Assessment_activity_is_present_on_LPN() {
		   mindTAP = new MindTapLPNPage();
		   Assert.assertTrue("Distinct Simple Assessment activity not attempted", mindTAP.isDistinctSAattempted());
		   logPassMessage("Attempted distinct Simple Assessment activity is present on LPN ");
		   PropFileHandler.writeToFile("LpnScore", mindTAP.getDistinctSimpleAssessmentLpnScore(), 
				   (YamlReader.getData("propertyfilepath")));
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

		@Then("^Recorded Score is displayed same as score on LPN's activity link$")
		public void recorded_Score_is_displayed_same_as_score_on_LPN_s_activity_link() {
		  activityInfo = new AssessmentActivityInformation();
		  String LpnScore = PropFileHandler.readProperty("LpnScore", (YamlReader.getData("propertyfilepath")));
		  Assert.assertEquals("Recorded Score is not same as LPN score", LpnScore, activityInfo.getRecordedScore());
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


}
