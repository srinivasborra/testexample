package com.test.selenium.webdriver.basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class RediffRegistrationTest {
	WebDriver driver;
	public void testRegistration(){
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		try {
			//String regExVal = "/[A-Z 0-9]{4}/g";
			String regExVal = "/.*[A-Z 0-9]{4}.*/g";
			driver = new WebDriverInit().invokeWebDriver("https://mail.rediff.com/cgi-bin/login.cgi");
			driver.findElement(By.xpath("//a[contains(text(),'Create a new account')]")).click();
//			driver.findElement(By.xpath("//input[@type='text'][1]")).sendKeys("Sameer Bhagwat");
//			driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("srinivas_foryou");
			driver.findElement(By.xpath("//input[contains(@name,'name')]")).sendKeys("Sameer Bhagwat");
			driver.findElement(By.xpath("//input[contains(@name,'login')]")).sendKeys("srinivas_foryou");
			driver.findElement(By.xpath("//input[@type='password'][1]")).sendKeys("welcome123");
			driver.findElement(By.xpath("//input[contains(@name,'confirm_passwd')]")).sendKeys("welcome123");
			driver.findElement(By.xpath("//input[contains(@name,'altemail')]")).sendKeys("testuser@gmail.com");
			driver.findElement(By.xpath("//input[contains(@name,'chk_altemail')]")).click();
			Select question = new Select(driver.findElement(By.xpath("//select[contains(@name,'hint')]")));
			List<WebElement> options = question.getOptions();
			for(WebElement opt : options){
				if((opt.getText()).contains("What is the name of your first school")){
					opt.click();
					break;
				}
			}
			driver.findElement(By.xpath("//input[@type='password'][contains(@name,'hint')]")).sendKeys("welcome123");
			driver.findElement(By.xpath("//input[contains(@name,'mothername')]")).sendKeys("mymom");
			
			driver.findElement(By.xpath("//*[@id=\"div_mob\"]/table/tbody/tr/td[3]/div[2]")).click();
			driver.findElement(By.xpath("//input[contains(@name,'mobno')]")).sendKeys("900729998");
			
			Select dobd = new Select(driver.findElement(By.xpath("//select[contains(@name,'DOB_Day')]")));
			List<WebElement> dd = dobd.getOptions();
			for(WebElement day : dd){
				if((day.getText()).contains("07")){
					day.click();
					break;
				}
			}
			Select dobm = new Select(driver.findElement(By.xpath("//select[contains(@name,'DOB_Month')]")));
			List<WebElement> dm = dobm.getOptions();
			for(WebElement mnth : dm){
				if((mnth.getText()).contains("JUL")){
					mnth.click();
					break;
				}
			}
			Select doby = new Select(driver.findElement(By.xpath("//select[contains(@name,'DOB_Year')]")));
			List<WebElement> dy = doby.getOptions();
			for(WebElement yr : dy){
				if((yr.getText()).contains("1971")){
					yr.click();
					break;
				}
			}
			
			Select cities = new Select(driver.findElement(By.xpath("//select[contains(@name,'city')]")));
			List<WebElement> cts = cities.getOptions();
			for(WebElement ct : cts){
				if((ct.getText()).contains("Bangalore")){
					ct.click();
					break;
				}
			}
			driver.findElement(By.className("captcha")).sendKeys(regExVal);
			driver.findElement(By.id("Register")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception{
		RediffRegistrationTest rf = new RediffRegistrationTest();
		rf.testRegistration();
		Thread.sleep(5000);
//		if(rf.driver!=null)
//		rf.driver.close();
	}
}
