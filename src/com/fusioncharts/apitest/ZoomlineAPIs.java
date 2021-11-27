package com.fusioncharts.apitest;

import java.io.IOException;

import javax.swing.Action;

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

public class ZoomlineAPIs extends APITestBase {
	
	//The api name according to the data sheet
	private final static String apiName = "zoomlineAPIs()"; 
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
	public void verifyAPIExistsInDataSheetZoomlineAPIs() 
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedZoomlineAPIs()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIZoomlineAPIs() throws IOException
	{
		String apiScript = TestUtil.apiScript(data, apiName);
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		
		jsExecuteWithBuffer("fusioncharts.setZoomMode(true);");
		long initialStartIndex = (long) js.executeScript("return fusioncharts.getViewStartIndex();");
		long initialEndIndex = (long) js.executeScript("return fusioncharts.getViewEndIndex();");
		
		WebElement canvas = pom.canvasZoomLine();
		Actions action = new Actions(driver);
		
		action.moveToElement(canvas).build().perform();
		action.clickAndHold().build().perform();
		action.moveByOffset(80, 0).build().perform();
		action.release().build().perform();
		
		long zoomedStartIndex = (long) js.executeScript("return fusioncharts.getViewStartIndex();");
		long zoomedEndIndex = (long) js.executeScript("return fusioncharts.getViewEndIndex();");
		
		Assert.assertTrue(initialStartIndex<zoomedStartIndex, "Chart should be zoomed");
		Assert.assertTrue(zoomedEndIndex<initialEndIndex, "Chart should be zoomed");
		
		action.moveToElement(canvas).build().perform();
		action.clickAndHold().build().perform();
		action.moveByOffset(80, 0).build().perform();
		action.release().build().perform();
		
		long microzoomedStartIndex = (long) js.executeScript("return fusioncharts.getViewStartIndex();");
		long microzoomedEndIndex = (long) js.executeScript("return fusioncharts.getViewEndIndex();");
		
		Assert.assertTrue(zoomedStartIndex<microzoomedStartIndex, "Chart should be more zoomed");
		Assert.assertTrue(microzoomedEndIndex<zoomedEndIndex, "Chart should be more zoomed");
		
		jsExecuteWithBuffer("fusioncharts.zoomOut();");
		
		long zoomedOutStartIndex = (long) js.executeScript("return fusioncharts.getViewStartIndex();");
		long zoomedOutEndIndex = (long) js.executeScript("return fusioncharts.getViewEndIndex();");
		
		Assert.assertTrue(zoomedStartIndex==zoomedOutStartIndex, "Chart should zoom out");
		Assert.assertTrue(zoomedEndIndex==zoomedOutEndIndex, "Chart should zoom out");
		
		jsExecuteWithBuffer("fusioncharts.zoomTo(30,70);");
		
		long zoomToStartIndex = (long) js.executeScript("return fusioncharts.getViewStartIndex();");
		long zoomToEndIndex = (long) js.executeScript("return fusioncharts.getViewEndIndex();");
		
		Assert.assertTrue(zoomToStartIndex==30, "Chart should have start index 30");
		Assert.assertTrue(zoomToEndIndex==70, "Chart should have end index 70");
		
		jsExecuteWithBuffer("fusioncharts.scrollTo(0.2);");
		
		long scrollToStartIndex = (long) js.executeScript("return fusioncharts.getViewStartIndex();");
		long scrollToEndIndex = (long) js.executeScript("return fusioncharts.getViewEndIndex();");
		
		Assert.assertTrue(zoomToStartIndex!=scrollToStartIndex, "Scroll To should work properly");
		Assert.assertTrue(zoomToEndIndex!=scrollToEndIndex, "Scroll To should work properly");
		
		jsExecuteWithBuffer("fusioncharts.scrollTo(1);");
		
		long scrollToEndStartIndex = (long) js.executeScript("return fusioncharts.getViewStartIndex();");
		long scrollToEndEndIndex = (long) js.executeScript("return fusioncharts.getViewEndIndex();");
		
		
		Assert.assertTrue(scrollToEndEndIndex==initialEndIndex, "Scroll To should work properly");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("zoomlineAPIs_scroll bar should be in the right end")));	//Code Line for screenshot
		
		jsExecuteWithBuffer("fusioncharts.resetChart();");
		
		long resetStartIndex = (long) js.executeScript("return fusioncharts.getViewStartIndex();");
		long resetEndEndIndex = (long) js.executeScript("return fusioncharts.getViewEndIndex();");
		
		Assert.assertTrue(initialStartIndex==resetStartIndex, "Scroll To should work properly");
		Assert.assertTrue(initialEndIndex==resetEndEndIndex, "Scroll To should work properly");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("zoomlineAPIs_Chart should be reset to initial")));	//Code Line for screenshot
	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
			System.out.println("zoomlineAPIs() executed");
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
