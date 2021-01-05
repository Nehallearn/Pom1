package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.base.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[contains(text(),\"User: Learnfirst Learnlast\")]")
	@CacheLookup
	WebElement loggedUser;
	
	@FindBy(css="a[title='Contacts']")
	@CacheLookup
	WebElement contactLink;
	
	@FindBy(css="a[title='New Contact']")
	@CacheLookup
	WebElement newContactLink;
	
	@FindBy(css="a[title='Deals']")
	@CacheLookup
	WebElement dealLink;
	
	
	   
	
	public String verifyHomepagetitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactLink.click();
		return new ContactsPage();
	}
	
	public void clickOnNewContactsLink()
	{
		Actions action  = new Actions(driver);
		//action.moveToElement(contactLink).build().perform();
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Contacts']")));
		action.moveToElement(contactLink).build().perform();
		newContactLink.click();
		//return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealLink.click();
		return new DealsPage();
	}
	
	public String verifyLoggedUser()
	{
		return loggedUser.getText();
	}

}
