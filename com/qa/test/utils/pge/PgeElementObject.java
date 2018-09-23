package com.qa.test.utils.pge;

import org.openqa.selenium.By;

public class PgeElementObject {
	public static By lnkSignIn = By.xpath("//a[contains(@href,'login')]//span[2]");
	public static By inputUserName=By.name("username");
	public static By inputPassword=By.id("password");
	public static By chkboxRemember=By.name("rempass");
	public static By btnSignIn = By.id("home_login_submit");
	public static By btnLogOut = By.xpath("//div[(@class='pge_coc-header-siginedin_gp')]//span//button[(@id='mPgeLogoutBtn')]");
	//public static By btnLogOut = By.xpath("//span//button[(@id=\"mPgeLogoutBtn\")]");
	
	public static By selectAccount = By.xpath("//div[(@id='accountListElement')]");
}
