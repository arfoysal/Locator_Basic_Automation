package testCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import basePackage.DriverSetup;

public class TC_010_Find_specific_offer_price extends DriverSetup {
	public static String baseurl = "https://www.othoba.com/hardware-sanitary";

	@Test
	public static void findSpecificPriceProduct() throws InterruptedException {

		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		boolean test = true;
		int page_number = 1;
		do {
			List<WebElement> pricelist = driver.findElements(By.cssSelector("span[class='price actual-price']"));
			Thread.sleep(2000);
			int item_number = 1;

			for (WebElement price : pricelist) {
				if (price.getText().equals("Tk 6")) {
					System.out.println("Item number - " + item_number);
					System.out.println("Page number - " + page_number);
					Thread.sleep(2000);
					test = false;
					break;
				}
				item_number++;
			}

			page_number++;
			pricelist.clear();
			if (test) {
				try {
					driver.findElement(By.xpath("//a[normalize-space()='Next']")).click();
				} catch (org.openqa.selenium.NoSuchElementException e) {
					test = false;
					System.out.println("Nothing found");
				}

			}

			Thread.sleep(5000);
		} while (test);

	}

}
