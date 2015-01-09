package com.gale.knewton.pageObjects;

import com.gale.knewton.base.BaseWebComponent;


public class AddActivityPanelPage extends BaseWebComponent {


	private String btn_simpleAssessment_xpath = "//div[text()='Simple Assessment']";
	private String btn_SAA_xpath = "//div[text()='SAA']";
	private String link_gDA_xpath = "//h3[@class='activityName' and text()='Assessment']";
	private String iframe_distinctActivity_id = "distinct_activity_create_frame";

	private String link_groveInlineActivity_xpath = "//h3[@class='activityName' and text()='Inline Assessment']";
	private String Link_examStudyCenter_xpath = "//h3[@class='activityName' and text()='Exam Study Center']";
	
	private String btn_toggle_xpath = "//button[@class='toggle']";
	private String btn_radioBtnPractice_xpath = "(//span[contains(text(),'Practice')])[1]/preceding-sibling::input";
	private String btn_radioBtnSAA_xpath = "(//span[contains(text(),'Knewton Management Assessment')])[1]/preceding-sibling::input";
	private String btn_radioBtnQuiz_xpath = "(//span[contains(text(),'Quiz')])[1]/preceding-sibling::input";
	private String btn_publish_xpath = "//button[contains(text(),'Publish')]";
	private String btn_cancelOnList_xpath = "(//*[contains(text(),'Cancel')])[1]";
	private String btn_cancelOnActivity_xpath = "(//*[contains(text(),'Cancel')])[2]";

	public void selectAssessment() {
		resetImplicitTimeout(10);
		findElementByXpath(link_gDA_xpath).click();
	}

	public void selectInlineAssessment() {
		findElementByXpath(link_groveInlineActivity_xpath).click();
	}
	
	public void selectExamStudyCenter() {
		hardWait(2);
		findElementByXpath(Link_examStudyCenter_xpath).click();
	}

	public String verifySACreationTypeForGroveActivity() {
		switchToFrame(findElementById(iframe_distinctActivity_id));
		String getSimpleAssessment = waitAndLocateElementByXpath(btn_simpleAssessment_xpath).getText();
		switchToDefaultContent();
		return getSimpleAssessment;
	}
	
	public String verifySAACreationTypeForGDA(){
		switchToFrame(findElementById(iframe_distinctActivity_id));
		String getSAA = waitAndLocateElementByXpath(btn_SAA_xpath).getText();
		switchToDefaultContent();
		return getSAA;
	}

	public void selectSimpleAssessment() {
		switchToFrame(findElementById(iframe_distinctActivity_id));
		findElementByXpath(btn_simpleAssessment_xpath).click();
	}
	
	public void selectSAA(){
		switchToFrame(findElementById(iframe_distinctActivity_id));
		findElementByXpath(btn_SAA_xpath).click();
	}

	public void expandAndSelectRadioForSimpleAssess() {
		findElementByXpath( btn_toggle_xpath).click();
		if(LoginPage.product.equals("Anderson"))
		findElementByXpath(btn_radioBtnPractice_xpath).click();
		else
			if(LoginPage.product.equals("Gulati"))
				findElementByXpath(btn_radioBtnQuiz_xpath).click();				
	}
	
	public void expandAndSelectRadioBtnForSAA(){
		findElementByXpath( btn_toggle_xpath).click();
		findElementByXpath(btn_radioBtnSAA_xpath).click();
	}

	public void clickPublish() {
		waitAndLocateElementByXpath(btn_publish_xpath).click();
		switchToDefaultContent();
	}
	
	public void clickCancelOnList(){
		findElementByXpath(btn_cancelOnList_xpath).click();
	}
	public void clickCancelOnActivity(){
		findElementByXpath(btn_cancelOnActivity_xpath).click();
	}
}
