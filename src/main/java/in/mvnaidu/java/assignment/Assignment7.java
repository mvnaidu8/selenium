package in.mvnaidu.java.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Assignment7 {
	public void assg7() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement tableDriver = driver.findElement(By.id("product"));
		int rows = tableDriver.findElements(By.xpath("//tbody/tr")).size();
		System.out.println("No of Rows = "+rows);
		int col = tableDriver.findElements(By.xpath("//tbody/tr[1]/th")).size();
		System.out.println("No of Columns = "+col);
		for(int i=1;i<=col;i++) {
			String xpath = "//tbody/tr[3]/td[" + i +"]";
			String value = tableDriver.findElement(By.xpath(xpath)).getText();
			System.out.println(value);
		}
	}

}
