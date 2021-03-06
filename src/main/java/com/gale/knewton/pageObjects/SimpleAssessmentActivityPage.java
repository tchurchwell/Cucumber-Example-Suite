package com.gale.knewton.pageObjects;


import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class SimpleAssessmentActivityPage extends BaseWebComponent {

	private String practiceVideo_xpath = "//Video";
	private String feedback_xpath = "//div[text()='Feedback']";
	private String currentPoint_xpath = "//*[@class='current-points']";
	private String scoreEntry_xpath = "(//*[@class='score-wrapper']/span[1])[1]";
	private String tryAnotherVersion_xpath = "//input[@value='Try Another Version']";
	private String btn_checkmywork_xpath= "//input[contains(@value,'Check My Work')]";
	private String grove_frame_css ="iframe[title='Assessments App']";
	private String frame2_Submit_id ="easyXDM_activityService_cxp_Target_provider"; 
	private String ereader_frame_css = "iframe[title='Reader App']";
	private String frame2inline_Submit_class = "appFrame";
	private String frame3inline_Submit_id ="easyXDM_activityService_cxp_Target_provider";
	private String btn_startActivitySA_css= "#rhs-start";
	private String answer_optionAnd_xpath = "(//*[@class='q4-choice']//input)[1]";
	private String answer_optionGul_xpath = "(//*[@class='ci-choices']//input)[1]";
	private String lbl_submit_xpath = "//button[text()='Review & Submit']";
	private String btn_submit_xpath = "//button[contains(.,'Grade Assignment Now')]";
	private String icon_close_class = "closeActivity";
	
	private String product;
	private boolean flag = false;
	
		
	public boolean isSimpleAssessmentLaunched() {
		product = PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath"));
		try
			{
				hardWait(1);
				switchToFrame(findElementByCssPath(grove_frame_css));
				hardWait(1);
				switchToFrame(findElementById(frame2_Submit_id));
				if(product.equals("Andersen")){
				resetImplicitTimeout(20);
				flag = waitAndLocateElementByXpath(practiceVideo_xpath).isDisplayed();
				}
				else
					if(product.equals("Gulati"))
					{
						resetImplicitTimeout(20);
						flag = waitAndLocateElementByXpath(btn_checkmywork_xpath).isDisplayed();
					}
				switchToDefaultContent();
			}
			catch(Exception e1){
				switchToDefaultContent();
				flag = false;
				}
		return flag;
	}
	
	public void relaunchActivity(){
		refresh();
		switchToDefaultContent();
	}
	
	public boolean isInlineSimpleAssessmentLaunched() {
		product = PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath"));
		try{
		switchToFrame(findElementByCssPath(ereader_frame_css));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		if(product.equals("Andersen")){
			resetImplicitTimeout(20);
			flag = waitAndLocateElementByXpath(practiceVideo_xpath).isDisplayed();
			}
			else
				if(product.equals("Gulati"))
				{
					resetImplicitTimeout(20);
					flag = waitAndLocateElementByXpath(btn_checkmywork_xpath).isDisplayed();
				}
		switchToDefaultContent();
		}
			catch(Exception e){
				switchToDefaultContent();
				flag = false;
			}
		return flag;
	}

	public void clickOnStartActivityforSA() {
		logMessage("Click on Start Activity");
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementById(frame2_Submit_id));
		findElementByCssPath(btn_startActivitySA_css).click();
		switchToDefaultContent();
	}

	public void selectOption() {
		product = PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath"));
		logMessage("Select answer option");
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementById(frame2_Submit_id));
		if(product.equals("Andersen")){
			findElementByXpath(answer_optionAnd_xpath).click();
			}
			else
				if(product.equals("Gulati"))
				{
					findElementByXpath(answer_optionGul_xpath).click();
				}
		
		switchToDefaultContent();
	}
	
	public void selectOptionInline() {
		product = PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath"));
		logMessage("Select answer option");
		switchToFrame(findElementByCssPath(ereader_frame_css));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		if(product.equals("Andersen")){
			findElementByXpath(answer_optionAnd_xpath).click();
			}
			else
				if(product.equals("Gulati"))
				{
					findElementByXpath(answer_optionGul_xpath).click();
				}
		switchToDefaultContent();
	}
	
	public void checkMyWork(){
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementById(frame2_Submit_id));
		logMessage("Click Check My Work Button");
		findElementByXpath(btn_checkmywork_xpath).click();
		switchToDefaultContent();
			}
	
	public void checkMyWorkInline(){
		switchToFrame(findElementByCssPath(ereader_frame_css));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		logMessage("Click Check My Work Button");
		scrollDown(findElementByXpath(btn_checkmywork_xpath));
		findElementByXpath(btn_checkmywork_xpath).click();
		switchToDefaultContent();
	}
	
	public boolean isFeedbackDisplayed(){
		boolean flag;
		switchToFrameByCss(grove_frame_css);
		switchToFrameById(frame2_Submit_id);
		flag = waitAndLocateElementByXpath(feedback_xpath).isDisplayed();
		switchToDefaultContent();
		return flag;
	}
	
	public boolean isInlineFeedbackDisplayed(){
		boolean flag;
		switchToFrame(findElementByCssPath(ereader_frame_css));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		flag = waitAndLocateElementByXpath(feedback_xpath).isDisplayed();
		switchToDefaultContent();
		return flag;
	}
	
	public boolean isTryAnotherVersionbtnDisplayed(){
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementById(frame2_Submit_id));
		boolean flag= findElementByXpath(tryAnotherVersion_xpath).isDisplayed();
		switchToDefaultContent();
		return flag;
	}
	
	public boolean isInlineTryAnotherVersionbtnDisplayed(){
		switchToFrame(findElementByCssPath(ereader_frame_css));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		boolean flag= findElementByXpath(tryAnotherVersion_xpath).isDisplayed();
		switchToDefaultContent();
		return flag;
	}
	
	public void submitSimpleAssessmentActivity() {
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementById(frame2_Submit_id));
		hardWait(1);
		logMessage("Click Grade Assessment button");
		findElementByXpath(btn_submit_xpath).click();
		switchToDefaultContent();
		
	}
	
	public void clickReviewSubmitGDA(){
		logMessage("Click Review and Submit label");
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementById(frame2_Submit_id));
		findElementByXpath(lbl_submit_xpath).click();
		switchToDefaultContent();
	}
	
	public void clickReviewSubmitInline(){ 
		logMessage("Click on Review and Submit link");
		hardWait(1);
		switchToFrame(findElementByCssPath(ereader_frame_css));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		findElementByXpath(lbl_submit_xpath).click();
		switchToDefaultContent();
	}
	
	public boolean verifyGradesOnTable(){
		hardWait(1);  
		switchToFrame(findElementByCssPath(grove_frame_css));
		hardWait(1);
		switchToFrame(findElementById(frame2_Submit_id));
		String currentPoints =waitAndLocateElementByXpath(currentPoint_xpath).getText();
		System.out.println("currentPoints:"+ currentPoints);
		String ScoreEntry = waitAndLocateElementByXpath(scoreEntry_xpath).getText();
		System.out.println("ScoreEntry:"+ ScoreEntry);
		switchToDefaultContent();
		if (currentPoints.equals(ScoreEntry)) 
				return true;
		else 
				return false;
	}
	
	public void gradeAssignmentButton(){
		logMessage("Click on Grade Assignment Button");
		switchToFrame(findElementByCssPath(ereader_frame_css));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		findElementByXpath(btn_submit_xpath).click();
		switchToDefaultContent();
	}
	
	public void closeSAActivity(){
		findElementByClass(icon_close_class).click();
	}
}
