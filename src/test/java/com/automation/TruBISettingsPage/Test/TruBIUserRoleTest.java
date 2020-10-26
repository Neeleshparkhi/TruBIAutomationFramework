package com.automation.TruBISettingsPage.Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.Configuration.BaseConfig;
import com.automation.PageObject.LoginPage;
import com.automation.PageObject.TruBISetting;
import com.automation.PageObject.TruBIUserRole;

public class TruBIUserRoleTest extends BaseConfig {

	public static Logger log = LogManager.getLogger(TruBIUserRoleTest.class.getName());
	
public WebDriver dirver;

LoginPage lp;
TruBISetting ts;
TruBIUserRole tur;

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

@Test
 public void UserRole() throws InterruptedException
 {
	 waitForPageToLoad();
	 tur = new TruBIUserRole(driver);
	 ts = new TruBISetting(driver);
	 WebElement Settingicon = ts.Settingicon();
	 highLighterMethod(driver,Settingicon);
	 log.info("Clicking on Setting Icon.");
	 ts.Settingicon().click();
	 log.info("Clicked on Setting Icon.");
	 WebElement setting = ts.Setting();
	 highLighterMethod(driver,setting);
	 Thread.sleep(2000);
	 log.info("Clicking on Setting option.");
	 ts.Setting().click();
	 log.info("Clicked on Setting option.");
	 waitForPageToLoad();
	 WebElement Userrole = tur.UserRole();
	 highLighterMethod(driver,Userrole);
	 log.info("Clicking on UserRole option.");
	 tur.UserRole().click();
	 log.info("Clicked on UserRole option.");
	 waitForPageToLoad();
	 WebElement adduserrole = tur.AddUserRole();
	 highLighterMethod(driver,adduserrole);
	 log.info("Clicking on AddUser Role option.");
	 tur.AddUserRole().click();
	 log.info("Clicked on AddUser Role option.");
	 WebElement userrole = tur.RoleName();
	 highLighterMethod(driver,userrole);
	 log.info("Sending the User Role Name.");
	 tur.RoleName().click();
	 tur.RoleName().sendKeys(prop.getProperty("UserRole"));
	 WebElement SaveBT = tur.SaveBt();
	 highLighterMethod(driver,SaveBT);
	 log.info("Clicking on Save Button.");
	 tur.SaveBt().click();
	 
    //Verification UserRole part
	 
	WebElement Search = tur.SearchRole();
	highLighterMethod(driver,Search);
	tur.SearchRole().click();
	tur.SearchRole().sendKeys(prop.getProperty("UserRole"));
	Thread.sleep(2000);
	String ExpectedUserRoleName= prop.getProperty("UserRole");
	String ActualUserRoleName = tur.VerifyRoleName().getText();
	System.out.println(tur.VerifyRoleName().getText());
	Assert.assertEquals(ActualUserRoleName, ExpectedUserRoleName);
 }

 
}
