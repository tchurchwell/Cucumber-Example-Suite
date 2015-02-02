package com.gale.knewton.pageObjects;


import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class SSOInstructorDashboardPage extends BaseWebComponent{
	
	private String courseName;
	private String environment;
	private String courseUrl;
	private String lnk_sign_Out_linkText = "Sign Out";
	private String lnk_dashboardCreateCourse_linkPath = "Create Course";
	private String lnk_courseName_xpath = "//span[contains(text(),'${course_name}')]/parent::a";
	private String lbl_title_xpath = ".//*[@id='productISBN']/option";
	private String pageTitle;
	
	public boolean isUserOnDashboardPage(){
		hardWait(1);
		String title = waitAndLocateElementByXpath(lbl_title_xpath).getText();
		if (title.contains("Andersen"))
			PropFileHandler.writeToFile("Product", "Andersen", YamlReader.getYamlValue("propertyfilepath"));
		else if(title.contains("Gulati"))
			PropFileHandler.writeToFile("Product", "Gulati", YamlReader.getYamlValue("propertyfilepath"));
		else{
			logWarningMessage("Incorrect Title");
		}
		pageTitle = driver.getTitle();
		if(pageTitle.equals("Instructor SSO - Instructor Resource Center"))
		PropFileHandler.writeToFile("CurrentLogin", "Instructor", YamlReader.getYamlValue("propertyfilepath"));
		return findElementByLinkText(lnk_sign_Out_linkText).isDisplayed();
	}
	
	public void logout(){
		findElementByLinkText(lnk_sign_Out_linkText).click();
	}
	
	public void clickOnCreateCourseLink(){
		findElementByLinkText(lnk_dashboardCreateCourse_linkPath).click();
	}
	
	public void clickNewCourse() {
		environment = YamlReader.getYamlValue("Environment");
		courseName = PropFileHandler.readProperty("CourseName", 
				YamlReader.getYamlValue("propertyfilepath"));
				
		courseUrl= findElementByXpath(getLocator(lnk_courseName_xpath, courseName)).getAttribute("href");
		
		if(courseUrl.contains("qaf.")&&(environment.equals("qaf"))){
			getUrl(courseUrl);
		} else {
				if(environment.equals("qad")){
				String url= replaceText(courseUrl, "qaf.", "qad-");
				getUrl(url);
			}
		}
		
	}	
	 
}
