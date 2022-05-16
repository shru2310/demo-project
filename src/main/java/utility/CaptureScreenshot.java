package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {

	public static void screenShot(WebDriver driver, String filename)
			throws IOException, InterruptedException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = null;
		if (filename.equalsIgnoreCase("Facebook")) {
			destination = new File("C:/Users/shruti.shendge/eclipse-workspace/WalletHub/demo-project/target/ScreenShots/Facebook/screenshot_" + filename + "_" + timestamp() + ".jpeg");
		} else if (filename.equalsIgnoreCase("WalletHub")) {
			destination = new File("C:/Users/shruti.shendge/eclipse-workspace/WalletHub/demo-project/target/ScreenShots/WalletHub/screenshot_" + filename + "_" + timestamp() + ".jpeg");
		}
		FileHandler.copy(source, destination);

	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
}
