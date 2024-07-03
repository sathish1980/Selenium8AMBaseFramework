package BasicsOfSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	
	public void DropdownImplementation()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		//browser.manage().window().minimize();
		//browser.close();
		//browser.quit(); 
		//browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		browser.get("https://www.leafground.com/select.xhtml");
		
		Select dropdown = new Select(browser.findElement(By.cssSelector("[class='ui-selectonemenu']")));
		/*
		 * 3 methods in Select
		 * SelectbyIndex(number)
		 * selectbyValue(string)
		 * selectbyVisibleText(string)
		 */
		System.out.println(dropdown.isMultiple());
		dropdown.selectByIndex(1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dropdown.selectByVisibleText("Cypress");
		//dropdown.selectByValue("");
	}
	
	public void multiselect() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@class='col-lg-3' and @id='second']")));
		if(dropdown.isMultiple())
		{
			dropdown.selectByIndex(1);
			Thread.sleep(2000);
			dropdown.selectByValue("pizza");
			Thread.sleep(2000);
			dropdown.selectByVisibleText("Bonda");
			Thread.sleep(2000);
			dropdown.deselectByIndex(0);
			Thread.sleep(2000);
			dropdown.deselectByVisibleText("Pizza");
			Thread.sleep(2000);
			dropdown.deselectAll();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Dropdown D = new Dropdown();
		D.multiselect();
	}

}
