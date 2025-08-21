package com.Ecommerce.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BaseClass {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "termsofservice")
	private WebElement termsServicesCheckbox;

	@FindBy(id = "checkout")
	private WebElement checkOutButton;

	@FindBy(xpath = "//input[@onclick='Billing.save()']")
	private WebElement billingContinue;

	@FindBy(xpath = "//input[@onclick='Shipping.save()']")
	private WebElement shippingContinue;

	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
	private WebElement shippingMethodContinue;

	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
	private WebElement paymentMethodContinue;

	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")
	private WebElement paymentInfoContinue;

	@FindBy(xpath = "//input[@value='Confirm']")
	private WebElement confirmButton;

	@FindBy(linkText = "Click here for order details.")
	private WebElement orderDetailsLink;

	public void orderConfirmation() {
		termsServicesCheckbox.click();
		checkOutButton.click();
		billingContinue.click();
		shippingContinue.click();
		shippingMethodContinue.click();
		paymentMethodContinue.click();
		paymentInfoContinue.click();
		confirmButton.click();
		orderDetailsLink.click();
	}

}
