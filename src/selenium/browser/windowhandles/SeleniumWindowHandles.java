package selenium.browser.windowhandles;

import java.time.Duration;
import java.util.LinkedHashSet;

import org.openqa.*;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumWindowHandles {

	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void openURLInNewTab(String url, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('" + url + "', '_blank');");
	}

	public static void main(String[] args) {

		// this is path of browser driver
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\ChromeDriver\\chromedriver.exe");

		// set the browser binary - which is actual browser application
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\BrowserBinaries\\chrome-win64\\chrome.exe");

		// open/invoke the browser
		WebDriver driver = new ChromeDriver(options);
		sleep(2500);

		// set page load time out
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));

		// get some url
		driver.navigate().to("https://www.amazon.in/");
		sleep(2500);

		// get some more urls opened in other tabs
		openURLInNewTab("https://www.google.co.in", driver);
		sleep(2500);
		System.out.println("after opening second tab which is google still driver is pointing to first tab : "
				+ driver.getTitle());
		// get some more urls opened in other tabs
		openURLInNewTab("https://www.w3schools.com/java/default.asp", driver);
		sleep(2500);

		// get some more urls opened in other tabs
		openURLInNewTab("https://www.youtube.com/", driver);
		sleep(2500);

		LinkedHashSet<String> handles = (LinkedHashSet<String>) driver.getWindowHandles();

		System.out.println("how many tabs we got ? "+handles.size());
		String[] array = handles.toArray(new String[0]);

		driver.switchTo().window(array[0]);
		System.out.println("window title : ? " + driver.getTitle());
		sleep(2500);

		driver.switchTo().window(array[1]);
		System.out.println("window title : ? " + driver.getTitle());
		sleep(2500);

		driver.switchTo().window(array[2]);
		System.out.println("window title : ? " + driver.getTitle());
		sleep(2500);

		driver.switchTo().window(array[3]);
		System.out.println("window title : ? " + driver.getTitle());
		sleep(2500);

		// if you want to switch to specific tab of your choice

		for (String x : array) {
			driver.switchTo().window(x);
			if ((driver.getTitle()).contains("Amazon")) {
				break;
			}
		}

		System.out.println("expecting Amazon : " + driver.getTitle());

		sleep(5500);
		driver.quit();
	}

}
