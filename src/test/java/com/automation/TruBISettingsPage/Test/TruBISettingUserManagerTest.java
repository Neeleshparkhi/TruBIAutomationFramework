package com.automation.TruBISettingsPage.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.Configuration.BaseConfig;
import com.automation.PageObject.LoginPage;
import com.automation.PageObject.TruBIAddUser;
import com.automation.PageObject.TruBIHomePage;
import com.automation.PageObject.TruBISetting;

public class TruBISettingUserManagerTest extends BaseConfig {
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(TruBISettingUserManagerTest.class.getName());
	
	LoginPage lp;
	TruBISetting ts;
	TruBIAddUser ta;
	
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
		log.info("Paswword is Enterd");
		WebElement login = lp.Loginbt();
		highLighterMethod(driver,login);
		lp.Loginbt().click();
		log.info("User Cliced on Login Button");
		try {
			WebElement alert = lp.LoginAlert();
			highLighterMethod(driver,alert);
			lp.LoginAlert().click();
		}
		catch (Exception e)
		{
			
		}
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider = "getAddUserAccount")
	public void UserManaer(String LoginName, String DisplayName, String EmailID, String UserRole, String MobileNumber, String FactorAuthentication, String FeatureAccess) throws InterruptedException
	{
		
		
		ts = new TruBISetting(driver);
		ta = new TruBIAddUser(driver);
     
		
		log.info("User Clicked Setting Icon From HomePage");
		ts.Settingicon().click();
		log.info("User is clicking on Settings");
		ts.Setting().click();
		Thread.sleep(3000);
		log.info("User is clicking on Add New Row + Button");
		ta.AddNewRow().click();
		Thread.sleep(3000);
		ta.AddUser(LoginName, DisplayName, EmailID, UserRole, MobileNumber, FactorAuthentication, FeatureAccess);
		log.info("User account is added");
		ta.Savebt().click();
			
	}
	
	@DataProvider
	public String[][] getAddUserAccount()
	{	
		String[][] dataRecords = getData("UserCreation.xlsx","CreateUser");	
		return dataRecords;	
	}
	
}
