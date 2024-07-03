package BasicsOfSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerificationandValidation {
	
	/*
	 * 1.getTitle
	 * 2.getCurrentUrl
	 * 3.getPageSource
	 * 4.getText
	 * 5.getAtribute
	 * 6.getWindowHandle
	 * 7.getWindowHandles
	 */
	
	String expected= "Facebook";
	public void Verfi()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		browser.get("https://www.facebook.com/");
		System.out.println(browser.getTitle());
		System.out.println(browser.getCurrentUrl());
		System.out.println(browser.getPageSource());
		System.out.println(browser.getWindowHandle());
		System.out.println(browser.findElement(By.name("login")).getCssValue("background-color"));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerificationandValidation V = new VerificationandValidation();
		V.Verfi();
	}

}
