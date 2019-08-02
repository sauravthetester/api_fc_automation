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

public class GetViewStartIndex_EndIndex_ResetChart extends APITestBase 
{
	//The api name according to the data sheet
			private final static String apiName = "getViewStartIndex_EndIndex_ResetChart()"; 
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
			public void verifyAPIExistsInDataSheetGetViewStartIndex_EndIndex_ResetChart()
			{
				boolean apiExists = TestUtil.thisAPIexists(data, apiName);
				Assert.assertTrue(apiExists, "API name matches in data sheet");
			}
			
			@Test(priority = 2)
			public void verifyChartIsRenderedGetViewStartIndex_EndIndex_ResetChart()
			{
				String htmlData = TestUtil.chartHtml(data, apiName);
				TestUtil.htmlWrite(htmlData);
				driver.navigate().refresh();
				boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
				Assert.assertTrue(containerDisplayed, "Chart is rendered");
			}
			
			@Test(priority = 3)
			public void verifyAPIGetViewStartIndex_EndIndex_ResetChart() throws IOException
			{
				String apiScript = TestUtil.apiScript(data, apiName);
				JavascriptExecutor js = (JavascriptExecutor) driver; 
				long InitaialStratIndedx = (long) js.executeScript("return fusioncharts.getViewStartIndex() " );	//Returns the data from the console
				System.out.println(InitaialStratIndedx);
				long InitaialEndIndedx = (long) js.executeScript("return fusioncharts.getViewEndIndex() " );	//Returns the data from the console
				System.out.println(InitaialEndIndedx);
//				Assert.assertTrue(result, "isUpdateActive() API executed");
				
				try {Thread.sleep(9000);} catch (InterruptedException e) {e.printStackTrace();}
				
				test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("GetViewStartIndex_EndIndex_ResetChart_Zoom Line Chart getting reset")));
			}
			
			@AfterTest
			public void shutDown() throws IOException
			{
				try
				{
					System.out.println("getViewStartIndex_EndIndex_ResetChart() executed");
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
