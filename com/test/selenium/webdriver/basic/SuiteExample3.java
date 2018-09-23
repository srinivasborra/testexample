package com.test.selenium.webdriver.basic;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SuiteExample3 {
	@BeforeTest
	public void TestS2(){
		System.out.println("Before TEst SuiteExample3");
	}
	@Test(groups={"groupname"})
	public void cases(){
		System.out.println("cases3");
	}
	@Test
	public void drns(){
		System.out.println("drns3");
	}
	@Test
	public void release(){
		System.out.println("release3");
	}
}
