package com.fusioncharts.apitest;

import java.io.IOException;
import java.util.List;

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

public class GetDataWithId extends APITestBase {
	
	//The api name according to the data sheet
	private final static String apiName = "getDataWithId()"; 
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
	public void verifyAPIExistsInDataSheetGetDataWithId() 
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedGetDataWithId()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIGetDataWithId() throws IOException
	{
		String apiScript = TestUtil.apiScript(data, apiName);

		WebElement table = driver.findElement(By.id("data-table"));

		boolean isTableEmpty = table.findElements(By.xpath(".//*")).isEmpty();
		
		System.out.println("isAnyElementInTable = "+isTableEmpty);
		
		Assert.assertTrue(isTableEmpty, "Table should be null");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("GetDataWithId_chart should not be fully rendered")));
		
		
		try {Thread.sleep(22000);} catch (InterruptedException e) {}
		
		isTableEmpty = table.findElements(By.xpath(".//*")).isEmpty();
		
		
		Assert.assertTrue(!isTableEmpty, "Table should not be null");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("GetDataWithId_table below chart with 1 heading row 3 columns and 5 data rows")));	//Code Line for screenshot
	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
			System.out.println("getDataWithId() executed");
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
