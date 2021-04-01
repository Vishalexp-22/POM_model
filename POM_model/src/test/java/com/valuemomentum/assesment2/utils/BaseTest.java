package com.valuemomentum.assesment2.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	static WebDriver driver;



	public static void setDriver(WebDriver driver) {
		BaseTest.driver = driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeTest
	public void test_beforesuit() {
		System.setProperty("webdriver.chrome.driver","C:\\Training\\Java\\TestAutomation\\lib\\chromedriver.exe");
	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

	}

	@AfterTest
	public void test_aftersuit() {
		driver.close();
		driver.quit();
	}
}
