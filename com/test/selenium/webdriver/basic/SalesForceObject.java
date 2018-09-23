package com.test.selenium.webdriver.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesForceObject {
	WebDriver driver;
	public SalesForceObject(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	public WebElement userName;
	
	@FindBy(name="pw")
	public  WebElement password;
	
	@FindBy(xpath="//*[@id=\"Login\"]")
	public  WebElement btnLogin;
	
	public WebElement getUserName() {
		return userName;
	}

	
	public WebElement getPassword() {
		return password;
	}

	

	public WebElement getBtnLogin() {
		return btnLogin;
	}


	
}
