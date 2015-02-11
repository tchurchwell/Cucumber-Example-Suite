package com.gale.knewton.pageObjects;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class ProgressApp extends BaseWebComponent {

	private String frame_ProgressApp_class = "appFrame";
	private String lbl_MyGradesStatus_xpath = "//a[text()='My Grades']/parent::*";
	private String lbl_MyGrade_xpath = "//*[@class='nav nav-tabs']/li[1]/a";
	private String lbl_MasteryReport_xpath = "//*[@class='nav nav-tabs']/li[2]/a";
	private String icon_CloseProgressApp_class = "hideApp";
	private String lbl_Score_xpath = "//a[text()='${activitytitle}']/../../td[3]/span/span";
	private String DynamicXpath;
	
	public boolean verifyMyGradeAsDefaultTab(){
		boolean flag;
		flag = findElementByXpath(lbl_MyGradesStatus_xpath).
				getAttribute("class")
				.contains("active");
		switchToDefaultContent();
		return flag;	
	}
	
	public String getMyGrade(){
		switchToFrame(findElementByClass(frame_ProgressApp_class));
		return findElementByXpath(lbl_MyGrade_xpath).getText();
	}
	
	public String getMasteryReport(){
		return findElementByXpath(lbl_MasteryReport_xpath).getText();
	}
	
	public boolean isStudentProgressAppDisplayed(){
		boolean flag;
		switchToFrame(findElementByClass(frame_ProgressApp_class));
		flag = findElementByXpath(lbl_MyGrade_xpath).isDisplayed();
		switchToDefaultContent();
		return flag;
	}
	
	public String getSAScore(){
		switchToFrame(findElementByClass(frame_ProgressApp_class));
		DynamicXpath = getLocator(lbl_Score_xpath,
				PropFileHandler.readProperty("SimpleAssessmentActivityTitle",(YamlReader.getData("propertyfilepath"))));
		String SAscore = findElementByXpath(DynamicXpath).getText();
		switchToDefaultContent();
		return SAscore;
	}
	
	public String getInlineSAScore(){
		switchToFrame(findElementByClass(frame_ProgressApp_class));
		DynamicXpath = getLocator(lbl_Score_xpath,
				PropFileHandler.readProperty("InlineSimpleAssessmentActivityTitle",(YamlReader.getData("propertyfilepath"))));
		String inlineSAscore = findElementByXpath(DynamicXpath).getText();
		switchToDefaultContent();
		return inlineSAscore;
	}
	
	public String getSAAScore(){
		switchToFrame(findElementByClass(frame_ProgressApp_class));
		DynamicXpath = getLocator(lbl_Score_xpath,
				PropFileHandler.readProperty("saaActivityTitle",(YamlReader.getData("propertyfilepath"))));
		String SAAscore = findElementByXpath(DynamicXpath).getText();
		switchToDefaultContent();
		return SAAscore;
	}
	
	public void closeProgressApp(){
		 findElementByClass(icon_CloseProgressApp_class).click();
	}
}
