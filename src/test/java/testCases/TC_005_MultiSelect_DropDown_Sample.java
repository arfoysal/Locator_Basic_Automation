package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_005_MultiSelect_DropDown_Sample extends DriverSetup {
	public static String baseurl = "https://qavbox.github.io/demo/signup/";

	@Test
	public static void multiSelectDropDown() throws InterruptedException {

		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement el = driver.findElement(By.xpath("//select[@id='tools']"));
		
		Select selectItems = new Select(el);
		
		List<WebElement> options = selectItems.getOptions();
		
		System.err.println("Total number of Dropdown options - " + options.size());
		
		for(WebElement option : options) {
			if (option.getAttribute("value").equals("codedui") ) {
				option.click();
			}	
		}
		
		selectItems.selectByIndex(1);
		Thread.sleep(2000);
		selectItems.selectByValue("qtp");
		Thread.sleep(2000);
		selectItems.selectByVisibleText("JMeter");
		Thread.sleep(2000);
		
		List<WebElement> selectedItems = selectItems.getAllSelectedOptions();
		
		for(WebElement itemSelected : selectedItems) {
			System.out.println(itemSelected.getText());
		}
		
	}

}
