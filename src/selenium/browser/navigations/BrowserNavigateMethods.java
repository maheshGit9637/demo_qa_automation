package selenium.browser.navigations;

import java.time.Duration;

import org.openqa.selenium.*;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserNavigateMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//============================================================================================================
		System.out.println("some test_ _ _ _ _ _ _ _ _ _ _ _ _");

		//============================================================================================================
		// browser driver executable
		System.setProperty("webdriver.edge.driver", "C:\\BrowserDrivers\\EdgeDriver\\msedgedriver.exe");

		//============================================================================================================
		// browser executable
		EdgeOptions options = new EdgeOptions();
		options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");

		//============================================================================================================
		// create browser session
		WebDriver driver = new EdgeDriver(options);

		//============================================================================================================
		// delete cookies
		driver.manage().deleteAllCookies();

		//============================================================================================================
		//set page load timeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//============================================================================================================
		// set implicit timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		//============================================================================================================
		// get some url opened in window
		driver.get("https://www.google.co.in");

		//============================================================================================================
		// set position of browser window on OS screen
		Point position = new Point(50, 50);
		driver.manage().window().setPosition(position);
		System.out.println("New window position: " + driver.manage().window().getPosition());

		//============================================================================================================
		// set Full HD size
		System.out.println("setting window size/resolution/dimensions as Full HD (1080p): 1555x883 : ");
		Dimension windowSizeFullHD = new Dimension(1555, 883);
		driver.manage().window().setSize(windowSizeFullHD);
		System.out.println("current window size is : " + driver.manage().window().getSize());
		Thread.sleep(5000);

		//============================================================================================================
		// navigate to some url
		driver.navigate().to("https://www.facebook.com/");
		Thread.sleep(5000);

		//============================================================================================================
		// navigate back
		driver.navigate().back();
		Thread.sleep(5000);

		//============================================================================================================
		// navigate forward
		driver.navigate().forward();
		Thread.sleep(5000);

		//============================================================================================================
		// navigate reload
		driver.navigate().refresh();
		Thread.sleep(5000);

		//============================================================================================================
		driver.quit();
	}
}