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

public class HasRendered extends APITestBase
{
	//The api name according to the data sheet
	private final static String apiName = "hasRendered()"; 
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
	public void verifyAPIExistsInDataSheetHasRendered()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
		driver.navigate().refresh();
	}
	
	
	@Test(priority = 2)
	public void verifyAPIHasRendered() throws IOException
	{
		String apiScript = TestUtil.apiScript(data, apiName);
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		boolean result = (boolean) js.executeScript("return "+apiScript);	//Returns the data from the console
		Assert.assertTrue(result==false, "hasRendered() should be false");
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("hasRendered()_Pie chart should not be rendered")));
		
		jsExecuteWithBuffer("fusioncharts.render()");
		Assert.assertTrue(pom.verifyIfChartMainContainerDisplayed(), "Chart should have been rendered");
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("render()_Pie chart should be rendered")));
		
		JavascriptExecutor jsE = (JavascriptExecutor) driver; 
		boolean returnresult = (boolean) jsE.executeScript("return "+apiScript);	//Returns the data from the console
		Assert.assertTrue(returnresult, "hasRendered() should be true");

	}
	@AfterTest
	public void shutDown() throws IOException
	{
		try
		{
			System.out.println("hasRendered() executed");
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
