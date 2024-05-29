package selenium.browser.scrolls;

import java.time.Duration;

import org.openqa.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBrowserScrolls {

	public static void main(String[] args) throws InterruptedException {

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// maximize window/tab
		driver.manage().window().maximize();

		// get test url
		driver.get("https://www.amazon.in/");

		// Create a JavascriptExecutor instance
		JavascriptExecutor js = (JavascriptExecutor) driver;

		int i = 0;
		while (i < (Long) js.executeScript("return document.body.scrollHeight;") / 500) {

			Thread.sleep(500); // Add a delay of 100 milliseconds (adjust as needed)
			js.executeScript("window.scrollBy(0, 500);");
			i++;
		}

		Thread.sleep(5000);

		// scroll to top of any page
		js.executeScript("window.scrollTo(0, document.body.scrollTop);");

		Thread.sleep(5000);
		// scroll to bottom of any page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		Thread.sleep(5000);
		driver.quit();
	}

}
