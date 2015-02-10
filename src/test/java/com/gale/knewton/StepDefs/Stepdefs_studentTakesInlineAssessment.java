package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.MindTapLPNPage;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.en.And;

public class Stepdefs_studentTakesInlineAssessment extends BaseWebComponent{
	
	private MindTapLPNPage mindTAP;

	@And("^LPN score is displayed on Inline Simple Assessment activity link$")
	public void lpn_score_is_displayed_on_inline_simple_assessment_activity_link()
	{
		mindTAP = new MindTapLPNPage();
		mindTAP.expandInlineOnLPN();
		Assert.assertFalse("lpn score not displayed at Inline Simple Assessment activity link", mindTAP.getInlineSimpleAssessmentLpnScore().isEmpty());
		logPassMessage("lpn score displayed successfully at Inline Simple Assessment activity link");
		PropFileHandler.writeToFile("InlineSALpnScore", mindTAP.getInlineSimpleAssessmentLpnScore(), 
				   (YamlReader.getData("propertyfilepath")));
		mindTAP.navigateToBaseLPN();
	}
}
