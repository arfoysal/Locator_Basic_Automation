package testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_012_Handle_iframe extends DriverSetup {
	public static String baseurl = "https://qavbox.github.io/demo/iframes/";

	@Test
	public static void hendleIframe() throws InterruptedException, IOException {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));;
		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		
		driver.switchTo().frame("Frame1");
		//there ways to to switch to a frame 
		//driver.switchTo().frame(0); //frame index as a attribute
		//driver.switchTo().frame("nameOrID"); //name or id value as a attribute.
		//driver.switchTo().frame("WebElement findElement"); //exact locators as a attribute.
		String text = driver.findElement(By.xpath("//p[@id='frametext']")).getText();
		System.out.println(text);
		System.out.println(driver.findElements(By.tagName("a")).size());
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		
		
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//input[@id='frameinput']")).sendKeys("Jannah");
		
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//a[contains(text(),'Pavilion')]")).click();
		Thread.sleep(2000);
	}

}
