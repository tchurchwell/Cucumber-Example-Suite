package com.gale.knewton.StepDefs;


import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.MindTapLPNPage;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Stepdefs_studentTakesAssessment extends BaseWebComponent {
	private MindTapLPNPage mindtapLPNPage;
		
	@Then("^I am on Student's LPN page$")
	public void i_am_on_students_LPN_page()
	{
		mindtapLPNPage = new MindTapLPNPage();
		Assert.assertTrue("Student LPN not displayed", mindtapLPNPage.isLPNDisplayedAtStudent());
		logPassMessage("User is on Student's LPN");
	}
	
	@And("^LPN score is displayed on Simple Assessment activity link$")
	public void lpn_score_is_displayed_on_simple_assessment_activity_link()
	{
		mindtapLPNPage = new MindTapLPNPage();
		Assert.assertFalse("lpn score not displayed at Simple Assessment activity link", mindtapLPNPage.getDistinctSimpleAssessmentLpnScore().isEmpty());
		logPassMessage("lpn score displayed successfully at Simple Assessment activity link");
		PropFileHandler.writeToFile("SALpnScore", mindtapLPNPage.getDistinctSimpleAssessmentLpnScore(), 
				   (YamlReader.getData("propertyfilepath")));
	}
	
	@And("^LPN score is displayed on SAA activity link$")
	public void lpn_score_is_displayed_on_saa_activity_link()
	{
		mindtapLPNPage = new MindTapLPNPage();
		Assert.assertFalse("lpn score not displayed at SAA activity link", mindtapLPNPage.getSAALpnScore().isEmpty());
		logPassMessage("lpn score displayed successfully at SAA activity link");
		PropFileHandler.writeToFile("SAALpnScore", mindtapLPNPage.getSAALpnScore(), 
				   (YamlReader.getData("propertyfilepath")));
	}
	
	

}
