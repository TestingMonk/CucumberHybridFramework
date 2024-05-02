package stepdefinations;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	
	WebDriver driver;
	RegisterPage registerpage;
	private Driverfactory driverfactory;

	@Given("User navigates to registration page")
	public void user_navigates_to_registration_page() {
		
		driverfactory = new Driverfactory();
	      
		driver =driverfactory.getDriver();
		
		HomePage homepage = new HomePage(driver);
		homepage.clickonMyAccount();
		homepage.selectRegisterOption();		
	}
	

@When("User enters below details into the corresponding fields")
public void user_enters_below_details_into_the_corresponding_fields(DataTable dataTable) {
  
	Map<String,String> dataMap=dataTable.asMap(String.class, String.class);
	
	registerpage = new RegisterPage(driver);
	registerpage.enterFirstName(dataMap.get("firstName"));
	registerpage.enterLastName(dataMap.get("lastName"));
	registerpage.enterEmail(CommonUtils.getEmailWithTimeStamp());
	registerpage.enterTelephone(dataMap.get("telephone"));
	registerpage.enterPassword(dataMap.get("password"));
	registerpage.enterPasswordConfirm(dataMap.get("password"));

}

@When("User enters below details into the corresponding fields with duplicate address")
public void user_enters_below_details_into_the_corresponding_fields_with_duplicate_address(DataTable dataTable) {
  
	Map<String,String> dataMap=dataTable.asMap(String.class, String.class);
	registerpage = new RegisterPage(driver);
	registerpage.enterFirstName(dataMap.get("firstName"));
	registerpage.enterLastName(dataMap.get("lastName"));
	registerpage.enterEmail(dataMap.get("email"));
	registerpage.enterTelephone(dataMap.get("telephone"));
	registerpage.enterPassword(dataMap.get("password"));
	registerpage.enterPasswordConfirm(dataMap.get("password"));
}

@And("User selects Privacy Policy")
public void user_selects_privacy_policy() {
	
	registerpage.selectPrivacyOption();
   
}

@And("User clicks on Continue button")
public void user_clicks_on_continue_button() {
	
	registerpage.clickOnContinueButton();
    
}

@Then("User Account should get created successfully")
public void user_account_should_get_created_successfully() {
	
	AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
	Assert.assertEquals("Your Account Has Been Created!", accountsuccesspage.pageHeadingMsg());
}


@And("User selects Yes for newsletter")
public void User_selects_Yes_for_newsletter() {
	
	
	registerpage.selectYesLetterOption();
	
} 

@Then("User should get proper warning message about duplicate email address")
public void User_should_get_proper_warning_message_about_duplicate_email_address() {
	
	
	
Assert.assertTrue(registerpage.warningMessageDisplayed().contains("Warning: E-Mail Address is already registered!"));

	
	
}

@When("User doesnt enters any details into fields")
public void User_doesnt_enters_any_details_into_fields() {
	
	registerpage = new RegisterPage(driver);
}


@Then("User should get proper warning message for every mandatory field")
public void User_should_get_proper_warning_message_for_every_mandatory_field() {
	
Assert.assertTrue(registerpage.warningMessageDisplayed().contains("Warning: You must agree to the Privacy Policy!"));
Assert.assertEquals("First Name must be between 1 and 32 characters!", registerpage.firstNameWarningMessage());
Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.lastNameWarningMessage());
Assert.assertEquals("E-Mail Address does not appear to be valid!", registerpage.emailAddressWarningMessage());
Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.telephoneWarningMessage() );
Assert.assertEquals("Password must be between 4 and 20 characters!", registerpage.passwordWarningMessgage());

	
}	








}
