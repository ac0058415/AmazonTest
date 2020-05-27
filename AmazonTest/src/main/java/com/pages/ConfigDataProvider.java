package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties property;
	
	//Constructor to initialize properties file
	public ConfigDataProvider() {
		
		File file = new File(".\\src\\main\\resources\\dataFiles\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			property = new Properties();
			property.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to read config file: " + e.getMessage());
		}
	}
	
	public String getBrowser() {
		return property.getProperty("Browser");
	}
	
	public String getURL() {
		return property.getProperty("url");
	}

}
