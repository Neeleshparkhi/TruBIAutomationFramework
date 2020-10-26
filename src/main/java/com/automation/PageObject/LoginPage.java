package com.automation.PageObject;

 

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import com.automation.Configuration.BaseConfig;

 

public class LoginPage extends BaseConfig {
	
	
	Logger log = LogManager.getLogger(LoginPage.class.getName());
	
	public LoginPage(WebDriver driver)
	{

		this.driver =driver;
		PageFactory.initElements(driver, this);
      
     }

	 By UserName = By.id("txt-userName");
	
	 By Password = By.id("txt-pwd");
	 
	 By Loginbt = By.id("btnlogin");
	 
	 By LoginAlert = By.id("alert-modal-confirm-ok");
	 
	 By Privacy = By.xpath("//a[contains(text(),'Privacy')]");
	 
	 By Terms = By.xpath("//a[contains(text(),'Terms')]");
	 
	 public WebElement UserName()

     {
		 return driver.findElement(UserName);

     }
	 
	 public WebElement Password()

     {
		 return driver.findElement(Password);

     }
	 
	 public WebElement Loginbt()

     {
		 return driver.findElement(Loginbt);

     }
	 
	 public WebElement LoginAlert()

     {
		 return driver.findElement(LoginAlert);

     }
	 
	 public void getLoginVerify(String Username, String password) throws InterruptedException
	 {
		 Thread.sleep(5000);
		 //javaScriptClick(UserName, "");
		 log.info("Click on User Name");
		 //scrollIntoView(UserName);
		 log.info("Scroll the Page");
		 writeText(UserName, Username);
		 log.info("Enter the username:");
		 writeText(Password, password);
		 Click(Loginbt);
		 isAlertPresent();
		 
	 }
	 
	 public WebElement Privacy()
	 {
		 return driver.findElement(Privacy);
	 }
	 
	 public String getTitle()
	 {
		return driver.getTitle();
		 
	 }
	 
	 public WebElement Terms()
	 {
		 return driver.findElement(Terms);
	 }

}


	    

     

     

     
    

    

               

                

                

               

               

               

               