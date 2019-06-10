package com.crm.qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LibraryPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ScreenerPublisherPage;
import com.crm.qa.pages.ScreenerInboxpage;
import com.crm.qa.pages.ScreenerOutboxPage;

public class ScreenerOutboxPageTest  extends TestBase{

	LoginPage loginpage;	
	HomePage HomePage;
	LibraryPage libraryPage;
	ScreenerPublisherPage ScreenerPublisherPage;
	ScreenerInboxpage ScreenerInboxpage;
	ScreenerOutboxPage ScreenerOutboxPage;
	
	
	public ScreenerOutboxPageTest(){
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
		ScreenerOutboxPage = new ScreenerOutboxPage();
		ScreenerPublisherPage = new ScreenerPublisherPage();
		ScreenerInboxpage = new ScreenerInboxpage();
		HomePage = loginpage.login(prop.getProperty("Username"), prop.getProperty("Pwd"));
		HomePage.ClickonTask();
	    HomePage.ClickonScreeners();
	    
	}
	
//	@Test(priority=0)
//	public void ClickOnOutBoxTab() throws InterruptedException
//	{
//		Thread.sleep(4000);
//		ScreenerOutboxPage.ClickonOutboxtab();
//	}
	@Test(priority=1)
	public void ApproveRequestOrder() throws InterruptedException
	{
		ScreenerOutboxPage.ClickonOutboxtab();
		Thread.sleep(4000);
		ScreenerOutboxPage.Searchorder(prop.getProperty("ScreenerTitleInternal"));
		ScreenerOutboxPage.ApprovalOrder(prop.getProperty("ApprovalComment"));
	}
	@Test(priority=2)
	public void EditTheOrder() throws InterruptedException
	{
		Thread.sleep(4000);
		ScreenerOutboxPage.ClickonOutboxtab();
		Thread.sleep(3000);
		ScreenerOutboxPage.Searchorder(prop.getProperty("ScreenerTitleInternal"));
		ScreenerOutboxPage.Editorder(prop.getProperty("EditFile"));
		ScreenerOutboxPage.EditRecipient(prop.getProperty("EditRecipientId"));
	}
	@Test(priority=3)
	public void ManualExpiry() throws InterruptedException
	{
		Thread.sleep(4000);
		ScreenerOutboxPage.ClickonOutboxtab();
		Thread.sleep(3000);
		ScreenerOutboxPage.Searchorder(prop.getProperty("ScreenerTitleInternal"));
		ScreenerOutboxPage.ManualExpiry(prop.getProperty("ManualExpiry"));
	}
	@Test(priority=4)
	public void DeletePublishOrder() throws InterruptedException
	{
		Thread.sleep(4000);
		ScreenerOutboxPage.ClickonOutboxtab();
		ScreenerOutboxPage.Searchorder(prop.getProperty("ScreenerTitleInternal"));
		Thread.sleep(4000);
		ScreenerOutboxPage.Deletepublish();
	}
	@AfterMethod
	public void Logout() {
		driver.quit();
	}
	@AfterSuite
	public void logout()
	{
		System.out.println("================SANITY REPORT END =================");
		driver.quit();
	}
}
