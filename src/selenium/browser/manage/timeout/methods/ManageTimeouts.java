package selenium.browser.manage.timeout.methods;

import java.time.Duration;

import org.openqa.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ManageTimeouts {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// set the key value pair of information about where the browser driver is
		// located in jvm and selenium java code will fetch this browser driver
		// internally

		// =========================================================================================

		System.setProperty("webdriver.gecko.driver", "C:\\BrowserDrivers\\FireFoxDriver\\geckodriver.exe");

		// =========================================================================================

		// set actual browser binary
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

		// =========================================================================================

		// open firefox browser here
		FirefoxDriver driver = new FirefoxDriver(options);

		// =========================================================================================

		// set page load timeout (page load time we will set here)
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		// =========================================================================================

		// set implicit timeout (global timeout/common timeout for each web element)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// =========================================================================================

		// delete all cookies for the test
		driver.manage().deleteAllCookies();

		// =========================================================================================

		driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(20));
		// only to execute async javascript code within script
		// this time out is applicable only to async javascript code within script
		// this time out is not an global timeout for entire script

		// Open a web page
		driver.get("https://www.example.com");

		try {
			// Execute an asynchronous script with a promise
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String script = "var callback = arguments[arguments.length - 1];"
					+ "setTimeout(function(){ callback('Script executed'); }, 15000);"; // 15 seconds
			String result = (String) jsExecutor.executeAsyncScript(script);
			System.out.println("Script result: " + result);
		} catch (TimeoutException e) {
			System.err.println("Script execution timed out!");
		}
		// =========================================================================================

		driver.quit();
	}

}
