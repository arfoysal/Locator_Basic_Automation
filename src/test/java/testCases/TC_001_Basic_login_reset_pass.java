package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_001_Basic_login_reset_pass extends DriverSetup {
	
	public static String baseUrl = "https://rahulshettyacademy.com/locatorspractice/";
	
	@Test
	public static void firstTestCaseToAutomateLogin() throws InterruptedException {
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.findElement(By.id("inputUsername")).sendKeys("Karim");
		Thread.sleep(3000);
		//driver.findElement(By.id("inputUsername")).clear();
		//Thread.sleep(3000);
		
		driver.findElement(By.name("inputPassword")).sendKeys("https://rahulshettyacademy.com");
		Thread.sleep(3000);
		
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(3000);
		
		String text = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(text);
		Thread.sleep(3000);
		
		if (text.contains("Incorrect")){
			driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
			Thread.sleep(3000);
			
			String msg = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
			int firstindex = msg.indexOf("'") + 1;
			int lastindex = msg.lastIndexOf("'");
			String pass = msg.substring(firstindex, lastindex);
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.id("inputUsername")).sendKeys("Karim");
			Thread.sleep(3000);
			
			driver.findElement(By.name("inputPassword")).sendKeys(pass);
			Thread.sleep(3000);
			
			driver.findElement(By.className("signInBtn")).click();
			Thread.sleep(10000);
			
		}
		driver.findElement(By.xpath("//button[@class='logout-btn']")).click();
		Thread.sleep(3000);
		
	
				
		
	}

}