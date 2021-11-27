package com.fusioncharts.apitest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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

public class DragableChartAPIs extends APITestBase {
	
	//The api name according to the data sheet
	private final static String apiName1 = "dragable_dragcolumn2d";
	private final static String apiName2 = "dragable_dragline";
	private final static String apiName3 = "dragable_dragarea";
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
		boolean apiExists = TestUtil.thisAPIexists(data, apiName1);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
		apiExists = TestUtil.thisAPIexists(data, apiName2);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
		apiExists = TestUtil.thisAPIexists(data, apiName3);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedDragcolumn2d()
	{
		String htmlData = TestUtil.chartHtml(data, apiName1);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIDragcolumn2d() throws IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("ZZZAutoVerify dragcolumn before setUpperLimit")));
		BufferedImage dragColumnBeforeExec = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify dragcolumn before setUpperLimit.png"));
		
		jsExecuteWithBuffer("fusioncharts.setUpperLimit(30000);");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("ZZZAutoVerify dragcolumn after setUpperLimit")));
		BufferedImage dragColumnAfterExec = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify dragcolumn after setUpperLimit.png"));
		
		Assert.assertTrue(!bufferedImagesEqual(dragColumnBeforeExec,dragColumnAfterExec),"The upper limit should get changed for dragcolumn2d");
		
		long getUpperLimit = (long) js.executeScript("return fusioncharts.getUpperLimit()");
		
		Assert.assertEquals(getUpperLimit, 30000);
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("ZZZAutoVerify dragcolumn before setLowerLimit")));
		dragColumnBeforeExec = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify dragcolumn before setLowerLimit.png"));
		
		jsExecuteWithBuffer("fusioncharts.setLowerLimit(-3000)");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("ZZZAutoVerify dragcolumn after setLowerLimit")));
		dragColumnAfterExec = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify dragcolumn after setLowerLimit.png"));
		
		Assert.assertTrue(!bufferedImagesEqual(dragColumnBeforeExec,dragColumnAfterExec),"The upper limit should get changed for dragcolumn2d");
		
		long getLowerLimit = (long) js.executeScript("return fusioncharts.getLowerLimit()");
		
		Assert.assertEquals(getLowerLimit, -3000);
		
		Assert.assertTrue(pom.getUpperLimit().equals("30K"),"The upper limit should get changed for dragcolumn2d");
		
		Assert.assertTrue(pom.getLowerLimit().equals("-3K"),"The upper limit should get changed for dragcolumn2d");
	}
	
	@Test(priority = 4)
	public void verifyChartIsRenderedDragline()
	{
		String htmlData = TestUtil.chartHtml(data, apiName2);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 5)
	public void verifyAPIDragline() throws IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("ZZZAutoVerify dragline before setUpperLimit")));
		BufferedImage draglineBeforeExec = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify dragline before setUpperLimit.png"));
		
		jsExecuteWithBuffer("fusioncharts.setUpperLimit(30000);");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("ZZZAutoVerify dragline after setUpperLimit")));
		BufferedImage draglineAfterExec = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify dragline after setUpperLimit.png"));
		
		Assert.assertTrue(!bufferedImagesEqual(draglineBeforeExec,draglineAfterExec),"The upper limit should get changed for dragline");
		
		long getUpperLimit = (long) js.executeScript("return fusioncharts.getUpperLimit()");
		
		Assert.assertEquals(getUpperLimit, 30000);
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("ZZZAutoVerify dragline before setLowerLimit")));
		draglineBeforeExec = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify dragline before setLowerLimit.png"));
		
		jsExecuteWithBuffer("fusioncharts.setLowerLimit(-3000)");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("ZZZAutoVerify dragline after setLowerLimit")));
		draglineAfterExec = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify dragline after setLowerLimit.png"));
		
		Assert.assertTrue(!bufferedImagesEqual(draglineBeforeExec,draglineAfterExec),"The upper limit should get changed for dragline");
		
		long getLowerLimit = (long) js.executeScript("return fusioncharts.getLowerLimit()");
		
		Assert.assertEquals(getLowerLimit, -3000);
		
		Assert.assertTrue(pom.getUpperLimit().equals("30K"),"The upper limit should get changed for dragline");
		
		Assert.assertTrue(pom.getLowerLimit().equals("-3K"),"The upper limit should get changed for dragline");
	}
	
	@Test(priority = 6)
	public void verifyChartIsRenderedDragarea()
	{
		String htmlData = TestUtil.chartHtml(data, apiName3);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 7)
	public void verifyAPIDragarea() throws IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("ZZZAutoVerify dragarea before setUpperLimit")));
		BufferedImage dragareaBeforeExec = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify dragarea before setUpperLimit.png"));
		
		jsExecuteWithBuffer("fusioncharts.setUpperLimit(30000);");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("ZZZAutoVerify dragarea after setUpperLimit")));
		BufferedImage dragareaAfterExec = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify dragarea after setUpperLimit.png"));
		
		Assert.assertTrue(!bufferedImagesEqual(dragareaBeforeExec,dragareaAfterExec),"The upper limit should get changed for dragarea");
		
		long getUpperLimit = (long) js.executeScript("return fusioncharts.getUpperLimit()");
		
		Assert.assertEquals(getUpperLimit, 30000);
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("ZZZAutoVerify dragarea before setLowerLimit")));
		dragareaBeforeExec = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify dragarea before setLowerLimit.png"));
		
		jsExecuteWithBuffer("fusioncharts.setLowerLimit(-3000)");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("ZZZAutoVerify dragarea after setLowerLimit")));
		dragareaAfterExec = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify dragarea after setLowerLimit.png"));
		
		Assert.assertTrue(!bufferedImagesEqual(dragareaBeforeExec,dragareaAfterExec),"The upper limit should get changed for dragarea");
		
		long getLowerLimit = (long) js.executeScript("return fusioncharts.getLowerLimit()");
		
		Assert.assertEquals(getLowerLimit, -3000);
		
		Assert.assertTrue(pom.getUpperLimit().equals("30K"),"The upper limit should get changed for dragarea");
		
		Assert.assertTrue(pom.getLowerLimit().equals("-3K"),"The upper limit should get changed for dragarea");
	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
			System.out.println("DragableChartAPIs executed");
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
