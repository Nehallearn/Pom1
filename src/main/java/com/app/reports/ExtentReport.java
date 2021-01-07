package com.app.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.app.utils.TestUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReport {
	
	
	private ExtentReport()
	{
		
	}
	
	private static ExtentReports extent;
	//Below line is ok if process in single thread.
	//public static ExtentTest test;
	
	public static void initReports()
	{
		if(Objects.isNull(extent)) {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(TestUtils.getExtentReportPath());
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("CRM APPIntegrtaion Report");
		spark.config().setReportName(" CRM APP My First Integration Report");
		}
	}
	
	public static void flushReports() throws Exception
	{
		if(Objects.nonNull(extent)) {
		extent.flush();
		}
		//Desktop.getDesktop().browse(new File(TestUtils.getExtentReportPath()).toURI());
	}
	
	public static void creaTest(String testcasename)
	{
		ExtentTest test = extent.createTest(testcasename);
		ExtentManager.setExtentTest(test);
		
	}

}
