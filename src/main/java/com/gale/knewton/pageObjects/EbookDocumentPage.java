package com.gale.knewton.pageObjects;



import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class EbookDocumentPage extends BaseWebComponent{
	
	private String iframe_EbookDoc_class = "ereader_iframe";
	private String img_close_xpath = "//a[contains(@title,'Close Activity')]";
	private String section_EbookDoc_id = "ebook_document";
	private String lnk_editMode_xpath = "//a[@title='Edit mode']";
	private String lnk_addInlineActivity_xpath = "//div[@id='ebook_document']/div[1]/div[2]/div[1]/a";
	private String btn_start_xpath = "//div[contains(text(),'${inlineActivitytitle}')]/preceding-sibling::a[2]";
	
	private String link_inlineActivityName_xpath = "//div[@class='nb_thumbTitle' and contains(.,'${activitytitle}')]";

	
	
	public boolean isUserOnEbookDocumentPage(){
		boolean flag =false;
		switchToFrame(findElementByClass(iframe_EbookDoc_class));
		hardWait(2);
		flag = findElementById(section_EbookDoc_id).isDisplayed();
		switchToDefaultContent();
		return flag;
		}
	
	public void openActivityPanelByEditMode() {
		switchToFrame(findElementByClass(iframe_EbookDoc_class));
		findElementByXpath(lnk_editMode_xpath).click();
		findElementByXpath(lnk_addInlineActivity_xpath).click();
		switchToDefaultContent();
	}
	
	
	public boolean verifySimpleAssessmentOnEbook() {
		boolean flag = false; 
		switchToFrame(findElementByClass(iframe_EbookDoc_class));
		hardWait(1);
		flag = findElementByXpath(getLocator(link_inlineActivityName_xpath, PropFileHandler.readProperty("InlineSimpleAssessmentActivityTitle", (YamlReader.getData("propertyfilepath"))))).isDisplayed();
		switchToDefaultContent();
		return flag;
	}

	public void clickInlineSA_Activity() {
		switchToFrame(findElementByClass(iframe_EbookDoc_class));
		logMessage("Click Start Button");
		findElementByXpath(getLocator(btn_start_xpath, PropFileHandler.readProperty("InlineSimpleAssessmentActivityTitle", (YamlReader.getData("propertyfilepath"))))).click();
		switchToDefaultContent();
		
	}
	
	public void closeEbook(){
		findElementByXpath(img_close_xpath).click();
	}
	
	
	
	
}
