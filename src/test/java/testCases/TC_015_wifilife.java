package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_015_wifilife extends DriverSetup {
	public static String baseurl = "https://www.wafilife.com/shop/books/the-foolish-crocodile/";
	
	@Test
	public void shadowDom() throws InterruptedException, IOException {
		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This Element is inside single shadow DOM.
		// Finding main container.
		//driver.findElement(By.xpath("//div[@class='body-wrapper']//button[2]")).click();
		js.executeScript("return document.getElementsByClassName('single_add_to_cart_button button alt')[1].click();");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'অর্ডার সম্পন্ন করুন')]")).click();
		Thread.sleep(2000);
		

		driver.findElement(By.xpath("//*[@role='textbox']")).click();
		//driver.findElement(By.xpath("//input[@class='select2-search__field']")).clear();
		listitem("//ul[@id='select2-billing_state-results']/li", "Jamalpur");
		/*
		List<WebElement> distlist =  driver.findElements(By.xpath("//ul[@id='select2-billing_state-results']/li"));
		for(WebElement dist : distlist) {
			if(dist.getText().equals("Jamalpur")) {
				dist.click();
				break;
				
			}
		}
		*/
		Thread.sleep(2000);
		/*
		WebElement el = driver.findElement(By.xpath("//select[@id='billing_area']"));
		Select selectItems = new Select(el);
		selectItems.selectByIndex(2);
		Thread.sleep(2000);
		selectItems.selectByValue("481");
		Thread.sleep(2000);
		selectItems.selectByVisibleText("সরিষাবাড়ী");
		*/
		perfomSelecttag("//select[@id='billing_area']","সরিষাবাড়ী" );
		Thread.sleep(5000);
		
		
	}
	public void perfomSelecttag(String path, String text) {
		WebElement el = driver.findElement(By.xpath(path));
		Select selectItems = new Select(el);
		selectItems.selectByVisibleText(text);
		
	}
	public void listitem(String path, String text) {
		List<WebElement> listItems =  driver.findElements(By.xpath(path));
		for(WebElement item : listItems) {
			if(item.getText().equals(text)) {
				item.click();
				break;
				
			}
		}
	}


}
