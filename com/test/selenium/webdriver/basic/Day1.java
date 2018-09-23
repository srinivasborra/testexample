package com.test.selenium.webdriver.basic;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Day1 {
	WebDriver driver;
	JavascriptExecutor jse;
	@Test
	public void invokeBrowser(){
		try {
			
			System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://localhost:8080");
			driver.getTitle();
			//driver.getPageSource();
			//System.out.println(driver.getCurrentUrl());
			//driver.switchTo().alert().
			driver.findElement(By.id("accountname")).sendKeys("testuser");
			driver.findElement(By.id("accountpassword")).sendKeys("test@123#1");
			Actions action= new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement appTopMenu = driver.findElement(By.id("app-toolbar"));
			int appTopMenuRowCnt = appTopMenu.findElements(By.id("")).size();
			System.out.println("Top Menu Row count"+appTopMenuRowCnt);
			String actionMnuText = driver.findElement(By.id("tb_header_toolbar_item_quick-actions")).getText();
			System.out.println(actionMnuText);
			//searchCourse();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	public void searchCourse(){
		try {
			driver.findElement(By.id("lst-ib")).sendKeys("Java");
			//Thread.sleep(1000);
			driver.findElement(By.name("btnK")).click();
			//driver.findElement(By.linkText("Forgot Password?")).click();
//		    jse = (JavascriptExecutor) driver;
//			jse.executeScript("scroll(0,1200);");
//			Set<String> ws = driver.getWindowHandles();
//			Iterator it = ws.iterator();
//			while(it.hasNext()){
//				System.out.println(it.next());
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Day1 d1 = new Day1();
		d1.invokeBrowser();
		//d1.tutor();
		d1.closeBrowser();
	}
   public void closeBrowser(){
	   try {
		Thread.sleep(5000);
	    driver.quit();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   public void tutor(){
	   System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
	   driver =new ChromeDriver();
	   driver.get("http://www.qaclickacademy.com/interview.php");
	   driver.findElement(By.xpath("//li[text()=' Selenium ']")).click();

	   driver.findElement(By.xpath("//ul[@class='responsive-tabs__list']/li[1]/following-sibling::li[2]")).click();

	   System.out.println(driver.findElement(By.xpath(".//*[@id='tablist1-tab2']/parent::ul")).getAttribute("role"));
   }
   @AfterMethod
   public void onErrorScreenshot(ITestResult result){
	   if(ITestResult.FAILURE == result.FAILURE){
		  try{
			  TakesScreenshot ts = (TakesScreenshot)driver;
			  File screenshot = ts.getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(screenshot, new File("/Users/nagaborra/Desktop/error"+currentDateTime()+".png"));
		  }catch(Exception e){
			  
		  }
		   System.out.println("There is some error$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		   driver.quit();
	   }
   }
   public String currentDateTime(){
	   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		Date date = new Date();
		String str=dateFormat.format(date); //2016/11/16 12:08:43
		return str;
   }
}
