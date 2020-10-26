package com.automation.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TruBIHomePage {

	public WebDriver driver;
	
	public TruBIHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	By Group = By.xpath("//i[@class='fa fa-sitemap']");
	
	By DashboardType = By.xpath("//*[@class='listsel']");
	
	By All = By.xpath("//*[@id=\"ddlReportType\"]/option[1]");
	
    By AllDashboard = By.xpath("//div[@id='divDashboardPartialList1']//tbody");
    
    By DashboardCount = By.xpath("//*[@id='divDashboardPartialList1']/div/div[2]/div/table/tbody/tr");
	
    By DashboardName = By.xpath("//*[@id=\"divDashboardPartialList1\"]/div/div[2]/div/table/tbody/tr[1]/td[1]/div/a/div/div[2]/span");
    
	public WebElement Group()
	{
		return driver.findElement(Group);	
	}
	
	public WebElement DashboardType()
	{
		return driver.findElement(DashboardType);
	}
	
	public WebElement All()
	{
		return driver.findElement(All);
	}
	
	public WebElement AllDashboard()
	{
		return driver.findElement(AllDashboard);
	}
	
	public List<WebElement> DashboardCount()
	{
		return driver.findElements(DashboardCount);
	}
	
	public WebElement DashboardName()
	{
		return driver.findElement(DashboardName);
	}
}
