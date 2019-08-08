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

public class SetJSONData extends APITestBase 
{

	//The api name according to the data sheet
	private final static String apiName = "setJSONData()"; 
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
	public void verifyAPIExistsInDataSheetSetJSONData()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedSetJSONData()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "Chart is rendered");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3)
	public void verifyAPISetJSONData() throws IOException
	{
		WebElement label1 = pom.getElementByPartialClassName("g", "vcanvas-label");
		WebElement labelText1 = label1.findElement(By.tagName("text"));
		String firstLabelText1 = labelText1.getText();
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("SetJSONData()_Column 2D chart should be rendered with Data1")));
		String apiScript = TestUtil.apiScript(data, apiName);
		jsExecuteWithBuffer(apiScript);
		
		String firstLabelText2 = labelText1.getText();
		Assert.assertTrue(!firstLabelText1.equals(firstLabelText2), "SetChartData() executed successfully");
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("SetJSONData()_Column 2D chart showing with Data2, should be different from Data1")));
	}
	
	@AfterTest
	public void shutDown() throws IOException
	{
		try
		{
			System.out.println("setJSONData() executed");
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
