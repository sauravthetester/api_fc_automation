package com.fusioncharts.pom;

import org.openqa.selenium.support.pagefactory.*;

import com.fusioncharts.main.APITestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class APIPageObjectModel extends APITestBase
{
	@FindBy(className="fusioncharts-container")
	WebElement mainContainer;
	
	@FindBy(id="btn_1")
	WebElement tempButton;
	
	public boolean verifyIfChartMainContainerDisplayed()
	{
		if(mainContainer.isDisplayed())
			return true;
		else
			return false;
	}
	
	public boolean temporaryButtonExists()
	{
		if(tempButton.isDisplayed())
			return true;
		else
			return false;
	}
	
	public APIPageObjectModel()
	{
		PageFactory.initElements(driver, this);
	}
}
