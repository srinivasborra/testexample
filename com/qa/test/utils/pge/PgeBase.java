package com.qa.test.utils.pge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;

public class PgeBase {

	public static WebDriver driver;
	
	//@Before(order=0)
	public PgeBase(){
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		if(driver==null){
			driver =new ChromeDriver();
			driver.get("https://www.pge.com/");
		}
	}
}
