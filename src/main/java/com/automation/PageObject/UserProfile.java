package com.automation.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UserProfile {
	
	public WebDriver driver;
	
	public UserProfile(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	By UserProfile = By.xpath("//i[@class='fa fa-user headerIconColor']");
	
	By LogOut = By.xpath("//a[contains(text(),'Logout')]");
	
	By MyTheme = By.xpath("//a[contains(text(),'My Themes')]");
	
	By Themelinkcount = By.xpath("//li//li//li//a");
	
	public WebElement UserProfile()
	{
		return driver.findElement(UserProfile);
	}
	
	public WebElement LogOut()
	{
		return driver.findElement(LogOut);
	}
	
	public WebElement MyTheme()
	{
		return driver.findElement(MyTheme);
	}
	
	public List<WebElement> Themelinkcount()
	{
		return driver.findElements(Themelinkcount);
	}
	

}
