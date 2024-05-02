package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResult {
	
	WebDriver driver;
	
	public SearchResult(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement searchproduct;
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criteria')]")
	private WebElement noProductMatching;
	
	
	public boolean searchproductDisplayed() {
		
		return searchproduct.isDisplayed();
		
	}
	
	public boolean noProductMatchingMessage() {
		
		return noProductMatching.isDisplayed();
		
	}

}
