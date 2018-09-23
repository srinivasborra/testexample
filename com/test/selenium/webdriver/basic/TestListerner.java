package com.test.selenium.webdriver.basic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListerner implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart*******");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
			System.out.println("Test success:"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed:"+result.getStatus());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("OnFinish");
	}
}
