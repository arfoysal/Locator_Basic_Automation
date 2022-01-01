package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_008_daraz extends DriverSetup {
	public static String baseurl = "https://www.daraz.com.bd";

	@Test
	public static void darazCopleteOrder() throws InterruptedException {

		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		String pagetitle = "Online Shopping in Bangladesh: Order Now from Daraz.com.bd";
		String actualTitle = driver.getTitle();

		Assert.assertEquals(pagetitle, actualTitle);
		//be friend shadowDomPopUp
		WebElement shadowDomHostElement = driver.findElement(By.cssSelector(".airship-html-prompt-shadow"));
		// Finding the ShadowRoot in a WebElement 
		SearchContext context = shadowDomHostElement.getShadowRoot();
		// finding the targeted element
		context.findElement(By.cssSelector(".airship-btn.airship-btn-deny")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(repoDaraz_xpath.selElectAcce)).click();
		Thread.sleep(1000);

		// Hover
		WebElement hover = driver.findElement(By.xpath(repoDaraz_xpath.selCompAcce));

		Actions action = new Actions(driver);
		action.clickAndHold(hover).build().perform();
		

		driver.findElement(By.xpath(repoDaraz_xpath.selPowCordAdap)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(repoDaraz_xpath.selFistItems)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(repoDaraz_xpath.selBuyNow)).click();
		Thread.sleep(2000);
		// Iframe
		WebElement loginfram = driver.findElement(By.xpath(repoDaraz_xpath.loginIfram));
		driver.switchTo().frame(loginfram);

		driver.findElement(By.xpath(repoDaraz_xpath.selPhoneEmail))
				.sendKeys(repoDaraz_xpath.phoneNumber);
		driver.findElement(By.xpath(repoDaraz_xpath.selPass)).sendKeys(repoDaraz_xpath.pass);
		Thread.sleep(2000);
		driver.findElement(By.xpath(repoDaraz_xpath.loginSubmit)).click();
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(repoDaraz_xpath.selPayOp)).click();
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath(repoDaraz_xpath.selCOD)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(repoDaraz_xpath.selConfOrd)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(repoDaraz_xpath.selBacktoNorm)).click();
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {
			System.out.println("Daraz AI may blocked your automation");
		}
		
		driver.findElement(By.xpath(repoDaraz_xpath.selUserManu)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(repoDaraz_xpath.selLogOut)).click();
		Thread.sleep(5000);
		
	}

}
