package com.hudspot.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hudspot.qa.pages.BasePage;
import com.hudspot.qa.pages.HomePage;
import com.hudspot.qa.pages.LoginPage;



public class HomePageTest extends BasePage{
	
	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest(){
		super();
	}

	@BeforeMethod
	public void setUp() {
        init();
        loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void homePageHeaderTest() {
		Assert.assertEquals(homePage.checkHomePageHeader(),com.hudspot.qa.util.Constants.HOME_PAGE_HEADER);
	}

	@Test(priority=2)
	public void homePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("home page title" + title);
		Assert.assertEquals(title,com.hudspot.qa.util.Constants.HOME_PAGE_TITLE);
	}

	@Test(priority=3)
	public void accountNameTest() {
		String accountName = homePage.getLoginInAccountName();
		System.out.println("logged in user account name is" + accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();

	}
}
