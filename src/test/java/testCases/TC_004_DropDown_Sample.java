package testCases;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_004_DropDown_Sample extends DriverSetup {
	public static String baseurl = "https://qavbox.github.io/demo/signup/";

	@Test
	public static void dropDown() throws InterruptedException {

		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement el = driver.findElement(By.xpath("//select[@name='sgender']"));
		
		Select selectItems = new Select(el);
		List<WebElement> options = selectItems.getOptions();
		
		System.err.println("Total number of Dropdown options - " + options.size());
		
		for(WebElement option : options) {
			if (option.getAttribute("value").equals("female") ) {
				option.click();
				System.out.println("Now Cond. Selected option is  - " + selectItems.getFirstSelectedOption().getText());	
			}
			
		}
		
		selectItems.selectByIndex(0);
		System.out.println("Now Selected option is  - " + selectItems.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		selectItems.selectByValue("male");
		System.out.println("Now Selected option is  - " + selectItems.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		selectItems.selectByVisibleText("Not Applicable");
		System.out.println("Now Selected option is  - " + selectItems.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		

	}

}
