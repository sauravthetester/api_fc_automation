package com.fusioncharts.pom;

import org.openqa.selenium.support.pagefactory.*;

import com.fusioncharts.main.APITestBase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class APIPageObjectModel extends APITestBase
{
	@FindBy(className="fusioncharts-container")
	WebElement mainContainer;
	
	@FindBy(id="btn_1")
	WebElement tempButton;
	
	public APIPageObjectModel()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyIfChartMainContainerDisplayed()
	{
		if(mainContainer.isDisplayed())
			return true;
		else
			return false;
	}
	
	public boolean verifyTemporaryButtonExists()
	{
		if(tempButton.isDisplayed())
			return true;
		else
			return false;
	}
	
	public List<WebElement> getTotalCharts()
	{
		return driver.findElements(By.className("fusioncharts-container"));
	}
	
	
}
