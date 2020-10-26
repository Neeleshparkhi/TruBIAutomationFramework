package com.automation.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.automation.Excel.excelReader;
import com.automation.Utility.Screenshot;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseConfig {
	
	public static WebDriver driver;
	public Properties prop;
	
	excelReader excel;
	
	public WebDriverWait wait;
	public Select select;
	public Actions actions;
	public Alert alert;
	public static String testName;
	public static String title;
	
	static final int TIMEOUT = 40;
	static final int POLLING = 100;
	
	Logger log = LogManager.getLogger(BaseConfig.class.getName());
	
	
	
	public WebDriver getDriver() throws IOException
	{
		
		//Getting the property file here
		prop = new Properties();
		
		//Getting the path of the file
		String ConfigFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\automation\\Resources\\Config.properties";
		String ConfigFilePath1 = System.getProperty("user.dir")+"\\src\\main\\java\\com\\automation\\Resources\\details.properties";
		//Getting introduce file into the project
		FileInputStream fis = new FileInputStream(ConfigFilePath);
		FileInputStream details = new FileInputStream(ConfigFilePath1);
		//load file into the project
		prop.load(fis);
		prop.load(details);
		
		//Now introducing the property file Driver into the project
		
		String Browserinvoke = prop.getProperty("browser");
		
		//Applying condition for different browser invoke
		
		if(Browserinvoke.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		//For Firefox driver
		else if(Browserinvoke.contains("FireFox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		//for IE driver
		else if (Browserinvoke.contains("IE")) {
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else {
			
			System.out.println("We Dont support this browser");
		}
		
		//Applied implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//browser maximize 
		driver.manage().window().maximize();

		return driver;
	}
	
	public String[][] getData(String ExcelName, String sheetName)
	{
		
		//Giving Excel file path location
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\automation\\Resources\\" + ExcelName;
		excel = new excelReader(path);
		String[][] data = excel.getDataFromSheet(sheetName, ExcelName);
		
		return data;
		
	}
	
	// Wait for element to appear
			public void waitForElementToAppear(By WebElement) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(WebElement));
				highLightElement(WebElement);
			}
			// Wait for element to be clickable
			public void waitForElementToClick(By elementBy) {
				wait.until(ExpectedConditions.elementToBeClickable(elementBy));
				highLightElement(elementBy);
			}
			// Wait for alert to appear
			public void waitForAlertToAppear() {
				alert = wait.until(ExpectedConditions.alertIsPresent());
				if (alert != null) {
					isAlertPresent();
				}
			}		
			
			//Is Element to present
			public boolean isElementPresent(By elementBy)
			{
				try {
					if(driver.findElements(elementBy).size()>0){
							return true;
						}else {
							return false;
					  }
					} catch(NoSuchElementException ex){
                	return false;
				}
			}
			
			//Is Element visible
			public boolean isElementVisible(By elementBy)
			{
				if(driver.findElement(elementBy).isDisplayed()) {
					System.out.println("Element is visible");
					return true;
				}
				else{
					System.out.println("Element is Invisible");
					return false;
				}
			}
			
				// isElementPresent
			//				public boolean isElementPresent(By elementBy)
			//				{
			//					try {
			//						if (driver.findElements(elementBy).size() > 0) {
			//							return true;
			//						} else {
			//							return false;
			//						}
			//					} catch (NoSuchElementException ex) {
			//						return false;
			//					}
			//				}
			//			    // isElementVisible
			//				public boolean isElementVisible(By elementBy) {
			//					if (driver.findElement(elementBy).isDisplayed()) {
			//						System.out.println("Element is Visible");
			//						return true;
				//
			//					} else {
			//						System.out.println("Element is InVisible");
			//						return false;
				//
			//					}
			//				}
			//			}
					
					     //Highlight Element
					//Creating a custom function
					 public void highLighterMethod(WebDriver driver, WebElement element){
					 JavascriptExecutor js = (JavascriptExecutor) driver;
					 js.executeScript("arguments[0].setAttribute('style', 'background: 5px solid yellow; border: 2px solid red;');", element);
					 }

		// isElementPresent
					//				public boolean isElementPresent(By elementBy)
					//				{
					//					try {
					//						if (driver.findElements(elementBy).size() > 0) {
					//							return true;
					//						} else {
					//							return false;
					//						}
					//					} catch (NoSuchElementException ex) {
					//						return false;
					//					}
					//				}
					//			    // isElementVisible
					//				public boolean isElementVisible(By elementBy) {
					//					if (driver.findElement(elementBy).isDisplayed()) {
					//						System.out.println("Element is Visible");
					//						return true;
						//
					//					} else {
					//						System.out.println("Element is InVisible");
					//						return false;
						//
					//					}
					//				}
					//			}
							
							     // Highlight Element
							 public void highLightElement(By elementBy) {
									JavascriptExecutor js = (JavascriptExecutor) driver;
									js.executeScript("arguments[0].setAttribute('style','border: 5px solid red;');", driver.findElement(elementBy));
									sleepTime(3);
									Screenshot.captureScreen(driver, title, testName);
									js.executeScript("arguments[0].setAttribute('style', arguments[1]);", driver.findElement(elementBy), "");
								}

		// isElementPresent
							//				public boolean isElementPresent(By elementBy)
							//				{
							//					try {
							//						if (driver.findElements(elementBy).size() > 0) {
							//							return true;
							//						} else {
							//							return false;
							//						}
							//					} catch (NoSuchElementException ex) {
							//						return false;
							//					}
							//				}
							//			    // isElementVisible
							//				public boolean isElementVisible(By elementBy) {
							//					if (driver.findElement(elementBy).isDisplayed()) {
							//						System.out.println("Element is Visible");
							//						return true;
								//
							//					} else {
							//						System.out.println("Element is InVisible");
							//						return false;
								//
							//					}
							//				}
							//			}
									
									     //UnHighilight Element
									 public void unHighLightElement(By elementBy)
									 {
										 JavascriptExecutor js = (JavascriptExecutor) driver; 
										 js.executeScript("arguments[0].setAttribute('style', arguments[1]);", driver.findElement(elementBy) , "");
										 
									 }

		// Check alert present
		public boolean isAlertPresent() {
			boolean presentFlag = false;
			try {
				alert = driver.switchTo().alert();
				presentFlag = true;
				alert.accept();
			} catch (NoAlertPresentException ex) {
				ex.printStackTrace();
			}
			return presentFlag;
		}


				// isElementPresent
//				public boolean isElementPresent(By elementBy)
//				{
//					try {
//						if (driver.findElements(elementBy).size() > 0) {
//							return true;
//						} else {
//							return false;
//						}
//					} catch (NoSuchElementException ex) {
//						return false;
//					}
//				}
//			    // isElementVisible
//				public boolean isElementVisible(By elementBy) {
//					if (driver.findElement(elementBy).isDisplayed()) {
//						System.out.println("Element is Visible");
//						return true;
	//
//					} else {
//						System.out.println("Element is InVisible");
//						return false;
	//
//					}
//				}
//			}
		
		     //Click method
		 public void Click(By elementBy)
		 {
			 WebElement element = driver.findElement(elementBy);
			 log.info("Trying to find element :" + element.getText());
			 waitForElementToClick(elementBy);
			 highLightElement(elementBy);
			 String temp =  Screenshot.captureScreen(driver, title, testName);
			 log.info(temp + "click on" + element.getText() + "Button");
			 unHighLightElement(elementBy);
			 element.click();
		 }
		 
		 //clear
		 public void clear(By elementBy)
		 {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].value = '';", driver.findElement(elementBy));
		 }
		 
		 //Double Click
		 public void doubleClick(By elementBy)
		 {
			 waitForElementToClick(elementBy);
			 actions = new Actions(driver);
			 actions.doubleClick(driver.findElement(elementBy)).perform();
		 }
		 
		 //write Text
		 public void writeText(By elementBy, String text)
		 {
			 WebElement element = driver.findElement(elementBy);
			 waitForElementToAppear(elementBy);
			 log.info("Entering" +text+ " value to : " + element.getAttribute("name"));
			 highLightElement(elementBy);
			 element.clear();
			 element.sendKeys(text);
			 String temp = Screenshot.captureScreen(driver, title, testName);
			 log.info(temp, "Entered "+text+ " value to : "+element.getAttribute("name"));
			 unHighLightElement(elementBy);
		 }
		 
		 //Read Text
		 public String readText(By elementBy)
		 {
			 WebElement element = driver.findElement(elementBy);
			 waitForElementToAppear(elementBy);
			 highLightElement(elementBy);
			 String temp = Screenshot.captureScreen(driver, title, testName);
			 log.info(temp, "Reading the text value from: "+element.getText());
			 unHighLightElement(elementBy);
			 return element.getText();
		 }
		 
		 //get Element
		 public WebElement getElement(By elementBy)
		 {
			 WebElement element = driver.findElement(elementBy);
			 waitForElementToAppear(elementBy);
			highLightElement(elementBy);
			String temp = Screenshot.captureScreen(driver, title, testName);
			log.info(temp, "Getting the WebElement from : "+element.getText());
			unHighLightElement(elementBy);
			return element.findElement(elementBy);
		 }
		 
		 //get Title
		 public String getTitle()
		 {
			 return driver.getTitle();
		 }
		 
		 
		// SwitchToWindow method
			public String switchToWindow_GetTitle() {
				String parent = driver.getWindowHandle();
				Set<String> s1 = driver.getWindowHandles();
				Iterator<String> I1 = s1.iterator();
				String title = null;
				while (I1.hasNext()) {
					String child_window = I1.next();
					if (!parent.equals(child_window)) {
						driver.switchTo().window(child_window);
						title = driver.switchTo().window(child_window).getTitle();
						System.out.println(title);
						driver.close();
					}
				}
				driver.switchTo().window(parent);
				return title;
			}
			
			//Get elements
			public List<WebElement> getElements(By elementBy)
			{
				waitForElementToAppear(elementBy);
				return driver.findElements(elementBy);
			}
			
			//KeyBoard function
			public void KeysEnter(By elementBy)
			{
				waitForElementToClick(elementBy);
				driver.findElement(elementBy).sendKeys(Keys.ENTER);
			}
			
			//Search Function
			public WebElement getSearch(By elementBy, String text)
			{
				waitForElementToAppear(elementBy);
				highLightElement(elementBy);
				driver.findElement(elementBy).sendKeys(text);
				log.info("Enter the Data in Search textbox:" + elementBy);
				driver.findElement(elementBy).sendKeys(Keys.DOWN);
				log.info("Selecting Item to down:" + elementBy);
				driver.findElement(elementBy).sendKeys(Keys.ENTER);
				log.info("Select Item is Enter:" + elementBy);
				return driver.findElement(elementBy);
			}
		 
			// Multiple selection by text
			public void multiSelectByText(By elementBy, String xPathValue) {
					//waitForElementToAppear(elementBy, "Selecting "+xPathValue+" from :"+elementBy.toString());
					int size = driver.findElements(By.xpath(xPathValue)).size();
					System.out.println(size + " mapsets found");
					boolean element = isElementPresent(By.xpath(xPathValue));
					if (element == true) {
						driver.findElement(By.xpath("(" + xPathValue + ")[" + size + "]")).click();
					} else {

					}
					System.out.println("changes are made to the most recent  mapset");
			}
			
			//Select By Visible Text
			public void selectByVisibleText(By elementBy, String value)
			{
				WebElement element = driver.findElement(elementBy);
				log.info("Trying to find : "+element.getAttribute("name"));
				waitForElementToAppear(elementBy);
				highLightElement(elementBy);
				select = new Select(element);
				select.selectByVisibleText(value);
				String temp = Screenshot.captureScreen(driver, title, testName);
				log.info(temp, "Selected : "+value+" from : "+element.getAttribute("name"));
				unHighLightElement(elementBy);
			}
			
			// Select by value
			public void selectByValue(By elementBy, String value) {			
					WebElement element= driver.findElement(elementBy);
					log.info("Trying to find : "+element.getAttribute("name"));
					waitForElementToAppear(elementBy);
					highLightElement(elementBy);
					select = new Select(element);
					select.selectByValue(value);
					String temp = Screenshot.captureScreen(driver, title, testName);
					log.info(temp, "Selected : "+value+" from : "+element.getAttribute("name"));
					unHighLightElement(elementBy);
			}
			
			// Get select value
			public String getSelectedValue(By elementBy) {
					//waitForElementToAppear(elementBy, "Getting Selected value from : "+elementBy.toString());
					Select select = new Select(driver.findElement(elementBy));
					return select.getFirstSelectedOption().getText();
			}
			
			//Element to be click from list
			public void elementTobeClickFromList(By elementBy, String value, String logMsg) 
			{
				List<WebElement> checkBoxes = getElements(elementBy);
				for(WebElement boxes : checkBoxes) {
					String textvalue = boxes.getText();
					if(textvalue.contains(value)) {
						boxes.click();
						break;
						}else {
							throw new RuntimeException(value + " is not available in the list");
						}
				}
			}
			
			public void javaScriptClick(By elementBy, String logMsg) {
				WebElement element=driver.findElement(elementBy);
				log.info("Trying to find element : "+element.getText());
				waitForElementToClick(elementBy);
				highLightElement(elementBy);
				String temp = Screenshot.captureScreen(driver, title, testName);
				log.info(temp, "Clicking on :"+element.getText());
				unHighLightElement(elementBy);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click();", element);			
		}
			
			// Scroll into view
			public void scrollIntoView(By elementBy) {
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("arguments[0].scrollIntoView(true);", elementBy);
			}
			// Scroll page
			public void  scroll() {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,400)", "");
			}
			// Scroll up page
			public void scrollUp() {
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					// jse.executeScript("scroll(0, -250);");
					jse.executeScript("window.scrollBy(0, -250)", "");
			}
			// Thread wait
			public void sleepTime(int seconds) {
					try {
						Thread.sleep(1000 * seconds);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}

			// Wait for page to load
			public void waitForPageToLoad() {
					sleepTime(1);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					String state = (String) js.executeScript("return document.readyState");
					while (!state.equals("complete")) {
						sleepTime(20);
						state = (String) js.executeScript("return document.readyState");
					}
			}
			
			// Convert date
			public String convertDate(String inputdate) {
					System.out.println("input date" + inputdate);
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					Date date = null;
					try {
						System.out.println("input date in concert date****" + inputdate);
						date = new SimpleDateFormat("MM/dd/yyyy").parse(inputdate);
						System.out.println("Date in concert date****" + date);
					} catch (Exception e) {
						e.getMessage();
					}
					return df.format(date);
			}
			
			//Take Screen Shot
			public String getScreenShotPath(WebDriver driver, String testCaseName) throws IOException
			{
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+formater.format(calendar.getTime())+".png";
				FileUtils.copyFile(source, new File(destinationFile));
				return destinationFile;
			}
			
}
