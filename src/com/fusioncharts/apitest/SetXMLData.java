package com.fusioncharts.apitest;

import java.io.IOException;

import org.openqa.selenium.By;
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

public class SetXMLData extends APITestBase 
{
	private final static String apiName = "setXMLData()"; 
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
	public void verifyAPIExistsInDataSheetSetXMLData()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedSetXMLData()
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
	public void verifyAPISetXMLData() throws IOException
	{
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("SetXMLData()_2013 year's data should be visible")));
		WebElement label1 = pom.getElementByPartialClassName("g", "canvasdatalabel");
		WebElement labelText1 = label1.findElement(By.tagName("text"));
		String firstLabelText1 = labelText1.getText();
		
		WebElement year = driver.findElement(By.id("year"));
		Select yeardd = new Select(year);
		yeardd.selectByValue("2014");
		
		String buttonMessage = driver.findElement(By.tagName("button")).getText();
		Assert.assertTrue(buttonMessage.equals("Set XML Data"),"This button should be clicked");
		WebElement button = driver.findElement(By.tagName("button"));
		Actions action = new Actions(driver);
		action.click(button).build().perform();
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("SetXMLData()_2014 year's data should be visible")));
		
		String firstLabelText2 = labelText1.getText();
		Assert.assertTrue(!firstLabelText1.equals(firstLabelText2), "SetXMLData() executed successfully");
	}
	
	@AfterTest
	public void shutDown() throws IOException
	{
		try
		{
			System.out.println("setXMLData() executed");
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
