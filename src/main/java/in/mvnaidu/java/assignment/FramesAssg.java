package in.mvnaidu.java.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAssg {
	public void FramesM() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		WebElement FrmTop = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(FrmTop);
		WebElement FTMid = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(FTMid);
		System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
	}
}
