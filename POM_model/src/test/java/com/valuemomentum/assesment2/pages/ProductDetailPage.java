package com.valuemomentum.assesment2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage {

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}

	

	@FindBy(id = "add-to-cart-button")
	private WebElement _btnAddToCart;

	public void clickOnAddToCart() {
		_btnAddToCart.click();
	}

}