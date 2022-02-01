package testCases;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.DriverSetup;


public class TC_003_Checkbox_Sample extends DriverSetup {
	public static String baseurl = "https://qavbox.github.io/demo/signup/";
	
	@Test
	public  void checkbox() throws InterruptedException {
		
		driver.get(baseurl);
		Thread.sleep(3000);
		List<WebElement> checkboxes = driver.findElements(By.name("language"));
		/*
		if (checkboxes.size()==5) {
			System.out.println("test passed");
		}*/
		for(WebElement btn : checkboxes) {
			//System.out.println(btn.getAttribute("value"));
			if (btn.getAttribute("value").equals("Selenium")) {
				btn.click();
				
				//Assert.assertTrue(btn.isSelected());
				
				//System.out.println("selected? - " + btn.isSelected());
				//System.out.println("checked? - " + btn.getAttribute("checked"));
				//btn.click();
				//break;
				
			}
			//Assert.assertFalse(btn.isSelected());
			//System.out.println("selected? - " + btn.isSelected());
		}
		
		System.out.println(itemSelecteStatus("TestingBasics")); 
		//Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		Thread.sleep(2000);
		
		
	}
	
	public Boolean itemSelecteStatus(String visibleText) {
		List<WebElement> listItems =  driver.findElements(By.name("language"));
		//Boolean bl = false;
		for(WebElement item : listItems) {
			//System.out.println(item.getText());
			
			if(item.getAttribute("value").equals(visibleText)) {
				return item.isSelected();	
				//System.out.println("hkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
			}
		}
		return false;
	}
}
