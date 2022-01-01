package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	public static WebDriver driver;

	@BeforeSuite
	public static void setDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterSuite
	public static void close() {
		driver.quit();

	}

}
