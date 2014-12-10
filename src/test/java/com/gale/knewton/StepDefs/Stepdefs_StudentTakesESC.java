package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.ESCActivityPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_StudentTakesESC extends BaseWebComponent{
	private ESCActivityPage escActivity;
	
	//######### Student Launches ESC###########
	@Then("^I am on Exam Study Center page$")
	public void i_am_on_Exam_Study_Center_page() {
		escActivity = new ESCActivityPage();
	   Assert.assertTrue("ESC activity not displayed at student", escActivity.isESCActivityDisplayedatStud());
	   logPassMessage("ESC activity launched successfully at student");
	}
	
	//############## Student Submits ESC #################
	@Given("^I should be on Exam Study Center page$")
	public void i_should_be_on_Exam_Study_Center_page() throws Throwable {
	    
	}
	
	@When("^I answer one question$")
	public void i_answer_one_question() throws Throwable {
		escActivity = new ESCActivityPage();
		escActivity.navigateToQuestion();
	   
	}

	@When("^I click on Submit button$")
	public void i_click_on_Submit_button() throws Throwable {
	   	}




}
