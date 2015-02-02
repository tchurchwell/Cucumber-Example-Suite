package com.gale.knewton.pageObjects;

import org.openqa.selenium.support.ui.Select;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class CreateCoursePage extends BaseWebComponent {

	String courseKey;

	private Long timeStamp = System.currentTimeMillis();
	private String courseName = "Course_Automation_" + timeStamp;
	private String timeZone = "America/New_York";

	private String radio_createNewCourse_xpath = "//*[@id='createNewCourse']";
	private String btn_continue_linktext = "Continue";
	private String inp_courseName_xpath = "//*[@id='courseName']";
	private String inp_beginDate_xpath = "//*[@id='beginDate']";
	private String inp_endDate_xpath = "//*[@id='endDate']";
	private String dropdown_timeZone_xpath = "//*[@id='timeZone']";
	private String btn_createCourse_xpath = "//a[contains(., 'Create Course')]";
	private String txt_courseKey_xpath = "//*[@class='distributionOptions']/a[1]";

	private String txt_courseCreated_xpath = "//*[text()='Course Created']";
	private String lnk_returnToInstdashboard_xpath = "//a[text()='Return to Instructor Dashboard']";

	public void selectCreateNewCourseRadioBtnAndContinue() {
		hardWait(2);
		findElementByXpath(radio_createNewCourse_xpath).click();
		hardWait(1);
		findElementByLinkText(btn_continue_linktext).click();
	}

	public void enterCourseInformation() {
		findElementByXpath(inp_courseName_xpath).sendKeys(courseName);
		findElementByXpath(inp_beginDate_xpath).sendKeys(getCurrentDate());
		findElementByXpath(inp_endDate_xpath).sendKeys(getNextMonthDate());
		PropFileHandler.writeToFile("CourseEndDate", getNextMonthDate(), YamlReader.getYamlValue("propertyfilepath"));
		Select dropdown = new Select(findElementByXpath(dropdown_timeZone_xpath));
		dropdown.selectByValue(timeZone);
	}
	
	public void clickOnCreateCourseButton() {
		findElementByXpath(btn_createCourse_xpath).click();
	}

	public boolean CourseIsCreated() {
		return findElementByXpath(txt_courseCreated_xpath).isDisplayed();
	}

	public void getCourseKey() {
		String regUrl = findElementByXpath(txt_courseKey_xpath).getText();
		courseKey = regUrl.substring(regUrl.lastIndexOf('/') + 1);// Split URL to get course key
		courseKey = removeHyphens(courseKey);//hyphens(-) are removed from the retrieved course key
	}

	public void saveCourseKeyToFile() {
		try {
			PropFileHandler.writeToFile("CourseKey", courseKey,
					YamlReader.getYamlValue("propertyfilepath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveCourseNameToFile() {
		try {
			PropFileHandler.writeToFile("CourseName", courseName,
					YamlReader.getYamlValue("propertyfilepath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logPassMessage("New course created: Course name- " + courseName + " & Course Key- " + courseKey);
	}
	
	public void clickReturnDashboard(){
		findElementByXpath(lnk_returnToInstdashboard_xpath).click();
	}
	
}
