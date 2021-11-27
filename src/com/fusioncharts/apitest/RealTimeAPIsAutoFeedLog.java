package com.fusioncharts.apitest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.pom.APIRTPageObjectModel;
import com.fusioncharts.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class RealTimeAPIsAutoFeedLog extends APITestBase {
	
	//The api name according to the data sheet
	private final static String apiName = "realTimeAPIsAutoFeedLog()"; 
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
	public void verifyAPIExistsInDataSheetRealTimeAPIsAutoFeedLog()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedRealTimeAPIsAutoFeedLog()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIRealTimeAPIsAutoFeedLog() throws IOException
	{
		String apiScript = TestUtil.apiScript(data, apiName);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		boolean logDisplayed=false;
		
		try {Thread.sleep(12000);} catch (InterruptedException e) {e.printStackTrace();}
		
		
		///Hiding all log windows
		
		logDisplayed = pomRT.rtgauge().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "gauge log should be displayed");
		js.executeScript("fusioncharts_gauge.hideLog()");
		logDisplayed = pomRT.rtgauge().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(!logDisplayed, "gauge log should not be displayed");
		
		logDisplayed = pomRT.rtarea().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "rtarea log should be displayed");
		js.executeScript("fusioncharts_rtarea.hideLog()");
		logDisplayed = pomRT.rtarea().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(!logDisplayed, "rtarea log should not be displayed");
		
		logDisplayed = pomRT.rtbulb().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "bulb log should be displayed");
		js.executeScript("fusioncharts_rtbulb.hideLog()");
		logDisplayed = pomRT.rtbulb().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(!logDisplayed, "bulb log should not be displayed");
		
		logDisplayed = pomRT.rtcolumn().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "rtcolumn log should be displayed");
		js.executeScript("fusioncharts_rtcolumn.hideLog()");
		logDisplayed = pomRT.rtcolumn().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(!logDisplayed, "rtcolumn log should not be displayed");
		
		logDisplayed = pomRT.rtcylinder().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "cylinder log should be displayed");
		js.executeScript("fusioncharts_rtcylinder.hideLog()");
		logDisplayed = pomRT.rtcylinder().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(!logDisplayed, "cylinder log should not be displayed");
		
		logDisplayed = pomRT.rthlinear().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "hlinear log should be displayed");
		js.executeScript("fusioncharts_rthlinear.hideLog()");
		logDisplayed = pomRT.rthlinear().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(!logDisplayed, "hlinear log should not be displayed");
		
		logDisplayed = pomRT.rtline().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "rtline log should be displayed");
		js.executeScript("fusioncharts_rtline.hideLog()");
		logDisplayed = pomRT.rtline().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(!logDisplayed, "rtline log should not be displayed");
		
		logDisplayed = pomRT.rtlinedy().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "rtline log should be displayed");
		js.executeScript("fusioncharts_rtlinedy.hideLog()");
		logDisplayed = pomRT.rtlinedy().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(!logDisplayed, "rtline log should not be displayed");
		
		logDisplayed = pomRT.rtsarea().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "rtarea log should be displayed");
		js.executeScript("fusioncharts_rtsarea.hideLog()");
		logDisplayed = pomRT.rtsarea().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(!logDisplayed, "rtarea log should not be displayed");
		
		logDisplayed = pomRT.rtscolumn().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "rtscolumn log should be displayed");
		js.executeScript("fusioncharts_rtscolumn.hideLog()");
		logDisplayed = pomRT.rtscolumn().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(!logDisplayed, "rtscolumn log should not be displayed");
		
		logDisplayed = pomRT.rtthermo().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "thermometer log should be displayed");
		js.executeScript("fusioncharts_rtthermometer.hideLog()");
		logDisplayed = pomRT.rtthermo().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(!logDisplayed, "thermometer log should not be displayed");
		
		logDisplayed = pomRT.rthbullet().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "hbullet log should be displayed");
		js.executeScript("fusioncharts_rthbullet.hideLog()");
		logDisplayed = pomRT.rthbullet().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(!logDisplayed, "hbullet log should not be displayed");
		
		logDisplayed = pomRT.rthled().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "hled log should be displayed");
		js.executeScript("fusioncharts_rthled.hideLog()");
		logDisplayed = pomRT.rthled().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(!logDisplayed, "hled log should not be displayed");
		
		logDisplayed = pomRT.rtvbullet().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "vbullet log should be displayed");
		js.executeScript("fusioncharts_rtvbullet.hideLog()");
		logDisplayed = pomRT.rtvbullet().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(!logDisplayed, "vbullet log should not be displayed");
		
		logDisplayed = pomRT.rtvled().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "vled log should be displayed");
		js.executeScript("fusioncharts_rtvled.hideLog()");
		logDisplayed = pomRT.rtvled().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(!logDisplayed, "vled log should not be displayed");
		
		
		///Showing for all windows
		
		js.executeScript("fusioncharts_gauge.showLog()");
		logDisplayed = pomRT.rtgauge().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "gauge log should be displayed");
		
		js.executeScript("fusioncharts_rtarea.showLog()");
		logDisplayed = pomRT.rtarea().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "rtarea log should be displayed");
		
		js.executeScript("fusioncharts_rtbulb.showLog()");
		logDisplayed = pomRT.rtbulb().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "bulb log should be displayed");
		
		js.executeScript("fusioncharts_rtcolumn.showLog()");
		logDisplayed = pomRT.rtcolumn().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "rtcolumn log should be displayed");
		
		js.executeScript("fusioncharts_rtcylinder.showLog()");
		logDisplayed = pomRT.rtcylinder().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "cylinder log should be displayed");
		
		js.executeScript("fusioncharts_rthlinear.showLog()");
		logDisplayed = pomRT.rthlinear().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "hlinear log should be displayed");
		
		js.executeScript("fusioncharts_rtline.showLog()");
		logDisplayed = pomRT.rtline().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "rtline log should be displayed");
		
		js.executeScript("fusioncharts_rtlinedy.showLog()");
		logDisplayed = pomRT.rtlinedy().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "rtline log should be displayed");
		
		js.executeScript("fusioncharts_rtsarea.showLog()");
		logDisplayed = pomRT.rtsarea().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "rtarea log should be displayed");
		
		js.executeScript("fusioncharts_rtscolumn.showLog()");
		logDisplayed = pomRT.rtscolumn().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "rtscolumn log should be displayed");
		
		js.executeScript("fusioncharts_rtthermometer.showLog()");
		logDisplayed = pomRT.rtthermo().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "thermometer log should be displayed");
		
		js.executeScript("fusioncharts_rthbullet.showLog()");
		logDisplayed = pomRT.rthbullet().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "hbullet log should be displayed");
		
		js.executeScript("fusioncharts_rthled.showLog()");
		logDisplayed = pomRT.rthled().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "hled log should be displayed");
		
		js.executeScript("fusioncharts_rtvbullet.showLog()");
		logDisplayed = pomRT.rtvbullet().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "vbullet log should be displayed");
		
		js.executeScript("fusioncharts_rtvled.showLog()");
		logDisplayed = pomRT.rtvled().findElement(By.id("dialog")).isDisplayed();
		Assert.assertTrue(logDisplayed, "vled log should be displayed");
		
		
		///Stopping update for all charts
		
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
		
		///Clear all log windows
		
		js.executeScript("fusioncharts_gauge.clearLog()");
		js.executeScript("fusioncharts_rtarea.clearLog()");
		js.executeScript("fusioncharts_rtbulb.clearLog()");
		js.executeScript("fusioncharts_rtcolumn.clearLog()");
		js.executeScript("fusioncharts_rtcylinder.clearLog()");
		js.executeScript("fusioncharts_rthbullet.clearLog()");
		js.executeScript("fusioncharts_rthled.clearLog()");
		js.executeScript("fusioncharts_rthlinear.clearLog()");
		js.executeScript("fusioncharts_rtline.clearLog()");
		js.executeScript("fusioncharts_rtlinedy.clearLog()");
		js.executeScript("fusioncharts_rtsarea.clearLog()");
		js.executeScript("fusioncharts_rtscolumn.clearLog()");
		js.executeScript("fusioncharts_rtthermometer.clearLog()");
		js.executeScript("fusioncharts_rtvbullet.clearLog()");
		js.executeScript("fusioncharts_rtvled.clearLog()");
		
		///Verifying cleared windows
		
		BufferedImage blankLogWindow = null;
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
			blankLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Compare Screenshots/Log Window Blank Sample_Chrome.png"));
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
			blankLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Compare Screenshots/Log Window Blank Sample_Firefox.png"));
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pomRT.rtgauge().findElement(By.id("dialog")),"ZZZAutoVerify log window rtgauge")));
		BufferedImage rtgaugeLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify log window rtgauge.png"));
		Assert.assertTrue(bufferedImagesEqual(blankLogWindow,rtgaugeLogWindow),"rtgauge window should be cleared");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pomRT.rtarea().findElement(By.id("dialog")),"ZZZAutoVerify log window rtarea")));
		BufferedImage rtareaLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify log window rtarea.png"));
		Assert.assertTrue(bufferedImagesEqual(blankLogWindow,rtareaLogWindow),"rtarea window should be cleared");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pomRT.rtbulb().findElement(By.id("dialog")),"ZZZAutoVerify log window rtbulb")));
		BufferedImage rtbulbLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify log window rtbulb.png"));
		Assert.assertTrue(bufferedImagesEqual(blankLogWindow,rtbulbLogWindow),"rtbulb window should be cleared");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pomRT.rtcolumn().findElement(By.id("dialog")),"ZZZAutoVerify log window rtcolumn")));
		BufferedImage rtcolumnLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify log window rtcolumn.png"));
		Assert.assertTrue(bufferedImagesEqual(blankLogWindow,rtcolumnLogWindow),"rtcolumn window should be cleared");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pomRT.rtcylinder().findElement(By.id("dialog")),"ZZZAutoVerify log window rtcylinder")));
		BufferedImage rtcylinderLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify log window rtcylinder.png"));
		Assert.assertTrue(bufferedImagesEqual(blankLogWindow,rtcylinderLogWindow),"rtcylinder window should be cleared");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pomRT.rthlinear().findElement(By.id("dialog")),"ZZZAutoVerify log window rthlinear")));
		BufferedImage rthlinearLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify log window rthlinear.png"));
		Assert.assertTrue(bufferedImagesEqual(blankLogWindow,rthlinearLogWindow),"rthlinear window should be cleared");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pomRT.rtline().findElement(By.id("dialog")),"ZZZAutoVerify log window rtline")));
		BufferedImage rtlineLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify log window rtline.png"));
		Assert.assertTrue(bufferedImagesEqual(blankLogWindow,rtlineLogWindow),"rtline window should be cleared");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pomRT.rtlinedy().findElement(By.id("dialog")),"ZZZAutoVerify log window rtlinedy")));
		BufferedImage rtlinedyLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify log window rtlinedy.png"));
		Assert.assertTrue(bufferedImagesEqual(blankLogWindow,rtlinedyLogWindow),"rtlinedy window should be cleared");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pomRT.rtsarea().findElement(By.id("dialog")),"ZZZAutoVerify log window rtsarea")));
		BufferedImage rtsareaLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify log window rtsarea.png"));
		Assert.assertTrue(bufferedImagesEqual(blankLogWindow,rtsareaLogWindow),"rtsarea window should be cleared");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pomRT.rtscolumn().findElement(By.id("dialog")),"ZZZAutoVerify log window rtscolumn")));
		BufferedImage rtscolumnLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify log window rtscolumn.png"));
		Assert.assertTrue(bufferedImagesEqual(blankLogWindow,rtscolumnLogWindow),"rtscolumn window should be cleared");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pomRT.rtthermo().findElement(By.id("dialog")),"ZZZAutoVerify log window rtthermo")));
		BufferedImage rtthermoLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify log window rtthermo.png"));
		Assert.assertTrue(bufferedImagesEqual(blankLogWindow,rtthermoLogWindow),"rtthermo window should be cleared");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pomRT.rthbullet().findElement(By.id("dialog")),"ZZZAutoVerify log window rthbullet")));
		BufferedImage rthbulletLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify log window rthbullet.png"));
		Assert.assertTrue(bufferedImagesEqual(blankLogWindow,rthbulletLogWindow),"rthbullet window should be cleared");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pomRT.rthled().findElement(By.id("dialog")),"ZZZAutoVerify log window rthled")));
		BufferedImage rthledLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify log window rthled.png"));
		Assert.assertTrue(bufferedImagesEqual(blankLogWindow,rthledLogWindow),"rthled window should be cleared");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pomRT.rtvbullet().findElement(By.id("dialog")),"ZZZAutoVerify log window rtvbullet")));
		BufferedImage rtvbulletLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify log window rtvbullet.png"));
		Assert.assertTrue(bufferedImagesEqual(blankLogWindow,rtvbulletLogWindow),"rtvbullet window should be cleared");
		
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.captureElement(pomRT.rtvled().findElement(By.id("dialog")),"ZZZAutoVerify log window rtvled")));
		BufferedImage rtvledLogWindow = ImageIO.read(new File(System.getProperty("user.dir") +"/Screenshots/ZZZAutoVerify log window rtvled.png"));
		Assert.assertTrue(bufferedImagesEqual(blankLogWindow,rtvledLogWindow),"rtvled window should be cleared");
	}
	
	@AfterTest
	public void shutDown() 
	{
		try
		{
			System.out.println("realTimeAPIsAutoFeedLog() executed");
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
