package com.gale.knewton.pageObjects;


import com.gale.knewton.base.BaseWebComponent;

public class SimpleAssessmentActivityPage extends BaseWebComponent {

	private String practiceVideo_xpath = "//Video";
	private String feedback_xpath = "//div[text()='Feedback']";
	private String currentPoint_xpath = "//*[@class='current-points']";
	private String scoreEntry_xpath = "(//*[@class='score-wrapper']/span[1])[1]";
	private String tryAnotherVersion_xpath = "//input[@value='Try Another Version']";
	private String checkmywork = "//input[contains(@value,'Check My Work')]";
	private String frame1_Submit_class ="ereader_iframe";
	private String frame2_Submit_id ="easyXDM_activityService_cxp_Target_provider";
	private String frame2inline_Submit_class = "appFrame";
	private String frame1inline_Submit_class ="ereader_iframe";
	private String frame3inline_Submit_id ="easyXDM_activityService_cxp_Target_provider";
	private boolean flag = false;
	private String btn_startActivitySA_css= "#rhs-start";
	private String answer_option_xpath = "(//*[@class='q4-choice']//input)[1]";
	private String lbl_submit_xpath = "//button[text()='Review & Submit']";
	private String btn_submit_xpath = "//button[contains(.,'Grade Assignment Now')]";
	
		
	public boolean isSimpleAssessmentLaunched() {
		try
			{
				logMessage("Switch to Frame 1");
				switchToFrame(findElementByClass(frame1_Submit_class));
				logMessage("Switch to Frame 2");
				switchToFrame(findElementById(frame2_Submit_id));
				resetImplicitTimeout(20);
				flag = findElementByXpath(practiceVideo_xpath).isDisplayed();
				switchToDefaultContent();
			}
			catch(Exception e1){
				switchToDefaultContent();
				flag = false;
				}
		return flag;
	}
	
	public void relaunchActivity(){
		refresh();
		switchToDefaultContent();
	}
	
	public boolean isInlineSimpleAssessmentLaunched() {
		
		try{
		logMessage("Switch to Frame 1");
		switchToFrame(findElementByClass(frame1inline_Submit_class));
		logMessage("Switch to Frame 2");
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		logMessage("Switch to Frame 3");
		switchToFrame(findElementById(frame3inline_Submit_id));
		resetImplicitTimeout(20);
		flag = findElementByXpath(practiceVideo_xpath).isDisplayed();
		switchToDefaultContent();
		}
			catch(Exception e){
				switchToDefaultContent();
				flag = false;
			}
		return flag;
	}

	public void clickOnStartActivityforSA() {
		logMessage("Click on Start Activity");
		logMessage("frame Start 1");
		switchToFrame(findElementByClass(frame1_Submit_class));
		logMessage("frame start 2");
		switchToFrame(findElementById(frame2_Submit_id));
		findElementByCssPath(btn_startActivitySA_css).click();
		switchToDefaultContent();
	}

	public void selectOption() {
		logMessage("Select answer option");
		switchToFrame(findElementByClass(frame1_Submit_class));
		switchToFrame(findElementById(frame2_Submit_id));
		findElementByXpath(answer_option_xpath).click();
		switchToDefaultContent();
	}
	
	public void selectOptionInline() {
		logMessage("Select answer option");
		switchToFrame(findElementByClass(frame1inline_Submit_class));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		findElementByXpath(answer_option_xpath).click();
		switchToDefaultContent();
	}
	
	public void checkMyWork(){
		switchToFrame(findElementByClass(frame1_Submit_class));
		switchToFrame(findElementById(frame2_Submit_id));
		logMessage("Click Check My Work Button");
		findElementByXpath(checkmywork).click();
			}
	
	public void checkMyWorkInline(){
		switchToFrame(findElementByClass(frame1inline_Submit_class));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		logMessage("Click Check My Work Button");
		findElementByXpath(checkmywork).click();
	}
	
	public boolean isFeedbackDisplayed(){
	boolean flag=findElementByXpath(feedback_xpath).isDisplayed();
	if (flag)
		return true;
	else 
		return false;
	}
	
	public boolean isTryAnotherVersionbtnDisplayed(){
		boolean flag= findElementByXpath(tryAnotherVersion_xpath).isDisplayed();
		switchToDefaultContent();
		return flag;
	}
	
	public void submitSimpleAssessmentActivity() {
		switchToFrame(findElementByClass(frame1_Submit_class));
		switchToFrame(findElementById(frame2_Submit_id));
		hardWait(1);
		logMessage("Click Grade Assessment button");
		findElementByXpath(btn_submit_xpath).click();
		switchToDefaultContent();
		
	}
	
	public void clickReviewSubmitGDA(){
		logMessage("Click Review and Submit label");
		logMessage("Switch to Frame 1");
		switchToFrame(findElementByClass(frame1_Submit_class));
		logMessage("Switch to Frame 2");
		switchToFrame(findElementById(frame2_Submit_id));
		findElementByXpath(lbl_submit_xpath).click();
		switchToDefaultContent();
	}
	
	public void clickReviewSubmitInline(){ 
		logMessage("Click on Review and Submit link");
		hardWait(1);
		switchToFrame(findElementByClass(frame1inline_Submit_class));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		findElementByXpath(lbl_submit_xpath).click();
		switchToDefaultContent();
	}
	
	public boolean verifyGradesOnTable(){
		hardWait(5);  //Wait for score to appear
		switchToFrame(findElementByClass(frame1_Submit_class));
		hardWait(1);
		switchToFrame(findElementById(frame2_Submit_id));
		hardWait(1);
		String currentPoints =findElementByXpath(currentPoint_xpath).getText();
		System.out.println("currentPoints:"+ currentPoints);
		String ScoreEntry = findElementByXpath(scoreEntry_xpath).getText();
		System.out.println("ScoreEntry:"+ ScoreEntry);
		switchToDefaultContent();
		if (currentPoints.equals(ScoreEntry))
		{
			return true;
	}
		else return false;
	}
	
	public void GradeAssignmentButton(){
			logMessage("Click on Grade Assignment Button");
			logMessage("Switch to Frame 1");
			switchToFrame(findElementByClass(frame1inline_Submit_class));
			logMessage("Switch to Frame 2");
			switchToFrame(findElementByClass(frame2inline_Submit_class));
			logMessage("Switch to Frame 3");
			switchToFrame(findElementById(frame3inline_Submit_id));
			findElementByXpath(btn_submit_xpath).click();
			switchToDefaultContent();
	}
	

}
