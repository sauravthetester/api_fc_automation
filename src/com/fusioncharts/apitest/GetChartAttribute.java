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

public class GetChartAttribute extends APITestBase {
	
	//The api name according to the data sheet
	private final static String apiName = "getChartAttribute()"; 
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
	public void verifyAPIExistsInDataSheetGetChartAttribute()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedGetChartAttribute()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIGetChartAttribute() throws IOException
	{
		String apiScript = TestUtil.apiScript(data, apiName);
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		String theme = "";
		
		js.executeScript("fusioncharts.setChartAttribute(\"theme\", \"zune\")");
		theme = (String) js.executeScript("return fusioncharts.getChartAttribute(\"theme\")");
		
		Assert.assertTrue(theme.equals("zune"), "Theme is Zune");
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("GetChartAttribute_theme should be zune")));	//Code Line for screenshot
		
		js.executeScript("fusioncharts.setChartAttribute(\"theme\", \"carbon\")");
		theme = (String) js.executeScript("return fusioncharts.getChartAttribute(\"theme\")");
		
		Assert.assertTrue(theme.equals("carbon"), "Theme is Zune");
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("GetChartAttribute_theme should be carbon")));	//Code Line for screenshot
		
		js.executeScript("fusioncharts.setChartAttribute(\"theme\", \"ocean\")");
		theme = (String) js.executeScript("return fusioncharts.getChartAttribute(\"theme\")");
		
		Assert.assertTrue(theme.equals("ocean"), "Theme is Zune");
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("GetChartAttribute_theme should be ocean")));	//Code Line for screenshot
	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
			System.out.println("getChartAttribute() executed");
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
