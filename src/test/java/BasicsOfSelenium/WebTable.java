package BasicsOfSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	
	public void tableimplementation(String expectedCountry) throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		//browser.manage().window().minimize();
		//browser.close();
		//browser.quit(); 
		//browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		browser.get("https://www.leafground.com/table.xhtml");
		// pagination
		
		List<WebElement> allPages = browser.findElements(By.xpath("//*[@class='ui-paginator-pages']//a"));
		for(int i=1;i<=allPages.size();i++)
		{
			browser.findElement(By.xpath("//*[@class='ui-paginator-pages']//a["+i+"]")).click();
			Thread.sleep(2000);
		
		
		List<WebElement> allRows= browser.findElements(By.xpath("//*[@class='ui-datatable-scrollable-body']//table//tbody//tr"));
		
		for(WebElement eachRow :allRows)
		{
			String actualCountryName  = eachRow.findElement(By.cssSelector("td:nth-child(2)>span[style^='vertical-align:']")).getText();
			if(expectedCountry.equalsIgnoreCase(actualCountryName))
			{
				String name = eachRow.findElement(By.cssSelector("td:nth-child(1)")).getText();
				System.out.println(name);
			}
		}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebTable W = new WebTable();
		W.tableimplementation("Italy");
	}

}
