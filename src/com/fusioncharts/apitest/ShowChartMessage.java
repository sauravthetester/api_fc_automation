package com.fusioncharts.apitest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class ShowChartMessage extends APITestBase 
{
	//The api name according to the data sheet
	private final static String apiName = "showChartMessage()"; 
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
	public void verifyAPIExistsInDataSheetShowChartMessage()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedShowChartMessage()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "Chart is rendered");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3)
	public void verifyAPIShowChartMessage() throws IOException
	{
		WebElement Label = driver.findElement(By.tagName("input"));
		Label.sendKeys("Chart Message");
		
		WebElement mode = driver.findElement(By.id("mode"));
		Select options = new Select(mode);
		options.selectByValue("overlay");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String buttonMessage = driver.findElement(By.tagName("button")).getText();
		Assert.assertTrue(buttonMessage.equals("Show Message"),"This button should be clicked");
		WebElement button = driver.findElement(By.tagName("button"));
		Actions action = new Actions(driver);
		action.click(button).build().perform();
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("ShowChartMessage()_Overlay Chart Message should be shown over the Chart")));
		
		options.selectByValue("onchart");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String buttonMessage1 = driver.findElement(By.tagName("button")).getText();
		Assert.assertTrue(buttonMessage1.equals("Show Message"),"This button should be clicked");
		WebElement button1 = driver.findElement(By.tagName("button"));
		Actions action1 = new Actions(driver);
		action1.click(button1).build().perform();
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("ShowChartMessage()_OnChart Chart Message should be shown over the Chart")));
		
	}
	
	@AfterTest
	public void shutDown() throws IOException
	{
		try
		{
			System.out.println("showChartMessage() executed");
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
