package com.fusioncharts.apitest;

import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class GetObjectReference extends APITestBase
{
	//The api name according to the data sheet
	private final static String apiName = "getObjectReference()"; 
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
	public void verifyAPIExistsInDataSheetGetObjectReference() 
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedGetObjectReference()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIGetObjectReference()
	{
		String apiScript = TestUtil.apiScript(data, apiName);
		jsExecuteWithBuffer(apiScript);
		boolean buttonDisplayed;
		buttonDisplayed = pom.verifyTemporaryButtonExists();
		Assert.assertTrue(buttonDisplayed, "Button is displayed");
	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
			System.out.println("GetObjectReference() executed");
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
