package selenium.browser.locators;

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

import com.google.common.io.Files;

public class DemoQAElementsCategory {

	public static void takeScreenShot(String destFilePath, WebDriver driver) {
		// Take screenshot and save it to a file
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destinationFilePath = new File(destFilePath);

		try {
			// Copy the source file to the destination file
			Files.copy(screenshotFile, destinationFilePath);
			//System.out.println("File copied successfully at path " + destinationFilePath.getPath());
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

		//---------------------------------------------------------------
		// get the title of the web page
		System.out.println("title of web page : " + driver.getTitle());
		//---------------------------------------------------------------

		// get the url of the web page
		System.out.println("url of web page : " + driver.getCurrentUrl());
		//---------------------------------------------------------------

		// get all the elements of category cards
		List<WebElement> categoriesDemoQA = driver.findElements(By.xpath("//div[@class='category-cards']/div"));
		
		System.out.println("======================================================================================");
		//---------------------------------------------------------------

		js.executeScript("arguments[0].scrollIntoView(true);", categoriesDemoQA.get(0));
		categoriesDemoQA.get(0).click();
		Thread.sleep(2000);
		takeScreenShot("C:\\Users\\mahesh shelke\\Downloads\\screenshotTesting\\Elements\\TextBox\\x1.png", driver);
		Thread.sleep(2000);
		//---------------------------------------------------------------

		// let us click on Text box button on Elements web page
		WebElement ElementsPageTextBoxButton = driver
				.findElement(By.xpath("//li[contains(@class, 'btn') and contains(span, 'Text Box')]"));
		ElementsPageTextBoxButton.click();
		Thread.sleep(2000);
		takeScreenShot("C:\\Users\\mahesh shelke\\Downloads\\screenshotTesting\\Elements\\TextBox\\x2.png", driver);
		//---------------------------------------------------------------

		// let us username in textbox section
		WebElement username = driver.findElement(By.cssSelector("[id='userName']"));
		js.executeScript("arguments[0].scrollIntoView(true)", username);
		username.sendKeys("Anand Rajaram Jadhav");
		Thread.sleep(2000);
		takeScreenShot("C:\\Users\\mahesh shelke\\Downloads\\screenshotTesting\\Elements\\TextBox\\x3.png", driver);
		//---------------------------------------------------------------

		// let us email in email section
		WebElement email = driver.findElement(By.cssSelector("#userEmail"));
		js.executeScript("arguments[0].scrollIntoView(true)", email);
		email.sendKeys("xyz@gmail.com");
		Thread.sleep(2000);
		takeScreenShot("C:\\Users\\mahesh shelke\\Downloads\\screenshotTesting\\Elements\\TextBox\\x4.png", driver);
		//---------------------------------------------------------------

		// let us current_address in email section
		WebElement current_address = driver.findElement(By.cssSelector("[id='currentAddress'][class='form-control']"));
		js.executeScript("arguments[0].scrollIntoView(true)", current_address);
		current_address.sendKeys("1234 Elm Street, Apt 56, Springfield, IL 62704, USA");
		Thread.sleep(2000);
		takeScreenShot("C:\\Users\\mahesh shelke\\Downloads\\screenshotTesting\\Elements\\TextBox\\x5.png", driver);
		//---------------------------------------------------------------

		// let us perm_address in email section
		WebElement perm_address = driver.findElement(By.cssSelector("[id='permanentAddress'][class='form-control']"));
		js.executeScript("arguments[0].scrollIntoView(true)", perm_address);
		perm_address.sendKeys("1234 Elm Street, Apt 56, Springfield, IL 62704, USA");
		Thread.sleep(2000);
		takeScreenShot("C:\\Users\\mahesh shelke\\Downloads\\screenshotTesting\\Elements\\TextBox\\x6.png", driver);
		//---------------------------------------------------------------

		// let us click on Submit button
		WebElement submit_button = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		js.executeScript("arguments[0].scrollIntoView(true)", submit_button);
		submit_button.click();
		Thread.sleep(2000);
		takeScreenShot("C:\\Users\\mahesh shelke\\Downloads\\screenshotTesting\\Elements\\TextBox\\x7.png", driver);
		//---------------------------------------------------------------

		// let us take output content at console
		WebElement output_content = driver.findElement(By.xpath("//div[@id=\"output\"]"));
		js.executeScript("arguments[0].scrollIntoView(true)", output_content);
		String outputContent = output_content.getText();
		Thread.sleep(2000);
		takeScreenShot("C:\\Users\\mahesh shelke\\Downloads\\screenshotTesting\\Elements\\TextBox\\x8.png", driver);
		//---------------------------------------------------------------
		System.out.println(outputContent);
		//---------------------------------------------------------------
		
		
		System.out.println("======================================================================================");
		driver.quit();
	}
}
