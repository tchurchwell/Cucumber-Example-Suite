package com.gale.knewton.pageObjects;

import com.gale.knewton.base.BaseWebComponent;

public class ConfirmCourseInfoPage extends BaseWebComponent  {
	
	private String btn_continue_xpath="//a[text()='Continue']";
	private String lbl_confirmCourseInfo_xpath="//h1[text()='Confirm Course Information']";
	private String lbl_error_id = "error_div";
	private boolean flag = true;
	
	public boolean isOnCourseInfoPage() {
		try{
		findElementByXpath(lbl_confirmCourseInfo_xpath).isDisplayed();
		logPassMessage("\"Confirm Course Information\" page displayed successfully");
		}catch(Exception e){
			if(findElementById(lbl_error_id).isDisplayed()){
				logPassMessage("Error Appeared as: " + findElementById(lbl_error_id).getText());
				flag = false;
			}else{
				logPassMessage("Exception" + e);
				flag = false;
			}	
		}
		
		return flag;
	}
	
	public void clickContinue() {
		findElementByXpath(btn_continue_xpath).click();		
		}
}
