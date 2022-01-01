package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_007_TextBox_Sample extends DriverSetup {
	public static String baseurl = "https://qavbox.github.io/demo/signup/";
	
	@Test
	public static void textbox() throws InterruptedException {
		
		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		String name = "Jess bise";
		WebElement elname = driver.findElement(By.id("username"));
		elname.sendKeys(name);
		String actualname = elname.getAttribute("value");
		
		if (actualname.equals(name)) {
			System.out.println("Test case passed");
			
		}
		Thread.sleep(2000);
		
		elname.clear();
		actualname = elname.getAttribute("value");
		if (actualname.equals("")) {
			System.out.println("Clear Test case passed");
		}
		Thread.sleep(2000);	
		
		
	}
	

}
