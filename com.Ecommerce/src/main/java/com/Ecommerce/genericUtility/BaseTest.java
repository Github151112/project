package com.Ecommerce.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * @author AMAN SINGH 
 * 12 August 2025
 */

public class BaseTest implements IAutoConstant {

	FileUtility f = new FileUtility();
	WebDriverUtility w = new WebDriverUtility();
	public WebDriver driver;

	@BeforeSuite
	public void toConnectServer() {
		Reporter.log("===server started===", true);
	}

	@BeforeTest
	public void toConnectDatabase() {
		Reporter.log("===database connected sucessfully===", true);
	}

	@BeforeClass
	public void setUp() {
		String browser = f.retrieveDataFromProperty(PROP_PATH, "browser");
		String url = f.retrieveDataFromProperty(PROP_PATH, "url");
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			Reporter.log("==Invalid browser==", true);
		}
		Reporter.log("==" + browser + "launched sucessfully", true);
		w.maximizeWindow(driver);
		w.implicitWait(driver, 5);
		w.launchApplication(url, driver);
	}

	@AfterClass
	public void tearDown() {
		Reporter.log("==browser closed sucessfully", true);
		driver.quit();
	}

	@AfterTest
	public void toCloseDb() {
		Reporter.log("==database closed sucessfully", true);
	}

	@AfterSuite
	public void toCloseServer() {
		Reporter.log("==server closed sucessfully==", true);
	}

}
