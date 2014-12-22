package com.gale.knewton.pageObjects;



import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class ESCActivityPage extends BaseWebComponent {

private String frame_Esc_css = "iframe[title='Adaptive App App']";
private String EscError_xpath = "//*[@class='ng-binding']";
private String btn_closeIcon_class = "closeActivity";
private String btn_Next_Css = "input[value='Next']";
private String link_MaterReport_id = "mastery";
private String lbl_EscChapter_xpath = ".//*[@id='masteryList']/ul/span/li/p[1]";
private String lbl_ExamTitle_xpath = ".//*[@id='examTitle']/h2/span";
private String instChapter;
	
	public boolean isESCErrorDisplayed(String error){
		hardWait(1);
		switchToFrame(findElementByCssPath(frame_Esc_css));
		String errorinst = waitAndLocateElementByXpath(EscError_xpath).getText();
		switchToDefaultContent();
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
		chapter = findElementByXpath(lbl_EscChapter_xpath).getText();
		instChapter = PropFileHandler.readProperty("EscChapterName", YamlReader.getData("propertyfilepath"));
		switchToDefaultContent();
		if(chapter.equals(instChapter))
			return true;
		else 
			return false;
	}
	
	public boolean verifyEscContent(){
		instChapter = PropFileHandler.readProperty("EscChapterName", YamlReader.getData("propertyfilepath"));
		//int chapterNumber = Integer.parseInt(instChapter.replaceAll("[^0-9]", ""));
		int chapterNumber = Integer.parseInt(instChapter.substring(8,9));
		switchToFrame(findElementByCssPath(frame_Esc_css));
		//int title = Integer.parseInt(findElementByXpath(lbl_ExamTitle_xpath).getText().replaceAll("[^0-9]", ""));
		int title = Integer.parseInt(findElementByXpath(lbl_ExamTitle_xpath).getText().substring(2,3));
		switchToDefaultContent();
		if (chapterNumber==title)
			return true;
		else 
			return false;
		
		
	}
}

