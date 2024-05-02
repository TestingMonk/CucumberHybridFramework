package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResult;

public class Search {
	
	WebDriver driver;
	HomePage homepage;
	SearchResult searchresult;
	private Driverfactory driverfactory;
	
	@Given("User opens the application")
	public void User_opens_the_application(){
		
		 driverfactory = new Driverfactory();
		
		driver =driverfactory.getDriver();
		
		
		
	}
	
	@When("User enter valid product {string} into the Search box field")
	public void User_enter_valid_product_into_the_Search_box_field(String validProduct) {
		
		 homepage = new HomePage(driver);
		homepage.searchBoxField(validProduct);
		
	}

	
	@And("User clicks on Search button")
	public void User_clicks_on_Search_button() {
		
	    homepage.searchButtonClick();
		
	}
	
	@Then("User should get valid product displayed in Search results")
	public void User_should_get_valid_product_displayed_in_Search_results() {
		
		 searchresult = new SearchResult(driver);
		
        Assert.assertTrue(searchresult.searchproductDisplayed());
        Assert.fail();   // intentionally failed to check screentshot code 
	}
	
	@When("User enter invalid product {string} into the Search box field")
	public void User_enter_invalid_product_into_the_Search_box_field(String invalidProduct) {
		
		homepage = new HomePage(driver);
		
		homepage.searchBoxField(invalidProduct);
		
		
	}
	
	@Then("User should get a message about no product matching")
	public void User_should_get_a_message_about_no_product_matching() {
		
		 searchresult = new SearchResult(driver);
		
		
		Assert.assertTrue(searchresult.noProductMatchingMessage());
		
		
	}
	
	@When("User dont enter any product name into the Search box field")
	public void User_dont_enter_any_product_name_into_the_Search_box_field() {
		
		homepage = new HomePage(driver);
	}
}
