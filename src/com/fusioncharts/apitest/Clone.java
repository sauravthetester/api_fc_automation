package com.fusioncharts.apitest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Clone extends APITestBase
{
	//The api name according to the data sheet
	private final static String apiName = "clone()"; 
	Object[][] data;
	APIPageObjectModel pom;
	ExtentReports extent;
    ExtentTest test;
	
	@BeforeTest
	public void setUp() 
	{
		api = new APITestBase();
		api.initialize();
		pom = new APIPageObjectModel();
		data = TestUtil.getTestData();
		
		extent = new ExtentReports(extentreportReportFile, true);
	}
	  
	@Test(priority = 1)
	public void verifyAPIExistsInDataSheetClone() 
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedClone()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIClone()
	{
		List<WebElement> containers;
		//containers = pom.getTotalCharts();
		
		List<WebElement> svgTotal = pom.getAllSvgElems();
		
		Assert.assertTrue(svgTotal.size()==1, "Only one chart getting rendered");
		
		String apiScript = TestUtil.apiScript(data, apiName);

		jsExecuteWithBuffer(apiScript);
		
		svgTotal = pom.getAllSvgElems();
		
		Assert.assertTrue(svgTotal.size()==2, "Totally 2 charts exist");
		
		int firstChartElementsTotal = svgTotal.get(0).findElements(By.xpath("*")).size();
		int clonedChartElementsTotal = svgTotal.get(1).findElements(By.xpath("*")).size();
		
		Assert.assertTrue(firstChartElementsTotal==clonedChartElementsTotal, "Child elements of both are equal in number");
		
		System.out.println(APITestBase.capture("screenShotNames").replace("/", "\\\\"));
		
//		test.log(LogStatus.INFO, test.addScreenCapture(APITestBase.capture("screenShotNames")));

	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
			System.out.println("Clone() executed");
			Thread.sleep(3000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		report.endTest(test);
		report.flush();
		driver.quit();
	}



}
