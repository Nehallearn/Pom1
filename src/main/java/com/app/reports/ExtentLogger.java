/*In this video I have explained the reason to create Extent Logger and also how can we integrate with listeners.

How to hide certain methods from other automation testers
How to create custom logger class
How to integrate with testng listeners
*/
package com.app.reports;

import com.app.base.BaseClass;
import com.app.utils.TestUtils;
import com.aventstack.extentreports.MediaEntityBuilder;

public final class ExtentLogger extends BaseClass {
	
	private ExtentLogger()
	{
		
	}
	
	public static void pass(String message)
	{
		ExtentManager.getExtentTest().pass(message);
	}
	public static void pass(String message,boolean isScreenshotrequired) throws Exception
	{
		if(prop.getProperty("passedstepscreenshot").equalsIgnoreCase("yes") && isScreenshotrequired)
		{
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtils.takeScreenshotasbase64()).build());
		}
		else
		{
			pass(message);
		}
		
		
	}
	public static void fail(String message)
	{
		ExtentManager.getExtentTest().fail(message);
	}
	
	public static void fail(String message,boolean isScreenshotrequired) throws Exception
	{
		if(prop.getProperty("failedstepscreenshot").equalsIgnoreCase("yes") && isScreenshotrequired)
		{
			ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtils.takeScreenshotasbase64()).build());
		}
		else
		{
			fail(message);
		}
		
	}
	public static void info(String message)
	{
		ExtentManager.getExtentTest().info(message);
	}
	public static void skip(String message)
	{
		ExtentManager.getExtentTest().skip(message);
	}

}
