package in.mvnaidu.java.test;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mvn {
	public void web() {
		System.out.println("MVN Rocks");
		System.out.println();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.mvnaidu.in");
		System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
	}
	
}
