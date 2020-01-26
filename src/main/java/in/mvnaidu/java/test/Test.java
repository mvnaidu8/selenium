package in.mvnaidu.java.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Test {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String URL = "https://www.phptravels.net/home";
		driver.get(URL);
		String Title = driver.getTitle();
		System.out.println(Title);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/button")).click(); //Accepts the Cookie
		
		// Currency Selector Begins
		
		  driver.findElement(By.id("dropdownCurrency")).click(); //Clicks the Currency Changer Drop-down
		  //driver.findElement(By.linkText("USD")).click(); //Changes the currency to EUR 
		  driver.findElement(By.linkText("EUR")).click(); //Changes the currency to EUR
		 		
		
		//Currency Selector Ends
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div[2]/div/ul/li[3]/div/a")).click(); //My Account Drop Down
		Thread.sleep(2000);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demouser");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/div/div[1]/div[2]/form/button")).click(); //Login Button
		
		
		

	}

}