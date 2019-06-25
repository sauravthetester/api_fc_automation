package com.fusioncharts.initialization;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fusioncharts.main.APITest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class InitializeAll 
{
	public void initializeExtentReportDoc()
	{
		APITest.report = new ExtentReports(System.getProperty("user.dir") +"/report/ExtentReportResults.html");
		APITest.report.addSystemInfo("Host Name", "SoftwareTestingMaterial").addSystemInfo("Environment", "Chrome").addSystemInfo("User Name", "Saurav Ghosh");
		APITest.report.loadConfig(new File(System.getProperty("user.dir")+"/jars/extent-config.xml"));
		APITest.test = APITest.report.startTest("ExtentDemo");
	}
	
	public void driverInitiateChrome()
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		ChromeOptions options = new ChromeOptions();
		try
		{
			options.addArguments("start-maximized");
			APITest.driver=new ChromeDriver(options);
			APITest.driver.get("https://www.google.com");
		}
		catch(Exception e)
		{
			System.out.println("could not initialize chrome");
		}
	}
	
	public void driverInitiateFirefox()
	{
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		try
		{
			APITest.driver=new FirefoxDriver();
			APITest.driver.manage().window().maximize();
			APITest.driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
			APITest.driver.get("");
		}
		catch(Exception e)
		{
			System.out.println("could not initialize firefox");
		}
	}
}
