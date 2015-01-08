package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.AddActivityPanelPage;
import com.gale.knewton.pageObjects.ESCActivityPage;
import com.gale.knewton.pageObjects.EbookDocumentPage;
import com.gale.knewton.pageObjects.ExamStudyCenterConfigPage;
import com.gale.knewton.pageObjects.MindTapLPNPage;
import com.gale.knewton.pageObjects.SimpleAssessmentActivityPage;

import cucumber.api.java.en.Given;

public class Stepdefs_basePage extends BaseWebComponent {
	
	private MindTapLPNPage mindTapLPNPage;
	private AddActivityPanelPage addActivityPage;
	private ExamStudyCenterConfigPage escConfigPage;
	private SimpleAssessmentActivityPage simpleAssessmentActivityPage;
	private EbookDocumentPage eBookDocPage;
	private ESCActivityPage escPage;
	
	private String lbl_addActivityHeading_xpath = "//h1[text()='Add Activity']";
	private String lbl_GDAHeading_xpath = "//span[contains(text(),' Select Grove Distinct Activity')]";

	
	@Given("^I am on Add Activity List$")
	public void i_am_on_Add_Activity_List() {
		mindTapLPNPage = new MindTapLPNPage();
		Assert.assertTrue("MindTap LPN did not appear",mindTapLPNPage.getInstLPNDisplayed());
		mindTapLPNPage.clickAddActivitybutton();
		Assert.assertEquals("Add Activity list do not appear",findElementByXpath(lbl_addActivityHeading_xpath).getText(), "Add Activity");
		logPassMessage("I am on Add Activity List");
	}
	
	@Given("^I am on Exam Study Center configuration page$")
	public void i_am_on_Exam_Study_Centre_configuration_page() {
		String EscCenterHead;
		escConfigPage = new ExamStudyCenterConfigPage();
		EscCenterHead = escConfigPage.getExamStudyCenterHead();
		System.out.println(EscCenterHead);
		Assert.assertTrue("Exam Study Center Configuration page not displayed", (EscCenterHead).equals("Exam Study Center - Configuration"));
	}
	
	@Given("^I am on Select Grove Distinct Activity page$")
	public void i_am_on_Select_Grove_Distinct_Activity_page() {
		mindTapLPNPage = new MindTapLPNPage();
		Assert.assertTrue("MindTap LPN did not appear",mindTapLPNPage.getInstLPNDisplayed());
		logPassMessage("Mindtap LPN appeared");
		mindTapLPNPage.clickAddActivitybutton();
		Assert.assertEquals("Add Activity page do not appear","Add Activity",findElementByXpath(lbl_addActivityHeading_xpath).getText());
		logPassMessage("I am on Add Activity page");
		addActivityPage = new AddActivityPanelPage(); 
		addActivityPage.selectGroveDistinctActivity();
		Assert.assertEquals("Select Grove Distinct Activity page do not appear","Select Grove Distinct Activity",findElementByXpath(lbl_GDAHeading_xpath).getText());
	}
	
	@Given("^I should be on instructor's LPN page$")
	public void i_should_be_on_instructor_LPN_page() {
		mindTapLPNPage = new MindTapLPNPage();
		Assert.assertTrue("MindTap LPN did not appear",mindTapLPNPage.getInstLPNDisplayed());
	}
	
	@Given("^I am on instructor's LPN page$")
	public void i_am_on_instructor_LPN_page() {
		mindTapLPNPage = new MindTapLPNPage();
		Assert.assertTrue("LPN Page not displayed", mindTapLPNPage.isLPNDisplayedAtInstructor());
		logPassMessage("LPN page is displayed successfully");
	}
	
	@Given("^I should be on Student's LPN page$")
	public void i_should_be_on_studentLPN_page(){
		mindTapLPNPage = new MindTapLPNPage();
		Assert.assertTrue("Studentlbl_addActivityHeading_xpath LPN not displayed", mindTapLPNPage.getStudLPNDisplayed());
		logPassMessage("User is on Student LPN");	   
	}
	
	@Given("^I should be on Simple Assessment activity page$")
	public void i_should_be_on_Simple_Assessment_activity_page() throws Throwable {
		simpleAssessmentActivityPage = new SimpleAssessmentActivityPage();
		
		if(simpleAssessmentActivityPage.isSimpleAssessmentLaunched()){
	 	  logPassMessage("Simple Assessment activity page displayed successfully");
	}else{
		logWarningMessage("Simple Assessment activity page not displayed");
		mindTapLPNPage = new MindTapLPNPage();
		mindTapLPNPage.getInstLPNDisplayed();
		hardWait(1);
		mindTapLPNPage.clickDistinctSimpleAssessment_Activity();
		Assert.assertTrue("Simple Assessment activity page still not displayed",
				simpleAssessmentActivityPage.isSimpleAssessmentLaunched());
		logPassMessage("Simple Assessment activity page displayed successfully");
		}
	}
	
	@Given("^I should be on inline Simple Assessment activity page$")
	public void i_should_be_on_inline_Simple_Assessment_activity_overview_page() throws Throwable {
		simpleAssessmentActivityPage = new SimpleAssessmentActivityPage();
		
		if(simpleAssessmentActivityPage.isInlineSimpleAssessmentLaunched()){
	 	  logPassMessage("Simple Assessment(inline) activity page displayed successfully");
	} else 
		{
			logWarningMessage("Simple Assessment(inline) activity page not displayed");
			mindTapLPNPage = new MindTapLPNPage();
			mindTapLPNPage.navigateToEBookDocument();
			eBookDocPage = new EbookDocumentPage();
			Assert.assertTrue("User is not on the Ebook Document Page", eBookDocPage.isUserOnEbookDocumentPage());
			eBookDocPage.clickInlineSA_Activity();
			Assert.assertTrue("Simple Assessment(inline) activity page still not displayed", simpleAssessmentActivityPage.isSimpleAssessmentLaunched());
			logPassMessage("Simple Assessment(inline) activity page displayed successfully");
		}
	}
	
	@Given("^I should be on Exam Study Center page$")
	public void i_should_be_on_Exam_Study_Center_page() {
	 escPage = new ESCActivityPage();
	 Assert.assertTrue("Student is not on ESC activity page", escPage.isESCActivityDisplayedatStud());
	 logPassMessage("Student is on ESC activity page");
	   
	}

	
}
