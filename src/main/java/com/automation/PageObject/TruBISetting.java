package com.automation.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TruBISetting {
	
	public WebDriver driver;
	
	public TruBISetting(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By Settingicon = By.xpath("//i[@class='fa fa-cog headerIconColor']");
	
	By Setting = By.xpath("//a[contains(text(),'Settings')]");
	
	
	public WebElement Settingicon()
	{
		
		return driver.findElement(Settingicon);
		
	}
	
	public WebElement Setting()
	{
		return driver.findElement(Setting);
		
	}
	
	
	

	
	
}
