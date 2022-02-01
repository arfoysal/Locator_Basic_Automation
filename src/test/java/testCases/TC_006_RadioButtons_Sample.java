package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_006_RadioButtons_Sample extends DriverSetup {
	public static String baseurl = "https://qavbox.github.io/demo/signup/";
	
	@Test
	public static void radioButtons() throws InterruptedException {
		
		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		List<WebElement> radioBtns = driver.findElements(By.name("experience"));
		if (radioBtns.size()==8) {
			System.out.println("test passed");
		}
		for(WebElement btn : radioBtns) {
			System.out.println(btn.getAttribute("value"));
			if (btn.getAttribute("value").equals("four")) {
				btn.click();
				System.out.println("selected? - " + btn.isSelected());
				System.out.println("checked? - " + btn.getAttribute("checked"));
				break;
				
			}
		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='seven']")).click();
		
		Thread.sleep(2000);
		
		
		
		
		
		
	}
	

}
