package com.fusioncharts.apitest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class GetDataAsCSV extends APITestBase {
	
	//The api name according to the data sheet
	private final static String apiName = "getDataAsCSV()"; 
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
	public void verifyAPIExistsInDataSheetGetDataAsCSV()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedGetDataAsCSV()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIGetDataAsCSV() throws IOException
	{
		String apiScript = TestUtil.apiScript(data, apiName);
		jsExecuteWithBuffer(apiScript);
		
		String msgText = driver.findElement(By.id("msg")).getText();
		
		Assert.assertTrue(!msgText.isEmpty(), "CSV data should have some value");
		
		String[] lines = msgText.split("\\r?\\n");
        for (String line : lines) 
        {
            Assert.assertTrue(line.startsWith("\""), "CSV is in correct format");
            Assert.assertTrue(line.endsWith("\""), "CSV is in correct format");
            Assert.assertTrue(line.contains("\",\""), "CSV is in correct format");
        }
        
        test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("GetDataAsCSV_CSV data should show above chart")));	//Code Line for screenshot
	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
			System.out.println("getDataAsCSV() executed");
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
