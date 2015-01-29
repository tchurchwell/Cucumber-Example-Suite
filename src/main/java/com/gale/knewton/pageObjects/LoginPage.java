package com.gale.knewton.pageObjects;


import org.openqa.selenium.By;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class LoginPage extends BaseWebComponent{
	
	private String inp_userName_id = "emailId";
	private String inp_password_id = "password";
	private String btn_Submit_css = "#loginFormId>input[type='submit']";
	public static String product;
		
	public void login(String userName, String password){
		findElementById(inp_userName_id).clear();
		findElementById(inp_password_id).clear();
		findElementById(inp_userName_id).sendKeys(userName);
		findElementById(inp_password_id).sendKeys(password);
		findElementByCssPath(btn_Submit_css).click();
		PropFileHandler.writeToFile("CurrentLogin", userName, YamlReader.getYamlValue("propertyfilepath"));
		if((userName.equals("knewton_automation_inst04@qai.com"))
				||(userName.equals("knewton_automation_stu04@qai.com"))){
		PropFileHandler.writeToFile("Product", "Anderson", YamlReader.getYamlValue("propertyfilepath"));
		product = "Anderson";
		}
		else
			if((userName.equals("knewton_automation_inst05@qai.com"))
					||(userName.equals("knewton_automation_stu05@qai.com"))){
				PropFileHandler.writeToFile("Product", "Gulati", YamlReader.getYamlValue("propertyfilepath"));
				product = "Gulati";
			}else{
				logWarningMessage("Incorrect Username passed");
			}
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
