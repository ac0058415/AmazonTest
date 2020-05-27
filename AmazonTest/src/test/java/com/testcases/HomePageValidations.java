package com.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Base;
import com.pages.ExcelDataProvider;
import com.pages.HomePageObjects;

public class HomePageValidations extends Base {

	//Test Cases class for home page
	WebDriver driver;
	HomePageObjects hpo;
	ExcelDataProvider excel;
	
	
	@BeforeMethod (groups = {"Links", "SignIn", "Search"})
	private void setUp() {
		System.out.println("+++++Method: Before Method Called+++++");
		driver = openHomePage();
		hpo = new HomePageObjects(driver);
		excel = new ExcelDataProvider();
	}
	//Test Case - Search on Search Bar
	@Test (groups = {"Search"})
	public void searchOnSearchBar() {
		System.out.println("+++++Methood: searchOnSearchBar()+++++");
		hpo.searchBar("Harry Potter");
	}
	
	//Test Case - Count all the links on the homepage
	@Test (groups = {"Links"})
	public void countLinksOnHomePage() {
		System.out.println("+++++Method: countLinksOnHomePage +++++");
		hpo.linksOnHomepage();
	}
	
	//Test Case - Print all the links in Footer second column
	@Test (groups = {"Links"})
	public void printLinksInFooter() {
		System.out.println("+++++Method: printLinksInFooter+++++");
		hpo.linksOnFooter();
	}
	
	//Test Case - SignIn positive
	@Test (groups = {"SignIn"})
	public void signInPositive() {
		System.out.println("+++++Method: signInPositive +++++");
		String title = hpo.signInOnClick(excel.getUserID(1, 0), excel.getPassword(1, 1));
		Assert.assertTrue(title.contains("Amazon.com"));
		System.out.println("Login successful: " + hpo.checkNameAfterSignIn() );
	}

	//Test Case - SignIn positive
		@Test  (groups = {"SignIn"})
		public void signInNegative() {
			System.out.println("+++++Method: signInNegative +++++");
			String title = hpo.signInOnClick(excel.getUserID(2, 0), excel.getPassword(2, 1));
			Assert.assertTrue(title.contains("Sign-In"));
		}

}
