package BrowserDriver;
import java.io.Externalizable;
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utils.PropertyFileRead;

public class Browsers {
	
	public WebDriver driver;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	//helps to generate the logs in test report.
	public static ExtentTest test;
	
	String reportPath = System.getProperty("user.dir")+"\\Report\\Automation.html";
	public void LaunchTheBrowser() throws IOException
	{
		String BrowserName = PropertyFileRead.GetDataFromPropFile().getProperty("browser");
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
		driver = new ChromeDriver();
		}
		else if (BrowserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
			{
			driver = new FirefoxDriver();
			}
		driver.manage().window().maximize();
		CreateorStartReport();
	}
	
	
	
	public void CreateorStartReport()
	{
		htmlReporter = new ExtentSparkReporter(reportPath);
	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	}
	
	
	public void CloseReport()
	{
		extent.flush();
	}
	
	public void CloseTheBrowser()
	{
		CloseReport();
		driver.quit();
	}

}
