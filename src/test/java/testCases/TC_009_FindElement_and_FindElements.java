package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import basePackage.DriverSetup;

public class TC_009_FindElement_and_FindElements extends DriverSetup {
	public static String baseurl = "https://qavbox.github.io/demo/signup/";

	@Test
	public static void FindElEls() throws InterruptedException {

		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);

		List<WebElement> textBoxes = driver.findElements(By.cssSelector("input[type='text'"));
		if (textBoxes.size() == 4) {
			System.out.println("passed");
			
		}
		
		for(WebElement textBox : textBoxes) {
			System.out.println(textBox.getAttribute("id"));
			if (textBox.getAttribute("id").equals("email")) {
				textBox.sendKeys("kadas@ggan.sdf");
				Thread.sleep(2000);
			}
		}
		
		List<WebElement> listItems = driver.findElements(By.className("ui-widget-content"));
		
		for(WebElement item : listItems) {
			System.out.println(item.getText());
			if (item.getText().equals("TelerikStudio")) {
				System.out.println("testcase passd");
				
			}
		}
		

	}

}
