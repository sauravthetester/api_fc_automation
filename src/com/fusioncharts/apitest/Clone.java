package com.fusioncharts.apitest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

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
	public void verifyAPIExistsInDataSheetClone()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedClone()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIClone() throws IOException
	{
		List<WebElement> svgTotal = pom.getAllSvgElems();
		Assert.assertTrue(svgTotal.size()==1, "Only one chart getting rendered");
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		
		String apiScript = TestUtil.apiScript(data, apiName);
		jsExecuteWithBuffer(apiScript);
		svgTotal = pom.getAllSvgElems();
		Assert.assertTrue(svgTotal.size()==2, "Totally 2 charts exist");
		
		int firstChartElementsTotal = svgTotal.get(0).findElements(By.xpath("*")).size();
		int clonedChartElementsTotal = svgTotal.get(1).findElements(By.xpath("*")).size();
		Assert.assertTrue(firstChartElementsTotal==clonedChartElementsTotal, "Child elements of both are equal in number");
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("Clone_there Should Be 2 Similar Charts")));	//Code Line for screenshot
		
		BufferedImage cloned = ImageIO.read(new File(System.getProperty("user.dir") +"/Compare Screenshots/Cloned.png"));
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(driver.findElement(By.id("chart_1")),"ZZZAutoVerify cloned")));
		BufferedImage clonedcapture = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify cloned.png"));
		Assert.assertTrue(bufferedImagesEqual(cloned,clonedcapture),"Clone() API with same chart type working correctly");
		
		driver.findElement(By.id("modified_copy")).click();
		
		try {Thread.sleep(4000);} catch (InterruptedException e) {e.printStackTrace();}
		svgTotal = pom.getAllSvgElems();
		Assert.assertTrue(svgTotal.size()==2, "Totally 2 charts exist");
		
		BufferedImage clonechanged = ImageIO.read(new File(System.getProperty("user.dir") +"/Compare Screenshots/clone changed.png"));
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(driver.findElement(By.id("chartobject-2")),"ZZZAutoVerify clone changed")));
		BufferedImage clonechangedcapture = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify clone changed.png"));
		Assert.assertTrue(bufferedImagesEqual(clonechanged,clonechangedcapture),"Clone() API with different chart type working correctly");
	}
	
	@AfterTest
	public void shutDown() throws IOException
	{
		try
		{
			System.out.println("Clone() executed");
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
