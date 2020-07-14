package in.mvnaidu.java.assignment;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiWinAssg {
	public void MultiWin() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		Set<String> winHan = driver.getWindowHandles();
		Iterator<String> winItr = winHan.iterator();
		String parentWin = winItr.next();
		String childWin = winItr.next();
		driver.switchTo().window(childWin);
		System.out.println(driver.findElement(By.xpath("//body/div/h3")).getText());
		driver.switchTo().window(parentWin);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
	}
}
