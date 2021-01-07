package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.base.BaseClass;
import com.app.reports.ExtentLogger;
import com.app.reports.ExtentManager;
import com.app.reports.ExtentReport;

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
		String title= driver.getTitle();
		//ExtentReport.test.pass("Login Page title is being verified");
		//ExtentManager.getExtentTest().pass("Login Page title is being verified in multithread environmnet");
		//ExtentLogger.pass("Login Page title is being verified in multithread environmnet2");
		return title;
	}
	public boolean verifyLogo()
	{
		boolean logo= appLogo.isDisplayed();
		//ExtentReport.test.pass("Login Page Logo is being verified");
		//ExtentManager.getExtentTest().pass("Login Page Logo is being verified in multithread environmnet");
		//ExtentLogger.pass("Login Page Logo is being verified in multithread environmnet2");
		return logo;
	}
	public HomePage Login(String u, String p)
	{
		username.sendKeys(u);
		password.sendKeys(p);
		loginButton.click();
		//ExtentReport.test.pass("Login crredentials entered and login button clicked.");
		//ExtentManager.getExtentTest().pass("Login crredentials entered and login button clicked in multithread environmnet");
		//ExtentLogger.pass("Login crredentials entered and login button clicked in multithread environmnet");
		//ExtentLogger.info("Simple message");
		return new HomePage();
	}
	

}
