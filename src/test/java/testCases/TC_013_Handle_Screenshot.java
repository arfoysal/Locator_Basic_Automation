package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_013_Handle_Screenshot extends DriverSetup {
	public static String baseurl = "https://qavbox.github.io/demo/iframes/";

	@Test
	public void screenshotTaken() throws InterruptedException, IOException {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));;
		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		screenshot("Home");
		
		driver.switchTo().frame(1);
		WebElement result = driver.findElement(By.xpath("//input[@id='frameinput']"));
		result.sendKeys("janhaa");
		Thread.sleep(2000);
		screenshot("After input", result);
		Thread.sleep(2000);
		screenshot("Final");
		
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
	}
	
	public void screenshot(String name) throws IOException {
		String strtime = setdate();
		File scFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scFile,new File("./image/"+strtime+name+".png"));
	}
	public void screenshot(String name, WebElement element) throws IOException {
		String strtime = setdate();
		File scFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scFile,new File("./image/"+strtime+name+".png"));
	}
	
	public String setdate() {
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyymmdd_HHmmss");
		String strdate = formatter.format(date);
		return strdate;
	}
}
