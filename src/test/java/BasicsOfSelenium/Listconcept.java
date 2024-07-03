package BasicsOfSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Listconcept {

	public void ListImplementation(String expectedCountry)
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		//browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		browser.get("https://www.leafground.com/select.xhtml");
		browser.findElement(By.xpath("//div[@id='j_idt87:country']//*[starts-with(@class,'ui-selectonemenu-trigger')]")).click();
		// wait
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='j_idt87:country_items']//following-sibling::li)[last()]")));
		
		List<WebElement> allcountry =browser.findElements(By.xpath("//*[@id='j_idt87:country_items']//following-sibling::li"));
	
		for(int i=1;i<=allcountry.size();i++)
		{
			String actualCountry = browser.findElement(By.xpath("(//*[@id='j_idt87:country_items']//following-sibling::li)["+i+"]")).getText();
			if(expectedCountry.equalsIgnoreCase(actualCountry))
			{
				 browser.findElement(By.xpath("(//*[@id='j_idt87:country_items']//following-sibling::li)["+i+"]")).click();
				 String value =browser.findElement(By.xpath("(//*[@id='j_idt87:country_items']//following-sibling::li)["+i+"]")).getAttribute("aria-selected");
				System.out.println(value);
				
				 break;
			}
			
		}
	}
	
	
	public void ListImplementationanotherway(String expectedCountry)
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		//browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		browser.get("https://www.leafground.com/select.xhtml");
		browser.findElement(By.xpath("//div[@id='j_idt87:country']//*[starts-with(@class,'ui-selectonemenu-trigger')]")).click();
		// wait
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='j_idt87:country_items']//following-sibling::li)[last()]")));
		
		List<WebElement> allcountry =browser.findElements(By.xpath("//*[@id='j_idt87:country_items']//following-sibling::li"));
	
		for(WebElement eachelement : allcountry)
		{
			String actualCountry  =eachelement.getText();
			if(expectedCountry.equalsIgnoreCase(actualCountry))
			{
				eachelement.click();
				 String value =eachelement.getAttribute("aria-selected");
				System.out.println(value);
				
				 break;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Listconcept L = new Listconcept();
		L.ListImplementationanotherway("USA");
		
	}

}
