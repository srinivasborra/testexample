package com.qa.test.stepdefinition.pge;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.qa.test.utils.pge.PgeBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class PgeHomePage extends PgeBase {
//	WebDriver driver;
//	
//	@Before(order=0)
//	public void setUp(){
//		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
//		 driver =new ChromeDriver();
//		 driver.get("https://www.pge.com/");
//	}
	
	@Given("^validate home page$")
	public void validate_home_page() throws Throwable {
	    System.out.println("validate_home_page");
	    Assert.assertEquals(PgeBase.driver.getCurrentUrl(),"https://www.pge.com/");
	}

	@Given("^page has sign in text$")
	public void page_has_sign_in_text() throws Throwable {
		WebElement signInTxt = driver.findElement(By.className("sign-in-text"));
		Assert.assertTrue(signInTxt.isDisplayed());
	}
	
	@When("^home page title$")
	public void home_page_title() throws Throwable {

		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
//		if(driver.findElement(By.xpath("//*[@id='wildfire-modal-close']/img")).isDisplayed()){
//			driver.findElement(By.xpath("//*[@id='wildfire-modal-close']/img")).click();	
//		}
		
	    Assert.assertEquals(pageTitle, "PG&E, Pacific Gas and Electric - Gas and power company for California");
	    
	}
	
	@Then("^user closed pop message$")
	public void user_closed_pop_message() throws Throwable {
		WebElement ele = driver.findElement(By.xpath("//*[@id='wildfire-modal-close']/img"));
		if(ele.isDisplayed()){
			ele.click();	
		} 
	}
	
	@Then("^user click on sign in link$")
	public void user_clicks_signIn_link(){
		//driver.findElement(PgeElementObject.lnkSignIn).click();
	}
	
	@Then("^user clicks Residential option$")
	public void user_clicks_Residential_option() throws Throwable {
		WebElement residential = driver.findElement(By.id("residential-link"));
		String loginDiv =null;
		if(residential.isDisplayed()){
			residential.click();
			loginDiv = driver.findElement(By.xpath("//div[@class='login login-container']/h3")).getText();
		}
		Assert.assertEquals(loginDiv, "SIGN IN");
	}
	
	@Then("^validate menu options$")
	public void validate_menu_options() throws Throwable {
		String[] menuOptions ={"YOUR ACCOUNT","CUSTOMER SERVICE","OUTAGES","RATE PLANS","SAVE ENERGY & MONEY","SOLAR & VEHICLES","IN YOUR COMMUNITY"};
		for(int i=1;i<8;i++){
			Assert.assertTrue(driver.findElement(By.id("navigation-l"+i)).isDisplayed());
			Assert.assertEquals(menuOptions[i-1], driver.findElement(By.id("navigation-l"+i)).getText());
		}
	}
	
	@Then("^clicked emergencies$")
	public void clicked_emergencies(){
		driver.findElement(By.xpath("//*[@id=\"emergency-dropdown-lable\"]")).sendKeys(Keys.DOWN);
		List<WebElement> emer=driver.findElements(By.xpath("//ul[(@class='emergency-dropdown-menu dropdown-menu')]//li"));
		for(WebElement ele : emer){
			if(ele.getText().equalsIgnoreCase("POWER OUTAGE")){
				ele.click();
				break;
			}
		}
	}
}
