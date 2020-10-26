package com.automation.PageObject;

 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

 
public class ForgotPassword {

               public WebDriver driver;

               public ForgotPassword(WebDriver driver)

                {
            	   this.driver = driver;
            	   PageFactory.initElements(driver, this); 
 
                }
               
     By Forgotp = By.id("forgotpassword");
     
     By ForgotEmailid = By.id("txt-pwdrecover");
     
     By RecoveryBt= By.id("btnRecoverpassword");
     
     By ReturnLogin = By.id("rtntologin");
     
     By EmailAlertMessage = By.id("lblcss");

     public WebElement Forgotp()
     {
    	 return driver.findElement(Forgotp);
     }
     
     public WebElement ForgotEmailid()
     {
    	 return driver.findElement(ForgotEmailid);
     }
     
     public WebElement RecoveryBt()
     {
    	 return driver.findElement(RecoveryBt);                  	 
     }
     
     public WebElement ReturnLogin()
     {
    	 return driver.findElement(ReturnLogin);
     }
     
     public WebElement EmailAlertMessage()
     {
    	 return driver.findElement(EmailAlertMessage);
     }
     
     
     
}


               

                
               

                

               

                

               

                

 

            