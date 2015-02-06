package com.gale.knewton.pageObjects;

import com.gale.knewton.base.BaseWebComponent;

public class AssessmentActivityInformation extends BaseWebComponent {
	
	private String lbl_ActivityInformationTitle_xpath = "//h2[text()='Assessment Activity Information']";
	private String lbl_RecordedScore_css = "td.attempt_score.recorded_score>div>span";
	private String btn_Review_xpath = "//input[@type='button' and @value='Review']";
	
	public boolean isUserOnAssessmentActivityPage(){
		hardWait(1);
		return findElementByXpath(lbl_ActivityInformationTitle_xpath).isDisplayed();
	}
	
	public String getRecordedScore(){
		return findElementByCssPath(lbl_RecordedScore_css).getText();
	}
	
	public boolean isReviewButtonDisplayed()
	{
		return findElementByXpath(btn_Review_xpath).isDisplayed();
	}
	
	public void clickReviewButton(){
		findElementByXpath(btn_Review_xpath).click();
	}

}
