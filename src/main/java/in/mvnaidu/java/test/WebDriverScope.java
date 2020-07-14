package in.mvnaidu.java.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverScope {
	public void WebDriverScopeM() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("Full Page Links Count = " + driver.findElements(By.tagName("a")).size());

		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println("Footer Links Count = " + footerDriver.findElements(By.tagName("a")).size());

		WebElement footerCol1Driver = footerDriver.findElement(By.xpath("//div[@id='gf-BIG']//td[1]"));
		int fc1l = footerCol1Driver.findElements(By.tagName("a")).size();
		System.out.println("Footer Column 1 Links Count = " + fc1l);
		String OpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		for (int i = 1; i < fc1l; i++) {
			footerCol1Driver.findElements(By.tagName("a")).get(i).sendKeys(OpeninNewTab);
		}
		Set<String> winHan = driver.getWindowHandles();
		Iterator<String> winHanItr = winHan.iterator();
		// int whsize = winHan.size();
		int count = 1;
		winHanItr.next();
		while (winHanItr.hasNext()) {
			driver.switchTo().window(winHanItr.next());
			System.out.println("Title of Window " + count + " is " + driver.getTitle());
			count++;
		}

	}
}
