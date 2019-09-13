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
	private final static String apiName = "realTimeAPIs()"; 
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
		String apiScript = TestUtil.apiScript(data, apiName);
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		
		
		js.executeScript("fusioncharts_gauge.feedData('&label=thislabel&value=43')");
		js.executeScript("fusioncharts_rtarea.feedData('&label=thislabel&value=43')");
		js.executeScript("fusioncharts_rtbulb.feedData('&label=thislabel&value=43')");
		js.executeScript("fusioncharts_rtcolumn.feedData('&label=thislabel&value=43')");
		js.executeScript("fusioncharts_rtcylinder.feedData('&label=thislabel&value=43')");
		js.executeScript("fusioncharts_rthbullet.feedData('&label=thislabel&value=43')");
		js.executeScript("fusioncharts_rthled.feedData('&label=thislabel&value=43')");
		js.executeScript("fusioncharts_rthlinear.feedData('&label=thislabel&value=43')");
		js.executeScript("fusioncharts_rtline.feedData('&label=thislabel&value=43')");
		js.executeScript("fusioncharts_rtlinedy.feedData('&label=thislabel&value=43')");
		js.executeScript("fusioncharts_rtsarea.feedData('&label=thislabel&value=43')");
		js.executeScript("fusioncharts_rtscolumn.feedData('&label=thislabel&value=43')");
		js.executeScript("fusioncharts_rtthermometer.feedData('&label=thislabel&value=43')");
		js.executeScript("fusioncharts_rtvbullet.feedData('&label=thislabel&value=43')");
		js.executeScript("fusioncharts_rtvled.feedData('&label=thislabel&value=43')");
		
		
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
		//driver.quit();
	}


}
