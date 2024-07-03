package BasicsOfSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {

	
	public void create()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		//browser.manage().window().minimize();
		//browser.close();
		//browser.quit(); 
		//browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		browser.get("https://www.facebook.com/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		browser.findElement(By.cssSelector("[data-testid='open-registration-form-button']")).click();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("firstname")));
		browser.findElement(By.name("firstname")).sendKeys("sathish");
		wait.until(ExpectedConditions.elementToBeClickable(browser.findElement(By.name("websubmit"))));
		browser.findElement(By.name("websubmit")).click();
		

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateAccount c = new CreateAccount();
		c.create();
	}

}
