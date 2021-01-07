package com.app.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.app.base.BaseClass;
import com.app.pages.HomePage;
import com.app.pages.LoginPage;
import com.app.reports.ExtentReport;

public class LoginPageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest()
	{
		super();
	}
	
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPagetitleTest()
	{
		//ExtentReport.creaTest("loginPagetitleTest");
		String title = loginpage.getLoginPageTitile();
		System.out.println(title);
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		
	}
	
	@Test(priority=2)
	public void logovalidation()
	{
		//ExtentReport.creaTest("logovalidation");
		boolean b = loginpage.verifyLogo();
		Assert.assertTrue(b);
	
	}
	
    @Test(priority=3)
    public void login()
    {
    	//ExtentReport.creaTest("login");
    	homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
    }
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
