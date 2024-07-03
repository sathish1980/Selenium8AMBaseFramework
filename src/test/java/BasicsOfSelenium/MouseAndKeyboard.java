package BasicsOfSelenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseAndKeyboard {
	
	/*
	 *  MouseaCtions
	 *  Actions --> class
	 *  1.MoveToElement
	 *  2.click
	 *  3.sendKeys
	 *  4.doubleClick
	 *  5.contextClick
	 *  6.DragAndDrop
	 *  7.KeyDown
	 *  8.KeyUp
	 */
	
	public void mouseActionImplementaion()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		browser.get("https://www.ebay.com/");
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.xpath("//*[@class='vl-flyout-nav__js-tab']//*[text()='Electronics']"))).perform();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Computers and tablets']")));
		
		mouse.moveToElement(browser.findElement(By.xpath("//*[text()='Computers and tablets']"))).click().perform();
	}
	
	public void nextimplementation()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		browser.get("https://www.facebook.com/");
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
		}
	
	public void DragAndDrop()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		browser.get("https://www.leafground.com/drag.xhtml");
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.id("form:drag"))).dragAndDrop(browser.findElement(By.id("form:drag")),browser.findElement(By.id("form:drop_content"))).perform();
		}
	
	public void DragAndDropby()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		browser.get("https://www.leafground.com/drag.xhtml");
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.id("form:conpnl_content"))).dragAndDropBy(browser.findElement(By.id("form:conpnl_content")),200,0).perform();
		mouse.moveToElement(browser.findElement(By.id("form:conpnl_content"))).dragAndDropBy(browser.findElement(By.id("form:conpnl_content")),-50,0).perform();
		}
	
	public void DragAndDropbyinslider()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		browser.get("https://www.leafground.com/drag.xhtml");
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[1]"))).dragAndDropBy(browser.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[1]")),50,0).perform();
		mouse.moveToElement(browser.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[2]"))).dragAndDropBy(browser.findElement(By.xpath("(//*[@id='form:j_idt125']//span)[2]")),-50,0).perform();
			
	}
	
	public void ProgressBar()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		browser.get("https://www.leafground.com/drag.xhtml");
		browser.findElement(By.id("form:j_idt119")).click();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.textToBePresentInElement(browser.findElement(By.xpath("//*[@class='ui-progressbar-label']")),"100%"));
		System.out.println(browser.findElement(By.className("ui-growl-title")).getText());
	}
	
	
	public void KeyboardusingActions()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		browser.get("https://www.facebook.com/");
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.id("email"))).sendKeys("sathish").keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.SHIFT).keyDown(Keys.TAB).keyUp(Keys.SHIFT).keyUp(Keys.TAB).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).perform();
		
	}
	
	public void KeyboardusingRobot() throws AWTException
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		browser.get("https://www.facebook.com/");
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		 MouseAndKeyboard M = new MouseAndKeyboard();
		 M.KeyboardusingRobot();
	}

}
