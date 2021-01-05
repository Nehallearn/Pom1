package com.app.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.app.base.BaseClass;

public class TestUtils extends BaseClass{
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	public static long TEST = 10;
	
	
	public void frame() {
		driver.switchTo().frame("mainpanel");
	}
	public static void takeScreenshot() throws Exception
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String datetime = new SimpleDateFormat("YYYY-MM-DD-HHMMSS").format(new Date());
		FileUtils.copyFile(src, new File("C:\\Users\\nehal\\eclipse-workspace\\TestAutomation1\\Screenshots\\"+"test"+datetime+".png"));
	}

}
