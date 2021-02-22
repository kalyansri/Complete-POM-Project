package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	public static void main(String[] args) throws IOException {	
		
		System.out.println(System.getProperty("user.dir"));
	
		Properties config = new Properties();
		Properties Locators = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties");
		config.load(fis);
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Locators.properties");
		Locators.load(fis);
		
		System.out.println(config.getProperty("browser"));
		//driver.findElement(By.cssSelector(Locators.getProperty("bmlBtn"))).click();
		System.out.println(Locators.getProperty("bmlBtn"));
	}
}      
