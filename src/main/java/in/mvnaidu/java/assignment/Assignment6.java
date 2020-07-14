package in.mvnaidu.java.assignment;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment6 {
	public void Assg6M() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption1")).click();
		String vText = driver.findElement(By.xpath("//input[@id='checkBoxOption1']/parent::label")).getText();
		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText(vText);
		driver.findElement(By.id("name")).sendKeys(vText);
		driver.findElement(By.id("alertbtn")).click();
		String aText = driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		//System.out.println(aText);
		boolean tBool = aText.contains(vText);
		System.out.println(tBool);
	}

}
