package com.automation.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TruBIUserRole {

	public WebDriver driver;
	
	public TruBIUserRole(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By UserRole = By.xpath("//a[contains(text(),'User Roles')]");
	
	By AddUserRole = By.xpath("//i[@title='Add New Role']");
	
	By RoleName = By.xpath("//tbody[@role='presentation']/tr/td/div/div/div/div/input");
	
	By SaveBt = By.xpath("//tr[1]//td[2]//a[1]");
	
	By SearchRole = By.xpath("//html//body//div//section//div//div//div//div//div//div//div//table//tbody//tr//td//div//div//div//div//div//input");
	
	By VerifyRoleName = By.xpath("//*[@id=\"gridContainer\"]/div/div[6]/div/table/tbody/tr[1]/td[1]");
	
	public WebElement UserRole()
	{
		return driver.findElement(UserRole);
	}
	
	public WebElement AddUserRole()
	{
		return driver.findElement(AddUserRole);
	}
	
	public WebElement RoleName()
	{
		return driver.findElement(RoleName);
	}
	
	public WebElement SaveBt()
	{
		return driver.findElement(SaveBt);
	}
	
	public WebElement SearchRole()
	{
		return driver.findElement(SearchRole);
	}
	
	public WebElement VerifyRoleName()
	{
		return driver.findElement(VerifyRoleName);
	}
	
	
}
