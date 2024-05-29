package demo.qa.automation.elements;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

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
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class DemoQAElementsLinks {

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
		// TODO Auto-generated method stub
		// selenium browser driver
		System.setProperty("webdriver.chrome.driver", "C:\\\\BrowserDrivers\\\\ChromeDriver\\\\chromedriver.exe");

		// actual browser binary or actual path of browser installed in your system
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\BrowserBinaries\\chrome-win64\\chrome.exe");

		// invoke the browser, or open the browser
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
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(255));

		// get some test url opened in address bar
		driver.get("https://demoqa.com/");

		// scroll on page bottom and scroll on page top only for test scrolling
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");

		Thread.sleep(2000);

		// scroll to top
		js.executeScript("window.scrollTo(0,0);");

		// ---------------------------------------------------------------
		// get the title of the web page
		System.out.println("title of web page : " + driver.getTitle());
		// ---------------------------------------------------------------

		// get the url of the web page
		System.out.println("url of web page : " + driver.getCurrentUrl());
		// ---------------------------------------------------------------

		// get all the elements of category cards
		List<WebElement> categoriesDemoQA = driver.findElements(By.xpath("//div[@class='category-cards']/div"));

		System.out.println("======================================================================================");
		// ---------------------------------------------------------------

		// let us click on CheckBox
		js.executeScript("arguments[0].scrollIntoView(true);", categoriesDemoQA.get(0));
		categoriesDemoQA.get(0).click();
		Thread.sleep(2000);
		// ---------------------------------------------------------------

		// let us click on button 'Buttons' on Elements web page
		WebElement element = driver
				.findElement(By.xpath("//li[contains(@class, 'btn') and contains(span, 'Buttons')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(2000);

		// let us click on button "double click"
		element = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
		Thread.sleep(5000);
		System.out.println("clicked : " + driver.findElement(By.cssSelector("[id='doubleClickMessage']")).getText());

		// let us click on button "right click"
		element = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		actions.contextClick(element).perform();
		Thread.sleep(5000);
		System.out.println("clicked : " + driver.findElement(By.cssSelector("[id='rightClickMessage']")).getText());
		// ---------------------------------------------------------------

		// let us click on button "single click"
		element = driver.findElement(By.xpath("//button[text()='Click Me']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		actions.click(element).perform();
		element.click();
		Thread.sleep(5000);
		System.out.println("clicked : " + driver.findElement(By.cssSelector("[id='dynamicClickMessage']")).getText());
		// ---------------------------------------------------------------

		System.out.println("======================================================================================");
		driver.quit();
	}
}
