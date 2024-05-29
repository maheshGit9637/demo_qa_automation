package selenium.locators.examples;

import java.time.Duration;

import org.openqa.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumLocatorsExamples {

	public static void main(String[] args) {

		// set browser driver
		System.setProperty("webdriver.chrome.driver", "C:\\\\BrowserDrivers\\\\ChromeDriver\\\\chromedriver.exe");

		// set browser binary
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\\\BrowserBinaries\\\\chrome-win64\\\\chrome.exe");

		// open browser
		WebDriver driver = new ChromeDriver(options);

		// set page load timeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

		// set implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// get test url
		driver.get("https://demoqa.com/text-box");

		// locator no 1 - by ID
		WebElement permAddressLabel = driver.findElement(By.id("permanentAddress-label"));

		// if label is the web element then we can
		System.out.println("is permAddressLabel displayed ?" + permAddressLabel.isDisplayed());
		
		//explicit wait
		
		WebDriverWait waitForPermAddressLabel = new WebDriverWait(driver, Duration.ofSeconds(5));
		waitForPermAddressLabel.until(ExpectedConditions.visibilityOf(permAddressLabel));
		

	}

}
