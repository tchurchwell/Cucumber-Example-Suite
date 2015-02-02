package com.gale.knewton.pageObjects;


import com.gale.knewton.base.BaseWebComponent;

public class EulaPage extends BaseWebComponent{
	
	private String div_EndUserLicense_xpath = "//*[@id='nb_eula']";
	private String btn_accept_css = ".adminButton.accept";
	private String link_mindTapEula_xpath = ".//*[@id='mindtap' and text()='MINDTAP SERVICE AGREEMENT']";
	private String link_KnewtonEula_xpath = ".//*[@id='knewton' and text()='KNEWTON SERVICE AGREEMENT']";
	private String lbl_MindTapEulaContent_css = ".eula.mindtap_eula>h3";
	private String lbl_KnewtonEulaContent_css = ".eula.knewton_eula>p>strong"; 
	private String btn_knewtonBack_id = "knewton_back_button";
	private String btn_MindtapBack_id = "mindtap_back_button";
	private String chk_Mindtap_class = "mindtap_select";
	private String chk_Knewton_class = "knewton_select";
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
	
		
	public boolean isEndUserLicensePageDisplayed(){
		resetImplicitTimeout(30);
		return waitAndLocateElementByXpath(div_EndUserLicense_xpath).isDisplayed();
	}
	
	public boolean isMindTapEulaDisplayed(){
		return waitAndLocateElementByXpath(link_mindTapEula_xpath).isDisplayed();
	}
	
	public void clickMinTapEula(){
		findElementByXpath(link_mindTapEula_xpath).click();
	}
	
	public boolean isKnewtonEulaDisplayed(){
		return waitAndLocateElementByXpath(link_KnewtonEula_xpath).isDisplayed();
	}
	
	public void clickKnewtonEula(){
		findElementByXpath(link_KnewtonEula_xpath).click();
	}
	
	public String mindTapEulaContent(){
		return findElementByCssPath(lbl_MindTapEulaContent_css).getText();
	}
	
	public String knewtonEulaContent(){
		return findElementByCssPath(lbl_KnewtonEulaContent_css).getText();
	}
	
	public void clickMindTapBackButton(){
		findElementById(btn_MindtapBack_id).click();
	}
	
	public void clickKnewtonBackButton(){
			findElementById(btn_knewtonBack_id).click();
	}
	
	public void clickEulaCheckboxes(){
		findElementByClass(chk_Mindtap_class).click();
		findElementByClass(chk_Knewton_class).click();
	}
	public void clickAcceptButton() {
		findElementByCssPath(btn_accept_css).click();
	}
	
	
}
