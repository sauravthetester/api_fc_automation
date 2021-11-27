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

public class GetData extends APITestBase
{

	//The api name according to the data sheet
		private final static String apiName = "getData()"; 
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
		public void verifyAPIExistsInDataSheetGetData()
		{
			boolean apiExists = TestUtil.thisAPIexists(data, apiName);
			Assert.assertTrue(apiExists, "API name matches in data sheet");
		}
		
		@Test(priority = 2)
		public void verifyChartIsRenderedGetData()
		{
			String htmlData = TestUtil.chartHtml(data, apiName);
			TestUtil.htmlWrite(htmlData);
			driver.navigate().refresh();
			boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
			Assert.assertTrue(containerDisplayed, "Chart is rendered");
		}
		
		@Test(priority = 3)
		public void verifyAPIGetData() throws IOException
		{
			String apiScript = TestUtil.apiScript(data, apiName);
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			
			List ls = (List) js.executeScript("return "+apiScript);	//Returns the data from the console
			
			List str0 = (List)ls.get(0);
			List str1 = (List)ls.get(1);
			List str2 = (List)ls.get(2);
			List str3 = (List)ls.get(3);
			List str4 = (List)ls.get(4);
			List str5 = (List)ls.get(5);
			
			for(int i=0;i<3;i++)
			{
				
				if(str0.get(1).equals(""))
					Assert.assertTrue(false, "Should not be empty");
				
				if(str0.get(2).equals(""))
					Assert.assertTrue(false, "Should not be empty");
				
				if(str1.get(i).equals(""))
					Assert.assertTrue(false, "Should not be empty");
				
				if(str2.get(i).equals(""))
					Assert.assertTrue(false, "Should not be empty");
				
				if(str3.get(i).equals(""))
					Assert.assertTrue(false, "Should not be empty");
				
				if(str4.get(i).equals(""))
					Assert.assertTrue(false, "Should not be empty");
				
				if(str5.get(i).equals(""))
					Assert.assertTrue(false, "Should not be empty");
			}
		}
		
		@AfterTest
		public void shutDown() throws IOException
		{
			try
			{
				System.out.println("getData() executed");
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
