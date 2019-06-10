package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ScreenerPublisherPage  extends TestBase{
	
	@FindBy(id="publishTitle")
	WebElement Title;
	
	@FindBy(id ="screenerRemarks")
	WebElement Remark;
	
	@FindBy(xpath="//*[@id='clearLoginId']")
	WebElement Recipient;
	
	@FindBy(xpath="//*[@class='promptBtn']")
	WebElement Submit;
	
	 public ScreenerPublisherPage()
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void EnterPublishTitle(String Title1)
	 {
		Title.sendKeys(Title1);
	 }
	 
	 public void EnterRemarks(String Remarks)
	 {
		 Remark.sendKeys(Remarks);
	 }
	 
	 public void EnterRecipient(String Recipients)
	 {
		 Recipient.sendKeys(Recipients ,Keys.ENTER);
	 }
	 
	 public void ClickonSubmit() throws InterruptedException
	 {
		 Thread.sleep(3000);
		 Submit.click();
	 }
	

}
