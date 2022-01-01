package jsexec;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_01_JSExecTest extends DriverSetup {
	public static String baseurl = "https://qavbox.github.io/demo/signup/";

	@Test
	public void jsExecTest() throws InterruptedException {
		
		driver.get(baseurl);
		driver.manage().window();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println(js.executeScript("return document.readyState;"));
		System.out.println(js.executeScript("return document.URL;"));
		System.out.println(js.executeScript("return document.title;"));
		System.out.println(js.executeScript("return document.getElementsByName('home')[0].value;"));
		js.executeScript("return document.getElementById('username').value = 'huhi';");
		WebElement el = (WebElement)(js.executeScript("return document.getElementById('email');"));
		el.sendKeys("asddsf@gggs.com");
		Thread.sleep(2000);
		System.out.println(js.executeScript("return document.getElementById('lblname').innerText;"));
		//Highlights a elements
		/*
		WebElement telephone = driver.findElement(By.xpath("//input[@id='tel']"));
		js.executeScript("arguments[0].setAttribute('style','border:2px solid red;background: beige');", telephone);
		*/
		highlighter("//input[@id='tel']");
		Thread.sleep(2000);

		driver.quit();

	}
	public void highlighter(String path) {
		WebElement element = driver.findElement(By.xpath(path));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','border:2px solid red;background: beige');", element);
		
	}

}
