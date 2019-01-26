package com.hudspot.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	
	@FindBy(id = "username")
	WebElement userName;

	@FindBy(id = "password")
	WebElement passWord;

	@FindBy(id = "loginBtn")
	WebElement loginButton;
	
	@FindBy(linkText = "Sign up")
	WebElement linkText;

	
	public LoginPage(){
	   PageFactory.initElements(driver,this);

	}

	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public void loginInCorrect(String Username, String Pwd){
		userName.sendKeys(Username);
		passWord.sendKeys(Pwd);
		loginButton.click();
	}
	
	public void clickSignUp(){
		linkText.click();
	}
	
	public HomePage login(String username,String pwd){
		userName.sendKeys(username);
		passWord.sendKeys(pwd);
		loginButton.click();
		
	return new HomePage();
		
	}
	
	
}
