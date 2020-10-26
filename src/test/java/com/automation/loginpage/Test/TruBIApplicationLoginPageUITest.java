package com.automation.loginpage.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.Configuration.BaseConfig;
import com.automation.PageObject.LoginPage;



public class TruBIApplicationLoginPageUITest extends BaseConfig {

	public WebDriver driver;
	
	LoginPage lp;
	
	public static Logger log = LogManager.getLogger(TruBIApplicationLoginPageUITest.class.getName());
	
	
	//invoking the broswer
		@BeforeTest
		public void BrowserSetup() throws IOException
		{
			
			driver = getDriver();
			log.info("Browser invoked and Launched");
			//getting the url from Properties file
			driver.get(prop.getProperty("url"));
			log.info("Entering the URL in Browser");
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	
	@Test
	public void LoginPageUITest()
	{
		lp = new LoginPage(driver);
		System.out.println(getTitle());
		String ActualTitle = getTitle();
		String ExcpectedTitle = prop.getProperty("LoginPageTitle");
	    assertEquals(ActualTitle, ExcpectedTitle);
	}
	
	@AfterTest
	public void BrowserClose()
	{
		driver.close();
	}
}
