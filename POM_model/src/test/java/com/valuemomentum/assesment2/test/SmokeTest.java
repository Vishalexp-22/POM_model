package com.valuemomentum.assesment2.test;


import org.testng.annotations.Test;

import com.valuemomentum.assesment2.pages.TrailPage;
import com.valuemomentum.assesment2.pages.HomePage;
import com.valuemomentum.assesment2.pages.MobilesPage;
import com.valuemomentum.assesment2.pages.ProductDetailPage;
import com.valuemomentum.assesment2.utils.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class SmokeTest extends BaseTest{
	private static final Logger logger=(Logger) LogManager.getLogger(SmokeTest.class);
	WebDriver driver;
	HomePage homePage;
	ProductDetailPage productDetailPage;
	MobilesPage mobilesPage;
	TrailPage trailPage;
	
	@BeforeClass
	public void setup() {
		logger.info("Setup method called");
		this.driver = getDriver();
		homePage=new HomePage(driver);
		
	}

	@Test
	public void assessment2() throws Exception {
		logger.info("Home Page method called");
		
		String extractedText=DataUtility.readData();
        Assert.assertEquals(extractedText, "Mobiles");
		
		mobilesPage=homePage.clickOnMobile();
		Thread.sleep(2000);
		
		logger.info("MobilePage method called");
		
		trailPage=mobilesPage.clickOnSelected();
		
		logger.info("Filter Result Page method called");
		
		productDetailPage=trailPage.clickOnItem();
		Thread.sleep(2000);
		
		logger.info("Product Details Page method called");
	
		productDetailPage.clickOnAddToCart();
		Thread.sleep(5000);
		logger.info("Test Ended");
		
		
		
		
		
		
	}
}