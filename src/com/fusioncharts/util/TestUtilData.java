package com.fusioncharts.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fusioncharts.main.APITestBase;

public class TestUtilData {
	static Workbook book;
	static Sheet sheet;
	static String DATA_FILE = System.getProperty("user.dir") + "/src/com/fusioncharts/testdata/apiallchartsdata.xls";
	private final static int numberOfCharts =34;
	
	public static Object[][] getTestData()
	{
		FileInputStream file=null;
		try {
			file = new FileInputStream(DATA_FILE);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sheet=book.getSheet("data");
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++)
			{
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
	}
	
	public static void htmlWrite(String htmlData)
	{
		try
		{    
           FileWriter fw=new FileWriter(APITestBase.htmlFile); 
           fw.write(htmlData);    
           fw.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static String chartHtml(Object[][] data,String chart)
	{
		String[] allCharts = new String[numberOfCharts];
		
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			allCharts[i] = (String) data[i][0];
			if(allCharts[i].equals(chart))
			{
				return (String) data[i][1];
			}
			
//			allChartsHTML[i] = (String) data[i][1];
		}
		return "";
	}
	
	public static String[] getAllCharts(Object[][] data)
	{
		String[] allCharts = new String[numberOfCharts];
		
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			allCharts[i] = (String) data[i][0];
			
		}
		return allCharts;
	}
	
	public static String getJSON(Object[][] data,String chart)
	{
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			String chartName = (String) data[i][0];
			if(chart.equals(chartName))
				return (String) data[i][2];
		}
		return "";
	}
	
	public static String getCSV(Object[][] data,String chart)
	{
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			String chartName = (String) data[i][0];
			if(chart.equals(chartName))
				return (String) data[i][3];
		}
		return "";
	}
	
	public static String getXML(Object[][] data,String chart)
	{
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			String chartName = (String) data[i][0];
			if(chart.equals(chartName))
				return (String) data[i][4];
		}
		return "";
	}

}
