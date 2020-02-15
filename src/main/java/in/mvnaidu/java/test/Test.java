package in.mvnaidu.java.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Test {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		
		//ChromeOptions
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("headless");
		 * options.addArguments("window-size=1200x600");
		 * 
		 * WebDriver driver = new ChromeDriver(options);
		 */

	}

}
