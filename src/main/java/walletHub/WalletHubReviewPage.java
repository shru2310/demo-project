package walletHub;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WalletHubReviewPage {
	
	@FindBy(xpath = "//span[@class='nav-txt' and contains(text(),'Reviews')]")
	public WebElement reviewtab;

	@FindBy(xpath = "//*[@class='dropdown-placeholder' and contains(text(),'Select')]")
	public WebElement select_dropdown;

	@FindBy(xpath = "//li[@role='option' and contains(text(),'Health Insurance')]")
	public WebElement healthInsurance_label;
	
	@FindBy(xpath = "//div[@class='android textarea-user']/textarea")
	public WebElement textArea_input;
	
	@FindBy(xpath = "//*[contains(text(),'Submit')]")
	public WebElement submit_button;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	public WebElement login_tab;
	
	@FindBy(name="em")
	public WebElement email;
	
	@FindBy(name="pw1")
	public WebElement password;
	
	@FindBy(xpath = "//button[@class='btn blue touch-element-cl']")
	public WebElement login_button;
	
	@FindBy(xpath = "//span[contains(text(),'Your Review')]")
	public WebElement review;

}
