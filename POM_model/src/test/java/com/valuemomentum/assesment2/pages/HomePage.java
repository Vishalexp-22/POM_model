package com.valuemomentum.assesment2.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.*;

import com.valuemomentum.assesment2.test.DataUtility;

public class HomePage extends BasePage {




	public HomePage(WebDriver driver) {
		super(driver);

	}
	
    

	
	@FindBy(xpath ="//*[contains(@class,'nav-a  ')and contains(text(),'Mobiles')]")
	private static WebElement _btnMobile;


	public MobilesPage clickOnMobile() throws Exception {
		
	
        
		_btnMobile.click();
		return new MobilesPage(driver);
	}
	
	
/*	public static String GetItemText() {
		return _btnMobile.getText();
	}*/
	}