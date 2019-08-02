package com.fusioncharts.apitest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class ClearChart extends APITestBase {
	
	//The api name according to the data sheet
	private final static String apiName = "clearChart()"; 
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
	public void verifyAPIExistsInDataSheetClearChart() 
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedClearChart()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIClearChart() throws IOException
	{
		String apiScript = TestUtil.apiScript(data, apiName);

		WebElement plot = pom.getElementByPartialClassName("g", "plot-group");
		
		while(true)
		{
			if(plot.findElements(By.tagName("path")).size()==6)
			{
				test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("clearChart_Chart should have 5 plots")));	//Code Line for screenshot
				break;
			}
		}
		
		jsExecuteWithBuffer(apiScript);

		Assert.assertTrue(plot.findElements(By.tagName("path")).size()==1, "Item should not be sliced");
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("clearChart_Chart should be empty with no data")));	//Code Line for screenshot
	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
			System.out.println("clearChart() executed");
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
