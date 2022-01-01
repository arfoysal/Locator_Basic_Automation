package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_002_Buttons_Sample extends DriverSetup {
	public static String baseurl = "https://qavbox.github.io/demo/signup/";
	
	@Test
	public static void buttons() throws InterruptedException {
		
		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement elButtens = driver.findElement(By.name("home"));
		String actualStr = elButtens.getAttribute("value");
		
		if (actualStr.equals("Home")) {
			System.out.println("test case passed");
			
		}
		elButtens.click();
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(2000);
		/*
		//count same elements
		List<WebElement> buttons = driver.findElements(By.name("home"));
		System.out.println(buttons.size());
		*/
		
		
		
		
		
		
		
		
		
	}
	

}
