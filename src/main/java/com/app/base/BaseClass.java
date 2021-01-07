package com.app.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.app.reports.ExtentLogger;
import com.app.utils.TestUtils;
import com.app.utils.WebEventListener;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	public static Logger logger;
	
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
		
		logger = Logger.getLogger("Framework");
		//PropertyConfigurator.configure("log4j.properties");
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Leraning\\Seleniumwithjava\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("Log4j> Brwser is Chrome");
			
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Leraning\\Seleniumwithjava\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			logger.info("Log4j> Brwser is firefox");
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
		
		e_driver = new EventFiringWebDriver(driver);
		eventlistener = new WebEventListener();
		e_driver.register(eventlistener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//ExtentLogger.info("Brwser Launched successfully info added in base class");
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		logger.info("Log4j> Driver is launched with url");
	}

}
