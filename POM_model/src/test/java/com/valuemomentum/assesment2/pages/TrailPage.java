package com.valuemomentum.assesment2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.valuemomentum.assesment2.utils.WebDriverHelper;

public class TrailPage extends BasePage {

	public TrailPage(WebDriver driver) {
		super(driver);

	}

	// element
	@FindBy(xpath = "//*[text()='OYESTUFF Patterns Printed Designer Slim Soft Back Cover Case for iPhone 7']")
	private WebElement _lblItem1;

	public ProductDetailPage clickOnItem() {
		_lblItem1.click();
		WebDriverHelper.switchToWindow();
		return new ProductDetailPage(driver);

	}

}