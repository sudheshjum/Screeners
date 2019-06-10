package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LibraryPage;
import com.crm.qa.pages.LoginPage;

public class HomepageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage HomePage;
	LibraryPage libraryPage;
	
	public HomepageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		intilization();
		loginpage = new LoginPage();
		HomePage = new HomePage();
		HomePage= loginpage.login(prop.getProperty("Username"), prop.getProperty("Pwd"));
		HomePage.ClickonLibrary();
	}

	@Test()
	public void NavigateToLibraryPage() throws InterruptedException {
		libraryPage = HomePage.ClickonLibrary();	 
	}
	@AfterMethod
	public void Logout() {
		driver.quit();
	}
	
		
		
}
