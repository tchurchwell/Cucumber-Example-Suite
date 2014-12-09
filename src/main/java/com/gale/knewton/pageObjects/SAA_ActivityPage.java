package com.gale.knewton.pageObjects;

import com.gale.knewton.base.BaseWebComponent;

public class SAA_ActivityPage extends BaseWebComponent {

	private String lbl_overview_xpath = "html/body/div[1]/div[2]/div[1]/div[1]";
	private String frame1_Overview_id ="69_NB_Main_IFrame";
	private String frame2_Overview_id ="easyXDM_activityService_cxp_Target_provider";
	private boolean flag = false;
	private String btn_startActivity_css = "#rhs-actuallystart";
	private String radio_answer_xpath = "//input[@class='ci-input' and @value='2']";
	private String lbl_submit_xpath = "//div[@id='submit']";
	private String btn_submit_xpath = "//div[@id='rhs-finalsubmit']";
	
	public boolean isSAA_OverviewTabDisplayed() {
		hardWait(5);
		try{
		switchToFrame(findElementById(frame1_Overview_id));
		switchToFrame(findElementById(frame2_Overview_id));
		
		if(findElementByXpath(lbl_overview_xpath).isDisplayed()){
			flag=true;
		}
		switchToDefaultContent();
		}catch(Exception e){
			flag=false;
		}
		return flag;
	}
	
	
	public void clickStartActivity(){
		logMessage("Click on Start Activity");
		switchToFrame(findElementById(frame1_Overview_id));
		switchToFrame(findElementById(frame2_Overview_id));
		findElementByCssPath(btn_startActivity_css).click();
		switchToDefaultContent();
	}
	
	
	public void selectRadioBtn(){
		logMessage("Select radio button for Question one");
		hardWait(1);
		switchToFrame(findElementById(frame1_Overview_id));
		switchToFrame(findElementById(frame2_Overview_id));
		findElementByXpath(radio_answer_xpath).click();
		switchToDefaultContent();
	}
	
	
	public void submitSAAActivity(){
		logMessage("Submit SAA Activity");
		hardWait(1);
		switchToFrame(findElementById(frame1_Overview_id));
		switchToFrame(findElementById(frame2_Overview_id));
		hardWait(1);
		findElementByXpath(lbl_submit_xpath).click();
		findElementByXpath(btn_submit_xpath).click();
		switchToDefaultContent();
	}

}
