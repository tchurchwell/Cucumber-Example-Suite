package com.gale.knewton.pageObjects;


import com.gale.knewton.base.BaseWebComponent;

public class ESCActivityPage extends BaseWebComponent {

private String EscFrame_xpath = "(//iframe[@class='ereader_iframe'])[last()]";
private String EscError_xpath = "((//div[@class='line'])[2]//p)[1]";
private String btn_closeIcon_class = "closeActivity";
private String btn_Next_Css = "input[value='Next']";
	
public boolean isESCErrorDisplayed(String error){
		switchToFrame(findElementByXpath(EscFrame_xpath));
		hardWait(3);
		String errorinst = findElementByXpath(EscError_xpath).getText();
		return (error.equals(errorinst));
	}

public void closeActivity(){
	
	logMessage("Switch to default content");
	hardWait(1);
	switchToDefaultContent();
	logMessage("activity Bar Displayed");
	hardWait(1);
	logMessage("Click close icon");
	fireOnClickJsEvent(btn_closeIcon_class);
}

public boolean isESCActivityDisplayedatStud(){
	hardWait(3);
	switchToFrame(findElementByXpath(EscFrame_xpath));
	hardWait(1);
	return findElementByCssPath(btn_Next_Css).isDisplayed();
}

}

