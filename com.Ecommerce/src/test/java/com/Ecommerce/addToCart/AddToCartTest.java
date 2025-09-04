package com.Ecommerce.addToCart;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Ecommerce.genericUtility.BaseTest;
import com.Ecommerce.genericUtility.CustomListener;
import com.Ecommerce.objectRepository.WelcomePage;

@Listeners(CustomListener.class)
public class AddToCartTest extends BaseTest {

	@Test
	public void addToCart() throws InterruptedException {
        Thread.sleep(5000);
		WelcomePage wp = new WelcomePage(driver);
		wp.getProductAddToCart(driver, "14.1-inch Laptop").click();
		Thread.sleep(5000);
		
		//d123456789@gmail.com
		//d@123456
	}

}
