package com.fusioncharts.apitest;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;

public class Clone extends APITestBase
{
	//The api name according to the data sheet
	private final static String apiName = "clone()"; 
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
	public void verifyAPIExistsInDataSheet() 
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name does not match in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRendered()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is not rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPI()
	{
		List<WebElement> containers;
		containers = pom.getTotalCharts();
		
		Assert.assertTrue(containers.size()==1, "Only one chart should get rendered");
		
		String apiScript = TestUtil.apiScript(data, apiName);
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript(apiScript);
		containers = pom.getTotalCharts();
		
		Assert.assertTrue(containers.size()==2, "Original chart is not getting cloned");
	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
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
