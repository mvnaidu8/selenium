package in.mvnaidu.java.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Udemy {
	public void udemy() throws InterruptedException {
		System.out.println("In Udemy.java");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		if (driver.findElement(By.cssSelector("#username")).isDisplayed()) {
			System.out.println("#username is displayed");
		}
		driver.findElement(By.cssSelector("#username")).sendKeys("Username");
		driver.findElement(By.cssSelector("#password")).sendKeys("Password");
		driver.findElement(By.cssSelector("#rememberUn")).click();
		driver.findElement(By.cssSelector("#Login")).click();
		Thread.sleep(1000);
		driver.close();
		System.out.println("Success");
	}

}
