package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LibraryPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ScreenerPublisherPage;

public class LibraryPageTest extends TestBase {
	
	LoginPage loginpage;	
	HomePage HomePage;
	LibraryPage libraryPage;
	ScreenerPublisherPage ScreenerPublisherPage;
	
	public LibraryPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		intilization();
		loginpage = new LoginPage();
		HomePage = loginpage.login(prop.getProperty("Username"), prop.getProperty("Pwd"));
		//IMP Point to remember
		libraryPage = HomePage.ClickonLibrary();
		//ScreenerPublisherPage = libraryPage.ClickOnScreenericon();
	}
	
//	@Test(priority=0)
//	public void DragandDropAssetToBIN() throws InterruptedException
//	{		
//		libraryPage.DragandDropVideoAsset(prop.getProperty("VideoFile"));
//		libraryPage.DragandDropImageAsset(prop.getProperty("ImageFile"));	
//	}
	@Test(priority=0)
	public void LaunchTheScreenerWindow() throws InterruptedException
	{		
		libraryPage.DragandDropVideoAsset(prop.getProperty("VideoFile"));
		libraryPage.DragandDropImageAsset(prop.getProperty("ImageFile"));
		ScreenerPublisherPage = libraryPage.ClickOnScreenericon();
	}
//	@AfterMethod
//	public void Logout() {
//		driver.quit();
//	}
	

}
