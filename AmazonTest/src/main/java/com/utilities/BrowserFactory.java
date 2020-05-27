package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	WebDriver driver;
	String driversPath;
	
	public BrowserFactory(WebDriver driver) {
		
		this.driver = driver;
		this.driversPath = System.getProperty("user.dir") + "\\src\\main\\resources\\drivers";
	}
	
	public WebDriver setUpBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", driversPath +"\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		} else if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", driversPath +"\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", driversPath +"\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		} else {
			
			System.err.println("Sorry! unsupported browser");
		}
		
		System.out.println("Driver intialized");
		return driver;
		
	}
	
	
	

}
