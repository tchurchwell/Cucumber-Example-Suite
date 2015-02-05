package com.gale.knewton.pageObjects;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class ExamStudyCenterConfigPage extends BaseWebComponent {
	
	private String iframe_distinctActivity_id = "distinct_activity_create_frame";
	private String label_examStudyCenter_xpath = "//h3[text()='Exam Study Center - Configuration']";
	private String inp_examDueDate_id = "examDueDate";
	private String chkbox_Chapter_xpath = "(//*[@name='chk'])[1]"; //Specify index for chapter number
	private String lbl_ESCchapterName_xpath = chkbox_Chapter_xpath+"/following-sibling::span";
	private String btn_save_id = "save";
	
	private String heading;
	
	public String getExamStudyCenterHead(){
		switchToFrame(findElementById(iframe_distinctActivity_id));
		hardWait(5);
		waitAndLocateElementByXpath(label_examStudyCenter_xpath);
		hardWait(1);
		heading =  findElementByXpath(label_examStudyCenter_xpath).getText();
		return heading;	
	}
	
	public void enterExamDueDate(){
		hardWait(1);
		findElementById(inp_examDueDate_id).clear();
		hardWait(1);
		findElementById(inp_examDueDate_id).sendKeys(getNextMonthDate());
	}
	
	public void selectChapterCheckbox(){
		findElementByXpath(chkbox_Chapter_xpath).click();
		String chapterName = findElementByXpath(lbl_ESCchapterName_xpath).getText();
		PropFileHandler.writeToFile("EscChapterName", chapterName, YamlReader.getData("propertyfilepath"));
		logMessage("Chapter Selected-->"+chapterName);
	}
	
	public void clickSave(){
		hardWait(1);
		findElementById(btn_save_id).click();
		switchToDefaultContent();
	}
	
	public String getExamDueDate(){
		return findElementById(inp_examDueDate_id).getAttribute("value");
	}
}
