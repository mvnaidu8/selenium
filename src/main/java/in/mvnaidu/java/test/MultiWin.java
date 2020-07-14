package in.mvnaidu.java.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiWin {
	public void MultiWinM() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.google.com/gmail/about/#");
		driver.findElement(By.xpath("//a[contains(text(),'Our policy')]")).click();
		System.out.println(driver.getTitle());
		Set<String> winHanId = driver.getWindowHandles();
		Iterator<String> winHanIdItr = winHanId.iterator();
		int len = winHanId.size();
		int winItr = 0;
		String[] winId = new String[len];
		while(winHanIdItr.hasNext()) {
			winId[winItr] = winHanIdItr.next();
			winItr++;
		}
		for (int i=0;i<len;i++) {
			System.out.println(winId[i]);
		}
		driver.switchTo().window(winId[1]);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[contains(text(),'s Terms of Service')]")).click();
		Set<String> winHanId2 = driver.getWindowHandles();
		winHanIdItr = winHanId2.iterator();
		len = winHanId2.size();
		winItr = 0;
		String[] winId2 = new String[len];
		while(winHanIdItr.hasNext()) {
			winId2[winItr] = winHanIdItr.next();
			winItr++;
		}
		for (int i=0;i<len;i++) {
			System.out.println(winId2[i]);
		}
	}
}
