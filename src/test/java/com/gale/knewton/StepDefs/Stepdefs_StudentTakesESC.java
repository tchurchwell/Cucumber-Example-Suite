package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.ESCActivityPage;

import cucumber.api.java.en.Then;

public class Stepdefs_StudentTakesESC extends BaseWebComponent{
	private ESCActivityPage escActivity;
	
	//######### Student Launches ESC###########
	@Then("^I am on Exam Study Center page$")
	public void i_am_on_Exam_Study_Center_page() {
		escActivity = new ESCActivityPage();
	   Assert.assertTrue("ESC activity not displayed at student", escActivity.isESCActivityDisplayedatStud());
	   logPassMessage("ESC activity launched successfully at student");
	}
	

}
