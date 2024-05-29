package demo.qa.automation.frames;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class BrowserFramesHandlingTest {

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
		System.setProperty("webdriver.edge.driver", "C:\\BrowserDrivers\\EdgeDriver\\msedgedriver.exe");

		// set browser binary of actual browser(actual browser exe path)
		EdgeOptions options = new EdgeOptions();
		options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");

		// open browser
		EdgeDriver driver = new EdgeDriver(options);

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
		driver.get("https://demoqa.com/frames");

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

		// switch to iframe using id="frame1"

		js.executeScript("window.scrollBy(0,500);");

		driver.switchTo().frame(driver.findElement(By.id("frame1")));
		System.out.println(
				"frame1 text content : " + driver.findElement(By.cssSelector("[id=\"sampleHeading\"]")).getText());

		driver.switchTo().defaultContent();

		js.executeScript("window.scrollBy(0,-500);");

		Thread.sleep(5000);

		System.out.println(
				"content on base page : " + driver.findElement(By.xpath("//h1[@class='text-center']")).getText());

		js.executeScript("window.scrollBy(0,500);");
		// switch to iframe using id="frame2"

		driver.switchTo().frame(driver.findElement(By.id("frame2")));
		System.out.println(
				"frame1 text content : " + driver.findElement(By.cssSelector("[id=\"sampleHeading\"]")).getText());

		driver.switchTo().defaultContent();

		js.executeScript("window.scrollBy(0,-500);");

		Thread.sleep(5000);

		System.out.println(
				"content on base page : " + driver.findElement(By.xpath("//h1[@class='text-center']")).getText());

		System.out.println("======================================================================================");

		driver.quit();
	}
}
