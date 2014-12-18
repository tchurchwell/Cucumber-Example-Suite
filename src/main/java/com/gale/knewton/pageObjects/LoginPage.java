package com.gale.knewton.pageObjects;


import org.openqa.selenium.By;

import com.gale.knewton.base.BaseWebComponent;

public class LoginPage extends BaseWebComponent{
	
	private String inp_userName_id = "emailId";
	private String inp_password_id = "password";
	private String btn_Submit_css = "#loginFormId>input[type='submit']";
	
	public void login(String userName, String password){
		findElementById(inp_userName_id).clear();
		findElementById(inp_password_id).clear();
		findElementById(inp_userName_id).sendKeys(userName);
		findElementById(inp_password_id).sendKeys(password);
		findElementByCssPath(btn_Submit_css).click();
	}
	
	public boolean isUserOnLoginPage(){
		resetImplicitTimeout(5);
		try{
			return driver.findElement(By.id(inp_userName_id)).isDisplayed();
		}
		catch(Exception e){
			return false;
		}
	}
	
	public void LaunchLoginpage(){
		if(isUserOnLoginPage())
			logPassMessage("User is on Login page");
		else{
			logMessage("Navigate to base url");
			NavigateToBaseUrl();
		}
	}
	
}
