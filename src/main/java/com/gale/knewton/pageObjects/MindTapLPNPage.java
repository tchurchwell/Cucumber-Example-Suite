package com.gale.knewton.pageObjects;


import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class MindTapLPNPage extends BaseWebComponent {

	private String div_LPN_link = "Course";
	private String div_LPNstud_link = "Detail";
	private String btn_add_css = "a.navLink.menu_trigger";
	private String btn_addActivity_css = "li.menu_item.activity > a";
	private String btn_enter_id = "nb_enter";
	private String btn_closeOverlay_css = "a.close.mxui_layout_positionable";
	private String btn_homeIcon_id = "nb_lpLauncher";
	private String img_back_xpath = "//*[text()='back']";

	private String img_firstChapterFolderOnLPN_xpath = "(//*[@class='lpn_thumbImage'])[1]";
	private String div_thumbar_xpath = "//div[contains(@title,'Reading')][1]";

	private String link_activityName_xpath = "//a[contains(.,'${activitytitle}')]";
	private String activityDynamicXpath;
	
	private String link_ESCactivity_xpath = "//a[contains(.,'${activitytitle}')]";
	private String ESCactivitydynamicxpath;
	
	



	public boolean getInstLPNDisplayed() {
		hardWait(5);
		boolean flag;
		flag = isLPNDisplayedAtInstructor();
			if(flag){
				return true;
			}
			else{
				openMindTapLPN();
				return isLPNDisplayedAtInstructor();
			}
	}
	
	public boolean isLPNDisplayedAtStudent() {
		hardWait(1);
		return	findElementByLinkText(div_LPNstud_link).isDisplayed();
	}
	
	public boolean isLPNDisplayedAtInstructor() {
		hardWait(1);
		return	findElementByLinkText(div_LPN_link).isDisplayed();
	}
	
	public void openMindTapLPN() {
		findElementById(btn_homeIcon_id).click();
		logPassMessage("Clicked over MindTap Home button to display LPN");
	}

	public void clickEnter() {
		findElementById(btn_enter_id).click();
		findElementByCssPath(btn_closeOverlay_css).click();
	}

	public void clickAddActivitybutton() {
		hardWait(1);
		findElementByCssPath(btn_add_css).click();
		findElementByCssPath(btn_addActivity_css).click();
	}

	public void navigateToEBookDocument() {
		hardWait(1);
		findElementByXpath(img_firstChapterFolderOnLPN_xpath).click();
		hardWait(2);
		findElementByXpath(div_thumbar_xpath).click();
		
	}


	public boolean verifySavedSimpleAssessmentOnLPN() {
		activityDynamicXpath = getLocator(link_activityName_xpath,PropFileHandler.readProperty(
				"SimpleAssessmentActivityTitle",
				(YamlReader.getData("propertyfilepath"))));
		hardWait(4);	
		return findElementByXpath(activityDynamicXpath).isDisplayed();
		
	}
	
	public void clickDistinctSimpleAssessment_Activity() {
		activityDynamicXpath = getLocator(link_activityName_xpath,
				PropFileHandler.readProperty(
						"SimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		findElementByXpath(activityDynamicXpath).click();
	}

	public boolean verifySavedESCActivityOnLPN() {
		
		activityDynamicXpath = getLocator(link_activityName_xpath, 
				PropFileHandler.readProperty("ESCTitle",
				(YamlReader.getData("propertyfilepath"))));
		hardWait(1);
		return findElementByXpath(activityDynamicXpath).isDisplayed();
	
	}
	
	public void clickESCActivity(){
		ESCactivitydynamicxpath = getLocator(link_ESCactivity_xpath, 
				PropFileHandler.readProperty("ESCTitle",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(1);
		logMessage("Click ESC Activity");
		findElementByXpath(ESCactivitydynamicxpath).click();
	}
	
	public void navigateToBaseLPN(){
		hardWait(3);
		findElementByXpath(img_back_xpath).click();
	}
		
	public boolean getStudLPNDisplayed(){
		boolean flag;
		flag = isLPNDisplayedAtStudent();
		if(flag){
			return true;
		}
		else{
			openMindTapLPN();
			return isLPNDisplayedAtStudent();
		}
	}
	
	public void clickDistinctSAasStudent(){
		activityDynamicXpath = getLocator(link_activityName_xpath, 
				PropFileHandler.readProperty("SimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(1);
		findElementByXpath(activityDynamicXpath).click();
	}


}
