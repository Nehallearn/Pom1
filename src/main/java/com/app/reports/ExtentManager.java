//This class will be used when extent report is used during parallel execution to handle multiple threads.

package com.app.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	
	private ExtentManager()
	{
		
	}
	
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	public static ExtentTest getExtentTest()
	{
		return extentTest.get();
	}
	public static void setExtentTest(ExtentTest test)
	{
		extentTest.set(test);
	}
	public static void unload()
	{
		extentTest.remove();
	}
	
	

}
