package in.mvnaidu.java.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public void Cleartrip() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");

		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		Select adult = new Select(driver.findElement(By.id("Adults")));
		adult.selectByIndex(3);
		Select child = new Select(driver.findElement(By.id("Childrens")));
		child.selectByVisibleText("2");
		driver.findElement(By.id("SearchBtn")).click();
		if (driver.findElements(By.id("homeErrorMessage")).size() != 0) {
			System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
		}

	}
}
