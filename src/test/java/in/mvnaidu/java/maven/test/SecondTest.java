package in.mvnaidu.java.maven.test;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class SecondTest {
	WebDriver driver;

	@Test
  public void f() {
	  driver.get("https://google.com");
	  String title = driver.getTitle();
	  if(title.isEmpty()) {
		  assertTrue(false);
	  }else {
		  assertTrue(true);
	  }
  }

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
