package com.qa.test.stepdefinition.pge;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.qa.test.utils.pge.PgeBase;
import com.qa.test.utils.pge.PgeElementObject;

import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class PgeLogin extends PgeBase{
	
	@Then("^user enters username (.*) and password (.*)$")
	public void user_enters_username_and_password(String username, String password) throws Throwable {
		WebElement eleUserName = driver.findElement(PgeElementObject.inputUserName);
		WebElement elePassword = driver.findElement(PgeElementObject.inputPassword);
		
		eleUserName.sendKeys(username);
		elePassword.sendKeys(password);
//		Assert.assertEquals(eleUserName.getText(), username);
//		Assert.assertEquals(elePassword.getText(), password);
		
	}

	@Then("^click sign in button$")
	public void click_sign_in_button() throws Throwable {
		WebElement btnSign= driver.findElement(PgeElementObject.btnSignIn);
		btnSign.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertTrue(btnSign.isDisplayed());
		System.out.println("click on sign button");
	}

	@Then("^check account user name$")
	public void check_account_user_name() throws Throwable {
		String userFName = driver.findElement(By.xpath("//*[@id=\"accountUserName\"]")).getText();
		System.out.println(userFName);
		Assert.assertTrue(!userFName.isEmpty());
		
	}
	
	@Then("^user clicks on account dropdown$")
	public void user_clicks_on_account_dropdown()throws Throwable{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.findElement(PgeElementObject.selectAccount).click();
		Assert.assertTrue(driver.findElement(PgeElementObject.selectAccount).isDisplayed());
	}
	
	@Then("^finally user clicks on signout$")
	public void finally_user_clicks_on_signout() throws Throwable {
		System.out.println(driver.getCurrentUrl());
		
		WebElement ele1 = driver.findElement(PgeElementObject.btnLogOut);
		boolean isVisible = ele1.isDisplayed();
		String str1=ele1.getText();
		System.out.println(str1);
		int p1 = ele1.getLocation().x;
		System.out.println(p1);
		ele1.click();
//		Actions actions = new Actions(driver);
//		actions.moveToElement(ele1).click().perform();
//		//driver.findElement(PgeElementObject.btnLogOut).click();
		Assert.assertTrue(isVisible);
		
	}
	
	@Then("^close browser$")
	public void close_browser() throws Throwable {
	    driver.quit();
	}
}
