package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.base.BaseClass;

public class ContactsPage extends BaseClass{
	
	@FindBy(xpath="//td[@class='datacardtitle' and contains(text(),\"Contacts\")]")
	WebElement contactsGridTitle;
	
	//This is ok for one particular checkbox but for generic case a method should be created 
	//@FindBy(xpath="//a[text()='SecondCont SecndLast']//parent::td[@class=\"datalistrow\"]//preceding-sibling::td[@class='datalistrow']/input")
	//WebElement contactCheckbox;
	
	
	
	
	
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

}
