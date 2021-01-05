package com.app.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
		//contactspage = homepage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactPage()
	{
		contactspage = homepage.clickOnContactsLink();
		boolean b = contactspage.verifyContactTitle();
		Assert.assertTrue(b);
	}
	
	@Test(priority=2)
	public void clickonContactCheckbox()
	{
		contactspage = homepage.clickOnContactsLink();
		contactspage.selectContactsByName("SecondCont SecndLast");
	}
	
	@Test(priority=3,dataProvider="data1")
	public void createNewContact(String a,String b, String c, String d)
	{
		homepage.clickOnNewContactsLink();
		//contactspage.createNewContact("Mr.", "Yusufotwo", "Yusuflasttwo", "TestBtwo");
		contactspage.createNewContact(a, b, c, d);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider
	public Iterator<Object[]> data1()
	{
		ArrayList<Object[]> data3 = new ArrayList<Object[]>();
		data3 = com.app.utils.GetDataUtility.getData();
		return data3.iterator();
		
	}

}
