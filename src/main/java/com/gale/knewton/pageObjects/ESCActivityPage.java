package com.gale.knewton.pageObjects;


import com.gale.knewton.base.BaseWebComponent;

public class ESCActivityPage extends BaseWebComponent {

private String frame_Esc_xpath = "//iframe[contains(@id,'NB_Main_IFrame')]";
private String EscError_xpath = "(//*[@class='line'])[2]//P[1]";
private String btn_closeIcon_class = "closeActivity";
private String btn_Next_Css = "input[value='Next']";
	
public boolean isESCErrorDisplayed(String error){
		hardWait(1);
		switchToFrame(findElementByXpath(frame_Esc_xpath));
		String errorinst = findElementByXpath(EscError_xpath).getText();
		return (error.equals(errorinst));
	}

public void closeActivity(){
	
	logMessage("Switch to default content");
	hardWait(1);
	switchToDefaultContent();
	hardWait(1);
	logMessage("Click close icon");
	fireOnClickJsEvent(btn_closeIcon_class);
}

public boolean isESCActivityDisplayedatStud(){
	hardWait(1);
	switchToFrame(findElementByClass(frame_Esc_xpath));
	hardWait(1);
	return findElementByCssPath(btn_Next_Css).isDisplayed();
}

}

