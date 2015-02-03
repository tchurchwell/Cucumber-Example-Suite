package com.gale.knewton.pageObjects;

import com.gale.knewton.base.BaseWebComponent;

public class UscActivityPage extends BaseWebComponent{
	
	private String lbl_USCheading_xpath = ".//div[@class='nb_actTitle nb_math' and contains(text(),'Study Center')]";
	private String btn_closeIcon_class = "closeActivity";
	
	public boolean isUSCactivityDisplayed(){
		return findElementByXpath(lbl_USCheading_xpath).isDisplayed();
	}
	
	public void closeUSCActivity(){
		hardWait(1);
		logMessage("Click close icon");
		fireOnClickJsEvent(btn_closeIcon_class);
		switchToDefaultContent();	
	}
	
}