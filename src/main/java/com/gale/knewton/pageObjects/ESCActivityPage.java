package com.gale.knewton.pageObjects;


import org.openqa.selenium.JavascriptExecutor;

import com.gale.knewton.base.BaseWebComponent;

public class ESCActivityPage extends BaseWebComponent {

private JavascriptExecutor js;	
	
private String EscFrame_id1 = "104_NB_Main_IFrame";
private String EscFrame_id2 = "easyXDM_activityService_cxp_target_provider";
private String EscError_xpath = "(//*[@class='line'])[2]//P";

	
public boolean isESCErrorDisplayed(String error){
		switchToFrame(findElementById(EscFrame_id1));
		String errorinst = findElementByXpath(EscError_xpath).getText();
		return (error.equals(errorinst));
	}

public void closeActivity(){
	
	js = (JavascriptExecutor) driver;
	logMessage("Switch to default content");
	hardWait(3);
	switchToDefaultContent();
	logMessage("activity Bar Displayed");
	hardWait(5);
	logMessage("Click close icon");
	js.executeScript(""
            + "var elem = document.getElementsByClassName('closeActivity')[0];"
                + "if( document.createEvent ) { "
                + "   var evObj = document.createEvent('MouseEvents');" 
            + "    evObj.initEvent( 'click', true, false );" 
            + "   elem.dispatchEvent(evObj);" 
            + "} else if( document.createEventObject ) {"
                + "    elem.fireEvent('onclick');"
                + "}" 
            + "" );
	logMessage("Click close icon completed");
}

public boolean isESCActivityDisplayedatStud(){
	hardWait(1);
	switchToFrame(findElementById(EscFrame_id1));
	hardWait(1);
	return findElementByCssPath(btn_Next_Css).isDisplayed();
}


}

