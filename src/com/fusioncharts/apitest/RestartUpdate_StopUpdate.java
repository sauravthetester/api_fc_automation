package com.fusioncharts.apitest;

import com.fusioncharts.main.APITestBase;
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

import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class RestartUpdate_StopUpdate extends APITestBase 
{
	//The api name according to the data sheet
	private final static String apiName = "stopUpdate()"; 
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
	public void verifyAPIExistsInDataSheetRestartUpdate_StopUpdate()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedRestartUpdate_StopUpdate()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "Chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIRestartUpdate_StopUpdate() throws IOException
	{
		String apiScript = TestUtil.apiScript(data, apiName);
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		jsExecuteWithBuffer(apiScript);
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("stopUpdate()_Realtime data should be present")));
		try {Thread.sleep(9000);} catch (InterruptedException e) {e.printStackTrace();}
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("stopUpdate()_Realtime data should be present")));
		
		js.executeScript("return fusioncharts.restartUpdate() " );
		
		try {Thread.sleep(9000);} catch (InterruptedException e) {e.printStackTrace();}
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("restartUpdate()_Realtime data should have more data")));
		
	}
	
	@AfterTest
	public void shutDown() throws IOException
	{
		try
		{
			System.out.println("stopUpdate() executed");
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
