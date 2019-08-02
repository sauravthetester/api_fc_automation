package com.fusioncharts.apitest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class SetData extends APITestBase
{
	
	//The api name according to the data sheet
	private final static String apiName = "setData()"; 
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
	public void verifyAPIExistsInDataSheetSetData() 
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedSetData()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPISetData() throws IOException
	{
		String apiScript = TestUtil.apiScript(data, apiName);
		int numerOfPlots;
		WebElement plot = pom.getElementByPartialClassName("g", "plot-group");
		
		numerOfPlots = pom.totalChildElements(plot);
		Assert.assertTrue(numerOfPlots==2, "Chart should have 1 plot");
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("SetData_There should be one plot")));	//Code Line for screenshot
		
		for(int i=0; i<3; i++)
			jsExecuteWithBuffer(apiScript);
		
		numerOfPlots = pom.totalChildElements(plot);
		Assert.assertTrue(numerOfPlots==5, "Chart should have 4 plots");
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("SetData_There should be 4 plots")));	//Code Line for screenshot
	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
			System.out.println("setData() executed");
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
