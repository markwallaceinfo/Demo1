package com.hudspot.qa.test;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hudspot.qa.pages.BasePage;

import com.hudspot.qa.pages.ContactsPage;
import com.hudspot.qa.pages.HomePage;
import com.hudspot.qa.pages.LoginPage;

public class ContactPageTest extends BasePage{

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		
		//driver.get(prop.getProperty("url"));
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();

	}
	
	@Test(priority=1)
	public void creatContactTest() {
		contactsPage.creatNewContact("Naveen06@gmail.com", "fNaveen", "joy", "Qa");
		Assert.assertTrue(driver.findElement(By.linkText("Naveen Test ")).isDisplayed());
	}

////	@Test(priority=2)
////	public void creatContactTest() {
////		contactsPage.creatNewContact("Naveen06@gmail.com", "fNaveen", "joy", "Qa");
////		Assert.assertTrue(driver.findElement(By.linkText("Naveen Test ")).isDisplayed());
////	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}