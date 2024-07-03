package BasicsOfSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsConcept {
	
	public void AlertImplementation()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		//browser.manage().window().minimize();
		//browser.close();
		//browser.quit(); 
		//browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		browser.get("https://www.leafground.com/alert.xhtml");
	/*	browser.findElement(By.id("j_idt88:j_idt91")).click();
		//navigate in to alert
		browser.switchTo().alert().accept(); // navigae and clicked ok in alert
		String message1 =browser.findElement(By.id("simple_result")).getText();
		System.out.println(message1);
		browser.findElement(By.id("j_idt88:j_idt93")).click();
		//navigate in to alert
		browser.switchTo().alert().dismiss(); // navigae and clicked cancel in alert
		String message2 =browser.findElement(By.id("result")).getText();
		System.out.println(message2);
		browser.findElement(By.id("j_idt88:j_idt104")).click();
		//navigate in to alert
		browser.switchTo().alert().sendKeys("Beant Tambaram") ;// navigae and clicked cancel in alert
		browser.switchTo().alert().accept();
		browser.switchTo().alert().getText();
		String message3 =browser.findElement(By.id("confirm_result")).getText();
		System.out.println(message3);*/
		
		browser.findElement(By.id("j_idt88:j_idt100")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		browser.findElement(By.xpath("//*[@id='j_idt88:j_idt101']//a[@aria-label='Close']")).click();		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlertsConcept A = new AlertsConcept();
		A.AlertImplementation();
	}

}
