package com.crm.qa.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LibraryPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ScreenerPublisherPage;
import com.crm.qa.pages.ScreenerInboxpage;
import com.crm.qa.pages.ScreenerOutboxPage;

public class SanityScreenerTest extends TestBase {
	
	LoginPage loginpage;	
	HomePage HomePage;
	LibraryPage libraryPage;
	ScreenerPublisherPage ScreenerPublisherPage;
	ScreenerInboxpage ScreenerInboxpage;
	ScreenerOutboxPage ScreenerOutboxPage;
	
	
	public SanityScreenerTest(){
		super();
	}
	
	@BeforeSuite
	public void SanityStart()
	{
		System.out.println("================SANITY REPORT START =================");
	}	
	
	
	@BeforeTest
	public void Login() throws InterruptedException {
		intilization();
		loginpage = new LoginPage();
	}
	
	@Test(priority = 0)
	public void VaildateUserLogin() throws InterruptedException  {	
		HomePage = loginpage.login(prop.getProperty("Username"), prop.getProperty("Pwd"));	
	}
	
	@Test(priority = 1)
	public void NavigateToLibraryPage() throws InterruptedException {
		libraryPage = HomePage.ClickonLibrary();	 
	}
	
	@Test(priority=2)
	public void DragandDropTheAssets() throws InterruptedException
	{		
		libraryPage.DragandDropVideoAsset(prop.getProperty("VideoFile"));
		libraryPage.DragandDropImageAsset(prop.getProperty("ImageFile"));
		ScreenerPublisherPage = libraryPage.ClickOnScreenericon();
	}
   
	@Test(priority=3)
	public void InternalPublish() throws InterruptedException
	{
		Thread.sleep(8000);
		ScreenerPublisherPage.EnterPublishTitle(prop.getProperty("ScreenerTitleInternal"));
		ScreenerPublisherPage.EnterRemarks(prop.getProperty("Remarks"));
		ScreenerPublisherPage.EnterRecipient(prop.getProperty("Internal_Recipient_Id"));
		Thread.sleep(3000);
		ScreenerPublisherPage.ClickonSubmit();
		//libraryPage.OpenNavigation();	
	//	HomePage.ClickonTask();
	//	HomePage.ClickonScreeners();
	}
	@Test(priority=4)
	public void ExternalPublish() throws InterruptedException
	{
		libraryPage.ClickonBin();
		ScreenerPublisherPage = libraryPage.ClickOnScreenericon();
		Thread.sleep(8000);
		ScreenerPublisherPage.EnterPublishTitle(prop.getProperty("ScreenerTitleExternal"));
		ScreenerPublisherPage.EnterRemarks(prop.getProperty("Remarks"));
		ScreenerPublisherPage.EnterRecipient(prop.getProperty("External_Recipient_Id"));
		Thread.sleep(3000);
		ScreenerPublisherPage.ClickonSubmit();
		Thread.sleep(3000);
		//libraryPage.OpenNavigation();	
     	HomePage.ClickonTask();
		HomePage.ClickonScreeners();
	}
	@Test(priority=5)
	public void RequestExtension() throws InterruptedException
	{
		Thread.sleep(4000);
		ScreenerPublisherPage = new ScreenerPublisherPage();
		ScreenerInboxpage = new ScreenerInboxpage();
	    ScreenerInboxpage.ClickonScreenerInboxTab();
	    Thread.sleep(5000);
	    ScreenerInboxpage.ClcikonSearchicon();
		ScreenerInboxpage.SearchtheOrder(prop.getProperty("ScreenerTitleInternal"));
		Thread.sleep(5000);
		ScreenerInboxpage.RequestExtenion(prop.getProperty("RequestExternsionComment"));
	}
    @Test(priority=6)
    public void EditExtension() throws InterruptedException
    {
    	Thread.sleep(4000);
    	ScreenerInboxpage.EditRequest(prop.getProperty("EditExternsionComment"));    	
    }
    @Test(priority=7)
	public void ApproveRequestOrder() throws InterruptedException
	{
    	ScreenerPublisherPage = new ScreenerPublisherPage();
		ScreenerInboxpage = new ScreenerInboxpage();
		ScreenerOutboxPage = new ScreenerOutboxPage();
		ScreenerOutboxPage.ClickonOutboxtab();
		Thread.sleep(4000);
		ScreenerOutboxPage.Searchorder(prop.getProperty("ScreenerTitleInternal"));
		ScreenerOutboxPage.ApprovalOrder(prop.getProperty("ApprovalComment"));
	}
	@Test(priority=8)
	public void EditTheOrder() throws InterruptedException
	{
		Thread.sleep(4000);
		ScreenerOutboxPage.ClickonOutboxtab();
		Thread.sleep(3000);
		ScreenerOutboxPage.Searchorder(prop.getProperty("ScreenerTitleInternal"));
		ScreenerOutboxPage.Editorder(prop.getProperty("EditFile"));
		ScreenerOutboxPage.EditRecipient(prop.getProperty("EditRecipientId"));
	}
	@Test(priority=9)
	public void ManualExpiry() throws InterruptedException
	{
		Thread.sleep(4000);
		ScreenerOutboxPage.ClickonOutboxtab();
		Thread.sleep(3000);
		ScreenerOutboxPage.Searchorder(prop.getProperty("ScreenerTitleInternal"));
		ScreenerOutboxPage.ManualExpiry(prop.getProperty("ManualExpiry"));
	}
	@Test(priority=10)
	public void DeletePublishOrder() throws InterruptedException
	{
		Thread.sleep(4000);
		ScreenerOutboxPage.ClickonOutboxtab();
		ScreenerOutboxPage.Searchorder(prop.getProperty("ScreenerTitleInternal"));
		Thread.sleep(4000);
		ScreenerOutboxPage.Deletepublish();
	}
    
	@AfterSuite
	public void logout()
	{
		System.out.println("================SANITY REPORT END =================");
		//driver.quit();
	}

}
