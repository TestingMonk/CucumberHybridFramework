package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		
		
		this.driver=driver;
	}
	
	// waiting and clicking on the element
	public void clickOnElement(WebElement element, long durationInSeconds) {
		
		WebElement webelement1 = waitForElement(element,durationInSeconds);;
		webelement1.click();
		}
	
	public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {
		
	   WebElement webelement2 = waitForElement(element,durationInSeconds);
	   
	   webelement2.click();
	   webelement2.clear();
	   
	   webelement2.sendKeys(textToBeTyped);
		
	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		
		WebElement webelement=null;
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			
			e.printStackTrace();
		}
		
		
		
		return webelement;
		
		
	}

}
