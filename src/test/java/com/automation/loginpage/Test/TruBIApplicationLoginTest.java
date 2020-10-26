package com.automation.loginpage.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.Configuration.BaseConfig;
import com.automation.PageObject.LoginPage;
import com.automation.PageObject.UserProfile;

public class TruBIApplicationLoginTest extends BaseConfig{
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(TruBIApplicationLoginTest.class.getName());
	
	LoginPage lp;
	UserProfile up;
	
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
	public void getLogin() throws InterruptedException
	{
		
		
		lp =new LoginPage(driver);
		lp.testName="Login";
		lp.title="Login";
		up = new UserProfile(driver);
		lp.getLoginVerify(prop.getProperty("UserName"), prop.getProperty("Password"));
		System.out.println(getTitle());
		

//		WebElement UserName = lp.UserName();
//		log.info("User clicking on UserName input box.");
//		highLighterMethod(driver,UserName );
//		lp.UserName().click();
//		log.info("User clicked on UserName input box.");
//		log.info("User Entering the UserName.");
//		lp.UserName().sendKeys(prop.getProperty("UserName"));
//		log.info("User Enterd the UserName.");
//		WebElement Password = lp.Password();
//		log.info("User Clicking on Password input box.");
//		highLighterMethod(driver,Password );
//		lp.Password().click();
//		log.info("User Clicked on Password input box.");
//		log.info("User entring the Password.");
//		lp.Password().sendKeys(prop.getProperty("Password"));
//		log.info("User Enterd the Password.");
//		WebElement loginbt = lp.Loginbt();
//		log.info("User clicking on Login Button.");
//		highLighterMethod(driver,loginbt );
//		lp.Loginbt().click();
//		log.info("User clicked on Login Button.");
//		waitForAlertToAppear();
//		
//		try {
//			log.info("User clicking on Alert OK Button.");
//			WebElement loginalert = lp.LoginAlert();
//			highLighterMethod(driver,loginalert );
//			lp.LoginAlert().click();
//		}
//		catch (Exception e)
//		{
//			
//		}
//		log.info("User clicking User Profile.");
//		WebElement Userprofile = up.UserProfile();
//		highLighterMethod(driver,Userprofile );
//		up.UserProfile().click();
//		log.info("User clicked User Profile.");
//		
//		log.info("User clicking Log Out.");
//		WebElement logout = up.LogOut();
//		highLighterMethod(driver,logout );
//		up.LogOut().click();
//		log.info("User Log out from the application.");		
	}
	
	//Browser is closing
	@AfterTest
	public void DriverClose()
	{
		driver.close();
	}


}
