package com.fusioncharts.apitest;

import java.io.IOException;
import java.util.Map;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fusioncharts.main.APITestBase;
import com.fusioncharts.pom.APIPageObjectModel;
import com.fusioncharts.util.TestUtilData;
import com.fusioncharts.util.TestUtilSetData;

public class AllChartsSetDataAPIs extends APITestBase  
{
	//The api name according to the data sheet
	//private final static String apiName = "getXMLData()"; 
	Object[][] data;
	APIPageObjectModel pom;
	private static boolean hasRendered;
	
	@BeforeTest
	public void setUp() 
	{
		api = new APITestBase();
		api.initialize();
		pom = new APIPageObjectModel();
		data = TestUtilSetData.getTestData();
		
	}
	  
	
	@Test(priority = 1)
	public void verifyAllChartsSetDataAPIs() throws IOException, SAXException
	{	
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		
		ObjectMapper mapper = new ObjectMapper();
		
		int cnt=0;
		
		String htmlData;
		String[] allCharts = new String[33];
		allCharts = TestUtilSetData.getAllCharts(data);
		
		Map<String, Object> getChartDataMap = null;
		Map<String, Object> getChartDataJSONMap = null;
		Map<String, Object> getJSONDataMap = null;
		Map<String, Object> getChartJSONMap = null;
		
		
		
		for(String chart:allCharts)
		{
			if(chart==null)
				break;
			cnt++;
			htmlData = TestUtilSetData.chartHtml(data, chart);
			TestUtilSetData.htmlWrite(htmlData);
			driver.navigate().refresh();
			try {Thread.sleep(4000);} catch (InterruptedException e) {e.printStackTrace();}
			
			jsExecuteWithBuffer("fusioncharts.render();");
			try {Thread.sleep(3000);} catch (InterruptedException e){e.printStackTrace();}
			js.executeScript("arguments[0].scrollIntoView(true);", pom.getSvg());
			
			String getChartData = TestUtilSetData.getChartData(data, chart).toString();
			TestUtilSetData.jsonWrite(getChartData);
			String setChartData = "fusioncharts.setChartDataUrl(\"feeddata.json\",\"json\")";
			jsExecuteWithBuffer(setChartData);
			try {Thread.sleep(2000);} catch (InterruptedException e){e.printStackTrace();}
			String getChartDataJSON = (String) js.executeScript("return JSON.stringify(fusioncharts.getJSONData(), undefined, 2)");
			
			try {Thread.sleep(4000);} catch (InterruptedException e){e.printStackTrace();}
			
			String getJSONData = TestUtilSetData.getJSON(data, chart).toString();
			TestUtilSetData.jsonWrite(getJSONData);
			String setJSONData = "fusioncharts.setJSONUrl(\"feeddata.json\")";
			jsExecuteWithBuffer(setJSONData);
			try {Thread.sleep(2000);} catch (InterruptedException e){e.printStackTrace();}
			String getChartJSON = (String) js.executeScript("return JSON.stringify(fusioncharts.getJSONData(), undefined, 2)");
			
			try {Thread.sleep(4000);} catch (InterruptedException e){e.printStackTrace();}
			
			String getXMLData = TestUtilSetData.getXML(data, chart).toString();
			TestUtilSetData.xmlWrite(getXMLData);
			String setXMLData = "fusioncharts.setXMLUrl(\"feeddata.xml\")";
			jsExecuteWithBuffer(setXMLData);
			try {Thread.sleep(2000);} catch (InterruptedException e){e.printStackTrace();}
			String getChartXML = (String) js.executeScript("return fusioncharts.getXMLData()");
			
			try {Thread.sleep(4000);} catch (InterruptedException e){e.printStackTrace();}
			
			
//			Assert.assertEquals(mapper.readTree(getChartData), mapper.readTree(getChartDataJSON),chart+" setChartDataURL() returns correct data");
//			Assert.assertEquals(mapper.readTree(getJSONData), mapper.readTree(getChartJSON),chart+" setJSONUrl() returns correct data");
			//Assert.assertTrue(getXMLData.equals(getChartXML), chart+" setXMLUrl() returns correct data");
//			TestUtilSetData.XMLequal(getXMLData,getChartXML);
//			Assert.assertTrue(TestUtilSetData.XMLequal(getXMLData,getChartXML)==true, chart+" setXMLUrl() returns correct data");
			
			if(cnt<10)
				TestUtilSetData.XMLequal(getXMLData,getChartXML);
			
			ObjectMapper om = new ObjectMapper();
	        try 
	        {
	            getChartDataMap = (Map<String, Object>)(om.readValue(getChartData, Map.class));
	            getChartDataJSONMap = (Map<String, Object>)(om.readValue(getChartDataJSON, Map.class));
	            getJSONDataMap = (Map<String, Object>)(om.readValue(getJSONData, Map.class));
	            getChartJSONMap = (Map<String, Object>)(om.readValue(getChartJSON, Map.class));	
	        } 
        	catch (Exception e) 
        	{
        		e.printStackTrace();
        	}
	        Assert.assertTrue(getChartDataMap.equals(getChartDataJSONMap), chart+" setChartDataURL() returns correct data");
	        Assert.assertTrue(getJSONDataMap.equals(getChartJSONMap), chart+" setJSONUrl() returns correct data");
		}
	}
	
	
	@AfterTest
	public void shutDown() throws IOException
	{
		try
		{
			System.out.println("AllChartsSetDataAPIs() executed");
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
