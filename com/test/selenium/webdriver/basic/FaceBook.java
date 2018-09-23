package com.test.selenium.webdriver.basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBook {
	WebDriver driver;
	public void invoke(){
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://facebook.com/");
//		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("myemailId");  //relative xpath
//		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("hello");
//		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("myemailId"); 
		String str=driver.findElement(By.xpath("//div[@id='content']/div/div/div/div/div[2]/h2")).getText(); //absolute xpath
		System.out.println(str);
		String str1=driver.findElement(By.xpath("//*[@id=\"month\"]/option[9]")).getText();
		System.out.println(str1);
	}
	public static void main(String[] args) throws Exception {
		FaceBook fb = new FaceBook();
		fb.invoke();
		Thread.sleep(5000);
		fb.driver.close();
	}

}
