package com.fusioncharts.pom;

import org.openqa.selenium.support.pagefactory.*;

import com.fusioncharts.main.APITestBase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class APIPageObjectModel extends APITestBase
{
	@FindBy(className="fusioncharts-container")
	WebElement mainContainer;
	
	@FindBy(id="btn_1")
	WebElement tempButton;
	
	@FindBy(tagName="svg")
	WebElement svgElement;
	
	@FindBy(tagName="svg")
	List<WebElement> svgElements;
	
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
	
	public String getInnerHtml(WebElement elem)
	{
		return elem.getAttribute("innerHTML");
	}
	
	public List<WebElement> getAllSvgElems()
	{
		return svgElements;
	}
	
	public WebElement mainContainer()
	{
		return mainContainer;
	}
	
	
}
