package demo.qa.automation.forms;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class DemoQAForms {

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
		// set browser driver for JVM and compiler (browser driver exe path)
		System.setProperty("webdriver.gecko.driver", "C:\\BrowserDrivers\\FireFoxDriver\\geckodriver.exe");

		// set browser binary of actual browser(actual browser exe path)
		FirefoxOptions fireFoxOptions = new FirefoxOptions();
		fireFoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

		// open browser
		FirefoxDriver driver = new FirefoxDriver(fireFoxOptions);

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
		driver.get("https://demoqa.com/automation-practice-form/");

		// create javascript executor as object
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// ---------------------------------------------------------------
		// get the title of the web page
		System.out.println("title of web page : " + driver.getTitle());
		// ---------------------------------------------------------------

		// get the url of the web page
		System.out.println("url of web page : " + driver.getCurrentUrl());
		// ---------------------------------------------------------------

		System.out.println("======================================================================================");
		// ---------------------------------------------------------------
		Thread.sleep(500);
		System.out.println("let us fill the form now");
		WebElement element = driver.findElement(By.id("firstName"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("Anand");
		Thread.sleep(500);

		element = driver.findElement(By.id("lastName"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("Jadhav");
		Thread.sleep(500);

		element = driver.findElement(By.id("userEmail"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("AnandJadhav@gmail.com");
		Thread.sleep(500);

		element = driver.findElement(By.id("gender-radio-1"));
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		element = driver.findElement(By.id("userNumber"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("9021237689");
		Thread.sleep(500);

		element = driver.findElement(By.cssSelector("input[id='dateOfBirthInput']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		element = driver.findElement(By.cssSelector("[class='react-datepicker__year-select']"));
		Select selectYear = new Select(element);
		selectYear.selectByVisibleText("1961");
		Thread.sleep(500);

		element = driver.findElement(By.cssSelector("[class='react-datepicker__month-select']"));
		Select selectMonth = new Select(element);
		selectMonth.selectByValue("6");
		Thread.sleep(500);

		int day = 10; // Day of the month you want to select single digits days to be 01,02
		element = driver.findElement(By.cssSelector(".react-datepicker__day--0" + day));
		element.click();
		Thread.sleep(500);

		element = driver.findElement(By.cssSelector("input[id=\"subjectsInput\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("m");
		Thread.sleep(500);

		element = driver.findElement(By.xpath("//div[contains(text(),'Maths')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(500);

		element = driver.findElement(By.xpath("//input[@type='checkbox' and @value='2']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		element = driver.findElement(By.xpath("//input[@type='checkbox' and @value='1']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		element = driver.findElement(By.cssSelector("#uploadPicture"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("C:\\test\\nature1.jpg");
		Thread.sleep(500);

		element = driver.findElement(By.id("currentAddress"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("Street	4191 Heather Sees Way\r\n" + "City	Tulsa\r\n" + "State/Province abbr	OK\r\n"
				+ "State/Province full	Oklahoma\r\n" + "Zip Code/Postal code	74105");
		Thread.sleep(500);

		js.executeScript("window.scrollBy(0,220);");

		element = driver.findElement(By.xpath("//div[contains(text(),'Select State')]"));
		js.executeScript("arguments[0].click();", element);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		Thread.sleep(500);

		js.executeScript("window.scrollBy(0,50);");
		String state = "NCR";
		element = driver.findElement(By.xpath("//div[contains(text(),'" + state + "')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(500);

		element = driver.findElement(By.xpath("//div[contains(text(),'Select City')]"));
		js.executeScript("arguments[0].click();", element);
		action = new Actions(driver);
		action.moveToElement(element).click().perform();
		Thread.sleep(500);

		js.executeScript("window.scrollBy(0,50);");
		String city = "Delhi";
		element = driver.findElement(By.xpath("//div[contains(text(),'" + city + "')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(500);

		js.executeScript("window.scrollBy(0,50);");
		element = driver.findElement(By.id("submit"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(500);

		// Assuming driver is already initialized
		js.executeScript("document.body.style.zoom='80%'"); // Zoom out to 90%

		takeScreenShot(
				"C:\\Eclipse\\SeleniumJavaScriptUsingSeleniumJar\\src\\demo\\qa\\automation\\screenshot\\formSubmittedSuccessfully.png",
				driver);
		Thread.sleep(500);
		// ---------------------------------------------------------------

		System.out.println("======================================================================================");
		driver.quit();
	}
}
