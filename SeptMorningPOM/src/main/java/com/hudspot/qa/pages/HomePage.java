package com.hudspot.qa.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage extends BasePage{
	
	
	//USING BY LOCATOR
	
	//@FindBy(xpath = "//span[@class='account-name ']")
	//WebElement accountName;
	
	By homePageHeader = By.xpath("//h1[text()='Sales Dashboard']");
	By accountName = By.xpath("//span[contains(@class,'account-name')]");
	
	//By clickContactButton = By.id("nav-primary-contacts-branch");
	
	@FindBy(id = "nav-primary-contacts-branch")
	WebElement contactLinkTab;
	
	@FindBy(id = "nav-secondary-contacts")
	WebElement contactLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	

	public String getHomePageTitle(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleIs(com.hudspot.qa.util.Constants.HOME_PAGE_TITLE));
		return driver.getTitle();
	}
	
	public String checkHomePageHeader(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(homePageHeader));
		
		if(driver.findElement(homePageHeader).isDisplayed()){
			return driver.findElement( homePageHeader).getText();
		}
		return null;
	}
	 public String getLoginInAccountName(){
		 WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.presenceOfElementLocated(accountName));
		 //wait.until(ExpectedConditions.visibilityOf(accountName));
		 return driver.findElement(accountName).getText();
	 }
	 
	 public void clickContact(){
		 WebDriverWait wait = new WebDriverWait(driver,20);
		 wait.until(ExpectedConditions.visibilityOf(contactLinkTab));
		 //wait.until(ExpectedConditions.visibilityOf(contactLinkTab));
		 contactLinkTab.click();
		 
		 wait.until(ExpectedConditions.visibilityOf(contactLinkTab));
		 contactLink.click();
	 }
 
	public ContactsPage goToContactsPage(){
		clickContact();
		return new ContactsPage(driver);
	}
}
