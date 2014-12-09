package com.gale.knewton.StepDefs;


import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.MindTapLPNPage;
import cucumber.api.java.en.Then;

public class StepDefs_studentTakesDistinctSA extends BaseWebComponent {
	private MindTapLPNPage mindtapLPNPage;
		
	//****************Submit Distinct Simple Assessment from Student***********
	
	@Then("^I am on Student's LPN page$")
	public void i_am_on_students_LPN_page()
	{
		mindtapLPNPage = new MindTapLPNPage();
		Assert.assertTrue("Student LPN not displayed", mindtapLPNPage.isLPNDisplayedAtStudent());
		logPassMessage("User is on Student's LPN");
	}

}
