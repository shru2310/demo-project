package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	public static WebDriver driver;

	public static WebDriver startBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\shruti.shendge\\eclipse-workspace\\WalletHub\\demo-project\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\shruti.shendge\\eclipse-workspace\\WalletHub\\demo-project\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("internet explorer")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\shruti.shendge\\eclipse-workspace\\WalletHub\\demo-project\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		return driver;

	}

}
