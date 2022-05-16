package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass extends BrowserFactory {

	public WebDriver driver;
	public static String[] ScreenshotNames = new String[100];
	public static Properties prop;
	public static FileInputStream ip;
	
	public BaseClass() throws Throwable {
	prop = new Properties();
	ip = new FileInputStream(
			"C:\\Users\\shruti.shendge\\eclipse-workspace\\WalletHub\\demo-project\\src\\main\\java\\utility\\config.properties");

	}

	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {

		prop.load(ip);

		driver = startBrowser(prop.getProperty("browser"));

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void tearDown() throws Throwable {

		driver.quit();

	}

}
