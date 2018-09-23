package com.test.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesForce {
	WebDriver webdriver;
	
	public void invokeBrowser(){
		
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		webdriver = new ChromeDriver();
		webdriver.get("https://login.salesforce.com/");
		webdriver.manage().deleteAllCookies();
		SalesForceObject sfo=new SalesForceObject(webdriver);
		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		sfo.getUserName().sendKeys("afadfdf");
		sfo.getPassword().sendKeys("adf1212");
		sfo.getBtnLogin().click();
//		webdriver.findElement(By.id("username")).sendKeys("hello");
//		webdriver.findElement(By.name("pw")).sendKeys("121212");
//		webdriver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
		String strErrorMsg=webdriver.findElement(By.cssSelector("#error.loginError")).getText();
		System.out.println(strErrorMsg);
	}
	
	public static void main(String[] args) throws Exception{
		SalesForce sf = new SalesForce();
		sf.invokeBrowser();
		Thread.sleep(5000);
		sf.webdriver.close();
	}

}
