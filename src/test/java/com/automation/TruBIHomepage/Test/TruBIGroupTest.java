package com.automation.TruBIHomepage.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.Configuration.BaseConfig;
import com.automation.PageObject.LoginPage;
import com.automation.PageObject.TruBIHomePage;
@Listeners(com.automation.Listeners.Listeners.class)
public class TruBIGroupTest extends BaseConfig{
	
	public WebDriver driver;
	
	TruBIHomePage hp;
	LoginPage lp;
	
	public static Logger log = LogManager.getLogger(TruBIGroupTest.class.getName());
	
	@BeforeTest
	public void BrowserSetup() throws IOException
	{
		driver = getDriver();
		log.info("Browser is Invoke and Launching");
		driver.get(prop.getProperty("url"));		
	}
	
	@Test
	public void TruBIGroup() throws InterruptedException
	{
		
        lp =new LoginPage(driver);
        hp = new TruBIHomePage(driver);
		
        WebElement UserName = lp.UserName();
        highLighterMethod(driver, UserName);
        log.info("Clicking on UserName");
		lp.UserName().click();
		log.info("Please Enter the UserName");
		lp.UserName().sendKeys("Neelesh");
		log.info("UserName is enterd");
		WebElement Paswword = lp.Password();
		highLighterMethod(driver, Paswword);
		lp.Password().click();
		log.info("Please Enter the Password");
		lp.Password().sendKeys("System@123");
		log.info("Password is Enterd");
		WebElement Loginbt = lp.Loginbt();
		highLighterMethod(driver, Loginbt);
		lp.Loginbt().click();
		log.info("User Clicked on Login Button");
		
		try {
			WebElement LoginAlert = lp.LoginAlert();
			highLighterMethod(driver, LoginAlert);
			lp.LoginAlert().click();
		}
		catch (Exception e)
		{
			
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		log.info("Program is clicking on Group");
		WebElement Groupclick = hp.Group();
		System.out.println(getTitle());
		highLighterMethod(driver, Groupclick);
		hp.Group().click();
		Thread.sleep(2000);
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class='dx-treelist-rowsview dx-treelist-nowrap dx-last-row-border dx-scrollable dx-visibility-change-handler dx-scrollable-both dx-scrollable-simulated dx-scrollable-customizable-scrollbars']//tr"));
		System.out.println(allLinks.size());
		int count = allLinks.size();
		for(int i=0 ; i<count; i++)
		{
			String GoupName = allLinks.get(i).getText();
			System.out.println(GoupName);
		}		
	}
}
