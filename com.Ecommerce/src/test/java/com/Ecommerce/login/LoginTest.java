package com.Ecommerce.login;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ecommerce.genericUtility.BaseTest;
import com.Ecommerce.genericUtility.ExcelUtility;
import com.Ecommerce.objectRepository.LoginPage;
import com.Ecommerce.objectRepository.RegisterPage;
import com.Ecommerce.objectRepository.WelcomePage;

public class LoginTest extends BaseTest {

	@DataProvider(name = "positiveData")
	public Object[][] getPositiveData() throws EncryptedDocumentException, IOException {
		return ExcelUtility.readMultipleData(EXCEL_PATH, "ValidLoginData");
	}

	@Test(dataProvider = "positiveData", priority = 1)
	public void positiveLoginTest(String email, String password) throws InterruptedException {
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login");
		LoginPage lp = new LoginPage(driver);
		lp.performLogin(email, password);
		RegisterPage rp = new RegisterPage(driver);
		Assert.assertEquals(rp.getLogoutLink().isDisplayed(), true);
	}

	@DataProvider(name = "NegativeData")
	public Object[][] getNegativeData() throws EncryptedDocumentException, IOException {
		return ExcelUtility.readMultipleData(EXCEL_PATH, "InvalidLoginData");
	}

	@Test(dataProvider = "NegativeData", priority = 2,enabled = false)
	public void negativeLoginTest(String email, String password) {
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		LoginPage lp = new LoginPage(driver);
		lp.performLogin(email, password);
	}

}
