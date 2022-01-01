package testCases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_011_Handle_Browser_Alerts extends DriverSetup {
	public static String baseurl = "https://qavbox.github.io/demo/alerts/";
	@Test
	public void handleAlert() throws InterruptedException {
		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//simple alert
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		accept();
		driver.findElement(By.xpath("//input[@id='confirm']")).click();
		dismiss();
		driver.findElement(By.xpath("//input[@id='prompt']")).click();
		accept("huha");
		//Thread.sleep(2000);	
		//Alert alert = driver.switchTo().alert();
		/*
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	
		Thread.sleep(2000);
		
		//confirm with yes or no
		
		alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		Thread.sleep(2000);
		String responseText = "You pressed OK!";
		String actuResponseText = driver.findElement(By.xpath("//p[@id='Parademo']")).getText();
		assertEquals(actuResponseText, responseText);
		Thread.sleep(2000);
		
		//Alert with input filed 
		driver.findElement(By.xpath("//input[@id='prompt']")).click();
		alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("ha he ho!");
		Thread.sleep(2000); 
		alert.accept();
		Thread.sleep(2000);
		responseText = "Hello ha he ho!! How are you today?";
		actuResponseText = driver.findElement(By.xpath("//p[@id='Parademo']")).getText();
		assertEquals(actuResponseText, responseText);
		*/
		Thread.sleep(3000);


		driver.quit();
		
	}
	public void accept() {
		Alert alert = alertWait();
		alert.accept();

	}
	public void accept(String value) {
		Alert alert = alertWait();
		alert.sendKeys(value);
		alert.accept();

	}
	public void dismiss() {
		Alert alert = alertWait();
		alert.dismiss();

	}
	
	public Alert alertWait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}
	
	

}
