package com.gale.knewton.pageObjects;


import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class SSOStudentDashBoardPage extends BaseWebComponent{
	
	
private String lnk_sign_Out_linkText = "Log Out";
private String label_sign_Out_xpath = "//h1[@class='dashboardTitle floatleft' and contains(text(),'My Home')]";
private String inp_courseKey_id = "registerAccessCode";
private String btn_register_linkText = "Register";
private String lbl_courseName_xpath = "//span[contains(.,'${activitytitle}')]";
private String activityDynamicXpath;
private String courseName;
private String courseKey;
private boolean flag = true;

private String link_open_xpath="//a[contains(@href,'${courseKey}')]";
private String lbl_title_xpath = link_open_xpath+"/ancestor::div[1]/span";
	
	public boolean isUserOnDashboardPage(){
		if (driver.getTitle().equals("CengageBrain - My Home"))
			PropFileHandler.writeToFile("CurrentLogin", "Student", YamlReader.getYamlValue("propertyfilepath"));
		return findElementByXpath(label_sign_Out_xpath).isDisplayed();
	}
	
	public void logout(){
		findElementByLinkText(lnk_sign_Out_linkText).click();
	}

	public void enterCourseKey() {
		String CourseKey = PropFileHandler.readProperty("CourseKey", YamlReader.getData("propertyfilepath"));
		findElementById(inp_courseKey_id).sendKeys(CourseKey);
	}

	public void clickRegister() {
		findElementByLinkText(btn_register_linkText).click();
	}

	public boolean isCourseDisplayed() {
		courseName = PropFileHandler.readProperty(
		"CourseName",(YamlReader.getData("propertyfilepath")));
		activityDynamicXpath = getLocator(lbl_courseName_xpath,courseName);
				
		try {
			findElementByXpath(activityDynamicXpath).isDisplayed();
			logPassMessage("Newly enrolled course " + courseName +" is successfully displayed on Student's dashboard" );
			PropFileHandler.writeToFile("enrolledCourse", courseName, YamlReader.getData("propertyfilepath"));
		} 
		catch (Exception e) {
			if(findElementByXpath(activityDynamicXpath).isDisplayed()){
				logPassMessage("Newly enrolled course " + courseName +" is successfully displayed on Student's dashboard" );
			}
				else{
					flag = false;
					logWarningMessage("Newly enrolling course " + courseName +" is not displayed on Student's dashboard" );				
			}
		}
			return flag;
	}

	public void clickOpen() {
		courseKey = PropFileHandler.readProperty("CourseKey", YamlReader.getData("propertyfilepath"));
		String courseTitle = findElementByXpath(getLocator(lbl_title_xpath, courseKey)).getText();
		if (courseTitle.contains("Andersen"))
			PropFileHandler.writeToFile("Product", "Andersen", YamlReader.getYamlValue("propertyfilepath"));
		else if(courseTitle.contains("Gulati"))
			PropFileHandler.writeToFile("Product", "Gulati", YamlReader.getYamlValue("propertyfilepath"));
		else{
			logWarningMessage("Incorrect Title");
		}
		waitAndLocateElementByXpath(getLocator(link_open_xpath, courseKey)).click();
	}
	
}
