package com.fusioncharts.apitest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;


public class FeedData extends APITestBase 
{
	//The api name according to the data sheet
	private final static String apiName = "feedData()"; 
	Object[][] data;
	APIPageObjectModel pom;
	
	@BeforeTest
	public void setUp() 
	{
		api = new APITestBase();
		api.initialize();
		pom = new APIPageObjectModel();
		data = TestUtil.getTestData();
	}
	  
	@Test(priority = 1)
	public void verifyAPIExistsInDataSheetFeedData()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedFeedData()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIFeedData() throws IOException
	{
		WebElement plot = pom.getElementByPartialClassName("g", "plot-group");
		List<WebElement> plots = plot.findElements(By.tagName("rect"));
		Assert.assertTrue(plots.size() == 1, "Chart contains only one column");
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("feedData_One column should exists")));	//Code Line for screenshot
		
		String apiScript = TestUtil.apiScript(data, apiName);
		jsExecuteWithBuffer(apiScript);
		plot = pom.getElementByPartialClassName("g", "plot-group");
		plots = plot.findElements(By.tagName("rect"));
		Assert.assertTrue(plots.size() == 2, "Feed Data API added a new cloumn");
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("feedData_Two columns should exists")));	//Code Line for screenshot
	}
	
	@AfterTest
	public void shutDown() throws IOException
	{
		try
		{
			System.out.println("feedData() executed");
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
