package com.test.selenium.webdriver.basic;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.selenium.webdriver.pge.PGEHomePage;

public class SuitePge extends PGEHomePage{
	@BeforeTest
	public void initTest(){
		invokeBrowser();
	}
	@Test(priority=1)
	public void componentsCheckTest(){
		testAllButtons();
	}
	
	@Test(priority=2)
	public void userNameTest(){
		testUserName();
	}
	
	@Test(priority=3)
	public void WrongPwdTest(){
		testWrongPwd();
	}
	@Test(priority=4)
	public void ValidDataTest(){
		testValidCredentials();
	}
	@Test(priority=5)
	public void logoutTest() throws Exception{
		testLogout();
	}
}
