package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {
	public TestBase(){
		Properties p = loadProperties();
		System.out.println(p.getProperty("URL"));
	}
	
	public Properties loadProperties(){
		Properties props = new Properties();
		FileInputStream fis = null;
		try {
			String path = new File(".").getCanonicalPath();
			 fis = new FileInputStream("/Users/nagaborra/Viserion_Workspace/restapi/src/main/java/com/qa/config/conf.properties");
			props.load(fis);
			return props;
	}catch(Exception e){
		}
		return null;
	}
}
