package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions extends BaseClass {
	
	
	public CommonActions() throws Throwable {
		super();
	}

	public static WebDriver driver;
	public static void sendKeys(WebElement element, String fileName, String value) throws Throwable, InterruptedException {
		
		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
		CaptureScreenshot.screenShot(driver, fileName);
		
	}
	
	public static void click(WebElement element, String fileName) throws Throwable, InterruptedException {
		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
		element.click();
		CaptureScreenshot.screenShot(driver, fileName);
	}

}
