package jsexec;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class Scroll_webpage extends DriverSetup {
	WebDriverWait wait;
	public static String baseurl = "https://www.rokomari.com/book";
	@Test
	public void scrollWebpage() throws InterruptedException {
		
		driver.get(baseurl);
		driver.manage().window();
		//Thread.sleep(2000);
		// window, arguments[0].scrollIntoView(true), document.
		waitForPageLoad();
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window,scrollBy(0, 200)");
		
		//WebElement el= driver.findElement(By.xpath("//span[normalize-space()='Pay cash on delivery']"));
		By el = By.xpath("//span[normalize-space()='Pay cash on delivery']");
		scorllToElement(el);
		
		//js.executeScript("arguments[0].scrollIntoView(true);", el);
		//js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
		
		//Actions action =  new Actions(driver);
		//action.moveToElement(el).perform();
		
		Thread.sleep(2000);
		//WebElement elup= driver.findElement(By.cssSelector(".user-selection__title"));
		By elup = By.cssSelector(".user-selection__title");
		scorllToElement(elup);
		//js.executeScript("arguments[0].scrollIntoView(true);", elup);
		Thread.sleep(2000);
	}
	public void waitForPageLoad() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// for using lambda expression > set build path library> JRE system Library 1.8 or above
		wait.until((ExpectedCondition<Boolean>) wd -> 
				((JavascriptExecutor) wd ).executeScript("return document.readyState;")
				.equals("complete"));
	}
	public void scorllToElement(By element) {
		WebElement el = driver.findElement(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", el);
	}
}