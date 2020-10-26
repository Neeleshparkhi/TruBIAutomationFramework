package com.automation.TruBIUserProfile;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.Configuration.BaseConfig;
import com.automation.PageObject.LoginPage;
import com.automation.PageObject.UserProfile;

public class TruBIMyThemesTest extends BaseConfig{

	Logger log = LogManager.getLogger(TruBIMyThemesTest.class.getName());
	
	public WebDriver driver;
	
	UserProfile up;
	LoginPage lp;
	
	@BeforeTest
	public void BrowserInvoke() throws IOException, InterruptedException
	{
		driver = getDriver();
		log.info("Browser is invoke and Launched");
		driver.get(prop.getProperty("url"));
		lp = new LoginPage(driver);
		WebElement Username = lp.UserName();
		highLighterMethod(driver,Username );
		lp.UserName().click();
		log.info("Please Enter the UserName");
		lp.UserName().sendKeys("Neelesh");
		log.info("UserName is enterd");
		WebElement password = lp.Password();
		highLighterMethod(driver,password );
		lp.Password().click();
		log.info("Please Enter the Password");
		lp.Password().sendKeys("System@123");
		log.info("Password is Enterd");
		WebElement login = lp.Loginbt();
		highLighterMethod(driver,login);
		lp.Loginbt().click();
		log.info("User Clicked on Login Button");
		Thread.sleep(3000);
		try {
			log.info("User clicking on Alert OK Button.");
			WebElement loginalert = lp.LoginAlert();
			highLighterMethod(driver,loginalert );
			lp.LoginAlert().click();
		}
		catch (Exception e)
		{
			
		}
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void Themes() throws IOException
	{
		waitForPageToLoad();
		up = new UserProfile(driver);
		List<WebElement> Themecount = up.Themelinkcount();
		int Themetotalcount = Themecount.size();
		System.out.println(Themetotalcount);
		for(int i=0;i<Themetotalcount;i++)
		{
			up.UserProfile().click();
			up.MyTheme().click();
			String ThemeName = Themecount.get(i).getText();
			log.info("Selecting the Theme : " + Themecount.get(i).getText());
			System.out.println(ThemeName);
			Themecount.get(i).click();
			getScreenShotPath(driver, ThemeName);
			waitForPageToLoad();
			
		}
	}
}
