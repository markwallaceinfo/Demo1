package com.hudspot.qa.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hudspot.qa.util.Constants;

public class BasePage {

	public static WebDriver driver = null;
	public static Properties prop = null;

	public BasePage() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/hudspot/qa/config/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void init() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/mark/Downloads/browser/chromedriver");
			driver = new ChromeDriver();
		} 
		else if (browserName.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", "/Users/mark/Downloads/browser/geckodriver");
			driver = new FirefoxDriver();
		}

		// driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT,
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

}
