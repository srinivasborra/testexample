package com.test.selenium.webdriver.pge;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.selenium.webdriver.basic.PgeObject;
import com.test.selenium.webdriver.basic.WebDriverInit;

public class PGEHomePage {
	private WebDriver webdriver;
	private WebDriverInit initvals;

	@BeforeTest
	public void invokeBrowser() {
		try {
			initvals = new WebDriverInit();
			webdriver = initvals.invokeWebDriver("https://www.pge.com/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void testAllButtons() {
		webdriver.findElement(By.xpath("//*[@id='wildfire-modal-close']/img")).click();

		boolean linkForgotUsername = webdriver.findElement(PgeObject.linkForgotUserName).isDisplayed();
		boolean inputUserName = webdriver.findElement(PgeObject.inputUserName).isDisplayed();
		boolean linkForgotPwd = webdriver.findElement(PgeObject.linkForgotPwd).isDisplayed();
		boolean inputPwd = webdriver.findElement(PgeObject.inputPassword).isDisplayed();
		boolean remem_checkbox = webdriver.findElement(PgeObject.chkboxRemember).isDisplayed();
		boolean btnSignIn = webdriver.findElement(PgeObject.btnSignIn).isDisplayed();
		boolean btnReg = webdriver.findElement(PgeObject.linkRegister).isDisplayed();
		boolean btnVisitor = webdriver.findElement(PgeObject.linkVisitor).isDisplayed();

		assertTrue(linkForgotUsername);
		assertTrue(inputUserName);
		assertTrue(linkForgotPwd);
		assertTrue(inputPwd);
		assertTrue(remem_checkbox);
		assertTrue(btnSignIn);
		assertTrue(btnReg);
		assertTrue(btnVisitor);
	}

	//@Test(priority = 2)
	public void testUserName() {

		webdriver.findElement(PgeObject.inputUserName).sendKeys("testuser@gmail.com");
		webdriver.findElement(PgeObject.btnSignIn).click();
		String pwdEmptyMsg = webdriver.findElement(By.id("passworderror")).getText();
		assertEquals("fasdfa", pwdEmptyMsg);
	}

	public void testWrongPwd() {
		webdriver.findElement(PgeObject.inputUserName).clear();
		webdriver.findElement(PgeObject.inputUserName).sendKeys("satyasrinivas.borra@gmail.com");
		webdriver.findElement(PgeObject.inputPassword).sendKeys("abcxyz123");
		webdriver.findElement(PgeObject.btnSignIn).click();
		String pwdEmptyMsg = webdriver.findElement(By.id("passworderror")).getText();
		assertEquals("", pwdEmptyMsg);
	}

	@Test(priority = 3)
	public void testValidCredentials() {
		webdriver.findElement(PgeObject.inputPassword).clear();
		webdriver.findElement(PgeObject.inputUserName).clear();
		webdriver.findElement(PgeObject.inputUserName).sendKeys("satyasrinivas.borra@gmail.com");
		webdriver.findElement(PgeObject.inputPassword).sendKeys(initvals.getPgepwd());
		webdriver.findElement(PgeObject.btnSignIn).click();
	}

	@Test(priority = 4)
	public void testLogout() throws Exception {
		webdriver.findElement(By.id("mPgeLogoutBtn")).click();
		String text = webdriver
				.findElement(By.xpath("//div[@class='profile pull-right']//span[contains(@class,'sign-in-text')]"))
				.getText();
		System.out.println(text);
		System.out.println("Logout is called");
		if (webdriver != null) {
			Thread.sleep(3000);
			webdriver.close();
		}
	}

	public WebDriver getWebdriver() {
		return this.webdriver;
	}

	//@AfterMethod
	public void onErrorScreenshot(ITestResult result) {
		if (ITestResult.FAILURE == result.FAILURE) {
			try {
				TakesScreenshot ts = (TakesScreenshot) webdriver;
				File screenshot = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("/Users/nagaborra/Desktop/error" + currentDateTime() + ".png"));
			} catch (Exception e) {

			}
			webdriver.quit();
		}
	}

	public String currentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		Date date = new Date();
		String str = dateFormat.format(date); // 2016/11/16 12:08:43
		return str;
	}

}
