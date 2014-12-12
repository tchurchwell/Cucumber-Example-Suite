package com.gale.knewton.base;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gale.knewton.util.YamlReader;

public class BaseWebComponent {

	public static WebDriver driver;
	public WebDriverWait wait;
	int AJAX_TIMEOUT = Integer.parseInt(YamlReader
			.getYamlValue("explicitTimeOut"));
	public PropertiesConfiguration searchProperties;
	public PropertiesConfiguration envProperties;
	private String mainWindowHandle = driver.getWindowHandle();
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public BaseWebComponent() {
		wait = new WebDriverWait(driver, AJAX_TIMEOUT);
	}

	private WebElement waitForElementToAppear(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	protected void switchDriverToPopUp() {
		String mainWindowHandle = driver.getWindowHandle();
		String popupWindowHandle = null;
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(mainWindowHandle)) {
				popupWindowHandle = windowHandle;
			}
		}
		if (null == popupWindowHandle) {
			throw new IllegalStateException(
					"Could not find the popup window handle for ");
		}
		driver.switchTo().window(popupWindowHandle);
	}

	protected void changeWindow(int i) {
		Set<String> windows = driver.getWindowHandles();
		if (i > 0) {
			for (int j = 0; j < 5; j++) {
				System.out.println("Windows: " + windows.size());
				if (windows.size() >= 2) {
					try {
						Thread.sleep(5000);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					break;
				}
				windows = driver.getWindowHandles();
			}
		}
		String wins[] = windows.toArray(new String[windows.size()]);
		driver.switchTo().window(wins[i]);
		driver.manage().window().maximize();
	}
	/**
     * Fire on click js event.
     *
     * @param elementRef the element ref
     */
    public void fireOnClickJsEvent(String elementRef){
        fireOnClickJsEvent (elementRef, "0");
    }
    
    /**
     * Fire on click js event.
     *
     * @param elementRef the element ref
     * @param index the index
     */
    public void fireOnClickJsEvent(String elementRef, String index){
        js.executeScript(""
            + "var elem = document.getElementsByClassName('"+elementRef+"')["+index+"];"
                + "if( document.createEvent ) { "
                + "   var evObj = document.createEvent('MouseEvents');" 
            + "    evObj.initEvent( 'click', true, false );" 
            + "   elem.dispatchEvent(evObj);" 
            + "} else if( document.createEventObject ) {"
                + "    elem.fireEvent('onclick');"
                + "}" 
            + "" );
    }   
 
    

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	@SuppressWarnings("deprecation")
	public String takeActualScreenShot(String pageName) {
		Date date = new Date();
		String currentDate = Integer.toString(date.getDate());
		String currentTime = Integer.toString(date.getHours())
				+ Integer.toString(date.getSeconds());
		String currentDateTime = currentDate + currentTime;
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("images\\actual\\" + pageName
					+ currentDateTime + "screenshot.jpg"));
			System.out.println("images\\actual\\" + pageName + currentDateTime
					+ "screenshot.jpg");
			return "images\\actual\\" + pageName + currentDateTime
					+ "screenshot.jpg";
		} catch (IOException e) {
			System.out.println("File not found");
		}
		return "";
	}

	@SuppressWarnings("deprecation")
	public String takeExpectedScreenShot(String pageName) {
		Date date = new Date();
		String currentDate = Integer.toString(date.getDate());

		String currentTime = Integer.toString(date.getHours())
				+ Integer.toString(date.getSeconds());
		String currentDateTime = currentDate + currentTime;
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("images\\expected\\"
					+ pageName + currentDateTime + "screenshot.jpg"));
			return "images\\expected\\" + pageName + currentDateTime
					+ "screenshot.jpg";
		} catch (IOException e) {
			System.out.println("File not found");
		}
		return "";
	}

	public void switchToMainWindow() {
		if (!driver.getWindowHandle().equals(mainWindowHandle)) {
			driver.close();
			driver.switchTo().window(mainWindowHandle);
		}
	}

	public void switchToPopUpWindow() {
		Set<String> allWindowHandle = driver.getWindowHandles();
		for (String window : allWindowHandle) {
			if (!window.equals(mainWindowHandle)) {
				driver.switchTo().window(window);
				break;
			}
		}

	}

	public void switchToOtherWindow() {
		if (driver.getWindowHandle().equals(mainWindowHandle)) {
			System.out.println(mainWindowHandle);
			driver.switchTo().window(mainWindowHandle);
		}
	}

	public String replaceCssWithIndex(String cssPath, String xIndex) {
		String locString = cssPath;
		return locString.replace("%", xIndex);
	}

	public String replaceCssWithIndex(String cssPath, String xIndex,
			String secIndex) {
		String locString = cssPath;
		locString = locString.replace("%", xIndex);
		return locString.replace("$", secIndex);
	}

	public WebElement findElementByXpath(String elementUid) {
	
		return waitForElementToAppear(driver.findElement(By.xpath(elementUid)));
	}

	public WebElement findElementById(String elementUid) {
		return waitForElementToAppear(driver.findElement(By.id(elementUid)));
	}

	public WebElement findElementById(String elementUid, String index) {
		elementUid = elementUid.replace("%", index);
		return waitForElementToAppear(driver.findElement(By.id(elementUid)));
	}

	public WebElement findElementByName(String elementUid) {
		return waitForElementToAppear(driver.findElement(By.name(elementUid)));

	}

	public WebElement findElementByLinkText(String elementUid) {
		return waitForElementToAppear(driver.findElement(By
				.linkText(elementUid)));

	}

	public WebElement findElementByClass(String elementUid) {
		return waitForElementToAppear(driver.findElement(By
				.className(elementUid)));

	}

	public WebElement findElementByCssPath(String elementUid) {
		WebElement searchIndex = (WebElement) driver.findElement(By
				.cssSelector(elementUid));
		return waitForElementToAppear(searchIndex);
	}

	public WebElement findElementByCssPath(String elementUid, String cssIndex) {
		return waitForElementToAppear(driver.findElement(By
				.cssSelector(replaceCssWithIndex(elementUid, cssIndex))));
	}

	public WebElement findElementByCssPath(String elementUid, String cssIndex,
			String secIndex) {
		return waitForElementToAppear(driver
				.findElement(By.cssSelector(replaceCssWithIndex(elementUid,
						cssIndex, secIndex))));
	}

	public String getStandardWaitTime() {
		return envProperties.getString("STANDARD_PAGE_LOAD_WAIT_TIME");
	}

	public void hardWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
		}
	}

	public void doHoverOverElementByID(String elementID) {
		WebElement element = driver.findElement(By.id(elementID));
		doHoverOverElement(element);
	}

	public void doHoverOverElement(WebElement element) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();
	}

	public void waitForElementToLoad(By seleniumFindExpression, long i) {

		long now = new Date().getTime();
		long endTime = now + i;

		while (now < endTime) {

			try {
				driver.findElement(seleniumFindExpression);
			} catch (NoSuchElementException e) {
				now = new Date().getTime();

				try {
					Thread.sleep(500);
				} catch (InterruptedException ignored) {
				}

				continue;
			}
			break;
		}
		if (now > endTime) {
			throw new IllegalStateException("could not find element "
					+ seleniumFindExpression.toString() + " within " + i
					+ "ms.");
		}
	}

	protected void waitForAjaxLoadAndVerifyByElementId(
			final String expectedElement) {
		try {
			(new WebDriverWait(driver, 5))
					.until(new ExpectedCondition<Boolean>() {
						public Boolean apply(WebDriver arg0) {
							return driver.findElement(By.id(expectedElement)) != null;
						}
					});
		} catch (TimeoutException ex) {
			throw new TimeoutException("Expected element " + expectedElement
					+ " did not load.", ex);
		}
	}

	protected void waitForAjaxLoadAndVerifyByCss(final String expectedElement) {
		try {
			(new WebDriverWait(driver, 5))
					.until(new ExpectedCondition<Boolean>() {
						public Boolean apply(WebDriver arg0) {
							return driver.findElement(By
									.cssSelector(expectedElement)) != null;
						}
					});
		} catch (TimeoutException ex) {
			throw new TimeoutException("Expected element " + expectedElement
					+ " did not load.", ex);
		}
	}

	public void switchBackToMainWindow() {
		driver.switchTo().window(mainWindowHandle);
	}
	
	public void switchToFrame(WebElement element) {
		try{
			waitForElementToAppear(element);
			driver.switchTo().frame(element);
		}catch(StaleElementReferenceException ex){
			hardWait(1);
			driver.switchTo().frame(element);
		}
		
	}
	

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public String getLocator(String locator1, String replacement) {
		String locator = locator1;
		locator = locator.replaceAll("\\$\\{.+\\}", replacement);
		return locator;
	}

	public void stopPageToLoad() {
		driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
	}
	
	public void getUrl(String URL){
		driver.get(URL);
	}
	
	
	
	////////////////////More Functions///////////////////////
	
	public String getCurrentDate() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
		return ft.format(dNow);
	}

	public String getNextMonthDate() {
		DateFormat formatter = new SimpleDateFormat("MM");
		SimpleDateFormat monthParse = new SimpleDateFormat("MM");
		DateFormat dformatter = new SimpleDateFormat("DD");
		SimpleDateFormat dateParse = new SimpleDateFormat("DD");
		Calendar cal = Calendar.getInstance();
		String month = Integer.toString(cal.get(Calendar.MONTH)+2);
		String date = Integer.toString(cal.get(Calendar.DATE)+1);
		try {
			month = formatter.format(monthParse.parse(month));
			date = dformatter.format(dateParse.parse(date));
		} catch (ParseException e) {
		}
		String year = Integer.toString(cal.get(Calendar.YEAR)+1);
		String calDate = month + "/" + date + "/" + year;
		return calDate;
	}
	
	public String replaceText(String actualText, String changeFrom, String changeTo){
		String Str = new String(actualText);

	      System.out.print("Return Value :" );
	      return Str.replace(changeFrom, changeTo);
	}
	
	public String removeHyphens(String str) {
		return str.replace("-", "");
	}

	public void logPassMessage(String message){
		System.out.println("\n|***Pass***| "+ message);
	}
	
	public void logWarningMessage(String message){
		System.out.println("\n|***Warning***| "+ message);
	}
	
	public void logMessage(String message){
		System.out.println("\n|**Action**| "+ message+" <--");
	}

	public void NavigateToBaseUrl(){
		driver.navigate().to(YamlReader.getYamlValue("baseurl"));
	}
	
	public void resetImplicitTimeout(int newTimeOut){
        try{
            driver.manage().timeouts().implicitlyWait(newTimeOut, TimeUnit.SECONDS);
        }
        catch(Exception e){}
    }
	
	public void refresh(){
		driver.navigate().refresh();
		}
	
	/**
     * Wait for spinner to disappear.
     */
   public void waitForSpinnerToDisappear(){
        int i = 0;
        resetImplicitTimeout(2);
        try{
            List <WebElement> spinnerGifs = driver.findElements(By.xpath("//div[@class='spinner']/div/div"));
            if (spinnerGifs.size()>0){
                for (WebElement spinnerGif : spinnerGifs){
                    while (spinnerGif.isDisplayed() && i <= AJAX_TIMEOUT){
                       hardWait(2);
                        i ++;
                    }
                }
            }
        }
        catch(Exception e){}
        resetImplicitTimeout(AJAX_TIMEOUT);       
    }
}
