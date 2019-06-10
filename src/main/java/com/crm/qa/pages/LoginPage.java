package com.crm.qa.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	  
	//page factory OR:
	
	@FindBy(id = "x-username")
	WebElement username;
	
	@FindBy(id = "loginContinue")
	WebElement logincontinue;
	
	@FindBy(id = "x-pwd")
	WebElement password;
	
	@FindBy(id = "loginSubmit")
	WebElement loginBtn;
	

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String Un, String pwd) throws InterruptedException{
		Thread.sleep(5000);
//		username.isDisplayed();
//		password.isDisplayed();
//		
//		username.isEnabled();
//		password.isEnabled();
		
		username.sendKeys(Un);
		logincontinue.click();
		password.sendKeys(pwd);
		
		loginBtn.isEnabled();
		loginBtn.click();
		
		return new HomePage();
	}
	
}


//driver.navigate().to("https://demo-poc.oneclear.com/BC/Product/Modules/home/home.aspx");
