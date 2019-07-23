package com.fusioncharts.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class APITestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports report;
	public static ExtentTest test;
	public APITestBase api;
	public static String htmlFile = System.getProperty("user.dir")+"/File/NewTestTry.html";
	public static String configFile = System.getProperty("user.dir")+"/src/com/fusioncharts/config/config.properties";
	public static String extentreportXMLFile = System.getProperty("user.dir")+"/src/com/fusioncharts/config/extent-config.xml";
	public static String extentreportReportFile = System.getProperty("user.dir") +"/test-output/FC_API_ExtentReport.html";
	
	
	public APITestBase() 
	{
		try 
		{
			prop = new Properties();
			FileInputStream file = new FileInputStream(configFile);
			prop.load(file);
			report = new ExtentReports(extentreportReportFile);
			report.loadConfig(new File(extentreportXMLFile));
			test = report.startTest("ExtentDemo");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void initialize()
	{
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	public static void jsExecuteWithBuffer(String apiScript)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript(apiScript);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String capture(String screenShotName)
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") +"/Screenshots/"+screenShotName+".png";
        File destination = new File(dest);
        try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
                     
        return dest;
    }
}
