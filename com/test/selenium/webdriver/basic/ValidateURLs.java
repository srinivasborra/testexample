package com.test.selenium.webdriver.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidateURLs {
	private WebDriver driver;
	
	public void invokeURL(){
		try {
			String currentURL="https://x.co/6nUBa";
			driver= new WebDriverInit().invokeWebDriver(currentURL);
			WebElement ele = driver.findElement(By.tagName("body"));
			
			System.out.println(driver.getPageSource());
			
			if(ele.getText().contains("apple")){
				System.out.println(ele.getText());
			}else{
				String tmpURL=driver.getCurrentUrl();
				if(!currentURL.equalsIgnoreCase(tmpURL) &&(tmpURL.contains("appl") ||tmpURL.contains("appl") || tmpURL.contains("idmsa"))){
					System.out.println("Source URL:"+currentURL+"  ->Redirected URL:"+tmpURL);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
		ValidateURLs vus = new ValidateURLs();
		vus.invokeURL();
		Thread.sleep(3000L);
		vus.driver.close();
	}

}
