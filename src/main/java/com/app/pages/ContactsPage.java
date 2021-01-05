package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.app.base.BaseClass;

public class ContactsPage extends BaseClass{
	
	@FindBy(xpath="//td[@class='datacardtitle' and contains(text(),\"Contacts\")]")
	WebElement contactsGridTitle;
	
	//This is ok for one particular checkbox but for generic case a method should be created 
	//@FindBy(xpath="//a[text()='SecondCont SecndLast']//parent::td[@class=\"datalistrow\"]//preceding-sibling::td[@class='datalistrow']/input")
	//WebElement contactCheckbox;
	//Webelemnts for new contacts:
	@FindBy(xpath="//select[@name='title']")
	WebElement getTitle;
	@FindBy(xpath="//input[@id='first_name']")
	WebElement getFirstName;
	@FindBy(xpath="//input[@id='surname']")
	WebElement getLastName;
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement getCompanyName;
	@FindBy(xpath="//input[@value='Save and Create Another (same company)' and @type='submit']/preceding-sibling::input[@value='Save']")
	WebElement saveContact;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactTitle()
	{
		return contactsGridTitle.isDisplayed();
	}
	
	//Below method is for checkbox
	public void selectContactsByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']/input")).click();
	}
	public void createNewContact(String title,String ftname,String ltname, String cmname)
	{
		Select select = new Select(getTitle);
		select.selectByVisibleText(title);
		getFirstName.sendKeys(ftname);
		getLastName.sendKeys(ltname);
		getCompanyName.sendKeys(cmname);
		saveContact.click();
	}

}
