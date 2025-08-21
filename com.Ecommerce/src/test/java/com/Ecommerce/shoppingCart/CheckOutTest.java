package com.Ecommerce.shoppingCart;

import org.testng.annotations.Test;

import com.Ecommerce.genericUtility.BaseTest;
import com.Ecommerce.objectRepository.LoginPage;
import com.Ecommerce.objectRepository.ShoppingCartPage;
import com.Ecommerce.objectRepository.WelcomePage;

public class CheckOutTest extends BaseTest {
	
	@Test
	public void checkOutOperation() throws InterruptedException
	{
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		LoginPage lp = new LoginPage(driver);
		lp.performLogin("d123456789@gmail.com", "d@123456");
		wp.getProductAddToCart(driver, "14.1-inch Laptop").click();
		wp.getShoppingCartLink().click();
		ShoppingCartPage scp = new ShoppingCartPage(driver);
		scp.orderConfirmation();
		w.scrollDown(driver, 1000);
		w.getScreenshotFullPage(driver,"OrderDetails");
	}

}
