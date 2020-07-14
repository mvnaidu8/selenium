package in.mvnaidu.java.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableGrid {
	public void TableGridM() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		WebDriver driver = new ChromeDriver(options);
		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/22773/nz-vs-ind-1st-t20i-india-tour-of-new-zealand-2020");
		WebElement TDriver = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		List<WebElement> TRows = TDriver
				.findElements(By.cssSelector("div[class='cb-col cb-col-8 text-right text-bold']"));
		int rowcount = TRows.size() + 2;
		// System.out.println(rowcount);
		int totalScore = 0;
		for (int i = 0; i < rowcount; i++) {
			Boolean nameBool = TDriver
					.findElements(By.xpath("//div[@id='innings_1']//div[1]//div[" + i + "]//div[1]/a")).isEmpty();
			Boolean scoreBool = TDriver.findElements(By.xpath("//div[@id='innings_1']//div[1]//div[" + i + "]//div[3]"))
					.isEmpty();
			if (!nameBool && !scoreBool) {
				String name = TDriver.findElement(By.xpath("//div[@id='innings_1']//div[1]//div[" + i + "]//div[1]/a"))
						.getText();
				String score = TDriver.findElement(By.xpath("//div[@id='innings_1']//div[1]//div[" + i + "]//div[3]"))
						.getText();
				System.out.println(name + "-" + score);
				totalScore = totalScore + Integer.parseInt(score);
			}
		}
		int extras = Integer
				.parseInt(TDriver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText());
		System.out.println("Extras = " + extras);
		totalScore = totalScore + extras;
		System.out.println("Team Score = " + totalScore);
	}

}
