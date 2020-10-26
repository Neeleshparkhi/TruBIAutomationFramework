package com.automation.Configuration;

import org.openqa.selenium.By;

public interface AutomationLocators {
	
	 By UserName = By.id("txt-userName");
		
	 By Password = By.id("txt-pwd");
	 
	 By Loginbt = By.id("btnlogin");
	 
	 By LoginAlert = By.id("alert-modal-confirm-ok");
	 
	 By Privacy = By.xpath("//a[contains(text(),'Privacy')]");
	 
	 By Terms = By.xpath("//a[contains(text(),'Terms')]");

}
