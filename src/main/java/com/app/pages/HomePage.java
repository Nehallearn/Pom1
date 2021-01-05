package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.base.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[contains(text(),\"User: Learnfirst Learnlast\")]")
	WebElement loggedUser;
	
	@FindBy(css="a[title='Contacts']")
	WebElement contactLink;
	
	@FindBy(css="a[title='Deals']")
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
