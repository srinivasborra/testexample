package com.test.selenium.webdriver.basic;

import org.testng.annotations.Test;

public class SuiteExample2 {
	@Test
	public void cases(){
		System.out.println("cases");
	}
	@Test(groups={"groupname"})
	public void drns(){
		System.out.println("drns1111111111111111111");
	}
	@Test
	public void release(){
		System.out.println("release");
	}
}
