package com.test.selenium.webdriver.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriverService;

import com.test.selenium.utils.GlobalConstants;

public class WebDriverInit {
	public WebDriver driver;
	private static String browser;
	private static String pgepwd;
	private static ChromeDriverService chromeService;
	private static GeckoDriverService fireFoxService;
	private static SafariDriverService safariService;
	static {
        loadProperties();
    }
	public WebDriver invokeWebDriver( String url) throws Exception {
		
		String brw = browser.toLowerCase();
		switch (brw) {
		case "chrome":
			chromeService = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File("/usr/local/bin/chromedriver")).usingAnyFreePort().build();
			chromeService.start();
			driver = new RemoteWebDriver(chromeService.getUrl(), DesiredCapabilities.chrome());
			driver.get(url);
			break;
		case "firefox":
			fireFoxService = new GeckoDriverService.Builder()
					.usingDriverExecutable(new File("/Users/nagaborra/Downloads/gecko/geckodriver")).usingAnyFreePort()
					.build();
			fireFoxService.start();
			driver = new RemoteWebDriver(fireFoxService.getUrl(), DesiredCapabilities.firefox());
			driver.get(url);
			break;
		case "safari":
			safariService= new SafariDriverService.Builder().usingDriverExecutable(new File("/usr/bin/safaridriver")).usingAnyFreePort().build();
			safariService.start();
			driver = new RemoteWebDriver(safariService.getUrl(), DesiredCapabilities.safari());
			driver.get(url);
			break;
		default:
			System.out.println("Please initiate Browser");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
public synchronized static void loadProperties(){
	Properties props = new Properties();
	FileInputStream fis = null;
	try {
		 fis = new FileInputStream("utils/application.properties");
		props.load(fis);
		browser = props.getProperty(GlobalConstants.BROWSER);
		pgepwd = props.getProperty(GlobalConstants.PGE_PWD);
	} catch (IOException e) {
		e.printStackTrace();
	}finally{
			try{
				if(fis != null){
					fis.close();
				}
			}catch(Exception e){
				
			}
	}
	
}
public String getPgepwd(){
	return pgepwd;
}
//	public void closeWebDriver() {
//		if (driver != null)
//			driver.close();
//	}
//
//	public void quitWebDriver() {
//		if (driver != null)
//			driver.quit();
//	}
}
