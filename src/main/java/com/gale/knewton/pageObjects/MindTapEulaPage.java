package com.gale.knewton.pageObjects;


import com.gale.knewton.base.BaseWebComponent;

public class MindTapEulaPage extends BaseWebComponent{
	
	private String div_eula_xpath = "//*[@class='eula']";
	private String btn_accept_css = ".adminButton.accept";
	private boolean flag = false;
	private String currentPageUrl;
	
	public boolean isOnMindTapWindow(){
		
		currentPageUrl = getCurrentURL();
		System.out.println(currentPageUrl);
		
		if(currentPageUrl.contains("ng.cengage.com")){
			flag= true;
		}
		return flag;
	}
	
	public boolean isEulaDisplayed(){
		logMessage("verify eula page");
		return waitAndLocateElementByXpath(div_eula_xpath).isDisplayed();
	}
	
	public void clickAcceptButton() {
		hardWait(1);
		logMessage("Click on accept button");
		findElementByCssPath(btn_accept_css).click();
	}
	
	
}
