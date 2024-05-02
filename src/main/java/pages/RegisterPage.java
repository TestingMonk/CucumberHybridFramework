package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstnameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastnameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement  privacyOption;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement  continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value=1]")
	private WebElement YesLetterOption;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;
	
	@FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailAddressWarning;
	
	@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarning;
	
	
	
	
	
	
	public void enterFirstName(String firstNameText) {
		
		firstnameField.sendKeys(firstNameText);
		
	}
	
	public void enterLastName(String lastNameText) {
		
		lastnameField.sendKeys(lastNameText);
	}
	
	public void enterEmail(String emailText) {
		
		emailField.sendKeys(emailText);
		
	}
	 
	public void enterTelephone(String telephoneText) {
		
		telephoneField.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {
		
		passwordField.sendKeys(passwordText);
		
	}
	
	public void enterPasswordConfirm(String confirmpasswordText) {
		
		passwordConfirmField.sendKeys(confirmpasswordText);
	}
	
	public void selectPrivacyOption() {
		
		privacyOption.click();
	}
	
	public void clickOnContinueButton() {

		continueButton.click();
		
	}
	
	public void selectYesLetterOption() {
		YesLetterOption.click();
	}
	
	public String warningMessageDisplayed() {
		
		
		return warningMessage.getText();
		
	}
	
	
	public String firstNameWarningMessage() {
		
		return firstNameWarning.getText();
	}
	
	public String lastNameWarningMessage() {
		
		return lastNameWarning.getText();
	}
	
	public String emailAddressWarningMessage() {
		
		return 	emailAddressWarning.getText();
	}
	
	
	public String telephoneWarningMessage() {
		
		return telephoneWarning.getText();
		
	}

	
	public String passwordWarningMessgage() {
		
		return passwordWarning.getText();
		
	}
}
