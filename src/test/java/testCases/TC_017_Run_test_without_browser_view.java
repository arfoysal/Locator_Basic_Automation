package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class TC_017_Run_test_without_browser_view {
	
	@Test
	public static void headlessTest() {
		WebDriver driver = new HtmlUnitDriver();
		
		driver.get("https://www.google.com");
		
		System.out.println("Title: "+ driver.getTitle());
		System.out.println("URL: "+driver.getCurrentUrl());
		
	}
}
