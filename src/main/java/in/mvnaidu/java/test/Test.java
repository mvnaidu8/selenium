package in.mvnaidu.java.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Test {
	

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.testandquiz.com/selenium/testing.html");
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
		
		/*
		 * //Double Click Action Class WebElement dbc =
		 * driver.findElement(By.id("dblClkBtn")); Actions builder = new
		 * Actions(driver); Action doubleClick = builder.doubleClick(dbc).build();
		 * doubleClick.perform();
		 */
		
				
				//driver.close();
		System.out.println("Test Ended");
	}

}