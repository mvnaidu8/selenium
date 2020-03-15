package in.mvnaidu.java.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesClass {
	public void FramesM() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		System.out.println("FrameCount = " + driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		// driver.findElement(By.id("draggable")).click();
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		// Switch back from iFrame
		driver.switchTo().defaultContent();
	}
}
