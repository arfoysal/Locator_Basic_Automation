package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_016_WebTable extends DriverSetup {
	public static String baseurl = "https://qavbox.github.io/demo/webtable/";

	@Test
	public static void handleWebTable() throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		// Collecting headers
		List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table01']/thead//th"));

		for (WebElement el : headers) {
			System.out.println(el.getText());
		}

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table01']/tbody/tr"));

		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement cellData : cols) {
				System.out.println(cellData.getText());
				if (cellData.getText().equals("Selenium")) {
					cols.get(0).findElement(By.tagName("input")).click();
					cols.get(4).findElement(By.tagName("input")).click();

				}
			}
		}
		// OR
		for (int i = 0; i < rows.size(); i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			for (int j = 1; j <= cols.size(); j++) {
				String celdata = driver
						.findElement(By.xpath("//table[@id='table01']/tbody/tr[" + (i + 1) + "]/td[" + j + "]"))
						.getText();
				System.out.println(celdata);
				if (celdata.equals("QTP")) {
					cols.get(0).findElement(By.tagName("input")).click();
					cols.get(4).findElement(By.tagName("input")).click();
				}
			}
		}
		Thread.sleep(2000);

		driver.quit();

	}

}
