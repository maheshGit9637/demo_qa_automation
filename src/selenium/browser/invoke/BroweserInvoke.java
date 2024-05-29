package selenium.browser.invoke;

import org.openqa.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BroweserInvoke {

	public static void main(String[] args) {

		System.out.println(".................. opening chrome browser ..................");
		// ################################################################################################
		// set the System property in java JVM - lets invoke Chrome browser
		// this is path of browser driver
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\ChromeDriver\\chromedriver.exe");

		// set the browser binary - which is actual browser application
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\BrowserBinaries\\chrome-win64\\chrome.exe");

		// open/invoke the browser
		WebDriver driver = new ChromeDriver(options);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(".................. quitting chrome browser ..................");
		driver.quit();
		// ################################################################################################

		System.out.println(".................. opening firefox browser ..................");

		// set browser driver for JVM and compiler
		System.setProperty("webdriver.gecko.driver", "C:\\BrowserDrivers\\FireFoxDriver\\geckodriver.exe");

		// set browser binary for browser driver
		FirefoxOptions fireFoxOptions = new FirefoxOptions();
		fireFoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

		// open browser
		FirefoxDriver fireFoxDriver = new FirefoxDriver(fireFoxOptions);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fireFoxDriver.quit();
		System.out.println(".................. quitting firefox browser ..................");
		// ################################################################################################

		System.out.println(".................. opening edge browser ..................");

		// set browser driver
		System.setProperty("webdriver.edge.driver", "C:\\BrowserDrivers\\EdgeDriver\\msedgedriver.exe");

		// set edge options and binary
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");

		// invoke edge browser
		EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		edgeDriver.quit();
		System.out.println(".................. quitting edge browser ..................");
		// ################################################################################################
	}

}
