package com.fusioncharts.pom;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fusioncharts.main.APITestBase;

public class APIRTPageObjectModel extends APITestBase
{
//	@FindBy(className="fusioncharts-container")
//	WebElement mainContainer;
	
	public APIRTPageObjectModel()
	{
		PageFactory.initElements(driver, this);
	}
	
	@SuppressWarnings("finally")
	public int totalPlotsIn(WebElement elem)
	{
		if(elem.getAttribute("id").equals("chart_2") || elem.getAttribute("id").equals("chart_9"))
		{
			List<WebElement> datalabel = new LinkedList<WebElement>();
			List<WebElement> allGElem = elem.findElements(By.tagName("g"));
			
			for(WebElement gElem : allGElem)
			{
				if(gElem.getAttribute("class").contains("fusioncharts-datalabels"))
					datalabel.add(gElem);
			}
			
			for(WebElement data : datalabel)
			{
				try
				{
					data.findElement(By.tagName("text"));
					return data.findElements(By.tagName("text")).size();
				}
				catch(NoSuchElementException e)
				{
					
				}
			}
		}
		else
		{
			List<WebElement> plotgroup = new LinkedList<WebElement>();
			List<WebElement> allGElem = elem.findElements(By.tagName("g"));
			
			char valid='a';
			int size = -1;
			
			for(WebElement gElem : allGElem)
			{
				if(gElem.getAttribute("class").contains("plot-group"))
					plotgroup.add(gElem);
			}
			
			for(WebElement data : plotgroup)
			{
				try
				{
					data.findElement(By.tagName("rect"));
					valid='r';
				}
				catch(NoSuchElementException e)
				{
					try 
					{
					data.findElement(By.tagName("path"));
					valid='p';
					}
					catch(NoSuchElementException e1) {}
				}
				finally
				{
					if(valid=='r')
					{
						size = data.findElements(By.tagName("rect")).size();
						break;
					}
					else if(valid=='p')
					{
						size = data.findElements(By.tagName("path")).size();
						if(size>1)
							break;
						else
							return -1;
					}
				}
			}
			return size;
		}
		return -1;
		
	}
	
}
