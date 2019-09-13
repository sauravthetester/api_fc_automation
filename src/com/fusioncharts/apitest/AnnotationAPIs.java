package com.fusioncharts.apitest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
import com.fusioncharts.pom.APIAnnotationPageObjectModel;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class AnnotationAPIs extends APITestBase{

	//The api name according to the data sheet
	private final static String apiName = "annotationAPIs()"; 
	Object[][] data;
	APIAnnotationPageObjectModel pom;
	
	@BeforeTest
	public void setUp() 
	{
		api = new APITestBase();
		api.initialize();
		pom = new APIAnnotationPageObjectModel();
		data = TestUtil.getTestData();
	}
	  
	@Test(priority = 1)
	public void verifyAPIExistsInDataSheetAnnotationAPIs()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedAnnotationAPIs()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIAnnotationAPIs() throws IOException
	{
		boolean annotationDisplayed;
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		Actions action = new Actions(driver);
		
		annotationDisplayed = pom.annotation().isDisplayed();
		Assert.assertTrue(!annotationDisplayed,"Annotation not displayed");
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		
		js.executeScript("arguments[0].scrollIntoView(true);", pom.addGroupAddItem());
		action.click(pom.addGroupAddItem()).build().perform();
		
		BufferedImage annoAdded = ImageIO.read(new File(System.getProperty("user.dir") +"/Compare Screenshots/Annotation Added.png"));
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pom.annotationSVG(),"ZZZAutoVerify Annotation Added Capture")));
		BufferedImage annoAddedCapture = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify Annotation Added Capture.png"));
		Assert.assertTrue(bufferedImagesEqual(annoAdded,annoAddedCapture),"Annotation Added screenshot matches correctly");
		
		annotationDisplayed = pom.annotation().isDisplayed();
		Assert.assertTrue(annotationDisplayed,"Annotation displayed");
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		
		js.executeScript("arguments[0].scrollIntoView(true);", pom.update());
		action.click(pom.update()).build().perform();
		
		BufferedImage annoUpdated = ImageIO.read(new File(System.getProperty("user.dir") +"/Compare Screenshots/Annotation Updated.png"));
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pom.annotationSVG(),"ZZZAutoVerify Annotation Updated Capture")));
		BufferedImage annoUpdatedCapture = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify Annotation Updated Capture.png"));
		Assert.assertTrue(bufferedImagesEqual(annoUpdated,annoUpdatedCapture),"Annotation Updated screenshot matches correctly");
		
		Assert.assertTrue(pom.annotation().findElement(By.tagName("rect")).getAttribute("fill").equals("#ff0000"),"Annotation Updated correctly");
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		
		js.executeScript("arguments[0].scrollIntoView(true);", pom.hide());
		action.click(pom.hide()).build().perform();
		
		BufferedImage annoHidden = ImageIO.read(new File(System.getProperty("user.dir") +"/Compare Screenshots/Annotation Hidden.png"));
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pom.annotationSVG(),"ZZZAutoVerify Annotation Hidden Capture")));
		BufferedImage annoHiddenCapture = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify Annotation Hidden Capture.png"));
		Assert.assertTrue(bufferedImagesEqual(annoHidden,annoHiddenCapture),"Annotation Hidden screenshot matches correctly");
		
		annotationDisplayed = pom.annotation().isDisplayed();
		Assert.assertTrue(!annotationDisplayed,"Annotation not displayed");
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		
		js.executeScript("arguments[0].scrollIntoView(true);", pom.show());
		action.click(pom.show()).build().perform();
		
		BufferedImage annoShown = ImageIO.read(new File(System.getProperty("user.dir") +"/Compare Screenshots/Annotation Shown.png"));
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pom.annotationSVG(),"ZZZAutoVerify Annotation Shown Capture")));
		BufferedImage annoShownCapture = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify Annotation Shown Capture.png"));
		Assert.assertTrue(bufferedImagesEqual(annoShown,annoShownCapture),"Annotation Shown screenshot matches correctly");
		
		annotationDisplayed = pom.annotation().isDisplayed();
		Assert.assertTrue(annotationDisplayed,"Annotation displayed");
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		
		js.executeScript("arguments[0].scrollIntoView(true);", pom.destroy());
		action.click(pom.destroy()).build().perform();
		
		BufferedImage annoDestroyed = ImageIO.read(new File(System.getProperty("user.dir") +"/Compare Screenshots/Annotation Destroyed.png"));
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pom.annotationSVG(),"ZZZAutoVerify Annotation Destroyed Capture")));
		BufferedImage annoDestroyedCapture = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify Annotation Destroyed Capture.png"));
		Assert.assertTrue(bufferedImagesEqual(annoDestroyed,annoDestroyedCapture),"Annotation Destroyed screenshot matches correctly");
		
		Assert.assertTrue(!pom.annotationExists(),"Annotation does not exist");
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		
		js.executeScript("arguments[0].scrollIntoView(true);", pom.addGroupAddItem());
		action.click(pom.addGroupAddItem()).build().perform();
		
		Assert.assertTrue(pom.annotationExists(),"Annotation exists by adding after destroy");
		
		jsExecuteWithBuffer("chart.annotations.clear()");
		
		Assert.assertTrue(!pom.annotationExists(),"Annotation does not exist after clear()");
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		
		js.executeScript("arguments[0].scrollIntoView(true);", pom.addMarker());
		action.click(pom.addMarker()).build().perform();
		
		BufferedImage markerAdded = ImageIO.read(new File(System.getProperty("user.dir") +"/Compare Screenshots/Marker Added.png"));
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pom.mapSVG(),"ZZZAutoVerify Marker Added Capture")));
		BufferedImage markerAddedCapture = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify Marker Added Capture.png"));
		Assert.assertTrue(bufferedImagesEqual(markerAdded,markerAddedCapture),"Marker Added screenshot matches correctly");
		
		
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		
		js.executeScript("arguments[0].scrollIntoView(true);", pom.updateMarker());
		action.click(pom.updateMarker()).build().perform();
		
		BufferedImage markerUpdated = ImageIO.read(new File(System.getProperty("user.dir") +"/Compare Screenshots/Marker Updated.png"));
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pom.mapSVG(),"ZZZAutoVerify Marker Updated Capture")));
		BufferedImage markerUpdatedCapture = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify Marker Updated Capture.png"));
		Assert.assertTrue(bufferedImagesEqual(markerUpdated,markerUpdatedCapture),"Marker Updated screenshot matches correctly");
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		
		js.executeScript("arguments[0].scrollIntoView(true);", pom.removeMarker());
		action.click(pom.removeMarker()).build().perform();
		
		BufferedImage markerRemoved = ImageIO.read(new File(System.getProperty("user.dir") +"/Compare Screenshots/Marker Removed.png"));
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pom.mapSVG(),"ZZZAutoVerify Marker Removed Capture")));
		BufferedImage markerRemovedCapture = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify Marker Removed Capture.png"));
		Assert.assertTrue(bufferedImagesEqual(markerRemoved,markerRemovedCapture),"Marker Removed screenshot matches correctly");
		
	}
	
	@AfterTest
	public void shutDown() throws IOException
	{
		try
		{
			System.out.println("AnnotationAPIs() executed");
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
