package com.gale.knewton.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class ESCActivityPage extends BaseWebComponent {

private String frame_Esc_css = "iframe[title='Adaptive App App']";
private String EscError_css = "#error p.ng-binding";
private String btn_closeIcon_class = "closeActivity";
private String btn_Next_Css = "input[value='Next']";
private String link_MaterReport_id = "mastery";
private String lbl_EscChapter_xpath = ".//*[@id='masteryList']/ul/span/li/p[1]";
private String lbl_ExamTitle_xpath = ".//*[@id='examTitle']/h2/span";
private String instChapter;
	
	public boolean isESCErrorDisplayed(String error){
		hardWait(1);
		switchToFrame(findElementByCssPath(frame_Esc_css));
		hardWait(2);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(EscError_css)));
		String errorinst = findElementByCssPath(EscError_css).getText();
		switchToDefaultContent();
		System.out.println(error);
		System.out.println(errorinst);
		return (error.equals(errorinst));
	}
	
	public void closeActivity(){
		hardWait(1);
		logMessage("Click close icon");
		fireOnClickJsEvent(btn_closeIcon_class);
		switchToDefaultContent();	
	}
	
	public boolean isESCActivityDisplayedatStud(){
		boolean flag;
		hardWait(1);
		switchToFrame(findElementByCssPath(frame_Esc_css));
		hardWait(1);
		flag=findElementByCssPath(btn_Next_Css).isDisplayed();
		switchToDefaultContent();
		return flag;
	}
	
	public void clickMasteryReport(){
		hardWait(1);
		switchToFrame(findElementByCssPath(frame_Esc_css));
		findElementById(link_MaterReport_id).click();
	}

	public boolean verifyChapterNameOnMasteryReport(){
		String chapter;
		hardWait(2);
		chapter = findElementByXpath(lbl_EscChapter_xpath).getText();
		instChapter = PropFileHandler.readProperty("EscChapterName", YamlReader.getData("propertyfilepath"));
		switchToDefaultContent();
		if(chapter.equals(instChapter))
			return true;
		else 
			return false;
	}
	
	public boolean verifyEscContent(){
		int chapterNumber = 0;
		switchToFrame(findElementByCssPath(frame_Esc_css));
		String chapter = findElementByXpath(lbl_EscChapter_xpath).getText();
		String[] instChapterNumber = chapter.split(":");
		if(LoginPage.product.equals("Anderson"))		
		chapterNumber = Integer.parseInt(instChapterNumber[0].substring(8));
		else
			if(LoginPage.product.equals("Gulati"))
				chapterNumber = Integer.parseInt(instChapterNumber[0]);
		String[] arr = findElementByXpath(lbl_ExamTitle_xpath).getText().split(" ");
		String arr2 = arr[0].substring(2);
		int title = Integer.parseInt(arr2);
		switchToDefaultContent();
		if (chapterNumber==title)
			return true;
		else 
			return false;
		
		
	}
}

