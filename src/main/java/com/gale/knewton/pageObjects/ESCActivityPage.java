package com.gale.knewton.pageObjects;


import com.gale.knewton.base.BaseWebComponent;

public class ESCActivityPage extends BaseWebComponent {

private String frame_Esc_css = "iframe[title='Adaptive App App']";
private String EscError_xpath = "//*[@class='ng-binding']";
private String btn_closeIcon_class = "closeActivity";
private String btn_Next_Css = "input[value='Next']";
	
	public boolean isESCErrorDisplayed(String error){
		hardWait(1);
		switchToFrame(findElementByCssPath(frame_Esc_css));
		String errorinst = waitAndLocateElementByXpath(EscError_xpath).getText();
		switchToDefaultContent();
		return (error.equals(errorinst));
	}
	
	public void closeActivity(){
		hardWait(1);
		logMessage("Click close icon");
		fireOnClickJsEvent(btn_closeIcon_class);
		switchToDefaultContent();	
	}
	
	public boolean isESCActivityDisplayedatStud(){
		hardWait(1);
		switchToFrame(findElementByCssPath(frame_Esc_css));
		hardWait(1);
		return findElementByCssPath(btn_Next_Css).isDisplayed();
	}

}

