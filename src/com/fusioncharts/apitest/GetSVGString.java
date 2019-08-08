package com.fusioncharts.apitest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
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

public class GetSVGString extends APITestBase
{

	//The api name according to the data sheet
	private final static String apiName = "getSVGString()"; 
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
	public void verifyAPIExistsInDataSheetGetSVGString()
	{
		boolean apiExists = TestUtil.thisAPIexists(data, apiName);
		Assert.assertTrue(apiExists, "API name matches in data sheet");
	}
	
	@Test(priority = 2)
	public void verifyChartIsRenderedGetSVGString()
	{
		String htmlData = TestUtil.chartHtml(data, apiName);
		TestUtil.htmlWrite(htmlData);
		driver.navigate().refresh();
		boolean containerDisplayed = pom.verifyIfChartMainContainerDisplayed();
		Assert.assertTrue(containerDisplayed, "Chart is rendered");
	}
	
	@Test(priority = 3)
	public void verifyAPIGetSVGString() throws IOException
	{
		String buttonMessage = driver.findElement(By.tagName("button")).getText();
		Assert.assertTrue(buttonMessage.equals("Get SVG String"),"This button should be clicked");
		WebElement buttonElement = pom.getElementByPartialClassName("div", "text-center");
		WebElement button = buttonElement.findElement(By.tagName("button"));
		Actions action = new Actions(driver);
		action.click(button).build().perform();
		test.log(LogStatus.PASS, test.addScreenCapture(APITestBase.capture("GetSVGString_SVG String should be visible")));	//Code Line for screenshot
		
		String SVGString = driver.findElement(By.id("msg")).getText();
		Assert.assertTrue(SVGString.startsWith("<svg"),"This is SVG Sting's start phase");
		Assert.assertTrue(SVGString.endsWith("</svg>"),"This is SVG Sting's end phase");
	}
	@AfterTest
	public void shutDown() throws IOException
	{
		try
		{
			System.out.println("getSVGString() executed");
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
