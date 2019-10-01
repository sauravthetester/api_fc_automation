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
	public void verifyAPIExistsInDataSheetRealTimeAPIs()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedRealTimeAPIs()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIRealTimeAPIs() throws IOException
	{
		String apiScript = TestUtil.apiScript(data, apiName);
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		
		//getData() and getDataForId() for all real time charts
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
		
		double rtareaGetData = (double) js.executeScript("return fusioncharts_rtarea.getData()[9][1]");
		Assert.assertTrue(rtareaGetData==35.27, "GetData() rtarea expected to return correct value");
		
		long bulbGetData = (long) js.executeScript("return fusioncharts_rtbulb.getData()");
		Assert.assertTrue(bulbGetData==-5, "GetData() bulb expected to return correct value");
		
		long rtcolumnGetData = (long) js.executeScript("return fusioncharts_rtcolumn.getData()[9][1]");
		Assert.assertTrue(rtcolumnGetData==3, "GetData() rtcolumn expected to return correct value");
		
		long rtcylinderGetData = (long) js.executeScript("return fusioncharts_rtcylinder.getData()");
		Assert.assertTrue(rtcylinderGetData==85, "GetData() rtcylinder expected to return correct value");
		
		long rthbulletGetData = (long) js.executeScript("return fusioncharts_rthbullet.getData()");
		Assert.assertTrue(rthbulletGetData==82, "GetData() rthbullet expected to return correct value");
		
		long rthledGetData = (long) js.executeScript("return fusioncharts_rthled.getData()");
		Assert.assertTrue(rthledGetData==67, "GetData() rthled expected to return correct value");
		
		long rtlineGetData = (long) js.executeScript("return fusioncharts_rtline.getData()[9][1]");
		Assert.assertTrue(rtlineGetData==50, "GetData() rtline expected to return correct value");
		
		long rtlinedyGetData1 = (long) js.executeScript("return fusioncharts_rtlinedy.getData()[9][1]");
		Assert.assertTrue(rtlinedyGetData1==2500, "GetData() rtlinedy[1] expected to return correct value");
		long rtlinedyGetData2 = (long) js.executeScript("return fusioncharts_rtlinedy.getData()[9][2]");
		Assert.assertTrue(rtlinedyGetData2==6000, "GetData() rtlinedy[2] expected to return correct value");
		
		long rtsareaGetData1 = (long) js.executeScript("return fusioncharts_rtsarea.getData()[9][1]");
		Assert.assertTrue(rtsareaGetData1==88, "GetData() rtsarea[1] expected to return correct value");
		long rtsareaGetData2 = (long) js.executeScript("return fusioncharts_rtsarea.getData()[9][2]");
		Assert.assertTrue(rtsareaGetData2==77, "GetData() rtsarea[2] expected to return correct value");
		
		long rtsculomnGetData1 = (long) js.executeScript("return fusioncharts_rtscolumn.getData()[9][1]");
		Assert.assertTrue(rtsculomnGetData1==12, "GetData() rtsculomn[1] expected to return correct value");
		long rtsculomnGetData2 = (long) js.executeScript("return fusioncharts_rtscolumn.getData()[9][2]");
		Assert.assertTrue(rtsculomnGetData2==20, "GetData() rtsculomn[2] expected to return correct value");
		
		long rtthermoGetData = (long) js.executeScript("return fusioncharts_rtthermometer.getData()");
		Assert.assertTrue(rtthermoGetData==-10, "GetData() rtthermo expected to return correct value");
		
		long vbulletGetData = (long) js.executeScript("return fusioncharts_rtvbullet.getData()");
		Assert.assertTrue(vbulletGetData==73, "GetData() vbullet expected to return correct value");
		
		long rtvledGetData = (long) js.executeScript("return fusioncharts_rtvled.getData()");
		Assert.assertTrue(rtvledGetData==58, "GetData() rtvled expected to return correct value");
		
		//setDataForId() for all real time charts
		
		js.executeScript("fusioncharts_gauge.setDataForId('dial1',47)");
		try {Thread.sleep(4000);} catch (InterruptedException e) {e.printStackTrace();}
		js.executeScript("fusioncharts_gauge.setDataForId('dial2',23)");
		
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		
		gaugeGetData1 = (long) js.executeScript("return fusioncharts_gauge.getData(1)");
		gaugeGetData2 = (long) js.executeScript("return fusioncharts_gauge.getData(2)");
		
		
		Assert.assertTrue(gaugeGetData1==47, "GetData() angulargauge after setDataForId expected to return correct value");
		Assert.assertTrue(gaugeGetData2==23, "GetData() angulargauge after setDataForId expected to return correct value");
		
		js.executeScript("fusioncharts_gauge.setData(1,63)");
		try {Thread.sleep(4000);} catch (InterruptedException e) {e.printStackTrace();}
		js.executeScript("fusioncharts_gauge.setData(2,79)");
		
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		
		gaugeGetData1 = (long) js.executeScript("return fusioncharts_gauge.getData(1)");
		gaugeGetData2 = (long) js.executeScript("return fusioncharts_gauge.getData(2)");
		
		Assert.assertTrue(gaugeGetData1==63, "GetData() angulargauge after setData expected to return correct value");
		Assert.assertTrue(gaugeGetData2==79, "GetData() angulargauge after setData expected to return correct value");
		
		
		js.executeScript("fusioncharts_rthlinear.setDataForId('pointer1',37)");
		try {Thread.sleep(4000);} catch (InterruptedException e) {e.printStackTrace();}
		js.executeScript("fusioncharts_rthlinear.setDataForId('pointer2',29)");
		
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		
		hlinearGetData1 = (long) js.executeScript("return fusioncharts_rthlinear.getData(1)");
		hlinearGetData2 = (long) js.executeScript("return fusioncharts_rthlinear.getData(2)");
		
		
		Assert.assertTrue(hlinearGetData1==37, "GetData() hlinear after setDataForId expected to return correct value");
		Assert.assertTrue(hlinearGetData2==29, "GetData() hlinear after setDataForId expected to return correct value");
		
		//setData() for all real time charts
		
		js.executeScript("fusioncharts_rthlinear.setData(1,70)");
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		js.executeScript("fusioncharts_rthlinear.setData(2,42)");
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		js.executeScript("fusioncharts_rtarea.setData(29,\"label1\")");
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		js.executeScript("fusioncharts_rtbulb.setData(59)");
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		js.executeScript("fusioncharts_rtcolumn.setData(36,\"label1\")");
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		js.executeScript("fusioncharts_rtcylinder.setData(54)");
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		js.executeScript("fusioncharts_rthbullet.setData(45)");
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		js.executeScript("fusioncharts_rthled.setData(24)");
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		js.executeScript("fusioncharts_rtline.setData(77,\"label1\")");
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		js.executeScript("fusioncharts_rtthermometer.setData(15)");
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		js.executeScript("fusioncharts_rtvbullet.setData(12)");
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		js.executeScript("fusioncharts_rtvled.setData(25)");
		
		
		try {Thread.sleep(7000);} catch (InterruptedException e) {e.printStackTrace();}
		
		hlinearGetData1 = (long) js.executeScript("return fusioncharts_rthlinear.getData(1)");
		hlinearGetData2 = (long) js.executeScript("return fusioncharts_rthlinear.getData(2)");
		
		Assert.assertTrue(hlinearGetData1==70, "GetData() hlinear after setData expected to return correct value");
		Assert.assertTrue(hlinearGetData2==42, "GetData() hlinear after setData expected to return correct value");
		
		
		long rtareaGetData1 = (long) js.executeScript("return fusioncharts_rtarea.getData()[9][1]");
		double rtareaGetData2 = (double) js.executeScript("return fusioncharts_rtarea.getData()[8][1]");
		
		Assert.assertTrue(rtareaGetData1==29, "GetData() rtarea after setData expected to return correct value");
		Assert.assertTrue(rtareaGetData2==35.27, "GetData() rtarea after setData expected to return correct value");
		
		
		bulbGetData = (long) js.executeScript("return fusioncharts_rtbulb.getData()");
		Assert.assertTrue(bulbGetData==59, "GetData() bulb after setData expected to return correct value");
		
		rtcolumnGetData = (long) js.executeScript("return fusioncharts_rtcolumn.getData()[9][1]");
		long rtcolumnGetDataPrev = (long) js.executeScript("return fusioncharts_rtcolumn.getData()[8][1]");
		Assert.assertTrue(rtcolumnGetData==36, "GetData() rtcolumn after setData expected to return correct value");
		Assert.assertTrue(rtcolumnGetDataPrev==3, "GetData() rtcolumn previous data after setData expected to return correct value");
		
		rtcylinderGetData = (long) js.executeScript("return fusioncharts_rtcylinder.getData()");
		Assert.assertTrue(rtcylinderGetData==54, "GetData() cylinder after setData expected to return correct value");
		
		rthbulletGetData = (long) js.executeScript("return fusioncharts_rthbullet.getData()");
		Assert.assertTrue(rthbulletGetData==45, "GetData() rthbullet after setData expected to return correct value");
		
		rthledGetData = (long) js.executeScript("return fusioncharts_rthled.getData()");
		Assert.assertTrue(rthledGetData==24, "GetData() rthled after setData expected to return correct value");
		
		rtlineGetData = (long) js.executeScript("return fusioncharts_rtline.getData()[9][1]");
		Assert.assertTrue(rtlineGetData==77, "GetData() rtline after setData expected to return correct value");
		long rtlineGetData2 = (long) js.executeScript("return fusioncharts_rtline.getData()[8][1]");
		Assert.assertTrue(rtlineGetData2==50, "GetData() rtline after setData expected to return correct value");
		
		rtthermoGetData = (long) js.executeScript("return fusioncharts_rtthermometer.getData()");
		Assert.assertTrue(rtthermoGetData==15, "GetData() rtthermo after setData expected to return correct value");
		
		vbulletGetData = (long) js.executeScript("return fusioncharts_rtvbullet.getData()");
		Assert.assertTrue(vbulletGetData==12, "GetData() vbullet after setData expected to return correct value");
		
		rtvledGetData = (long) js.executeScript("return fusioncharts_rtvled.getData()");
		Assert.assertTrue(rtvledGetData==25, "GetData() rtvled after setData expected to return correct value");
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
		driver.quit();
	}
}
