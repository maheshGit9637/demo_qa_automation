package demo.qa.automation.alerts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.Set;
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
import com.google.common.io.Files;

public class BrowserAlertsHandling {

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
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(255));

		// get some test url opened in address bar
		driver.get("https://demoqa.com/browser-windows");

		// create javascript executor as object
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// ---------------------------------------------------------------
		// get the title of the web page
		System.out.println("title of web page : " + driver.getTitle());
		// ---------------------------------------------------------------

		// get the url of the web page
		System.out.println("url of web page : " + driver.getCurrentUrl());
		// ---------------------------------------------------------------

		String firstTab = driver.getWindowHandle();

		System.out.println("======================================================================================");
		// ---------------------------------------------------------------
		Thread.sleep(500);
		System.out.println("let us click on different tabs");
		WebElement element = driver.findElement(By.cssSelector("button[id=\"tabButton\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(2000);
		String secondTab = driver.getWindowHandle();
		Thread.sleep(2000);

		driver.switchTo().window(firstTab);
		Thread.sleep(2000);

		element = driver.findElement(By.cssSelector("button[id=\"windowButton\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(2000);
		String thirdTab = driver.getWindowHandle();
		Thread.sleep(4000);

		driver.switchTo().window(firstTab);
		Thread.sleep(4000);

		element = driver.findElement(By.cssSelector("button[id=\"messageWindowButton\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(2000);
		String fourthTab = driver.getWindowHandle();
		Thread.sleep(4000);

		Set<String> windows = driver.getWindowHandles();

		System.out.println("how many windows are opened expected - 4 actual - " + windows.size());

		LinkedList<String> y = new LinkedList<String>();
		Thread.sleep(2000);

		int n = 1;
		for (String i : windows) {
			driver.switchTo().window(i);
			Thread.sleep(2000);
		}

		// ---------------------------------------------------------------

		System.out.println("======================================================================================");
		driver.quit();
	}
}
