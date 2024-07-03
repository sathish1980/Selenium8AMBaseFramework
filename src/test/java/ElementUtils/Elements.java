package ElementUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements {
	
	
	public static void ClickBackButton(WebDriver driver)
	{
		driver.navigate().back();
	}
	
	public static void EnterText(WebElement element,String TexttoBeEnter)
	{
		if(element.isDisplayed())
		{
			element.clear();
			element.sendKeys(TexttoBeEnter);
		}
	}
	
	public static void ClickOnButton(WebElement element)
	{
		if(element.isDisplayed())
		{
			element.click();
		}
	}
	
	public static String GetText(WebElement element)
	{
		if(element.isDisplayed())
		{
			return element.getText();
		}
		return null;
	}
	
	public static String GetAttribute(WebElement element,String attribute)
	{
		if(element.isDisplayed())
		{
			return element.getAttribute(attribute);
		}
		return null;
	}
	
	public static String GetScreenshot(WebDriver browser,String filename) throws IOException
	{
		TakesScreenshot screen = (TakesScreenshot)browser;
		File sourceFile = screen.getScreenshotAs(OutputType.FILE);
		File DestinationFile = new File(System.getProperty("user.dir")+"//Screenshot//"+filename+".png");
		FileUtils.copyFile(sourceFile, DestinationFile);
		return DestinationFile.toString();
	}
	
	
	public static void WaitForClickable(WebDriver driver,By Element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
		
	}
	
	public static void WaitForVisible(WebDriver driver,By Element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
		
	}
	

}
