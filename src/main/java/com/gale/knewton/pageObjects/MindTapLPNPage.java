package com.gale.knewton.pageObjects;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class MindTapLPNPage extends BaseWebComponent {

	private String div_LPN_xpath = "//a[text()='Course']";
	private String div_LPNstud_xpath = "//*[text()='Detail']";
	private String btn_add_css = "a.navLink.menu_trigger";
	private String btn_addActivity_css = "li.menu_item.activity > a";
	private String btn_enter_id = "nb_enter";
	private String btn_closeOverlay_css = "a.close.mxui_layout_positionable";
	private String btn_homeIcon_id = "nb_lpLauncher";
	private String img_back_xpath = "//*[text()='back']";

	private String img_firstUnit_xpath = "(//*[@class='lpn_thumbImage'])[1]";
	private String div_thumbar_xpath = "//div[contains(@title,'Reading')][1]";
	private String img_ChapterFolderGul_xpath = "(//img[@title='Folder'])[1]";
	private String img_expandedFolders_xpath = "//img[@title='Folder' and parent::div[contains(@class,'lpn_group_expanded')]]";
	private String icon_announcementNotice_xpath = "//div[contains(@class,'announcement')]/div/a[contains(@class,'nb_closeIcon')]";

	private String link_activityName_xpath = "//a[contains(.,'${activitytitle}')]";
	private String activityDynamicXpath;
	
	private String link_ESCactivity_xpath = "//a[contains(.,'${activitytitle}')]";
	private String ESCactivitydynamicxpath;
	
	private String link_USCactivity_xpath = "//a[contains(text(),'Study Center')]";
	private String lbl_USCchapter_class = "lpn_title";
	
	private String icon_ProgressApp_Id = "app_gradebook_student";
	
	private String product;
	
	
public void collapseLPNFolders(){
	hardWait(2);
	List<WebElement> folders = driver.findElements(By.xpath(img_expandedFolders_xpath));
	for(WebElement folder : folders)
	folder.click();
}

	public boolean getInstLPNDisplayed() {
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
		return waitAndLocateElementByXpath(div_LPNstud_xpath).isDisplayed();
	}
	
	public boolean isLPNDisplayedAtInstructor() {
		return	waitAndLocateElementByXpath(div_LPN_xpath).isDisplayed();
	}
	
	public void openMindTapLPN() {
		findElementById(btn_homeIcon_id).click();
		logPassMessage("Clicked over MindTap Home button to display LPN");
	}

	public void clickEnter() {
		resetImplicitTimeout(5);
		try	{
			hardWait(1);
			findElementById(btn_enter_id).click();
			findElementByCssPath(btn_closeOverlay_css).click();
			}
		catch (Exception e){
			System.out.println("*******Exception"+e);
		}
		}
		

	public void clickAddActivitybutton() {
		hardWait(1);
		findElementByCssPath(btn_add_css).click();
		findElementByCssPath(btn_addActivity_css).click();
	}
	
	public void closeAnnouncement(){
	     try {
            resetImplicitTimeout(3);
            if(findElementByXpath(icon_announcementNotice_xpath).isDisplayed()){
                findElementByXpath(icon_announcementNotice_xpath).click();
                hardWait(2);
            }
            
        }catch(Exception e){ }
   
    }
	

	public void navigateToEBookDocument() {
		product = PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath"));
		if(product.equals("Andersen")){
			hardWait(1);
			findElementByXpath(img_firstUnit_xpath).click();
			hardWait(2);
			logMessage("Navigate to ebook");
			findElementByXpath(div_thumbar_xpath).click();
			logMessage("clicked");
		}
		else
			if(product.equals("Gulati")){
			hardWait(1);
			findElementByXpath(img_ChapterFolderGul_xpath).click();
			hardWait(1);
			findElementByXpath(img_firstUnit_xpath).click();
			hardWait(3);
			findElementByXpath(div_thumbar_xpath).click();
			}	
	}


	public boolean verifySavedSimpleAssessmentOnLPN() {
		activityDynamicXpath = getLocator(link_activityName_xpath,PropFileHandler.readProperty(
				"SimpleAssessmentActivityTitle",
				(YamlReader.getData("propertyfilepath"))));
		hardWait(4);	
		return findElementByXpath(activityDynamicXpath).isDisplayed();
		
	}
	
	public boolean verifySavedSAAOnLPN() {
		activityDynamicXpath = getLocator(link_activityName_xpath,
				PropFileHandler.readProperty("saaActivityTitle",
			      (YamlReader.getData("propertyfilepath"))));
		hardWait(2);	
		return findElementByXpath(activityDynamicXpath).isDisplayed();
		
	}
	
	public void clickDistinctSimpleAssessment_Activity() {
		activityDynamicXpath = getLocator(link_activityName_xpath,
				PropFileHandler.readProperty(
						"SimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(1);
		findElementByXpath(activityDynamicXpath).click();
	}
	
	public void clickDistinctSAA_Activity(){
		activityDynamicXpath = getLocator(link_activityName_xpath,
				PropFileHandler.readProperty(
						"saaActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(1);
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
		product = PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath"));
		if(product.equals("Andersen")){
		hardWait(3);
		findElementByXpath(img_back_xpath).click();
		}
		else
			if(product.equals("Gulati"))
			{
				hardWait(3);
				findElementByXpath(img_back_xpath).click();
				collapseLPNFolders();				
			}
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
	
	public void navigateToChapterLPN(){
		product = PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath"));
		if(product.equals("Andersen")){
			hardWait(2);
			waitAndLocateElementByXpath(img_firstUnit_xpath).click();
		}
		else
			if(product.equals("Gulati")){
			hardWait(1);
			waitAndLocateElementByXpath(img_ChapterFolderGul_xpath).click();
			hardWait(1);
			waitAndLocateElementByXpath(img_firstUnit_xpath).click();
			}	
	}
	
	public boolean isUSCLinkDisplayed(){
		hardWait(1);
		return findElementByXpath(link_USCactivity_xpath).isDisplayed();
	}
	
	public void clickUSCActivity(){
		hardWait(1);
		String usc = findElementByClass(lbl_USCchapter_class).getText();
		PropFileHandler.writeToFile("USCchapter", usc, YamlReader.getYamlValue("propertyfilepath"));
		hardWait(1);
		findElementByXpath(link_USCactivity_xpath).click();
	}
	
	public void clickProgressApp(){
		findElementById(icon_ProgressApp_Id).click();
	}

}
