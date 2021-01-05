package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.base.BaseClass;

public class LoginPage extends BaseClass{
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Username']")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	@CacheLookup
	WebElement loginButton;
	
	@FindBy(xpath="//a[normalize-space()='Sign Up']")
	@CacheLookup
	WebElement signupButton;
	
	@FindBy(xpath="//img[@src='https://classic.freecrm.com/img/logo.png']")
	@CacheLookup
	WebElement appLogo;
	
	public String getLoginPageTitile()
	{
		return driver.getTitle();
	}
	public boolean verifyLogo()
	{
		return appLogo.isDisplayed();
	}
	public HomePage Login(String u, String p)
	{
		username.sendKeys(u);
		password.sendKeys(p);
		loginButton.click();
		
		return new HomePage();
	}
	

}
