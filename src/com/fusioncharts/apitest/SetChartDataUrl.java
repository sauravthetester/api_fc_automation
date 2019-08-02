package com.fusioncharts.apitest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class SetChartDataUrl extends APITestBase {
	
	//The api name according to the data sheet
	private final static String apiName = "setChartDataUrl()"; 
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
	public void verifyAPIExistsInDataSheetSetChartDataUrl() 
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedSetChartDataUrl()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPISetChartDataUrl() throws IOException
	{
		String apiScript = TestUtil.apiScript(data, apiName);
		int numerOfPlots;
		WebElement plot = pom.getElementByPartialClassName("g", "plot-group");
		
		numerOfPlots = pom.totalChildElements(plot);
		Assert.assertTrue(numerOfPlots==12, "Chart should have 12 plot");
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("setChartDataUrl_There should be 12 plots")));	//Code Line for screenshot
		
		jsExecuteWithBuffer(apiScript);
		
		numerOfPlots = pom.totalChildElements(plot);
		Assert.assertTrue(numerOfPlots==4, "Chart should have 4 plots");
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("setChartDataUrl_There should be 4 plots")));	//Code Line for screenshot
	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
			System.out.println("setChartDataUrl() executed");
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
