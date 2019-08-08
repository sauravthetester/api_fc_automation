package com.fusioncharts.apitest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class GetXMLData extends APITestBase 
{
	//The api name according to the data sheet
	private final static String apiName = "getXMLData()"; 
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
	public void verifyAPIExistsInDataSheetGetXMLData()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedGetXMLData()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "Chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIGetXMLData() throws IOException
	{
		String apiScript = TestUtil.apiScript(data, apiName);
		jsExecuteWithBuffer(apiScript);
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("getXMLData()_XML Data should be visible")));

		String XMLData = driver.findElement(By.id("datainsert")).getText();
		Assert.assertTrue(XMLData.startsWith("<chart"),"This is SVG Sting's start phase");
		Assert.assertTrue(XMLData.endsWith("</chart>"),"This is SVG Sting's end phase");
	}
	@AfterTest
	public void shutDown() throws IOException
	{
		try
		{
			System.out.println("getXMLData() executed");
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
