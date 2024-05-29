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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class DemoQAElementsWebTables {

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

		// let us click on Text box button on Elements web page
		WebElement ElementsWebTables = driver
				.findElement(By.xpath("//li[contains(@class, 'btn') and contains(span, 'Web Tables')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", ElementsWebTables);
		ElementsWebTables.click();
		Thread.sleep(2000);
		// ---------------------------------------------------------------

		// we will get all the table content in console printed
		List<WebElement> headerRow = driver.findElements(By.xpath("//div[@class='rt-tr' and @role='row']/div"));

		js.executeScript("window.scrollBy(0,200)");

		int i = 0;

		while (i < headerRow.size()) {
			System.out.print(headerRow.get(i).getText() + " ");
			i++;
		}
		System.out.println();

		List<WebElement> oddRowData = driver.findElements(By.cssSelector("[class='rt-tr -odd'] [class='rt-td']"));

		i = 0;
		while (i < oddRowData.size()) {
			System.out.print(oddRowData.get(i).getText() + " ");
			if (i % 6 == 0) {
				System.out.println();
			}
			i++;
		}
		System.out.println();

		List<WebElement> evenRowData = driver.findElements(By.cssSelector("[class='rt-tr -even'] [class='rt-td']"));

		i = 0;
		while (i < evenRowData.size()) {
			System.out.print(evenRowData.get(i).getText() + " ");
			if (i % 6 == 0) {
				System.out.println();
			}
			i++;
		}

		// let us get header row by different locator

		// *[@class='ReactTable -striped -highlight']/div[1]/div[1]

		WebElement headerRowContent = driver
				.findElement(By.xpath("//*[@class='ReactTable -striped -highlight']/div[1]/div[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", headerRowContent);

		System.out.println("header row content is : ");
		System.out.println("--------");
		System.out.print(headerRowContent.getText() + " ");
		System.out.println();
		System.out.println("--------");

		// let us get header row by different locator

		// *[@class='ReactTable -striped -highlight']/div[1]/div[1]

		WebElement tableRowContent = driver
				.findElement(By.xpath("//*[@class='ReactTable -striped -highlight']/div[1]/div[2]"));
		js.executeScript("arguments[0].scrollIntoView(true);", tableRowContent);

		System.out.println("table row content is : ");
		System.out.println("--------");
		System.out.print(tableRowContent.getText() + " ");
		System.out.println();
		System.out.println("--------");

		// let us print first row of the table
		// *[@class='ReactTable -striped -highlight']/div[1]/div[2]/div[3]
		WebElement firstRowContent = driver
				.findElement(By.xpath("//*[@class='ReactTable -striped -highlight']/div[1]/div[2]/div[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", firstRowContent);

		System.out.println("table first row content is : ");
		System.out.println("--------");
		System.out.print(firstRowContent.getText() + " ");
		System.out.println();
		System.out.println("--------");

		// let us print second row of the table
		// *[@class='ReactTable -striped -highlight']/div[1]/div[2]/div[3]
		WebElement secondRowContent = driver
				.findElement(By.xpath("//*[@class='ReactTable -striped -highlight']/div[1]/div[2]/div[2]"));
		js.executeScript("arguments[0].scrollIntoView(true);", secondRowContent);

		System.out.println("table second row content is : ");
		System.out.println("--------");
		System.out.print(secondRowContent.getText() + " ");
		System.out.println();
		System.out.println("--------");

		// let us print third row of the table
		// *[@class='ReactTable -striped -highlight']/div[1]/div[2]/div[3]
		WebElement thirdRowContent = driver
				.findElement(By.xpath("//*[@class='ReactTable -striped -highlight']/div[1]/div[2]/div[3]"));
		js.executeScript("arguments[0].scrollIntoView(true);", thirdRowContent);

		System.out.println("table third row content is : ");
		System.out.println("--------");
		System.out.print(thirdRowContent.getText() + " ");
		System.out.println();
		System.out.println("--------");

		// let us add one new row in table
		WebElement addBtn = driver.findElement(By.cssSelector("button[id='addNewRecordButton']"));
		js.executeScript("arguments[0].scrollIntoView(true);", addBtn);
		addBtn.click();

		// let us fill the form for addition of row
		WebElement element = driver.findElement(By.cssSelector("[placeholder=\"First Name\"][type=\"text\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("Vinod");

		element = driver.findElement(By.cssSelector("#lastName"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("Tyagi");

		element = driver.findElement(By.id("userEmail"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("vinodTyagi@gmail.com");

		element = driver.findElement(By.xpath("//input[@placeholder=\"Age\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("30");

		element = driver.findElement(By.xpath("//input[@placeholder=\"Salary\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("71000");

		element = driver.findElement(By.xpath("//input[@type=\"text\" and @placeholder=\"Department\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("Research and Developement");

		element = driver.findElement(By.cssSelector("button[type='Submit']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

		
		// check if row data is availabel on webpage
		element = driver.findElement(By.xpath("//*[@class='ReactTable -striped -highlight']/div[1]/div[2]/div[4]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		System.out.println("table fourth row content is : ");
		System.out.println("--------");
		System.out.print(element.getText() + " ");
		System.out.println();
		System.out.println("--------");

		System.out.println("======================================================================================");
		Thread.sleep(5000);
		driver.quit();
	}
}
