package com.hudspot.qa.test;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hudspot.qa.pages.BasePage;

import com.hudspot.qa.pages.ContactsPage;
import com.hudspot.qa.pages.HomePage;
import com.hudspot.qa.pages.LoginPage;

public class ContactPageTest extends BasePage {

	LoginPage loginPage;
	HomePage homePage;
	public ContactsPage contactsPage;

	public ContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();

	}

	@Test(priority = 1)
	public void creatContactTest() {
		contactsPage.creatNewContact("Naveen06@gmail.com", "fNaveen", "joy", "Qa");
		Assert.assertTrue(driver.findElement(By.linkText("Naveen Test ")).isDisplayed());
	}

	//// @Test(priority=2)
	//// public void creatContactTest() {
	//// contactsPage.creatNewContact("Naveen06@gmail.com", "fNaveen", "joy",
	//// "Qa");
	//// Assert.assertTrue(driver.findElement(By.linkText("Naveen Test
	//// ")).isDisplayed());
	//// }

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}