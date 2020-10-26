package com.automation.TruBIHomepage.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.Configuration.BaseConfig;
import com.automation.PageObject.LoginPage;
import com.automation.PageObject.TruBIHomePage;
import com.automation.PageObject.UserProfile;

public class AllDashboardDropDownTest extends BaseConfig {
	
	public WebDriver driver;
	LoginPage lp;
	TruBIHomePage hp;
	
	public static Logger log = LogManager.getLogger(AllDashboardDropDownTest.class.getName());
	
	
	@BeforeTest
	public void BrowserSetup() throws IOException
	{
    
		driver = getDriver();
		driver.get(prop.getProperty("url"));
	
	}
	
	@Test
	public void AllDashboardDropDown() throws InterruptedException
	{
		
		waitForPageToLoad();
		lp =new LoginPage(driver);
		hp = new TruBIHomePage(driver);

		WebElement UserName = lp.UserName();
		log.info("User clicking on UserName input box.");
		highLighterMethod(driver,UserName );
		lp.UserName().click();
		log.info("User clicked on UserName input box.");
		log.info("User Entering the UserName.");
		lp.UserName().sendKeys(prop.getProperty("UserName"));
		log.info("User Enterd the UserName.");
		WebElement Password = lp.Password();
		log.info("User Clicking on Password input box.");
		highLighterMethod(driver,Password );
		lp.Password().click();
		log.info("User Clicked on Password input box.");
		log.info("User entring the Password.");
		lp.Password().sendKeys(prop.getProperty("Password"));
		log.info("User Enterd the Password.");
		WebElement loginbt = lp.Loginbt();
		log.info("User clicking on Login Button.");
		highLighterMethod(driver,loginbt );
		lp.Loginbt().click();
		log.info("User clicked on Login Button.");
		
		try {
			log.info("User clicking on Alert OK Button.");
			WebElement loginalert = lp.LoginAlert();
			highLighterMethod(driver,loginalert );
			lp.LoginAlert().click();
		}
		catch (Exception e)
		{
			
		}
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			Select s = new Select(hp.DashboardType());
			List<WebElement> element = s.getOptions();
			
			int count = element.size();
			for(int i=0; i<count;i++)
			{
				System.out.println(element.get(i).getText());
				element.get(i).click();
				Thread.sleep(3000);
				//int Dcount = hp.DashboardCount().size();
	            //Printing Dashboard Name
				List<WebElement> DName = driver.findElements(By.xpath("//*[@id='divDashboardPartialList']/div/div[2]/div"));
				int DashboardC = DName.size();
				for(int j=0 ; j<DashboardC;j++)
				{
				   System.out.println(DName.get(j).getText());
				}
				
				List<WebElement> RName = driver.findElements(By.xpath("//*[@id='divReportPartialList']/div/div[2]/div"));
				int ReportC = RName.size();
				for(int k=0;k<ReportC; k++)
				{
					System.out.println(RName.get(k).getText());
				}	
			}	System.out.println();
	}
}
