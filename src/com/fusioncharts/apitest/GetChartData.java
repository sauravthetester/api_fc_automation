package com.fusioncharts.apitest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.relevantcodes.extentreports.LogStatus;

public class GetChartData extends APITestBase {
	
	//The api name according to the data sheet
	private final static String apiName = "getChartData()"; 
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
	public void verifyAPIExistsInDataSheetGetChartData()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedGetChartData()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIGetChartData() throws IOException
	{
		String apiScript = TestUtil.apiScript(data, apiName);
		
		Select format = new Select(driver.findElement(By.id("data_format")));
		
		format.selectByValue("csv");
		
		driver.findElement(By.id("get_chart_data")).click();
		String msgText = driver.findElement(By.id("msg")).getText();
		
		Assert.assertTrue(!msgText.isEmpty(), "CSV data should have some value");
		
		String[] lines = msgText.split("\\r?\\n");
        for (String line : lines) 
        {
            Assert.assertTrue(line.startsWith("\""), "CSV is in correct format");
            Assert.assertTrue(line.endsWith("\""), "CSV is in correct format");
            Assert.assertTrue(line.contains("\",\""), "CSV is in correct format");
        }
        
        test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("GetChartData_CSV data should show above chart")));	//Code Line for screenshot
		
        format.selectByValue("json");
		
		driver.findElement(By.id("get_chart_data")).click();
		msgText = driver.findElement(By.id("msg")).getText();
		
		Assert.assertTrue(!msgText.isEmpty(), "JSON data should have some value");
		
		try
		{
			JsonParser parser = new JsonParser();
			parser.parse(msgText);
		} 
		catch(JsonSyntaxException jse)
		{
			Assert.assertTrue(false, "JSON is in correct format");
		}
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("GetChartData_JSON data should show above chart")));	//Code Line for screenshot
	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
			System.out.println("getChartData() executed");
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
