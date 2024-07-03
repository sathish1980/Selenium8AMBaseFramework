package BasicsOfSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {
	
	public void launch() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		browser.get("https://www.facebook.com/");
		
		JavascriptExecutor js= (JavascriptExecutor)browser;
		//vertical scroll down
		js.executeScript("window.scrollBy(0,150)", "");
		Thread.sleep(2000);
		
		//vertical scroll up
		js.executeScript("window.scrollBy(0,-100)", "");
		Thread.sleep(2000);
				
		//Horizontal scroll right
		js.executeScript("window.scrollBy(150,0)", "");
		Thread.sleep(2000);
				
		//Horizontal scroll left
		js.executeScript("window.scrollBy(-100,0)", "");
		Thread.sleep(2000);
		
		// vertically scroll down to the end
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		
		// vertically scroll down to the end
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		Thread.sleep(2000);

		// scroll in to specific element
		WebElement startbutton=browser.findElement(By.xpath("//*[text()='Sign Up']"));
		js.executeScript("arguments[0].scrollIntoView();", startbutton);
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scroll s = new Scroll();
		s.launch();
	}

}
