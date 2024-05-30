package demo.qa.automation.widgets.autocomplete;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Test {

	public static void takeScreenShot(String destFilePath, WebDriver driver) {
		// Take screenshot and save it to a file
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destinationFilePath = new File(destFilePath);

		try {
			// Copy the source file to the destination file
			Files.copy(screenshotFile, destinationFilePath);
			// System.out.println("File copied successfully at path " +
			// destinationFilePath.getPath());
		} catch (IOException e) {
			System.out.println("Error occurred while copying the file: " + e.getMessage());
		}
	}

	public static void main(String[] args) throws InterruptedException, IOException, WebDriverException {
		// set browser driver for JVM and compiler (browser driver exe path)
		// this is path of browser driver
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\ChromeDriver\\chromedriver.exe");

		// set the browser binary - which is actual browser application
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\BrowserBinaries\\chrome-win64\\chrome.exe");

		// open/invoke the browser
		WebDriver driver = new ChromeDriver(options);

		// set window size
		driver.manage().window().setSize(new Dimension(1367, 788));

		// set max size of the window
		driver.manage().window().maximize();

		// set implicitly timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

		// delete all cookies
		driver.manage().deleteAllCookies();

		// set page load timeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));

		// get some test url opened in address bar
		driver.get("https://demoqa.com/auto-complete");

		// create javascript executor as object
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// ---------------------------------------------------------------
		// get the title of the web page
		System.out.println("title of web page : " + driver.getTitle());
		// ---------------------------------------------------------------

		// get the url of the web page
		System.out.println("url of web page : " + driver.getCurrentUrl());
		// ---------------------------------------------------------------

		System.out.println("modal dialogue short : ");

		// button click to open modal 1
		WebElement element = driver.findElement(By.cssSelector("input[id=\"autoCompleteMultipleInput\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("red");

		// id="react-select-2-option-0"

		int optionIndex = 0; // Replace this with your desired integer
		String cssSelector = String.format("[id=\"react-select-2-option-%d\"]", optionIndex);
		element = driver.findElement(By.cssSelector(cssSelector));
		element.click();

		// enter g and select second auto option
		element = driver.findElement(By.cssSelector("input[id=\"autoCompleteMultipleInput\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("g");

		// id="react-select-2-option-1"

		optionIndex = 1; // Replace this with your desired integer
		cssSelector = String.format("[id=\"react-select-2-option-%d\"]", optionIndex);
		element = driver.findElement(By.cssSelector(cssSelector));
		element.click();

		Thread.sleep(4000);

		System.out.println("======================================================================================");

		driver.quit();
	}
}
