package com.gale.knewton.pageObjects;

import org.openqa.selenium.JavascriptExecutor;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.YamlReader;

public class CoursePaymentPage extends BaseWebComponent {

	private String btn_takeMeToMyCourse_class = "gracePeriodBtn";
	String courseUrl;
	String env;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public void clickTakeMeToMyCourse() {
		modifyMindTapURL();
		findElementByClass(btn_takeMeToMyCourse_class).click();
		changeWindow(1);
		getUrl(courseUrl);
		
	}

	private void modifyMindTapURL() {
		env = YamlReader.getYamlValue("Environment");
		courseUrl = (String) js.executeScript("return document.getElementById('courseURL').getAttribute('value');");
		if(courseUrl.contains("qaf.")&&(env.equals("qaf"))){
		logMessage("Launching student at QAF environment");	
		}
		else{
			if(env.equals("qad")){
			courseUrl = replaceText(courseUrl, "qaf.", "qad-");	
			}
		}
		}
}
