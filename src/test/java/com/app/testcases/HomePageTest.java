package com.app.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.base.BaseClass;
import com.app.pages.ContactsPage;
import com.app.pages.DealsPage;
import com.app.pages.HomePage;
import com.app.pages.LoginPage;
import com.app.utils.TestUtils;

public class HomePageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtils testutil;
	ContactsPage contactspage;
	DealsPage dealspage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		testutil = new TestUtils();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle()
	{
		String title = homepage.verifyHomepagetitle();
		System.out.println(title);
		Assert.assertEquals(title,"CRMPRO","Home page title is not matching please check." );
		
		
		
	}
	@Test(priority=2)
	public void loggeduserValidation()
	{
		testutil.frame();
		String user = homepage.verifyLoggedUser();
		Assert.assertEquals("  User: Learnfirst Learnlast", user);
		
	}
	
	
	@Test(priority=3)
	public void clickonContactLink()
	{
		testutil.frame();
		contactspage = homepage.clickOnContactsLink();
		
	}
	
	@Test(priority=4)
	public void clickonDealsLink()
	{
		testutil.frame();
		dealspage= homepage.clickOnDealsLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
