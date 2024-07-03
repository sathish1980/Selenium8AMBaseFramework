package BasicsOfSelenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Download {
	
	WebDriver driver;
	public void downloadconcpet()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/grid.xhtml");
		driver.findElement(By.id("form:j_idt93")).click();
	}
	
	public void downloadintospecific() throws AWTException, InterruptedException
	{
		Map<String, Object> ad = new HashMap<String, Object>();
		//ad.put("download.default_directory",  System.getProperty("user.dir")+ File.separator + "OutputFile" + File.separator + "downloadFiles");
		ad.put("profile.default_content_settings.popups", 0);
		ad.put("download.default_directory",  "D:\\FITA\\Downloads\\");
		ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("prefs", ad);
		options.setExperimentalOption("prefs", ad);
		options.addArguments("start-maximized");
		//options.addArguments("--disable-Notifications");
		//options.addArguments("--incognito");
		//options.addArguments("--headless");

		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
	
		driver = new ChromeDriver(options);
		driver.get("https://leafground.com/grid.xhtml");
		System.out.println("Lauched browser");
		driver.findElement(By.id("form:j_idt93")).click();
		Robot rb = new Robot();
		Thread.sleep(1000);
		 //rb.keyPress(KeyEvent.VK_ENTER);
		 //rb.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("Download is Done");
		System.out.println("Done");
	}



	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		Download d = new Download();
		d.downloadintospecific();
	}

}
