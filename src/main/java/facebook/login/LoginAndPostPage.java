package facebook.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.CommonActions;

public class LoginAndPostPage extends CommonActions {

	WebDriver driver;

	public LoginAndPostPage(WebDriver driver) throws Throwable {
		this.driver = driver;
	}

	@FindBy(id = "m_login_email")
	public WebElement login_Email_input;

	@FindBy(id = "m_login_password")
	public WebElement login_pw_input;

	@FindBy(name = "login")
	public WebElement login_button;

	@FindBy(xpath = "//span[contains(text(),'Not Now')]/parent::*")
	public WebElement notNow_button;

	@FindBy(xpath = "//div[contains(text(),'Write something here')]")
	public WebElement writeSomething_input;

	@FindBy(xpath = "//button[@type='submit' and @value='Cancel' and not(@aria-hidden='true')]")
	public WebElement cancel_button;

	@FindBy(xpath = "//textarea[@class='composerInput mentions-input']")
	public WebElement postStatus_input;

	@FindBy(xpath = "//a[contains(text(),'Shruti')]//ancestor::div[@class='story_body_container']/div//span")
	public WebElement updatedStory_text;

}
