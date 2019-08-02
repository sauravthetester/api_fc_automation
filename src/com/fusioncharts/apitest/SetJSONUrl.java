package com.fusioncharts.apitest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class SetJSONUrl extends APITestBase {
	
	//The api name according to the data sheet
	private final static String apiName = "setJSONUrl()"; 
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
	public void verifyAPIExistsInDataSheetSetJSONUrl() 
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedSetJSONUrl()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPISetJSONUrl() throws IOException
	{
		String apiScript = TestUtil.apiScript(data, apiName);
		int numerOfPlots;
		WebElement plot = null;
		int ctr=0;
		List<WebElement> plots = pom.getElementsByPartialClassName("plots");
		for(WebElement el : plots)
		{
			ctr++;
			if(ctr==2)
				plot=el;
		}
		
		numerOfPlots = pom.totalChildElements(plot);
		Assert.assertTrue(numerOfPlots==4, "Chart should have 4 plots");
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("setJSONUrl_There should be 4 plots")));	//Code Line for screenshot
		
		jsExecuteWithBuffer(apiScript);
		
		numerOfPlots = pom.totalChildElements(plot);
		Assert.assertTrue(numerOfPlots==6, "Chart should have 6 plots");
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("setJSONUrl_There should be 6 plots")));	//Code Line for screenshot
	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
			System.out.println("setJSONUrl() executed");
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
