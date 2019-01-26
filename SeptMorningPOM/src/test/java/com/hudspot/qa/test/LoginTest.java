package com.hudspot.qa.test;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hudspot.qa.pages.BasePage;
import com.hudspot.qa.pages.LoginPage;
import com.hudspot.qa.util.Constants;



public class LoginTest extends BasePage{

    LoginPage loginPage;
	
	public LoginTest(){
		super();
	}
	
 
	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		}

	@Test(priority=1)
	public void verifyLoginPageTitleTest(){
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is"+ title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	
		
	}
	
	@Test(priority=2)
	public void loginTest(){
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 boolean flag1 = driver.findElement(By.className("private-page__title")).isDisplayed();
		 Assert.assertTrue(flag1);
		 
		 
	}
	
	@Test(priority=4)
	public void clickSignUplinkTest(){
		loginPage.clickSignUp();
		boolean flag3 = driver.findElement(By.id("uid-firstName-9")).isDisplayed();
		Assert.assertTrue(flag3);
		
	}
	
	@Test(priority=3)
	public void loginInwithInCorrTest(){
		loginPage.loginInCorrect(prop.getProperty("username1"), prop.getProperty("password"));
		boolean flag = driver.findElement(By.className("alert private-alert")).isDisplayed();
		Assert.assertTrue(flag);
				
	}
	
	@AfterMethod
	public void tearDown(){
		driver=null;
		driver.quit();
	}

	
}
