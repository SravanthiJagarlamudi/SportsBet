package com.inetBetting.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.inetBetting.utilities.ReadConfig;

public class BrowserFactory extends BaseClass {
	private static String browserName = "";

	public static WebDriver getDefaultDriver() throws InterruptedException {
		browserName = ReadConfig.getBrowser();
		if (browserName.equalsIgnoreCase("chrome")) {
			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\jagalram\\workspace\\SportsBetting\\Drivers\\chromedriver.exe");
			// initializing driver variable using ChromeDriver
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {

		} else if (browserName.equalsIgnoreCase("firefox")) {

		} else if (browserName.equalsIgnoreCase("safari")) {

		} else if (browserName.equalsIgnoreCase("opera")) {

		} else {
			// IE
		}

		// maximized the browser window
		// driver.manage().window().maximize();

		Dimension d = new Dimension(420, 600);
		driver.manage().window().setSize(d);
		logger.info("Browser window size is set to dimension of 420*600");
	//	Thread.sleep(5000);
		// Delete All cookies
		// driver.manage().deleteAllCookies();

		// // Pageload timeout
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//
		// // Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

}
