package com.test.selenium.webdriver.basic;

import org.openqa.selenium.By;

public class PgeObject {
	public static By linkForgotUserName=By.xpath("//a[contains(@href,'forgotUserName')]");
	public static By inputUserName=By.name("username");
	public static By linkForgotPwd = By.xpath("//a[contains(@href,'forgotPassword')]");
	public static By inputPassword=By.id("password");
	public static By chkboxRemember=By.name("rempass");
	public static By btnSignIn = By.id("home_login_submit");
	
	public static By linkRegister=By.xpath("//a[contains(@href,'SignInRegistration')]");
	public static By linkVisitor=By.xpath("//a[contains(@href,'visitorota')]");
	
	public static By btnSignOut = By.id("mPgeLogoutBtn");
}
