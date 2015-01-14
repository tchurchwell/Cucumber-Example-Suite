package com.gale.knewton.pageObjects;

import com.gale.knewton.base.BaseWebComponent;

public class SAA_ActivityPage extends BaseWebComponent {

	private String grove_frame_css ="iframe[title='Assessments App']";
	private String frame2_Submit_id ="easyXDM_activityService_cxp_Target_provider";
	private String lbl_overview_xpath = "//div[text()='Overview']";
	private boolean flag = false;
	private String btn_startActivity_xpath = "//*[@id='rhs-actuallystart']";
	private String radio_answer_xpath = "//input[@class='ci-input' and @value='2']";
	private String icon_Cross_xpath = radio_answer_xpath+"/ancestor::div[1]/span[2]/span";
	private String lbl_Feedback_css = ".ci-feedback-title";
	private String btn_SubmitAnswer_xpath = "//div[text()='Submit Answer']";
	private String lbl_Submit_xpath = ".//*[@id='submit']/div";
	private String btn_Submit_id = "rhs-finalsubmit";
	private String lbl_scoreIndicator_css = ".scoreIndicator";
	private String lbl_CurrentPoints_id = "lhs-current-points";
	private String lbl_PossiblePoints_id = "lhs-possible-score";
	
	public boolean isSAA_OverviewTabDisplayed() {
		try
		{
			hardWait(1);
			switchToFrame(findElementByCssPath(grove_frame_css));
			hardWait(1);
			switchToFrame(findElementById(frame2_Submit_id));
			flag = findElementByXpath(lbl_overview_xpath).isDisplayed();
			switchToDefaultContent();
		}
		catch(Exception e1){
			switchToDefaultContent();
			flag = false;
			}
	return flag;
	}
	
	
	public void clickStartActivity(){
		logMessage("Click on Start Activity");
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementById(frame2_Submit_id));
		waitAndLocateElementByXpath(btn_startActivity_xpath).click();
		switchToDefaultContent();
	}
	
	public void selectRadioBtn(){
		logMessage("Select radio button for Question one");
		hardWait(1);
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementById(frame2_Submit_id));
		findElementByXpath(radio_answer_xpath).click();
		switchToDefaultContent();
	}
	
	
	public void submitSaaQuestion(){
		logMessage("Submit SAA question");
		hardWait(1);
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementById(frame2_Submit_id));
		hardWait(1);
		findElementByXpath(btn_SubmitAnswer_xpath).click();
		switchToDefaultContent();
	}
	
	public boolean verifySAAfeedback(){
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementById(frame2_Submit_id));
		String cross_icon = findElementByXpath(icon_Cross_xpath).getAttribute("rejoinder");
		cross_icon = cross_icon.substring(0,cross_icon.length()-1);
		String feedback = findElementByCssPath(lbl_Feedback_css).getText();
		if(feedback.equals(cross_icon)){
			logPassMessage("feedback displayed as: "+feedback);
			switchToDefaultContent();
			return true;
		}
		else{
			switchToDefaultContent();
			return false;
		}
	}
	
	public void clickSubmitLabelSaa(){
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementById(frame2_Submit_id));
		scrollDown(findElementByXpath(lbl_Submit_xpath));
		findElementByXpath(lbl_Submit_xpath).click();		
	}
	
	public boolean verifySaaGrades(){
		String currentScore = findElementByCssPath(lbl_scoreIndicator_css).getText();
		String[] current = currentScore.substring(15).split(" ");
		currentScore = current[0];
		logMessage("Current Score is: "+currentScore);
		String score = findElementById(lbl_CurrentPoints_id).getText();
		score = score+"/"+findElementById(lbl_PossiblePoints_id).getText();
		if(currentScore.equals(score))
			return true;
		else
			return false;		
	}
	
	public void submitSAA(){
		findElementById(btn_Submit_id).click();
		switchToDefaultContent();
	}
	
	public void relaunchSaaActivity(){
		refresh();
		switchToDefaultContent();
	}

}
