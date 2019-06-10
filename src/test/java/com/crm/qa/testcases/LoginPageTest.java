package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	@BeforeSuite
	public void SanityStart()
	{
		System.out.println("================SANITY REPORT START =================");
	}
	
	@BeforeMethod
	public void setUp() {
		intilization();
		loginPage = new LoginPage();
}
	
//	@Test(priority = 1)
//	public void validateLoginPageTitle() {
//		String title = loginPage.validateLoginPageTitle();
//		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
//	}
	
//	@Test(priority = 2)
//	public void crmLogo() {
//		boolean logo = loginPage.validatecrmImage();
//		Assert.assertTrue(logo);
//	}
	
	@Test(priority = 0)
	public void VaildateUserLogin() throws InterruptedException  {
	homepage = loginPage.login(prop.getProperty("Username"), prop.getProperty("Pwd"));
		
//		Assert.assertEquals(arg0, arg1);
	}
	
	@AfterMethod
	public void Logout() {
		driver.quit();
	}
	
	
}
 