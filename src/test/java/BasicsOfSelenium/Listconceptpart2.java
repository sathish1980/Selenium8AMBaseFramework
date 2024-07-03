package BasicsOfSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Listconceptpart2 {

	WebDriver browser;
	public void ListImplementation(String expectedCountry,String radioType)
	{
		browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		//browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		browser.get("https://www.makemytrip.com/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SelectRadioButton(radioType);
		browser.findElement(By.xpath("//*[@for='fromCity']")).click();
		// wait
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='react-autowhatever-1']//li)[last()]")));
		
		List<WebElement> allcountry =browser.findElements(By.xpath("//*[@id='react-autowhatever-1']//li"));
	
		for (WebElement eachElement : allcountry)
		{
			String Code = eachElement.findElement(By.cssSelector("div[class^='font14']")).getText();
			System.out.println(Code);
			if(Code.equalsIgnoreCase(expectedCountry))
			{
				eachElement.click();
				break;
			}
		}
	}
	
	
	
	public void SelectRadioButton(String expectedtripType)
	{
		List<WebElement> allTrips = browser.findElements(By.xpath("//*[starts-with(@class,'fswTabs')]//li"));
		for(WebElement eachElement : allTrips)
		{
			String tripType = eachElement.getText();
			if(tripType.equalsIgnoreCase(expectedtripType))
			{
			eachElement.findElement(By.cssSelector("span[class^='tabsCircle']")).click();
			break;
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Listconceptpart2 L = new Listconceptpart2();
		L.ListImplementation("PNQ","Multi City");
		
	}

}
