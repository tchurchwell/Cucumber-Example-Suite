package com.gale.knewton.pageObjects;


import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class SSOInstructorDashboardPage extends BaseWebComponent{
	
	private String courseName;
	private String environment;
	private String courseUrl;
	private String lnk_sign_Out_linkText = "Sign Out";
	private String lnk_dashboardCreateCourse_xpath = "//*[@id='columnMain']/div[4]/ul/li/div/a[1]";
	private String lnk_courseName_xpath = "//span[contains(text(),'${course_name}')]/parent::a";
	
	public boolean isUserOnDashboardPage(){
		return findElementByLinkText(lnk_sign_Out_linkText).isDisplayed();
	}
	
	public void logout(){
		findElementByLinkText(lnk_sign_Out_linkText).click();
	}
	
	public void clickOnCreateCourseLink(){
		findElementByXpath(lnk_dashboardCreateCourse_xpath).click();
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
