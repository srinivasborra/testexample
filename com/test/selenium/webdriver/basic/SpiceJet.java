package com.test.selenium.webdriver.basic;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SpiceJet {
	WebDriver driver;
	public void invoke() throws Exception{
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver = new WebDriverInit().invokeWebDriver("https://ksrtc.in/");
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot,new File("/Users/nagaborra/Desktop/kstrc.jpg"));
		driver.findElement(SpiceJetObject.fromPlace).sendKeys("BENG");
		//driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
//		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
//		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
//		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).click();
//		String startedPlaceId=driver.findElement(By.xpath("//input[@id='startPlaceId']")).getText(); //will return blank
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		boolean frmP =false;
		String frmPlace="";
		while(!frmP){
			
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
			String script1 = "return document.getElementById('fromPlaceName').value;";
			frmPlace = (String) jse.executeScript(script1);
			if(frmPlace.equalsIgnoreCase("BENGALURU INTERNATION AIPORT")){
				frmP = true;
				System.out.println(frmPlace);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		SpiceJet sj = new SpiceJet();
		sj.invoke();
		Thread.sleep(5000);
		if(sj.driver!=null)
		sj.driver.close();
	}

}

//System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
//driver = new ChromeDriver();
//driver.get("https://spicejet.com/");
////driver.findElement(By.xpath("//input[@name='email']")).sendKeys("myemailId");  //relative xpath
////driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("hello");
////driver.findElement(By.xpath("//input[@value='Log In']")).click();
//
////Select s = new Select(driver.findElement(By.id("//*[@id=\"divChild\"]/div[1]/span")));
////s.selectByIndex(2);
//driver.findElement(By.xpath("//*[@id=\"divpaxinfo\"]")).click();
//System.out.println(driver.findElements(By.tagName("a")).size());
//WebElement we = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]"));
//System.out.println(we.findElements(By.tagName("a")).size());
//
////driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@id='_hjRemoteVarsFrame']")));
////driver.findElement(By.xpath(".//iframe[@id='btn1']")).click();
////driver.switchTo().defaultContent();
