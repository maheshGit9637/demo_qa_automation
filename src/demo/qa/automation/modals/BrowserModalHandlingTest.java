package demo.qa.automation.modals;

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

public class BrowserModalHandlingTest {

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
		driver.get("https://demoqa.com/modal-dialogs");

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
		WebElement element = driver.findElement(By.cssSelector("[id='showSmallModal']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

		// modal 1 text
		element = driver.findElement(By.cssSelector("[id=\"example-modal-sizes-title-sm\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

		// div[@class="modal-header"]/button close button icon 'x' for modal 1
		// div[@class="modal-header"]/div small modal header
		// div[@class="modal-body"] small modal content

		// get small modal body header
		element = driver.findElement(By.xpath("//div[@class=\"modal-header\"]/div"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		System.out.println("small modal header : " + element.getText());

		// get small modal body text
		element = driver.findElement(By.xpath("//div[@class=\"modal-body\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		System.out.println("small modal content : " + element.getText());

		// close the small modal
		element = driver.findElement(By.xpath("//div[@class='modal-header']/button"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		System.out.println("small modal closed : ");

		// open large modal
		element = driver.findElement(By.id("showLargeModal"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		System.out.println("large modal opened : ");

		// large modal header
		element = driver.findElement(By.id("example-modal-sizes-title-lg"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		System.out.println("large modal header : " + element.getText());

		// large modal body contentt
		element = driver.findElement(By.className("modal-body"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		System.out.println("large modal body content : " + element.getText());

		// large modal closed
		element = driver.findElement(By.id("closeLargeModal"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		System.out.println("large modal cloased : ");

		System.out.println("======================================================================================");

		driver.quit();
	}
}
