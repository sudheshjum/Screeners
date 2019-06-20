package com.crm.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ScreenerOutboxPage extends TestBase {
	
	@FindBy(id="ScreenerOutbox")
	WebElement Outboxtab;
	
	@FindBy(xpath="//*[@id='UCsrchIcon']")
	WebElement OutboxSearchIcon;
	
	@FindBy(id="ScreenerInboxSearch")
	WebElement OuboxSearch;
	
	@FindBy(xpath="//*[@id='extensionRequested']")
	WebElement ExtensionApproval;
	
	@FindBy(xpath="//*[@id='requestorCommentsInbox']")
	WebElement ApprovalCommentBox;

	@FindBy(id ="dvApprove")
	WebElement Submitbutton;
	
	
	@FindBy(xpath="(//*[contains(text(),'Expiry')])[1]")
	WebElement ExtendExpiry;
	
	@FindBy(xpath="//*[contains(text(),'Expire')]")
	WebElement ManualExpiry;
	
	@FindBy(id ="outBoxTextArea")
	WebElement ManualCommentBox;
	
	@FindBy(id ="btnExpire")
	WebElement ManualSubmitButton;
	
	@FindBy(xpath="//*[contains(text(),'Delete')]")
	WebElement DeletePublish;
	
	@FindBy(xpath="//*[contains(text(),'Edit')]")
	WebElement EditPublish;
	
	@FindBy(xpath="//*[@id='_searchBin']")
	WebElement Edit_AddAsset;
	
	@FindBy(xpath="//*[@id='txtCurrentSearchText']")
	WebElement Edit_Searchbox;
	
	@FindBy(xpath="//*[@id='browseBinThumb_5051-246078']")
	WebElement Edit_VideoFile;
	
//	@FindBy(xpath="//*[@id='browseBinThumb_9001-306691']")
//	WebElement Edit_VideoFile;
	

	@FindBy(id="binV2")
	WebElement Edit_Binarea;
	
	@FindBy(id="Update2")
	WebElement Edit_BtnUpdate;
	
	@FindBy(xpath="//*[@id='clearLoginId']")
	WebElement Edit_Recipient;
	
	@FindBy(id="Publish1")
	WebElement Edit_Publish;
	
	@FindBy(xpath="//*[@id='Yes1']")
	WebElement AlertPop;
	
	@FindBy(xpath="//*[contains(@title,'request for extension')]")
	WebElement RequestNewLinkIcon;	
	
	@FindBy(id="RequestComments")
	WebElement RequestLinkCommentbox;
	
		
	
	public ScreenerOutboxPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void ClickonOutboxtab()
	{
		Outboxtab.click();
	}
	
	public void Searchorder(String Search) throws InterruptedException
	{
		Thread.sleep(3000);
		OutboxSearchIcon.click();
		OuboxSearch.click();
		OuboxSearch.sendKeys(Search , Keys.ENTER);
		Thread.sleep(3000);
		
	}
	
	public void ApprovalOrder(String ApprovalComent) throws InterruptedException
	{
		Thread.sleep(3000);
		ExtensionApproval.click();
		Thread.sleep(3000);
		ApprovalCommentBox.click();
		ApprovalCommentBox.sendKeys(ApprovalComent,Keys.ENTER);
		Submitbutton.click();	
	}
	
	public void Editorder(String EditVideoFile) throws InterruptedException
	{
		EditPublish.click();
		Thread.sleep(8000);
		Edit_AddAsset.click();
		Thread.sleep(10000);
		Edit_Searchbox.click();
		Edit_Searchbox.sendKeys(EditVideoFile,Keys.ENTER);
		Thread.sleep(5000);
		Edit_VideoFile.click();
		Actions a = new Actions(driver);
		a.dragAndDrop(Edit_VideoFile, Edit_Binarea).build().perform();
		Edit_BtnUpdate.click();		
	}
	public void EditRecipient(String Recipient) throws InterruptedException
	{
		//wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOf(Edit_Recipient));
		Thread.sleep(8000);
		Edit_Recipient.click();
		Edit_Recipient.sendKeys(Recipient,Keys.ENTER);
		Thread.sleep(3000);
		Edit_Publish.click();	
	}
	
	
//	public void ExtendExpiry(String ExtendComments)
//	{
//		ExtendExpiry.click();
//		
//	}
	public void ManualExpiry(String ManualComments) throws InterruptedException
	{
		Thread.sleep(3000);
		ManualExpiry.click();
		ManualCommentBox.sendKeys(ManualComments);
		ManualSubmitButton.click();
		
	}
	public void RequestNewLink(String RequestLinkComment) throws InterruptedException
	{
		Thread.sleep(3000);
		RequestNewLinkIcon.click();
		RequestLinkCommentbox.click();
		RequestLinkCommentbox.sendKeys(RequestLinkComment);
		
	}
	public void Deletepublish()
	{
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfAllElements(DeletePublish));
		DeletePublish.click();
		AlertPop.click();
	}
	
	

}
