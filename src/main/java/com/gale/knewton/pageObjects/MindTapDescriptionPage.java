package com.gale.knewton.pageObjects;

import java.io.IOException;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class MindTapDescriptionPage extends BaseWebComponent {

	private String btn_save_xpath = "//a[text()='Save']";
	private String inp_title_id = "name";
	private String div_orderArrow_xpath = "//*[@id='order-button']/span[2]";
	private String option_order_xpath = "//*[@id='order-menu']/li[1]/a";
	
	private String timeStamp = String.valueOf(System.currentTimeMillis());
	private String saaActivityTitle = "SaaActivity_" + timeStamp;
	private String simpAssessActivityTitle = "SimpleAssessment_" + timeStamp;
	private String escTitle = "Exam Study Center_" + timeStamp;
		
	public void enterSaaActivityTitle() throws IOException {
		findElementById(inp_title_id).clear();
		findElementById(inp_title_id).sendKeys(saaActivityTitle);
		logPassMessage("Title entered as: " + saaActivityTitle);
		PropFileHandler.writeToFile("saaActivityTitle", saaActivityTitle, YamlReader.getYamlValue("propertyfilepath"));
	}

	public void enterSimpAssessTitle() throws IOException {
		hardWait(3);
		findElementById(inp_title_id).clear();
		findElementById(inp_title_id).sendKeys(simpAssessActivityTitle);
		logPassMessage("Title entered as: " + simpAssessActivityTitle);
		PropFileHandler.writeToFile("SimpleAssessmentActivityTitle", simpAssessActivityTitle, YamlReader.getYamlValue("propertyfilepath"));
	}
	
	public void enterinlineSimpAssessTitle() throws IOException {
		hardWait(3);
		findElementById(inp_title_id).clear();
		findElementById(inp_title_id).sendKeys(simpAssessActivityTitle);
		logPassMessage("Title entered as: " + simpAssessActivityTitle);
		PropFileHandler.writeToFile("InlineSimpleAssessmentActivityTitle", simpAssessActivityTitle, YamlReader.getYamlValue("propertyfilepath"));
		
	}

	public void enterESCTitle() throws IOException {
		hardWait(2);
		findElementById(inp_title_id).clear();
		findElementById(inp_title_id).sendKeys(escTitle);
		logPassMessage("Title entered as: " + escTitle);
		PropFileHandler.writeToFile("ESCTitle", escTitle, YamlReader.getYamlValue("propertyfilepath"));
	}
	
	public void reorderActivity(){
		findElementByXpath(div_orderArrow_xpath).click();
		findElementByXpath(option_order_xpath).click();
	}

	public void clickSaveButton() {
		findElementByXpath(btn_save_xpath).click();
	}

	

}
