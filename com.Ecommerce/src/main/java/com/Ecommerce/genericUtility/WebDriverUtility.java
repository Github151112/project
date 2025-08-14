package com.Ecommerce.genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void implicitWait(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public void launchApplication(String url, WebDriver driver) {
		driver.get(url);
	}

}
