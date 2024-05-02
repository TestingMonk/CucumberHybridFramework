package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementutils;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);  // used to intialize webelements
		
		
		elementutils = new ElementUtils(driver);
		
	}
	
	@FindBy(xpath="//span[text() ='My Account']")
	private WebElement myAccountDropDown;
	
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
	@FindBy(name="search")
    private WebElement searchbox;	
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	
	public void clickonMyAccount() {
		
		elementutils.clickOnElement(myAccountDropDown, 15);  // generalized approach using waiting mechanism
	}
	
	public void selectLoginOption() {
		
	   elementutils.clickOnElement(loginOption,15);
	}
	
	public void selectRegisterOption() {
		
		RegisterOption.click();
	}
	
	public void searchBoxField(String product) {
		
		elementutils.typeTextIntoElement(searchbox, product, 30);
		
		
	}
	
	public void searchButtonClick() {
		
		searchButton.click();
	}

}
