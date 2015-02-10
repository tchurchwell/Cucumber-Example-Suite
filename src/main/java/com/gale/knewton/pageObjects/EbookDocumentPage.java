package com.gale.knewton.pageObjects;



import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class EbookDocumentPage extends BaseWebComponent{
	
	private String iframe_EbookDoc_css = "iframe[title='Reader App']";
	private String img_close_class = "closeActivity";
	private String section_EbookDoc_id = "ebook_document";
	private String lnk_editMode_xpath = "//a[@title='Edit mode']";
	private String lnk_addInlineActivity_xpath = "//div[@id='ebook_document']/div[1]/div[2]/div[1]/a";
	private String btn_start_xpath = "//div[contains(text(),'${inlineActivitytitle}')]/preceding-sibling::a[2]";
		
	private String link_inlineActivityName_xpath = "//div[@class='nb_thumbTitle' and contains(.,'${activitytitle}')]";

	boolean flag = false;
	
	
	public boolean isUserOnEbookDocumentPage(){
		try{
		hardWait(1);
		switchToFrame(findElementByCssPath(iframe_EbookDoc_css));
		hardWait(2);
		resetImplicitTimeout(15);
		flag = findElementById(section_EbookDoc_id).isDisplayed();
		switchToDefaultContent();
		}catch (Exception e){
			switchToDefaultContent();
			flag = false;
		}
		return flag;
	}
	
	public void openActivityPanelByEditMode() {
		switchToFrame(findElementByCssPath(iframe_EbookDoc_css));
		findElementByXpath(lnk_editMode_xpath).click();
		findElementByXpath(lnk_addInlineActivity_xpath).click();
		switchToDefaultContent();
	}
	
	
	public boolean verifySimpleAssessmentOnEbook() {
		boolean flag = false; 
		switchToFrame(findElementByCssPath(iframe_EbookDoc_css));
		hardWait(1);
		flag = findElementByXpath(getLocator(link_inlineActivityName_xpath,
				PropFileHandler.readProperty("InlineSimpleAssessmentActivityTitle", 
						(YamlReader.getData("propertyfilepath"))))).isDisplayed();
		switchToDefaultContent();
		return flag;
	}

	public void clickInlineSA_Activity() {
		switchToFrame(findElementByCssPath(iframe_EbookDoc_css));
		logMessage("Click Start Button");
		findElementByXpath(getLocator(btn_start_xpath, 
				PropFileHandler.readProperty("InlineSimpleAssessmentActivityTitle", 
						(YamlReader.getData("propertyfilepath"))))).click();
		switchToDefaultContent();
		
	}
	
	public void closeEbook(){
		hardWait(1);
		fireOnClickJsEvent(img_close_class);
	}
	
}
