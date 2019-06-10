package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LibraryPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ScreenerInboxpage;
import com.crm.qa.pages.ScreenerPublisherPage;

public class ScreenerPublisherPageTest extends TestBase {
	
	LoginPage loginpage;	
	HomePage HomePage;
	LibraryPage libraryPage;
	ScreenerPublisherPage ScreenerPublisherPage;
	ScreenerInboxpage ScreenerInboxpage;
	
	public ScreenerPublisherPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		intilization();
		libraryPage = new LibraryPage();
		HomePage = new HomePage();
		loginpage = new LoginPage();
		ScreenerPublisherPage = new com.crm.qa.pages.ScreenerPublisherPage();
		loginpage = new LoginPage();
		HomePage = loginpage.login(prop.getProperty("Username"), prop.getProperty("Pwd"));
		//IMP Point to remember
		libraryPage = HomePage.ClickonLibrary();
		libraryPage.DragandDropVideoAsset(prop.getProperty("VideoFile"));
		libraryPage.DragandDropImageAsset(prop.getProperty("ImageFile"));	
	    ScreenerPublisherPage = libraryPage.ClickOnScreenericon();

	}
	
	@Test(priority=0)
	public void InternalPublish() throws InterruptedException
	{
		Thread.sleep(8000);
		ScreenerPublisherPage.EnterPublishTitle(prop.getProperty("ScreenerTitleInternal"));
		ScreenerPublisherPage.EnterRemarks(prop.getProperty("Remarks"));
		ScreenerPublisherPage.EnterRecipient(prop.getProperty("Internal_Recipient_Id"));
		Thread.sleep(3000);
		ScreenerPublisherPage.ClickonSubmit();
		//libraryPage.OpenNavigation();	
//		HomePage.ClickonTask();
//		HomePage.ClickonScreeners();
	}
	@Test(priority=1)
	public void ExternalPublish() throws InterruptedException
	{
		Thread.sleep(8000);
		ScreenerPublisherPage.EnterPublishTitle(prop.getProperty("ScreenerTitleExternal"));
		ScreenerPublisherPage.EnterRemarks(prop.getProperty("Remarks"));
		ScreenerPublisherPage.EnterRecipient(prop.getProperty("External_Recipient_Id"));
		Thread.sleep(3000);
		ScreenerPublisherPage.ClickonSubmit();
		Thread.sleep(3000);
		//libraryPage.OpenNavigation();	
	    HomePage.ClickonTask();
	    ScreenerInboxpage = HomePage.ClickonScreeners();
	}

	
}
