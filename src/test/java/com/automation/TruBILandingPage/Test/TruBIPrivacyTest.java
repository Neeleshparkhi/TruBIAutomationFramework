package com.automation.TruBILandingPage.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.Configuration.BaseConfig;
import com.automation.PageObject.LoginPage;

public class TruBIPrivacyTest extends BaseConfig{

	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(TruBIPrivacyTest.class.getName());
	
	LoginPage lp;
	
	@BeforeTest
	public void BrowserSetup() throws IOException
	{
		driver = getDriver();
		log.info("Browser invoked and Launched.");
		//getting the url from Properties file
		driver.get(prop.getProperty("url"));
		log.info("Entering the URL in Browser.");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void TestPrivacy() throws InterruptedException
	{
		lp = new LoginPage(driver);
		log.info("Clicking on the Privacy Link.");
		WebElement privacy = lp.Privacy();
		highLighterMethod(driver,privacy );
		lp.Privacy().click();
		log.info("Clicked on the Privacy Link.");
		Set<String> Window = driver.getWindowHandles();
		Iterator<String> it = Window.iterator();
		String Parentid = it.next();
		String Chileid = it.next();
		log.info("Switching to the Privacy page.");
		driver.switchTo().window(Chileid);
		log.info("Switched to the Privacy page.");
		Thread.sleep(3000);
		log.info("Getting Privacy page Title.");
		System.out.println(driver.getTitle());		
	}	
	
	public void Browserclose()
	{
		log.info("Driver is getting close.");
		driver.close();
	}
}
