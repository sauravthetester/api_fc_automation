package com.fusioncharts.apitest;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class RealTimeAPIs extends APITestBase {
	
	//The api name according to the data sheet
	private final static String apiName = "realTimeAPIs()"; 
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
	public void verifyAPIExistsInDataSheetLockResize_ResizeTo()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedLockResize_ResizeTo()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPILockResize_ResizeTo() throws IOException
	{
		String apiScript = TestUtil.apiScript(data, apiName);
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		
		long gaugeGetData1 = (long) js.executeScript("return fusioncharts_gauge.getData(1)");
		long gaugeGetData2 = (long) js.executeScript("return fusioncharts_gauge.getData(2)");
		long gaugeGetDataForId1 = (long) js.executeScript("return fusioncharts_gauge.getDataForId('dial1')");
		long gaugeGetDataForId2 = (long) js.executeScript("return fusioncharts_gauge.getDataForId('dial2')");
		
		Assert.assertTrue(gaugeGetData1==65, "GetData() angulargauge expected to return correct value");
		Assert.assertTrue(gaugeGetData2==85, "GetData() angulargauge expected to return correct value");
		Assert.assertTrue(gaugeGetDataForId1==65, "GetData() angulargauge expected to return correct value");
		Assert.assertTrue(gaugeGetDataForId2==85, "GetData() angulargauge expected to return correct value");
		
		long hlinearGetData1 = (long) js.executeScript("return fusioncharts_rthlinear.getData(1)");
		long hlinearGetData2 = (long) js.executeScript("return fusioncharts_rthlinear.getData(2)");
		long hlinearGetDataForId1 = (long) js.executeScript("return fusioncharts_rthlinear.getDataForId('pointer1')");
		long hlinearGetDataForId2 = (long) js.executeScript("return fusioncharts_rthlinear.getDataForId('pointer2')");
		
		Assert.assertTrue(hlinearGetData1==80, "GetData() hlineargauge expected to return correct value");
		Assert.assertTrue(hlinearGetData2==68, "GetData() hlineargauge expected to return correct value");
		Assert.assertTrue(hlinearGetDataForId1==80, "GetData() hlineargauge expected to return correct value");
		Assert.assertTrue(hlinearGetDataForId2==68, "GetData() hlineargauge expected to return correct value");
		
		
	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
			System.out.println("lockResize() executed");
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
