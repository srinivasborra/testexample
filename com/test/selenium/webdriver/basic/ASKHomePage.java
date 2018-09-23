package com.test.selenium.webdriver.basic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ASKHomePage {
	WebDriver driver;
	@Test
	public void testHomePage(){
		try {
			driver = new ASKWebDriver().invokeWebDriver("https://google.com");
			Thread.sleep(3000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Home Page");
	}
}
