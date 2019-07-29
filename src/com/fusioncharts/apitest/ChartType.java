package com.fusioncharts.apitest;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class ChartType extends APITestBase
{
	//The api name according to the data sheet
	private final static String apiName = "chartType(a)"; 
	private final static String apiNameMultiparam = "chartType(a,b,c)";
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
	public void verifyAPIExistsInDataSheetChartType() 
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedChartType()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIChartType1paramChartType() throws IOException
	{
		String changeToChart = "bar2d";
		String apiScript = TestUtil.apiScript(data, apiName);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		jsExecuteWithBuffer(apiScript);
		boolean chartChanged=false;
		Object chartType = js.executeScript("return fusioncharts.chartType()");
		if(chartType.toString().equals(changeToChart))
			chartChanged = true;
		Assert.assertTrue(chartChanged, "Chart type has changed for 1 param");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("ChartType_Chart Should Be - bar2d")));	//Code Line for screenshot
	}
	
	@Test(priority = 4)
	public void verifyAPIChartType3paramChartType() throws IOException
	{
		String changeToChart = "msstackedcolumn2dlinedy";
		String apiScript = TestUtil.apiScript(data, apiNameMultiparam);
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		jsExecuteWithBuffer(apiScript);
		boolean chartChanged=false;
		Object chartType = js.executeScript("return fusioncharts.chartType()");
		if(chartType.toString().equals(changeToChart))
			chartChanged = true;
		Assert.assertTrue(chartChanged, "Chart type has changed for 3 param");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("ChartType_Chart Should Be - msstackedcolumn2dlinedy")));	//Code Line for screenshot
	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
			System.out.println("ChartType() executed");
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
