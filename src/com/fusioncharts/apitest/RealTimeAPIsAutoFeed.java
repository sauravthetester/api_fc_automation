package com.fusioncharts.apitest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.pom.APIRTPageObjectModel;
import com.fusioncharts.util.TestUtil;

public class RealTimeAPIsAutoFeed extends APITestBase {
	
	//The api name according to the data sheet
	private final static String apiName = "realTimeAPIsAutoFeed()"; 
	Object[][] data;
	APIPageObjectModel pom;
	APIRTPageObjectModel pomRT;
	
	@BeforeTest
	public void setUp() 
	{
		api = new APITestBase();
		api.initialize();
		pom = new APIPageObjectModel();
		pomRT = new APIRTPageObjectModel();
		data = TestUtil.getTestData();
	}
	  
	@Test(priority = 1)
	public void verifyAPIExistsInDataSheetRealTimeAPIsAutoFeed()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedRealTimeAPIsAutoFeed()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIRealTimeAPIsAutoFeed() throws IOException
	{
		String apiScript = TestUtil.apiScript(data, apiName);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int sizeArea;
		int sizeColumn;
		int sizeLine;
		int sizeLinedy;
		int sizeSArea;
		int sizeSColumn;
		
		int sizeAreaStop;
		int sizeColumnStop;
		int sizeLineStop;
		int sizeLinedyStop;
		int sizeSAreaStop;
		int sizeSColumnStop;
		
		
		boolean isUpdateActiveGauge = (boolean) js.executeScript("return fusioncharts_gauge.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveGauge==true, "isUpdateActive() expected to show true for gauge");
		boolean isUpdateActiveArea = (boolean) js.executeScript("return fusioncharts_rtarea.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveArea==true, "isUpdateActive() expected to show true for area");
		boolean isUpdateActiveBulb = (boolean) js.executeScript("return fusioncharts_rtbulb.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveBulb==true, "isUpdateActive() expected to show true for bulb");
		boolean isUpdateActiveColumn = (boolean) js.executeScript("return fusioncharts_rtcolumn.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveColumn==true, "isUpdateActive() expected to show true for column");
		boolean isUpdateActiveCylinder = (boolean) js.executeScript("return fusioncharts_rtcylinder.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveCylinder==true, "isUpdateActive() expected to show true for cylinder");
		boolean isUpdateActiveHBullet = (boolean) js.executeScript("return fusioncharts_rthbullet.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveHBullet==true, "isUpdateActive() expected to show true for hbullet");
		boolean isUpdateActiveHLed = (boolean) js.executeScript("return fusioncharts_rthled.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveHLed==true, "isUpdateActive() expected to show true for hled");
		boolean isUpdateActiveHLinear = (boolean) js.executeScript("return fusioncharts_rthlinear.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveHLinear==true, "isUpdateActive() expected to show true for hlinear");
		boolean isUpdateActiveLine = (boolean) js.executeScript("return fusioncharts_rtline.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveLine==true, "isUpdateActive() expected to show true for line");
		boolean isUpdateActiveLinedy = (boolean) js.executeScript("return fusioncharts_rtlinedy.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveLinedy==true, "isUpdateActive() expected to show true for linedy");
		boolean isUpdateActiveSArea = (boolean) js.executeScript("return fusioncharts_rtsarea.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveSArea==true, "isUpdateActive() expected to show true for stackedarea");
		boolean isUpdateActiveSColumn = (boolean) js.executeScript("return fusioncharts_rtscolumn.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveSColumn==true, "isUpdateActive() expected to show true for stackedcolumn");
		boolean isUpdateActiveThermo = (boolean) js.executeScript("return fusioncharts_rtthermometer.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveThermo==true, "isUpdateActive() expected to show true for thermometer");
		boolean isUpdateActiveVBullet = (boolean) js.executeScript("return fusioncharts_rtvbullet.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveVBullet==true, "isUpdateActive() expected to show true for vbullet");
		boolean isUpdateActiveVLed = (boolean) js.executeScript("return fusioncharts_rtvled.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveVLed==true, "isUpdateActive() expected to show true for vled");
		
		try {Thread.sleep(12000);} catch (InterruptedException e) {e.printStackTrace();}
		
		js.executeScript("fusioncharts_gauge.stopUpdate()");
		js.executeScript("fusioncharts_rtarea.stopUpdate()");
		js.executeScript("fusioncharts_rtbulb.stopUpdate()");
		js.executeScript("fusioncharts_rtcolumn.stopUpdate()");
		js.executeScript("fusioncharts_rtcylinder.stopUpdate()");
		js.executeScript("fusioncharts_rthbullet.stopUpdate()");
		js.executeScript("fusioncharts_rthled.stopUpdate()");
		js.executeScript("fusioncharts_rthlinear.stopUpdate()");
		js.executeScript("fusioncharts_rtline.stopUpdate()");
		js.executeScript("fusioncharts_rtlinedy.stopUpdate()");
		js.executeScript("fusioncharts_rtsarea.stopUpdate()");
		js.executeScript("fusioncharts_rtscolumn.stopUpdate()");
		js.executeScript("fusioncharts_rtthermometer.stopUpdate()");
		js.executeScript("fusioncharts_rtvbullet.stopUpdate()");
		js.executeScript("fusioncharts_rtvled.stopUpdate()");
		
		sizeArea = pomRT.totalPlotsIn(driver.findElement(By.id("chart_2")));
		Assert.assertTrue(sizeArea>2, "rtarea expected to get updated data");
		
		sizeColumn = pomRT.totalPlotsIn(driver.findElement(By.id("chart_4")));
		Assert.assertTrue(sizeColumn>2, "rtcol expected to get updated data");
		
		sizeLine = pomRT.totalPlotsIn(driver.findElement(By.id("chart_7")));
		Assert.assertTrue(sizeLine>2, "rtline expected to get updated data");
		
		sizeLinedy = pomRT.totalPlotsIn(driver.findElement(By.id("chart_8")));
		Assert.assertTrue(sizeLinedy>2, "rtlinedy expected to get updated data");
		
		sizeSArea = pomRT.totalPlotsIn(driver.findElement(By.id("chart_9")));
		Assert.assertTrue(sizeSArea>2, "rtsarea expected to get updated data");
		
		sizeSColumn = pomRT.totalPlotsIn(driver.findElement(By.id("chart_10")));
		Assert.assertTrue(sizeSColumn>2, "rtscol expected to get updated data");
		
		
		try {Thread.sleep(12000);} catch (InterruptedException e) {e.printStackTrace();}
		
		
		sizeAreaStop = pomRT.totalPlotsIn(driver.findElement(By.id("chart_2")));
		Assert.assertTrue(sizeArea==sizeAreaStop, "rtarea expected to stop after stopUpdate");
		
		sizeColumnStop = pomRT.totalPlotsIn(driver.findElement(By.id("chart_4")));
		Assert.assertTrue(sizeColumn==sizeColumnStop, "rtcol expected to stop after stopUpdate");
		
		sizeLineStop = pomRT.totalPlotsIn(driver.findElement(By.id("chart_7")));
		Assert.assertTrue(sizeLine==sizeLineStop, "rtline expected to stop after stopUpdate");
		
		sizeLinedyStop = pomRT.totalPlotsIn(driver.findElement(By.id("chart_8")));
		Assert.assertTrue(sizeLinedy==sizeLinedyStop, "rtlinedy expected to stop after stopUpdate");
		
		sizeSAreaStop = pomRT.totalPlotsIn(driver.findElement(By.id("chart_9")));
		Assert.assertTrue(sizeSArea==sizeSAreaStop, "rtsarea expected to stop after stopUpdate");
		
		sizeSColumnStop = pomRT.totalPlotsIn(driver.findElement(By.id("chart_10")));
		Assert.assertTrue(sizeSColumn==sizeSColumnStop, "rtscol expected to stop after stopUpdate");
		
		
		js.executeScript("fusioncharts_rtarea.clearChart()");
		js.executeScript("fusioncharts_rtcolumn.clearChart()");
		js.executeScript("fusioncharts_rtline.clearChart()");
		js.executeScript("fusioncharts_rtlinedy.clearChart()");
		js.executeScript("fusioncharts_rtsarea.clearChart()");
		js.executeScript("fusioncharts_rtscolumn.clearChart()");
		
		sizeArea = pomRT.totalPlotsIn(driver.findElement(By.id("chart_2")));
		Assert.assertTrue(sizeArea==-1, "rtarea expected to get cleared");
		
		sizeColumn = pomRT.totalPlotsIn(driver.findElement(By.id("chart_4")));
		Assert.assertTrue(sizeColumn==-1, "rtcol expected to get cleared");
		
		sizeLine = pomRT.totalPlotsIn(driver.findElement(By.id("chart_7")));
		Assert.assertTrue(sizeLine==-1, "rtline expected to get cleared");
		
		sizeLinedy = pomRT.totalPlotsIn(driver.findElement(By.id("chart_8")));
		Assert.assertTrue(sizeLinedy==-1, "rtlinedy expected to get cleared");
		
		sizeSArea = pomRT.totalPlotsIn(driver.findElement(By.id("chart_9")));
		Assert.assertTrue(sizeSArea==-1, "rtsarea expected to get cleared");
		
		sizeSColumn = pomRT.totalPlotsIn(driver.findElement(By.id("chart_10")));
		Assert.assertTrue(sizeSColumn==-1, "rtscol expected to get cleared");
		
		js.executeScript("fusioncharts_gauge.restartUpdate()");
		js.executeScript("fusioncharts_rtarea.restartUpdate()");
		js.executeScript("fusioncharts_rtbulb.restartUpdate()");
		js.executeScript("fusioncharts_rtcolumn.restartUpdate()");
		js.executeScript("fusioncharts_rtcylinder.restartUpdate()");
		js.executeScript("fusioncharts_rthbullet.restartUpdate()");
		js.executeScript("fusioncharts_rthled.restartUpdate()");
		js.executeScript("fusioncharts_rthlinear.restartUpdate()");
		js.executeScript("fusioncharts_rtline.restartUpdate()");
		js.executeScript("fusioncharts_rtlinedy.restartUpdate()");
		js.executeScript("fusioncharts_rtsarea.restartUpdate()");
		js.executeScript("fusioncharts_rtscolumn.restartUpdate()");
		js.executeScript("fusioncharts_rtthermometer.restartUpdate()");
		js.executeScript("fusioncharts_rtvbullet.restartUpdate()");
		js.executeScript("fusioncharts_rtvled.restartUpdate()");
		
		
		try {Thread.sleep(24000);} catch (InterruptedException e) {e.printStackTrace();}
		
		js.executeScript("fusioncharts_gauge.stopUpdate()");
		js.executeScript("fusioncharts_rtarea.stopUpdate()");
		js.executeScript("fusioncharts_rtbulb.stopUpdate()");
		js.executeScript("fusioncharts_rtcolumn.stopUpdate()");
		js.executeScript("fusioncharts_rtcylinder.stopUpdate()");
		js.executeScript("fusioncharts_rthbullet.stopUpdate()");
		js.executeScript("fusioncharts_rthled.stopUpdate()");
		js.executeScript("fusioncharts_rthlinear.stopUpdate()");
		js.executeScript("fusioncharts_rtline.stopUpdate()");
		js.executeScript("fusioncharts_rtlinedy.stopUpdate()");
		js.executeScript("fusioncharts_rtsarea.stopUpdate()");
		js.executeScript("fusioncharts_rtscolumn.stopUpdate()");
		js.executeScript("fusioncharts_rtthermometer.stopUpdate()");
		js.executeScript("fusioncharts_rtvbullet.stopUpdate()");
		js.executeScript("fusioncharts_rtvled.stopUpdate()");
		
		isUpdateActiveGauge = (boolean) js.executeScript("return fusioncharts_gauge.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveGauge==false, "isUpdateActive() expected to show false for gauge");
		isUpdateActiveArea = (boolean) js.executeScript("return fusioncharts_rtarea.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveArea==false, "isUpdateActive() expected to show false for area");
		isUpdateActiveBulb = (boolean) js.executeScript("return fusioncharts_rtbulb.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveBulb==false, "isUpdateActive() expected to show false for bulb");
		isUpdateActiveColumn = (boolean) js.executeScript("return fusioncharts_rtcolumn.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveColumn==false, "isUpdateActive() expected to show false for column");
		isUpdateActiveCylinder = (boolean) js.executeScript("return fusioncharts_rtcylinder.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveCylinder==false, "isUpdateActive() expected to show false for cylinder");
		isUpdateActiveHBullet = (boolean) js.executeScript("return fusioncharts_rthbullet.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveHBullet==false, "isUpdateActive() expected to show false for hbullet");
		isUpdateActiveHLed = (boolean) js.executeScript("return fusioncharts_rthled.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveHLed==false, "isUpdateActive() expected to show false for hled");
		isUpdateActiveHLinear = (boolean) js.executeScript("return fusioncharts_rthlinear.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveHLinear==false, "isUpdateActive() expected to show false for hlinear");
		isUpdateActiveLine = (boolean) js.executeScript("return fusioncharts_rtline.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveLine==false, "isUpdateActive() expected to show false for line");
		isUpdateActiveLinedy = (boolean) js.executeScript("return fusioncharts_rtlinedy.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveLinedy==false, "isUpdateActive() expected to show false for linedy");
		isUpdateActiveSArea = (boolean) js.executeScript("return fusioncharts_rtsarea.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveSArea==false, "isUpdateActive() expected to show false for stackedarea");
		isUpdateActiveSColumn = (boolean) js.executeScript("return fusioncharts_rtscolumn.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveSColumn==false, "isUpdateActive() expected to show false for stackedcolumn");
		isUpdateActiveThermo = (boolean) js.executeScript("return fusioncharts_rtthermometer.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveThermo==false, "isUpdateActive() expected to show false for thermometer");
		isUpdateActiveVBullet = (boolean) js.executeScript("return fusioncharts_rtvbullet.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveVBullet==false, "isUpdateActive() expected to show false for vbullet");
		isUpdateActiveVLed = (boolean) js.executeScript("return fusioncharts_rtvled.isUpdateActive()");
		Assert.assertTrue(isUpdateActiveVLed==false, "isUpdateActive() expected to show false for vled");
		
		sizeArea = pomRT.totalPlotsIn(driver.findElement(By.id("chart_2")));
		Assert.assertTrue(sizeArea>2, "rtarea expected to get updated data after restart");
		
		sizeColumn = pomRT.totalPlotsIn(driver.findElement(By.id("chart_4")));
		Assert.assertTrue(sizeColumn>2, "rtcol expected to get updated data after restart");
		
		sizeLine = pomRT.totalPlotsIn(driver.findElement(By.id("chart_7")));
		Assert.assertTrue(sizeLine>2, "rtline expected to get updated data after restart");
		
		sizeLinedy = pomRT.totalPlotsIn(driver.findElement(By.id("chart_8")));
		Assert.assertTrue(sizeLinedy>2, "rtlinedy expected to get updated data after restart");
		
		sizeSArea = pomRT.totalPlotsIn(driver.findElement(By.id("chart_9")));
		Assert.assertTrue(sizeSArea>2, "rtsarea expected to get updated data after restart");
		
		sizeSColumn = pomRT.totalPlotsIn(driver.findElement(By.id("chart_10")));
		Assert.assertTrue(sizeSColumn>2, "rtscol expected to get updated data after restart");
	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
			System.out.println("realTimeAPIs() executed");
			Thread.sleep(3000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		report.endTest(test);
		report.flush();
//		driver.quit();
	}


}
