package com.test.selenium.webdriver.basic;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSuite2 {
	@BeforeTest
	public void TestS2(){
		System.out.println("Before TEst TestSuite2");
	}
	@Test
	public void cases2(){
		System.out.println("TestSuite2");
	}
	@Test
	public void drns2(){
		System.out.println("TestSuite2");
	}
	@Test
	public void release2(){
		System.out.println("TestSuite2");
	}
}
