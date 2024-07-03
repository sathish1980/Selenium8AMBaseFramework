package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ElementUtils.Elements;

public class SearchResultPage {
	
	WebDriver driver;
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String GetSearchResultText()
	{
		Elements.WaitForVisible(driver, By.xpath("//*[@class='error-title']"));
		return Elements.GetText(driver.findElement(By.xpath("//*[@class='error-title']")));
	}
	

}
