package com.app.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.app.utils.TestUtils;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass()
	{
		try
		{
			prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\nehal\\eclipse-workspace\\TestAutomation1\\src\\main\\java\\com\\app\\config\\config.properties");
		prop.load(fis);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Leraning\\Seleniumwithjava\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Leraning\\Seleniumwithjava\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("edge"))
		{
			//tbc
		}
		else if(browserName.equals("ie"))
		{
			//tbc
		}
		else
		{
			System.out.println("Please setup correct browser name in Properties file");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
