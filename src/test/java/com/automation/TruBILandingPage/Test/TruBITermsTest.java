package com.automation.TruBILandingPage.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.Configuration.BaseConfig;
import com.automation.PageObject.LoginPage;

import junit.framework.Assert;

public class TruBITermsTest extends BaseConfig {
	
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
	public void TestTerms()
	{
		lp = new LoginPage(driver);
		waitForPageToLoad();
		lp.Terms().click();
		log.info("Clicked on Terms" );
		switchToWindow_GetTitle();
		
		String Expected = "Terms and Conditions";
		
//		Set<String> window = driver.getWindowHandles();
//		Iterator<String> it = window.iterator();
//		String parentid = it.next();
//		String childid = it.next();
//		driver.switchTo().window(childid);
		
	}
	
}
