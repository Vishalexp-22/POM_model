package com.valuemomentum.assesment2.utils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class WebDriverHelper extends BaseTest {

	static WebDriver driver;

	public static void ScreenShot(String methodName) {
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C:\\Training\\Java\\assesment2\\screenshot\\"+methodName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void switchToWindow() {
		String currentWindow = getDriver().getWindowHandle();
		Set<String> windows = getDriver().getWindowHandles();
		Iterator<String> ite = windows.iterator();
		while (ite.hasNext()) {
			String newWindow = ite.next();
			if (!currentWindow.equals(newWindow)) {
				getDriver().switchTo().window(newWindow);
			}
		}
	}

	
}
