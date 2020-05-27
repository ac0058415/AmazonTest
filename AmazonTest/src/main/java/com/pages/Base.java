package com.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.utilities.BrowserFactory;

public class Base {
	
	/*Base Class
	 * It will initialize all drivers, files 
	 * It should be extended by all Test Cases
	 */
	
	WebDriver driver;
	BrowserFactory bf;
	ConfigDataProvider config;
//	ExcelDataProvider excel;
	
	@BeforeSuite
	public void initializeFiles() {
		System.out.println("Before Suite: initializeFiles()");
		config = new ConfigDataProvider();
	//	excel = new ExcelDataProvider();
	}
	
	@BeforeTest
	public void initializeDriver() {
		
		System.out.println("Before Test: initializeDriver()");
		bf = new BrowserFactory(driver);
		driver = bf.setUpBrowser(config.getBrowser());
	}
	
	
	public WebDriver openHomePage() {
				driver.get(config.getURL());
				System.out.println("Test: openHomepage()");
				return driver;
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("After Test: tearDown()");
		driver.close();
	}
	

}
