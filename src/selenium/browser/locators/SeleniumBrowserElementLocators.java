package selenium.browser.locators;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class SeleniumBrowserElementLocators {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// selenium browser driver
		System.setProperty("webdriver.chrome.driver", "C:\\\\BrowserDrivers\\\\ChromeDriver\\\\chromedriver.exe");

		// actual browser binary or actual path of browser installed in your system
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\BrowserBinaries\\chrome-win64\\chrome.exe");

		// invoke the browser, or open the browser
		driver = new ChromeDriver(options);

		// set window size
		driver.manage().window().setSize(new Dimension(1367, 788));

		// set max size of the window
		driver.manage().window().maximize();

		// set implicitly timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

		// delete all cookies
		driver.manage().deleteAllCookies();

		// set page load timeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));

		// get some test url opened in address bar
		driver.get("https://demoqa.com/");

		// scroll on page bottom and scroll on page top only for test scrolling
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");

		Thread.sleep(2000);

		// scroll to top
		js.executeScript("window.scrollTo(0,0);");

		System.out.println("---------------------------");
		// get the title of the web page
		System.out.println("title of web page : " + driver.getTitle());
		System.out.println("---------------------------");

		// get the url of the web page
		System.out.println("url of web page : " + driver.getCurrentUrl());
		System.out.println("---------------------------");

		// get all the elements of category cards
		List<WebElement> categoriesDemoQA = driver.findElements(By.xpath("//div[@class='category-cards']"));
		System.out.println("how many category cards are available on webpage : " + categoriesDemoQA.size());
		System.out.println("category list items : ");

		System.out.println("---------------------------");
		int i = 0;
		while (i < categoriesDemoQA.size()) {
			System.out.println(categoriesDemoQA.get(i).getText());
			i++;
		}
		System.out.println("---------------------------");

		// click on Elements category
		WebElement categoryElements = driver.findElement(By.xpath("//div[@class='category-cards']/div[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(categoryElements));

		// categoryElements.click(); - this is giving
		// org.openqa.selenium.ElementClickInterceptedException

		// so let us try to scroll to view, it means that the element we want to click
		// we are scroll so that it is clearly visible on webpage?

		// approach 01 Scroll the element into view
		js.executeScript("arguments[0].scrollIntoView(true);", categoryElements);

		Thread.sleep(5000);
		categoryElements.click();

		/*
		 * approach 02 categoryElements.click(); - this is giving it is direct click
		 * without element to be visible on webpage
		 * org.openqa.selenium.ElementClickInterceptedException or you need to click
		 * using javascript executor $x("//h5[contains(text(),'Elements')]").click();
		 */
		// js.executeScript("arguments[0].click();",categoryElements);

		System.out.println("---------------------------");

		System.out.println("page url : " + driver.getCurrentUrl());

		// now let us scroll on the new page
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);

		// scroll to top
		js.executeScript("window.scrollTo(0,0);");
		Thread.sleep(2000);

		System.out.println("---------------------------");

		// let us navigate back
		driver.navigate().back();
		System.out.println("page url : " + driver.getCurrentUrl());
		Thread.sleep(2000);

		System.out.println("---------------------------");
		// now let us navigate to second category element
		WebElement Category_Forms = driver.findElement(By.xpath("//h5[contains(text(),'Forms')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", Category_Forms);
		Category_Forms.click();
		System.out.println("category forms web page url : " + driver.getCurrentUrl());
		System.out.println("---------------------------");
		// let us scroll to bottom on this page
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);

		js.executeScript("window.scrollTo(0,0);");
		Thread.sleep(2000);

		System.out.println("---------------------------");

		// let us go back again
		driver.navigate().back();
		System.out.println("url on current page : " + driver.getCurrentUrl());

		System.out.println("---------------------------");

		// let us open next category

		WebElement category_alerts_frames_windows = driver
				.findElement(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]"));

		// lets scroll to view

		js.executeScript("arguments[0].scrollIntoView(true);", category_alerts_frames_windows);

		// lets click on this element after scrolling to view

		category_alerts_frames_windows.click();

		Thread.sleep(2000);

		System.out.println("category alerts, frames and windows web page url :" + driver.getCurrentUrl());

		// let us scroll down and up

		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");

		Thread.sleep(3000);

		js.executeScript("window.scrollTo(0,0);");

		Thread.sleep(3000);

		// let us go back

		driver.navigate().back();
		Thread.sleep(3000);

		System.out.println("base page url : " + driver.getCurrentUrl());

		Thread.sleep(3000);

		System.out.println("---------------------------");

		// let us click on category widgets

		WebElement category_widgets = driver.findElement(By.cssSelector("[class='card mt-4 top-card']:nth-child(4)"));
		// let us scroll into view for category widgets element
		js.executeScript("arguments[0].scrollIntoView(true);", category_widgets);
		// let us click on this element
		category_widgets.click();
		// let us print the url
		System.out.println("category widgets web url : " + driver.getCurrentUrl());
		// let us scroll down
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		// let us wait for 3 seconds
		Thread.sleep(3000);
		// let us scroll top
		js.executeScript("window.scrollTo(0,0);");
		Thread.sleep(3000);
		// let us go back to base page
		driver.navigate().back();
		Thread.sleep(3000);
		// let us print the base page url
		System.out.println("base page url : " + driver.getCurrentUrl());

		System.out.println("---------------------------");

		// let us click on category interactions

		WebElement category_interactions = driver.findElement(By.cssSelector("[class='card mt-4 top-card']:nth-child(5)"));
		// let us scroll into view for category widgets element
		js.executeScript("arguments[0].scrollIntoView(true);", category_interactions);
		// let us click on this element
		category_interactions.click();
		// let us print the url
		System.out.println("category interactions web url : " + driver.getCurrentUrl());
		// let us scroll down
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		// let us wait for 3 seconds
		Thread.sleep(3000);
		// let us scroll top
		js.executeScript("window.scrollTo(0,0);");
		Thread.sleep(3000);
		// let us go back to base page
		driver.navigate().back();
		Thread.sleep(3000);
		// let us print the base page url
		System.out.println("base page url : " + driver.getCurrentUrl());
		System.out.println("---------------------------");
		
		
		System.out.println("---------------------------");

		// let us click on category book store applicaiton

		WebElement category_book_store_app = driver.findElement(By.xpath("//h5[text()='Book Store Application']"));
		// let us scroll into view for category widgets element
		js.executeScript("arguments[0].scrollIntoView(true);", category_book_store_app);
		// let us click on this element
		category_book_store_app.click();
		// let us print the url
		System.out.println("category category_book_store_app web url : " + driver.getCurrentUrl());
		// let us scroll down
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		// let us wait for 3 seconds
		Thread.sleep(3000);
		// let us scroll top
		js.executeScript("window.scrollTo(0,0);");
		Thread.sleep(3000);
		// let us go back to base page
		driver.navigate().back();
		Thread.sleep(3000);
		// let us print the base page url
		System.out.println("base page url : " + driver.getCurrentUrl());
		System.out.println("---------------------------");
		
		Thread.sleep(5000);
		driver.quit();

	}

}
