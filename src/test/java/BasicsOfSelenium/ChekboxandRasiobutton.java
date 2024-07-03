package BasicsOfSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChekboxandRasiobutton {
	
	public void CBImplementation()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();// window maximize
		//browser.manage().window().minimize();
		//browser.close();
		//browser.quit(); 
		//browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		browser.get("https://www.leafground.com/checkbox.xhtml");
		browser.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//div[2]")).click();
		String value = browser.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//div[2]")).getAttribute("class");
		if(value.contains("ui-state-active"))
		{
			System.out.println("pass");
		}
		browser.findElement(By.className("ui-toggleswitch-slider")).click();
		String cvalue = browser.findElement(By.id("j_idt87:j_idt100")).getAttribute("class");
		if(cvalue.contains("toggleswitch-checked"))
		{
			System.out.println("pass");
		}
		browser.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//div[2]")).click();
		String nvalue = browser.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//div[2]")).getAttribute("class");
		System.out.println(nvalue);
		if(!nvalue.contains("ui-state-active"))
		{
			System.out.println("pass");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChekboxandRasiobutton c = new ChekboxandRasiobutton();
		c.CBImplementation();
	}

}
