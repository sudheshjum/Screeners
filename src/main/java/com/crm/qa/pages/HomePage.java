package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//*[@role='presentation'  and contains(@title ,'Library')]")
	WebElement Libraryicon;
	
	@FindBy(xpath="//*[@role='presentation'  and contains(@title ,'Tasks')]")
	WebElement Tasktab;
	
	@FindBy(xpath="//*[contains(@title,'Click to hide the navigation drawer')]")
	WebElement LabelIcon;
	
	@FindBy(xpath="//*[@role='presentation'  and contains(@title ,'Screeners')]")
	WebElement Screenertab;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public LibraryPage ClickonLibrary() throws InterruptedException {
		Thread.sleep(5000);
		Libraryicon.click();
		return new LibraryPage();
	}
	
	public void  ClickonTask() throws InterruptedException {
		
		boolean Label = LabelIcon.isDisplayed();
		if(Label==true)
		{
			Thread.sleep(3000);
			Tasktab.click();
		}
		else
		{
			LabelIcon.click();
			Thread.sleep(3000);
			Tasktab.click();
		}

	}
	
	public ScreenerInboxpage ClickonScreeners() throws InterruptedException {
		Thread.sleep(3000);
		Screenertab.click();
		return new ScreenerInboxpage();
	}
	
	 

}
