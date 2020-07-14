package in.mvnaidu.java.test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuggestiveDropDown {

	public void url() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		String winHandle = driver.getWindowHandle();
		System.out.println(winHandle);
		Thread.sleep(20000);
		driver.switchTo().activeElement().click();
		Thread.sleep(2000);
		driver.switchTo().window(winHandle);
		Thread.sleep(2000);

		Set<String> handles = driver.getWindowHandles();
		System.out.println("Set<String> = " + handles);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();

		WebElement source = driver.findElement(By.xpath("//input[@placeholder='From']"));

		Thread.sleep(1000);

		source.click();
		Thread.sleep(1000);

		source.sendKeys("MUM");

		Thread.sleep(1000);

		source.sendKeys(Keys.ARROW_DOWN);

		source.sendKeys(Keys.ENTER);

		WebElement dest = driver.findElement(By.xpath("//input[@placeholder='To']"));

		Thread.sleep(1000);

		dest.click();

		Thread.sleep(1000);

		dest.sendKeys("DEL");

		Thread.sleep(1000);

		dest.sendKeys(Keys.ARROW_DOWN);

		dest.sendKeys(Keys.ENTER);

	}

	public void SDropDown() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("https://www.makemytrip.com/");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='fromCity']")).click();

		WebElement source = driver.findElement(By.xpath("//input[@placeholder='From']"));

		Thread.sleep(1000);

		source.click();

		Thread.sleep(1000);

		source.sendKeys("MUM");

		Thread.sleep(1000);

		source.sendKeys(Keys.ARROW_DOWN);

		source.sendKeys(Keys.ENTER);

		source = driver.findElement(By.xpath("//input[@placeholder='To']"));

		Thread.sleep(1000);

		source.click();

		Thread.sleep(1000);

		source.sendKeys("DEL");

		Thread.sleep(1000);

		for (int i = 1; i < 3; i++)

		{

			source.sendKeys(Keys.ARROW_DOWN);

		}

		source.sendKeys(Keys.ENTER);

	}

	public void Spicy() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");

		Thread.sleep(2000);
		// OneWay Trip
		do {
			driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).click();
		} while (!driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).isSelected());

		// Passengers Count
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("divpaxinfo")).click();
		driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']//option[contains(text(),'2')]"))
				.click();
		driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Child']//option[contains(text(),'3')]"))
				.click();
		// Currency Selector
		Select curr = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		curr.selectByVisibleText("USD");
		// driver.findElement(By.xpath("//option[contains(text(),'INR')]")).click();

		// Check box count
		System.out.println(
				"No of Checkboxes in page = " + driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		// Check box selector
		driver.findElement(By.cssSelector("input[id*='IndArm']")).click();
		System.out.println("Ind Army Check Box Selected = "
				+ driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());

		// From

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Delhi (DEL)')]")).click();

		// To

		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[contains(text(),'Chennai (MAA)')]"))
				.click();

		// Current day selection

		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		// click on search

		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}
}
