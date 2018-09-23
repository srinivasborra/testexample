package com.test.selenium.webdriver.basic;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSuiteExample {
	
	
	@BeforeTest
	public void TestS1(){
		System.out.println("Before TEst TestSuiteExample");
		
	}
	
	@Test
	public void login(){
		System.out.println("Login");
		
	}
	@Parameters({ "URL" })
	@Test
	public void fetchRecs(String urlParam){
		System.out.println("FetchRecs");
		System.out.println("URL:"+urlParam);
	}
	@Test
	public void showDetails(){
		System.out.println("showDetails");
	}
	
}
