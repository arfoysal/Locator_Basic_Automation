package testCases;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_003_Checkbox_Sample extends DriverSetup {
	public static String baseurl = "https://qavbox.github.io/demo/signup/";
	
	@Test
	public static void checkbox() throws InterruptedException {
		
		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		List<WebElement> checkboxes = driver.findElements(By.name("language"));
		if (checkboxes.size()==5) {
			System.out.println("test passed");
		}
		for(WebElement btn : checkboxes) {
			System.out.println(btn.getAttribute("value"));
			if (btn.getAttribute("value").equals("Selenium")) {
				btn.click();
				System.out.println("selected? - " + btn.isSelected());
				System.out.println("checked? - " + btn.getAttribute("checked"));
				//break;
				
			}
		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		Thread.sleep(2000);
		
		
		
		
		
		
	}
	

}
