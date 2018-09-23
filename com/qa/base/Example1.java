package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example1 e = new Example1();
		Properties p = e.loadProperties();
		String str=p.getProperty("serviceUrl");
		System.out.println("welcome"+str);
	}
	private Properties loadProperties(){
		Properties props = new Properties();
		FileInputStream fis = null;
		try {
			String path = new File(".").getCanonicalPath();
			System.out.println(path);
			 fis = new FileInputStream("/Users/nagaborra/Viserion_Workspace/restapi/src/main/java/com/qa/config/conf.properties");
			props.load(fis);
			return props;
	}catch(Exception e){
		}
		return null;
	}
}
