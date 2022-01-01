package seleniumExceptions;

import org.testng.annotations.Test;

import basePackage.DriverSetup;

public class TC_01_ExceptionTest extends DriverSetup {
	public static String baseurl = "https://qavbox.github.io/demo/signup/";

	@Test
	public static void exceptionTest() throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		/*
		rise NoSuchElementException
		driver.findElement(By.id("username1")).sendKeys("hello username");
		*/
	    /*
		//NoAlertPresentException
		driver.findElement(By.name("home")).click();
		try {
			
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			System.out.println("No alert");
			
		}
		driver.findElement(By.linkText("SignUp Form")).click();
		*/
		/*
		// NoSuchFrameException
		driver.findElement(By.name("home")).click();
		driver.findElement(By.linkText("iFrames")).click();
		driver.switchTo().frame("Frame3");
		*/
		/*
		//TimeoutException
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.id("username1")));
		driver.findElement(By.id("username")).sendKeys("hi");
		*/
		
		Thread.sleep(2000);

		driver.quit();

	}

}
