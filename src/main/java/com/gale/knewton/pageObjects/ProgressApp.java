package com.gale.knewton.pageObjects;

import com.gale.knewton.base.BaseWebComponent;

public class ProgressApp extends BaseWebComponent {

	private String frame_ProgressApp_class = "appFrame";
	private String lbl_MyGradesStatus_xpath = "//a[text()='My Grades']/parent::*";
	private String lbl_MyGrade_xpath = "//*[@class='nav nav-tabs']/li[1]/a";
	private String icon_CloseProgressApp_class = "hideApp";
	
	public boolean verifyMyGradeAsDefaultTab(){
		boolean flag;
		flag = findElementByXpath(lbl_MyGradesStatus_xpath).
				getAttribute("class")
				.contains("active");
		switchToDefaultContent();
		return flag;	
	}
	
		
	public boolean isStudentProgressAppDisplayed(){
		switchToFrame(findElementByClass(frame_ProgressApp_class));
		return findElementByXpath(lbl_MyGrade_xpath).isDisplayed();
	}
	
	public void closeProgressApp(){
		 findElementByClass(icon_CloseProgressApp_class).click();
	}
}
