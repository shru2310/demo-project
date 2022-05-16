package facebook.login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utility.CaptureScreenshot;
import utility.CommonActions;

public class FBLoginAndPost extends CommonActions {

	public FBLoginAndPost() throws Throwable {
		super();
	}

	static WebElement email, password, loginButton, notNowButton, writeSomething_inputArea, status;

	public void navigate(WebDriver driver) throws Throwable {
		try {

			CommonActions.driver = driver;
			
			prop.load(ip);
			driver.get(prop.getProperty("urlfb"));
			CaptureScreenshot.screenShot(driver, "facebook");
			Reporter.log("Launched facebook application");

			LoginAndPostPage loginAndPostPage = PageFactory.initElements(driver, LoginAndPostPage.class);

			email = loginAndPostPage.login_Email_input;
			password = loginAndPostPage.login_pw_input;
			loginButton=loginAndPostPage.login_button;
			
			prop.load(ip);
			String em =prop.getProperty("emailfb");
			String pw =prop.getProperty("passwordfb");
			sendKeys(email, "facebook",em );
			Reporter.log("Email is entered");
			sendKeys(password, "facebook",pw );
			Reporter.log("Password is entered");
			
			click(loginButton, "facebook");
			Reporter.log("Login button is clicked");

			notNowButton = loginAndPostPage.notNow_button;

			click(notNowButton, "facebook");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void post(WebDriver driver) throws Throwable {

		CommonActions.driver = driver;
		LoginAndPostPage loginAndPostPage = PageFactory.initElements(driver, LoginAndPostPage.class);
		writeSomething_inputArea = loginAndPostPage.writeSomething_input;
		click(writeSomething_inputArea, "facebook");

		List<WebElement> OKbutton = driver.findElements(By.xpath("//button[@type='submit' and @value='OK']"));

		for (WebElement OKButton : OKbutton) {
			if (OKButton.isDisplayed()) {
				click(OKButton, "facebook");
			} else
				try {
					{
						click(loginAndPostPage.cancel_button, "facebook");
						click(OKButton, "facebook");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

		status = loginAndPostPage.postStatus_input;
		click(status, "facebook");
		sendKeys(status, "facebook", "Hello World");
		Reporter.log("status is entered");

		status.sendKeys(Keys.TAB);
		List<WebElement> PostButton = driver.findElements(By.xpath("//button[@type='submit' and @value='Post']"));

		for (WebElement post : PostButton) {
			if (post.isDisplayed()) {
				click(post, "facebook");
			}
		}
		Reporter.log("status is posted");
		loginAndPostPage.updatedStory_text.getText().equals("Hello World");
		CaptureScreenshot.screenShot(driver, "facebook");
		Reporter.log("status is displayed");

	}
}
