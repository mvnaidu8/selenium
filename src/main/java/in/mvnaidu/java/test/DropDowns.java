package in.mvnaidu.java.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDowns {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");

		// Passengers Selector
		driver.findElement(By.id("divpaxinfo")).click();
		Select adult = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		adult.selectByValue("2");
		Select child = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		child.selectByVisibleText("1");
		Select infant = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
		infant.selectByIndex(0);
		driver.findElement(By.id("divpaxinfo")).click();
		// Currency Selector
		Select cur = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		cur.selectByIndex(2); // cur.selectByValue("INR");
		cur.selectByVisibleText("INR");

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// Select From dropdown
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		// Select from city
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		Thread.sleep(3000);
		// Select to city
		// driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click(); //Using Index

		driver.findElement(By.xpath(
				"//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//td[@class='mapbg']//a[@value='DEL']"))
				.click(); // Using Parent Child Relationship

	}

}
