package com.automation.TruBILandingPage.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.Configuration.BaseConfig;
import com.automation.PageObject.ForgotPassword;

public class ForgotPasswordTest extends BaseConfig {
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(ForgotPasswordTest.class.getName());
	
	ForgotPassword fp;
	
	public String ExpectedBlankEmailAlert = "Email address is required";
	
	
	@BeforeTest
	public void BrowserSetup() throws IOException
	{
		
		driver = getDriver();
		log.info("Browser is invoke and Launched");
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	public void ForgotPassword()
	{
		
		fp = new ForgotPassword(driver);
		log.info("Click on Forgot Password link");
		WebElement Forgotpassword = fp.Forgotp();
		highLighterMethod(driver,Forgotpassword );
		fp.Forgotp().click();
		log.info("Entering The User Email ID");
		System.out.println(driver.getTitle());
		fp.ForgotEmailid().sendKeys(prop.getProperty("EmailId"));
		log.info("Click on Recover Button");
		fp.RecoveryBt().click();
		WebElement AlertMessage = fp.EmailAlertMessage();
		highLighterMethod(driver,AlertMessage);
		WebElement Atext = fp.EmailAlertMessage();
		String ActualText = Atext.getText();
		String ExpectedText = "Email address is not valid: neelesh.parkhi@datamatics.com";
		System.out.println(ActualText);
		//Assert.assertEquals(ActualText, ExpectedText, "Email address is not valid: neelesh.parkhi@datamatics.com");
		
	}
}
