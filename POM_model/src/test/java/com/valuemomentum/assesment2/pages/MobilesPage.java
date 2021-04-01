package com.valuemomentum.assesment2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.valuemomentum.assesment2.utils.WebDriverHelper;

public class MobilesPage extends BasePage {

	public MobilesPage(WebDriver driver) {
		super(driver);

	}

	// element
	@FindBy(xpath = "//*[text()='Oye Stuff']")
	private WebElement _btnoyestuff;

	public  TrailPage clickOnSelected() {
		_btnoyestuff.click();
		//WebDriverHelper1.switchToWindow();
		return new TrailPage(driver);

	}

}