package com.fusioncharts.main;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.fusioncharts.initialization.*;


public class APITest 
{
	public static ExtentTest test = null;
	public static ExtentReports report = null;
	public static WebDriver driver=null;
	
	@BeforeTest
	public void beforeTest() 
	{
		System.out.println("before");
		InitializeAll init = new InitializeAll();
		init.initializeExtentReportDoc();
		init.driverInitiateChrome();
	}
	  
	@AfterTest
	public void afterTest() 
	{
		System.out.println("after");
		report.endTest(test);
		report.flush();
	}
		
	@Test(priority =3)
	public void f()
	{
		System.out.println("test 2nd");
		test.log(LogStatus.PASS, "Navigated to the specified URL");
	}
	  
	@Test(priority =0)
	public void f1() 
	{
		System.out.println("test");
		test.log(LogStatus.PASS, "Clicked");
	}
	  
	@Test(groups = { "in" })
	public void testMethodOne() 
	{
		System.out.println("Test method one");
	}
	
	@Test(groups = { "in" })
	public void testMethodTwo() 
	{
		System.out.println("Test method two");
	}
	
	@Test(groups = { "in" })
	public void testMethodThree() 
	{
		System.out.println("Test method three");
	}
	
	@Test(groups = { "ex" })
	public void testMethodFour() 
	{
		System.out.println("Test method Four");
	}
	  
	@Test(groups = { "ex" })
	public void testMethodFive() 
	{
		System.out.println("Test method Five");	  
	}
}
