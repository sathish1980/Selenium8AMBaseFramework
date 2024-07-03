package BasicsOfSelenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstClass {

	public void launch()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		//browser.manage().window().minimize();
		//browser.close();
		//browser.quit(); 
		browser.get("https://www.facebook.com/");
		/*browser.navigate().to("https://www.gmail.com/");
		browser.navigate().back();
		browser.navigate().forward();
		browser.navigate().refresh();*/
		WebElement username = browser.findElement(By.id("email"));
		username.sendKeys("sathish");
		username.clear();
		browser.findElement(By.name("pass")).sendKeys("test");
		//browser.findElement(By.className("inputtext _55r1 _6luy _9npi")).sendKeys("test");
		//browser.findElement(By.linkText("Forgotten password?")).click();
		browser.findElement(By.partialLinkText("ssword?")).click();
		// tag and id
		browser.findElement(By.cssSelector("input#pass")).sendKeys("twst");
		// tag and class
		browser.findElement(By.cssSelector("input.inputtext _55r1 _6luy")).sendKeys("twst");
		// tag and attribute
		browser.findElement(By.cssSelector("input[type='text']")).sendKeys("");
		// tag , class and attribute
		
		browser.findElement(By.cssSelector("input[type='text']")).sendKeys("");
		//absolute xpath
		browser.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/form/div/div/input"));
		//relative xpath
		browser.findElement(By.xpath("//input[@type='text']")).sendKeys("");
		/*
		 * css selector
		 */
		
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FirstClass F = new FirstClass();
		F.launch();
	}

}
