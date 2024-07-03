package BasicsOfSelenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {
	
	public void windowsHandle() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		browser.get("https://www.leafground.com/window.xhtml");
		String ParentWindow = browser.getWindowHandle();
		browser.findElement(By.id("j_idt88:new")).click();
		Set<String> allWindows =browser.getWindowHandles();
		for(String eachChildName :allWindows)
		{
			if(!eachChildName.equalsIgnoreCase(ParentWindow))
			{
				browser.switchTo().window(eachChildName);
				List<WebElement> elementExist  =browser.findElements(By.id("menuform:j_idt40"));
				if(elementExist.size()>0)
				{
					browser.findElement(By.id("menuform:j_idt40")).click();
					browser.findElement(By.id("menuform:m_input")).click();
					browser.findElement(By.id("j_idt88:name")).sendKeys("sathish");
					browser.close();
					break;
					
				}
			}
			
		}
		browser.switchTo().window(ParentWindow);
		
		browser.findElement(By.id("j_idt88:j_idt91")).click();
		Set<String> allWindows1 =browser.getWindowHandles();
		for(String eachChildName1 :allWindows1)
		{
			if(!eachChildName1.equalsIgnoreCase(ParentWindow))
			{
				browser.switchTo().window(eachChildName1);
				List<WebElement> elementExist  =browser.findElements(By.id("menuform:j_idt40"));
				if(elementExist.size()>0)
				{
					browser.manage().window().maximize();
					Thread.sleep(2000);
					//browser.findElement(By.id("menuform:j_idt40")).click();
					Thread.sleep(2000);
					browser.findElement(By.id("menuform:m_input")).click();
					browser.findElement(By.id("j_idt88:name")).sendKeys("sathish");
					//browser.close();
					break;
					
				}
			}
			
		}
		browser.switchTo().window(ParentWindow);
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WindowsHandling W = new WindowsHandling();
		W.windowsHandle();
	}

}
