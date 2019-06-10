package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ScreenerInboxpage extends TestBase {
	
	@FindBy(xpath="//*[@id='UCsrchIcon']")
	WebElement InboxSearchIcon;
	
	@FindBy(xpath="//*[@id='ScreenerInboxSearch']")
	WebElement InboxSearch;
	
	@FindBy(xpath="//*[@id='ScreenerInbox']")
	WebElement ScreenerInboxtab;
	
	@FindBy(xpath="//*[contains(@id,'requestExtension_')]")
	WebElement RequestExtension;
	
	@FindBy(xpath="//*[@id='requestorCommentsInbox']")
	WebElement RequestCommentBox;

	@FindBy(id ="dvSubmit")
	WebElement Submitbutton;
	
	
	public ScreenerInboxpage()
	{
		PageFactory.initElements(driver, this);
	}
	public void ClickonScreenerInboxTab()
	{		
		ScreenerInboxtab.click();
	}
	
	public void ClcikonSearchicon()
	{
		InboxSearchIcon.click();
	}
	public void SearchtheOrder(String Comment)
	{
		InboxSearch.click();
		InboxSearch.sendKeys(Comment ,Keys.ENTER );
	}

	public void RequestExtenion(String RequestComment)
	{
		RequestExtension.click();
		RequestCommentBox.click();
		RequestCommentBox.sendKeys(RequestComment ,Keys.ENTER);
		Submitbutton.click();
	}



}
