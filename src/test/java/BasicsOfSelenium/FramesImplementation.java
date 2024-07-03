package BasicsOfSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesImplementation {

	
	public void frames() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		browser.get("https://www.leafground.com/frame.xhtml");
		//Thread.sleep(5000);
		//browser.findElement(By.xpath("//*[@id='Click' and contains(@style,'ff7295')]")).click();
		List<WebElement> allFrames = browser.findElements(By.tagName("iframe"));
		for(int i=0;i<allFrames.size();i++)
		{
			browser.switchTo().frame(i);
			List<WebElement> elementExist  =browser.findElements(By.xpath("//*[@id='Click' and contains(@style,'ff7295')]"));
			if(elementExist.size()>0)
			{
				browser.findElement(By.xpath("//*[@id='Click' and contains(@style,'ff7295')]")).click();
				break;
			}
		}
		browser.switchTo().defaultContent();
	}
	
	public void framesintoanotherframe() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		browser.get("https://www.leafground.com/frame.xhtml");
		//Thread.sleep(5000);
		//browser.findElement(By.xpath("//*[@id='Click' and contains(@style,'ff7295')]")).click();
		List<WebElement> allFrames = browser.findElements(By.tagName("iframe"));
		for(int i=0;i<allFrames.size();i++)
		{
			browser.switchTo().frame(i);
			List<WebElement> innerFrames = browser.findElements(By.tagName("iframe"));
			
			//List<WebElement> elementExist  =browser.findElements(By.xpath("//*[@id='Click' and contains(@style,'ff7295')]"));
			if(innerFrames.size()>0)
			{
				browser.switchTo().frame("frame2");
				browser.findElement(By.xpath("//*[@id='Click' and contains(@style,'8e70ee')]")).click();
				break;
			}
			browser.switchTo().defaultContent();
		}
		browser.switchTo().defaultContent();
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FramesImplementation F = new FramesImplementation();
		F.framesintoanotherframe();
	}

}
