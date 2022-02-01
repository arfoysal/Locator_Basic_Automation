package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class TC_018_Run_randomeTest {
	
	@Test
	public static void headlessTest() {
		WebDriver driver = new HtmlUnitDriver();
		
		driver.get("https://www.rokomari.com/book/author/1/humayun-ahmed?ref=mm_p0");
		String text =driver.findElement(By.xpath("(//button[@class='btn cart-btn js--add-to-cart'])[3]")).getText();
		driver.findElement(By.xpath("(//button[@class='btn cart-btn js--add-to-cart'])[3]")).click();
		System.out.println(text);
		//System.out.println("Title: "+ driver.getTitle());
		System.out.println("URL: "+driver.getCurrentUrl());
		
	}
}
