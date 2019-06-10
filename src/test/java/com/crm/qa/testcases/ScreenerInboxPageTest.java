package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LibraryPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ScreenerInboxpage;
import com.crm.qa.pages.ScreenerOutboxPage;
import com.crm.qa.pages.ScreenerPublisherPage;

public class ScreenerInboxPageTest extends TestBase{
	
	LoginPage loginpage;	
	HomePage HomePage;
	LibraryPage libraryPage;
	ScreenerPublisherPage ScreenerPublisherPage;
	ScreenerInboxpage ScreenerInboxpage;
	ScreenerOutboxPage ScreenerOutboxPage;
	
	
	public ScreenerInboxPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		intilization();
		libraryPage = new LibraryPage();
		HomePage = new HomePage();
		loginpage = new LoginPage();
		ScreenerPublisherPage = new ScreenerPublisherPage();
		ScreenerInboxpage = new ScreenerInboxpage();
		HomePage = loginpage.login(prop.getProperty("Username"), prop.getProperty("Pwd"));
		HomePage.ClickonTask();
	    ScreenerInboxpage = HomePage.ClickonScreeners();
	}
	
//	@Test(priority=0)
//	public void ClikonScreenertab() throws InterruptedException
//	{
//		Thread.sleep(4000);
//	    ScreenerInboxpage.ClickonScreenerInboxTab();
//	}
	@Test(priority=0)
	public void RequestExtension() throws InterruptedException
	{
		Thread.sleep(4000);
	    ScreenerInboxpage.ClickonScreenerInboxTab();
	    Thread.sleep(5000);
	    ScreenerInboxpage.ClcikonSearchicon();
		ScreenerInboxpage.SearchtheOrder(prop.getProperty("ScreenerTitleInternal"));
		Thread.sleep(5000);
		ScreenerInboxpage.RequestExtenion(prop.getProperty("RequestExternsionComment"));
	}
	@AfterMethod
	public void Logout() {
		driver.quit();
	}
	
}
