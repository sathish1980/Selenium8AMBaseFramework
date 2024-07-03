package BasicsOfSelenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Screenshot {
	WebDriver browser;

	public void ListImplementation(String[] expectedCountries) throws InterruptedException, IOException
	{
		browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		//browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		browser.get("https://www.leafground.com/select.xhtml");
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		
		for(int i=0;i<expectedCountries.length;i++)
		{
		String expectedCountry =expectedCountries[i];
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j_idt87:auto-complete']//button")));
		
		browser.findElement(By.xpath("//*[@id='j_idt87:auto-complete']//button")).click();
		// wait
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='j_idt87:auto-complete_panel']//li)[last()]")));
		
		List<WebElement> allcountry =browser.findElements(By.xpath("//*[@id='j_idt87:auto-complete_panel']//li"));
	
		for (WebElement eachElement : allcountry)
		{
			wait.until(ExpectedConditions.visibilityOf(eachElement));
			
			String Code = eachElement.getText();
			System.out.println(Code);
			if(Code.equalsIgnoreCase(expectedCountry))
			{
				wait.until(ExpectedConditions.elementToBeClickable(eachElement));
				
				eachElement.click();
				break;
			}
		}
		}
		Screenshots("Add");
	}
	
	public void RemoveValue(String remove) throws IOException, InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='j_idt87:auto-complete']//li)[last()]")));
		
		List<WebElement> allcountry =browser.findElements(By.xpath("//*[@id='j_idt87:auto-complete']//li"));
	
		for (WebElement eachElement : allcountry)
		{
			String Code = eachElement.getAttribute("data-token-value");
			System.out.println(Code);
			if(Code.equalsIgnoreCase(remove))
			{
				eachElement.findElement(By.cssSelector("span[class$='ui-icon-close']")).click();
				break;
			}
		}
		Thread.sleep(1000);
		Screenshots("Remove");
	}
	
	public void Screenshots(String filename) throws IOException
	{
		TakesScreenshot screen = (TakesScreenshot)browser;
		File sourceFile = screen.getScreenshotAs(OutputType.FILE);
		File DestinationFile = new File(System.getProperty("user.dir")+"//ScreenshotFolder//"+filename+".png");
		FileUtils.copyFile(sourceFile, DestinationFile);
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		Screenshot L = new Screenshot();
		String[] c = {"Appium","JMeter","AWS"};
		L.ListImplementation(c);
		L.RemoveValue("JMeter");
		
	}

}
