package walletHub;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import utility.CaptureScreenshot;
import utility.CommonActions;

public class WHubReview extends CommonActions {

	WebElement reviewtab, select, policyType, email, password, textArea, submitbutton, logintab, loginButton, review;

	public WHubReview() throws Throwable {
		super();
	}

	public void walletHubReview(WebDriver driver) throws Throwable {

		CommonActions.driver = driver;

		prop.load(ip);

		driver.get(prop.getProperty("urlWH"));

		WalletHubReviewPage walletHubReviewPage = PageFactory.initElements(driver, WalletHubReviewPage.class);

		reviewtab = walletHubReviewPage.reviewtab;
		click(reviewtab, "Wallethub");

		WebElement ele = driver
				.findElement(By.xpath("//*[@aria-label='4 star rating' and @role='radio' and @aria-checked='false']"));

		Actions action = new Actions(driver);

		List<WebElement> stars = driver
				.findElements(By.xpath("//div[contains(@class,'review-action')]//*[name()='svg']"));

		for (int i = 1; i < stars.size(); i++) {

			String fillBeforeHighlight = stars.get(i).getCssValue("fill");
			action.moveToElement(stars.get(i)).perform();
			List<WebElement> starsAfterHighlight = driver.findElements(
					By.xpath("//div[contains(@class,'review-action')]//*[name()='svg']/*[name()='g']/*[name()='path'][1]"));
			String fillAfterHighlight = starsAfterHighlight.get(i).getCssValue("fill");
			if(fillBeforeHighlight.equalsIgnoreCase(fillAfterHighlight)) {
				System.out.println("Star not lighting up with color");
			} else {
				System.out.println("Star are lighting up with color");
				System.out.println("Before: "+fillBeforeHighlight);
				System.out.println("Before: "+fillAfterHighlight);
			}
			
		}

		action.moveToElement(ele).perform();

		action.moveToElement(ele).click().perform();

		select = walletHubReviewPage.select_dropdown;
		policyType = walletHubReviewPage.healthInsurance_label;
		click(select, "Wallethub");
		click(policyType, "Wallethub");

		textArea = walletHubReviewPage.textArea_input;

		click(textArea, "Wallethub");
		prop.load(ip);

		String text = prop.getProperty("textWH");
		sendKeys(textArea, "Wallethub", text);

		submitbutton = walletHubReviewPage.submit_button;
		click(submitbutton, "Wallethub");

		logintab = walletHubReviewPage.login_tab;
		click(logintab, "Wallethub");

		prop.load(ip);

		String em = prop.getProperty("emailWH");
		String pw = prop.getProperty("passwordWH");

		email = walletHubReviewPage.email;
		password = walletHubReviewPage.password;

		sendKeys(email, "Wallethub", em);
		sendKeys(password, "Wallethub", pw);

		loginButton = walletHubReviewPage.login_button;
		click(loginButton, "Wallethub");

		review = walletHubReviewPage.review;

		CaptureScreenshot.screenShot(driver, "Wallethub");
		assert review.isDisplayed();
		CaptureScreenshot.screenShot(driver, "Wallethub");

	}

}
