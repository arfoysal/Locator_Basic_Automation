package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_014_Handle_ShadowDom extends DriverSetup {
	public static String baseurl = "https://www.daraz.com.bd";
	
	@Test
	public static void shadowDom() throws InterruptedException, IOException {
		TC_013_Handle_Screenshot scshot = new TC_013_Handle_Screenshot();
		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		scshot.screenshot("Daraz");
		// This Element is inside single shadow DOM.
		// Finding main container.
		WebElement shadowDomHostElement = driver.findElement(By.cssSelector(".airship-html-prompt-shadow"));
		
		// Finding the ShadowRoot in a WebElement 
		SearchContext context = shadowDomHostElement.getShadowRoot();
		
		// finding the targeted element
		context.findElement(By.cssSelector(".airship-btn.airship-btn-deny")).click();
		Thread.sleep(2000);
		scshot.screenshot("Home Page");
		
		// Click on SignUp / Login
		WebElement login = driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]"));
		scshot.screenshot("login",login);
		login.click();
		Thread.sleep(5000);
		
	}

}
