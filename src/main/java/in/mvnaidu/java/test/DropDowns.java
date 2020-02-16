package in.mvnaidu.java.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDowns {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		
		
		
		/*
		 * Thread.sleep(1000); Boolean b =
		 * driver.findElements(By.id("ctl00_mainContent_DropDownListCurrency")).isEmpty(
		 * ); if(!b) { 
		 * Select cur = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		 * //cur.selectByIndex(2); //cur.selectByValue("INR");
		 * //cur.selectByVisibleText("INR"); }
		 */
		
		
		//Passengers Selector
		driver.findElement(By.id("divpaxinfo")).click();
		Select adult = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		adult.selectByValue("2");
		Select child = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		child.selectByVisibleText("1");
		Select infant = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
		infant.selectByIndex(0);
		driver.findElement(By.id("divpaxinfo")).click();
		//Currency Selector
		Select cur = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		cur.selectByIndex(2); //cur.selectByValue("INR");
		cur.selectByVisibleText("INR"); 
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
		

	}

}
