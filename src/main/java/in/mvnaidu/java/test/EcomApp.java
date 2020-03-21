package in.mvnaidu.java.test;

//import java.time.Duration;
import java.util.Arrays;
import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EcomApp {
	public void ecom() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Walnuts" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		// Thread.sleep(3000);

		addItems(driver, itemsNeeded);

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) throws InterruptedException

	{

		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++)

		{

			// Brocolli - 1 Kg

			// Brocolli, 1 kg

			String[] name = products.get(i).getText().split("-");
			/*
			 * int len = name.length; for(int stl=0;stl<len;stl++) {
			 * System.out.println("name["+stl+"] = "+name[stl]); }
			 */
			String formattedName = name[0].trim();

			// format it to get actual vegetable name

			// convert array into array list for easy search

			// check whether name you extracted is present in arrayList or not-

			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName))

			{

				j++;

				// click on Add to cart

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {

					break;
				}

			}

		}

		// Explicit wait - WebDriverWait
		 WebDriverWait w = new WebDriverWait(driver,10);

		//Wait<WebDriver> fw = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")));

		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter promo code']")));
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).clear();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		System.out
				.println("Promo Code Status = " + driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());

	}// addItems

}