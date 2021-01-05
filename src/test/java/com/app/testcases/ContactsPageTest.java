package com.app.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.base.BaseClass;
import com.app.pages.ContactsPage;
import com.app.pages.HomePage;
import com.app.pages.LoginPage;
import com.app.utils.TestUtils;

public class ContactsPageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtils testutil;
	ContactsPage contactspage;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		testutil = new TestUtils();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.frame();
		contactspage = homepage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactPage()
	{
		boolean b = contactspage.verifyContactTitle();
		Assert.assertTrue(b);
	}
	
	@Test(priority=2)
	public void clickonContactCheckbox()
	{
		contactspage.selectContactsByName("SecondCont SecndLast");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
