package com.gale.knewton.pageObjects;

import com.gale.knewton.base.BaseWebComponent;


public class AddActivityPanelPage extends BaseWebComponent {


	private String btn_simpleAssessment_xpath = "//div[text()='Simple Assessment']";
	private String link_gDA_xpath = "//h3[@class='activityName' and text()='Grove Distinct Activity']";
	private String iframe_distinctActivity_id = "distinct_activity_create_frame";

	private String link_groveInlineActivity_xpath = "//h3[@class='activityName' and text()='Grove Inline Activity']";
	private String Link_examStudyCenter_xpath = "//h3[@class='activityName' and text()='Exam Study Center']";
	
	private String btn_toggle_xpath = "//button[@class='toggle']";
	private String btn_radioBtnQuiz_xpath = " (//span[contains(text(),'Practice')])[1]/preceding-sibling::input";
	private String btn_publish_xpath = "//button[contains(text(),'Publish')]";
	private String btn_cancelOnList_xpath = "(//*[contains(text(),'Cancel')])[1]";
	private String btn_cancelOnActivity_xpath = "(//*[contains(text(),'Cancel')])[2]";

	public void selectGrooveDistinctActivity() {
		resetImplicitTimeout(10);
		findElementByXpath(link_gDA_xpath).click();
	}

	public void selectGrooveInlineActivity() {
		findElementByXpath(link_groveInlineActivity_xpath).click();
	}
	
	public void selectExamStudyCenter() {
		hardWait(2);
		findElementByXpath(Link_examStudyCenter_xpath).click();
	}

	public String verifyCreationTypeForGroveActivity() {
		switchToFrame(findElementById(iframe_distinctActivity_id));
		hardWait(1);
		String getSimpleAssessment = findElementByXpath(btn_simpleAssessment_xpath).getText();
		switchToDefaultContent();
		return getSimpleAssessment;
	}

	public void selectSimpleAssessment() {
		switchToFrame(findElementById(iframe_distinctActivity_id));
		findElementByXpath(btn_simpleAssessment_xpath).click();
	}

	public void expandAndSelectRadioForSimpleAssess() {
		findElementByXpath( btn_toggle_xpath).click();
		findElementByXpath(btn_radioBtnQuiz_xpath).click();
	}

	public void clickPublish() {
		findElementByXpath(btn_publish_xpath).click();
		switchToDefaultContent();
	}
	
	public void clickCancelOnList(){
		findElementByXpath(btn_cancelOnList_xpath).click();
	}
	public void clickCancelOnActivity(){
		findElementByXpath(btn_cancelOnActivity_xpath).click();
	}
}
