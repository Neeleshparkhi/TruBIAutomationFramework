package com.automation.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TruBIAddUser {

	public WebDriver driver;
	
	public TruBIAddUser(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    By AddNewRow = By.xpath("//i[@class='dx-icon dx-icon-edit-button-addrow']");
	
	By LoginName = By.xpath("//body/div/div/div/div/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
	
	By DisplayName = By.xpath("(//input[@role='textbox'])[14]");
	
	By EmailId = By.xpath("(//input[@role='textbox'])[15]");
	
	By UserRole = By.xpath("//*[@id='AdminUserRole']/div[1]/div/div[1]");
	
	By MobileNumber = By.xpath("(//input[@role='textbox'])[16]");
	
	By Fauthentication = By.xpath("//div[@class='dx-fileuploader-button dx-button dx-button-normal dx-button-mode-contained dx-widget']//div[@class='dx-button-content']");
	
	By ListofFAcuthentication = By.xpath("//*[@id=\"dx-53b6b195-af69-c269-5fcb-241830920c5a\"]/div[1]/div/div[1]/div[2]/div");
	
	By FeatureAccess = By.xpath("//div[@id='AdminUserRole']//div[@class='dx-texteditor-input-container dx-tag-container dx-native-click']");
	
	By Savebt = By.xpath("//div[@class='dx-toolbar dx-widget dx-visibility-change-handler dx-collection dx-popup-bottom']//div[@class='dx-toolbar-items-container']//div[1]//div[1]//div[1]//div[1]");
	
	By SystemAdmin = By.xpath("//div[text()='System Admin']");
	
	public WebElement AddNewRow()
	{
		
		return driver.findElement(AddNewRow);
		
	}
	
	public WebElement LoginName()
	{
		return driver.findElement(LoginName);
	}
	
	public WebElement DisplayName()
	{
		return driver.findElement(DisplayName);
	}
	
	public WebElement EmailId()
	{
		return driver.findElement(EmailId);
	}
	
	public WebElement UserRole()
	{
		return driver.findElement(UserRole);
	}
	
	public WebElement systemAdmin()
	{
		return driver.findElement(SystemAdmin);
		
	}
	
	public void getUserRole(String role)
	{
		UserRole().click();
		systemAdmin().click();
//		Select ur = new Select(UserRole());
//		ur.selectByValue(role);
	}
	
	public WebElement MobileNumber()
	{
		return driver.findElement(MobileNumber);
	}
	
	public WebElement Fauthentication()
	{
		return driver.findElement(Fauthentication);
	}
	
	public List<WebElement> ListofFAcuthentication()
	{
		return driver.findElements(ListofFAcuthentication);
	}
	
	public void getAuthentication(String Auth)
	{
		Fauthentication().click();
		ListofFAcuthentication().size();
		ListofFAcuthentication().get(0).click();
		Select f = new Select(Fauthentication());
		f.selectByValue(Auth);
	}

	public WebElement FeatureAccess()
	{
		return driver.findElement(FeatureAccess);
	}
	
	public void getFeature(String Feature)
	{
		FeatureAccess().click();
		Select fa = new Select(FeatureAccess());
		fa.selectByValue(Feature);
	}
	
	public WebElement Savebt()
	{
		return driver.findElement(Savebt);
	}
	
	public void AddUser(String LoginName, String DisplayName, String EmailID, String UserRole, String MobileNumber, String FactorAuthentication, String FeatureAccess  )
	{
		
		LoginName().sendKeys(LoginName);
		DisplayName().sendKeys(DisplayName);
		EmailId().sendKeys(EmailID);
		getUserRole(UserRole);
		MobileNumber().sendKeys(MobileNumber);
		getAuthentication(FactorAuthentication);
		getFeature(FeatureAccess);
				
	}
	
	
	
}
