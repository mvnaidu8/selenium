package in.mvnaidu.java.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Academy {
	
	public void academy() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Code Starts here
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		
	}

}
