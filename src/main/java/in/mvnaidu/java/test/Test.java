package in.mvnaidu.java.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.openqa.selenium.Alert;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Test {
	

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		File file = new File("systemout");
        //Instantiating the PrintStream class
        PrintStream stream = new PrintStream(file);
        System.out.println("From now on "+file.getAbsolutePath()+" will be your console");
        System.setOut(stream);
		
		
		driver.get("https://www.testandquiz.com/selenium/testing.html");
		System.out.println("Current URL = "+ driver.getCurrentUrl());
		//Text Box
		driver.findElement(By.id("fname")).sendKeys("Venkat");
		
		//Button
		driver.findElement(By.id("idOfButton")).click();
		
		//Dropdown
		Select dropDown = new Select(driver.findElement(By.id("testingDropdown")));
		dropDown.selectByVisibleText("Manual Testing");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Radio-Button
		WebElement radioButton = driver.findElement(By.id("male"));
		radioButton.click();
		if(radioButton.isSelected()) {
			System.out.println("Male Selected");
		}
		else {
			System.out.println("Male not Selected");
		}
		
		//Checkbox
		driver.findElement(By.cssSelector("input.Automation")).click();
		
		//getText
		String text = driver.findElement(By.xpath("/html/body/div/div[3]")).getText();
		System.out.println(text);
		
		 //Double Click Action Class 
		 WebElement dbcbutton = driver.findElement(By.id("dblClkBtn")); 
		 Actions builder = new Actions(driver); 
		 Action doubleClick = builder.doubleClick(dbcbutton).build();
		 doubleClick.perform();
		
		 //Alert Handling
		 Alert alert = (Alert) driver.switchTo().alert();
		 alert.accept();
		 
		 System.out.println("Window Handle = "+driver.getWindowHandle());
				
				driver.close();
		System.out.println("Test Ended");
	}

}