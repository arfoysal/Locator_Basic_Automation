package jsexec;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class Scroll_Inside_Elements extends DriverSetup {
	public static String baseurl = "https://accounts.google.com/signin/v2/identifier?hl=en&continue=https%3A%2F%2Fwww.google.com%2Fsearch%3Fclient%3Dopera%26q%3Dgma%26sourceid%3Dopera%26ie%3DUTF-8%26oe%3DUTF-8&ec=GAlAAQ&flowName=GlifWebSignIn&flowEntry=AddSession";
	@Test
	public void scrollWebpage() throws InterruptedException {
		
		driver.get(baseurl);
		driver.manage().window();
		Thread.sleep(2000);
		waitForPageLoad();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement el= driver.findElement(By.cssSelector("[jsname='d9BH4c']"));
		el.click();
		
		Thread.sleep(1000);
		js.executeScript("document.querySelector('.OA0qNb.ncFHed').scrollTop=200;");
		Thread.sleep(1000);
		js.executeScript("document.querySelector('.OA0qNb.ncFHed').scrollBy(0, 400);");
		Thread.sleep(1000);
		scorllInsideElement(".OA0qNb.ncFHed", 0, 500);
		
		Thread.sleep(2000);
	}
	public void waitForPageLoad() {
		// for using lambda expression > set build path library> JRE system Library 1.8 or above
		new WebDriverWait(driver, Duration.ofSeconds(30))
		.until((ExpectedCondition<Boolean>) wd -> 
		((JavascriptExecutor) wd ).executeScript("return document.readyState;")
		.equals("complete"));
	}
	public void scorllInsideElement(String cssLocator,int offsetX, int offsetY ) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('"+cssLocator+"').scrollBy("+offsetX+","+offsetY+");");
	}
	
}