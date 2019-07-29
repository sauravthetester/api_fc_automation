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
    
    @FindBy(tagName="svg")
    WebElement svgElement;
    
    @FindBy(tagName="svg")
    List<WebElement> svgElements;
    
    @FindBy(id="btn_1")
    WebElement tempButton;
    
    @FindBy(id="set")
    WebElement set;
    
    @FindBy(id="rem")
    WebElement remove;
    
    @FindBy(id="data1")
    WebElement divText;
    
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
    
    public boolean verifyTemporaryButtonExists()
    {
        if(tempButton.isDisplayed())
            return true;
        else
            return false;
    }
    
    public WebElement setButton()
    {
        return set;
    }
    
    public boolean verifySetButtonExists()
    {
        if(set.isDisplayed())
            return true;
        else
            return false;
    }
    
    public WebElement removeButton()
    {
        return remove;
    }
    
    public boolean verifyRemoveButtonExists()
    {
        if(remove.isDisplayed())
            return true;
        else
            return false;
    }
    
    public WebElement divText()
    {
        return divText;
    }
    
    public WebElement getElementByPartialClassName(String tagName,String partialClassName)
    {
        List<WebElement> allElements = driver.findElements(By.tagName(tagName));
        for(WebElement all : allElements)
        {
            if(all.getAttribute("class").contains(partialClassName))
                return all;
        }
        return null;
    }
    
    public List<WebElement> getElementsByPartialClassName(String name)
    {
        return svgElement.findElements(By.xpath("//*[contains(@class,'"+name+"')]"));
    }
    
}
