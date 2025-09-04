package com.Ecommerce.register;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Ecommerce.genericUtility.BaseTest;
import com.Ecommerce.genericUtility.ExcelUtility;
import com.Ecommerce.objectRepository.RegisterPage;
import com.Ecommerce.objectRepository.WelcomePage;

public class RegisterTest extends BaseTest {

	@DataProvider(name = "TestData")
	public Object[][] getRegisterData() throws EncryptedDocumentException, IOException {
		return ExcelUtility.readMultipleData(EXCEL_PATH, REG_SHEET);
	}

	@Test(dataProvider = "TestData")
	public void register(String firstName, String lastName, String email, String password) {
		WelcomePage wp = new WelcomePage(driver);
		wp.getRegisterLink().click();
		SoftAssert s = new SoftAssert();
		s.assertEquals(driver.getTitle(), "Demo Web Shop. Register");
		RegisterPage rp = new RegisterPage(driver);
		rp.registration(driver, "Male", firstName, lastName, email, password);
		s.assertAll();

	}
}
