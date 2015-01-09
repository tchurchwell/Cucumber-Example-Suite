package com.gale.knewton.pageObjects;

import com.gale.knewton.base.BaseWebComponent;

public class SAA_ActivityPage extends BaseWebComponent {

	private String grove_frame_css ="iframe[title='Assessments App']";
	private String frame2_Submit_id ="easyXDM_activityService_cxp_Target_provider";
	private String lbl_overview_xpath = "//div[text()='Overview']";
	private boolean flag = false;
	private String btn_startActivity_id = "rhs-actuallystart";
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
	
	
	public void relaunchSaaActivity(){
		refresh();
		switchToDefaultContent();
	}

}
