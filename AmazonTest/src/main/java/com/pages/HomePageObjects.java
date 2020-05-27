package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {
	
	WebDriver driver;
	
	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	//Search bar locators
	//@FindBy(id="twotabsearchtextbox") WebElement searchBar;
	By searchBar = By.id("twotabsearchtextbox");
	By go = By.xpath("//input[@type='submit' and @value='Go']");
	
	//Links
	By link = By.tagName("a");
	
	//Footer
	By footer = By.xpath("//div[@class='navFooterLinkCol navAccessibility'][2]");
	
	//SignIn
	By signIn = By.cssSelector("a[id='nav-link-accountList']");
	By userID = By.cssSelector("input[id='ap_email']");
	By cont = By.cssSelector("input[id='continue']");
	By password = By.cssSelector("input[id='ap_password']");
	By submit = By.cssSelector("input[id='signInSubmit']");

	//Check Name
	By checkName = By.xpath("(//div[@class='nav-line-1-container']//span[@class='nav-line-1'])[1]");
	
	
	public String signInOnClick(String uid, String pwd) {
		driver.findElement(signIn).click();
		driver.findElement(userID).sendKeys(uid);
		driver.findElement(cont).click();
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(submit).click();		
		return driver.getTitle();
	}
	
	public String checkNameAfterSignIn() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver.findElement(checkName).getText();
	}
	public  void searchBar(String text) {
	//	searchBar.sendKeys(text);;
		driver.findElement(searchBar).sendKeys(text);
		driver.findElement(go).click();		
	}
	
	public void linksOnHomepage() {
		List<WebElement> list = driver.findElements(link) ;
		System.out.println("Total Links: " + list.size());
	}
	
	public void linksOnFooter() {
		List<WebElement> list = driver.findElements(footer) ;
		System.out.println("***************");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
		}
		System.out.println("***************");
	}
	

}
