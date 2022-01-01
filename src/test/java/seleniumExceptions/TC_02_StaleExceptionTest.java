package seleniumExceptions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_02_StaleExceptionTest extends DriverSetup {
	public static String baseurl = "https://qavbox.github.io/demo/signup/";

	@Test
	public static void staleexceptionTest() throws InterruptedException {
		
		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement username = driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys("hkdhsakd");
		//staleexceptionTest
		driver.navigate().refresh();
		System.out.println(username.getAttribute("value"));
		
		
		Thread.sleep(2000);

		driver.quit();

	}

}
