package com.gale.knewton.StepDefs;

import java.io.IOException;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.AddActivityPanelPage;
import com.gale.knewton.pageObjects.ExamStudyCenterConfigPage;
import com.gale.knewton.pageObjects.MindTapDescriptionPage;
import com.gale.knewton.pageObjects.MindTapLPNPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_examStudyCenter extends BaseWebComponent {
	
	private AddActivityPanelPage addActivityPage;
	private MindTapDescriptionPage mindTapDescPage;
	private MindTapLPNPage mindTapLPNPage;
	
	private ExamStudyCenterConfigPage escConfigPage = new ExamStudyCenterConfigPage();
	
	String heading;
	
	//**********Access Exam Study Center Configurations page**********
	
	@When("^I click Exam Study Center from Activities list$")
	public void i_click_Exam_Study_Center_from_Activities_list() {
		addActivityPage = new AddActivityPanelPage();
		addActivityPage.selectExamStudyCenter();
	}

	//**********Save ESC after filling required details and verify its link on LPN********
	
	@When("^I save ESC activity after completing required details on Config page and following MindTap Description page$")
	public void i_enter_required_details_and_following_MindTap_Description_page_and_save() throws IOException {
	    escConfigPage.enterExamDueDate();
	    escConfigPage.selectChapterCheckbox();
	    escConfigPage.clickSave();
	    
	    mindTapDescPage = new MindTapDescriptionPage();
		mindTapDescPage.enterESCTitle();
		mindTapDescPage.reorderActivity();
		mindTapDescPage.clickSaveButton();
	}

	@Then("^created ESC should be linked to LPN$")
	public void created_ESC_should_be_linked_to_LPN() {
		mindTapLPNPage = new MindTapLPNPage();
		Assert.assertTrue("Published Exam Study Center is not displayed on LPN ",mindTapLPNPage.verifySavedESCActivityOnLPN());
		logPassMessage("ESC Activity is verified on LPN as distinct activity");
	}
	
}
