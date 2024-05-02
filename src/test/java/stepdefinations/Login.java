package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login  {
	
	WebDriver driver;
	private LoginPage loginpage;
	private AccountPage accountpage;
	private Driverfactory driverfactory;
	
	@Given("User has navigates to login page")
	public void User_has_navigates_to_login_page() {
		
		driverfactory = new Driverfactory();
		
		driver = driverfactory.getDriver();  
		HomePage homepage = new HomePage(driver);
		homepage.clickonMyAccount();
        homepage.selectLoginOption();
}
	
	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
	   
		loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(emailText);
	}
	
	
	@And("^User enters valid password (.+) into password field$")
	public void User_enters_valid_password_into_password_field(String passwordText) {
		
		loginpage.enterPasswordField(passwordText);
			
	}	
	
	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		
		loginpage.clickOnloginButton();
	    
	}
    
	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		
		 accountpage = new AccountPage(driver);
		
	    Assert.assertTrue(accountpage.displayStatusOfeditYourAccountInformationOption());
		 
	}
	
	

    @When("User enters invalid email address into email field")
    public void User_enters_invalid_email_address_into_email_field() {
    	
    	 loginpage = new LoginPage(driver);  // again object is created because this is second scenario
    	 loginpage.enterEmailAddress(CommonUtils.getEmailWithTimeStamp());
    
  }
    
    @And("User enters invalid password {string} into password field")
    public void User_enters_invalid_password_into_password_field(String invalidPasswordText) {
    	
    	loginpage.enterPasswordField(invalidPasswordText);
    }
    	
   
    @Then("User should get a warning message about credentials mismatch")
    public void User_should_get_a_warning_message_about_credentials_mismatch() {
    	
    accountpage = new AccountPage(driver);// again object is created because this is second scenario
    Assert.assertTrue(accountpage.warningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
    }
	
	
    @When("User do not enter any email address into email field")
    public void user_do_not_enter_any_email_address_into_email_field() {
    	
    	
    	loginpage = new LoginPage(driver); // again object is created because this is diffrent scenario
    	loginpage.enterEmailAddress("");
        
    }

    @When("User do not enter any password into password field")
    public void user_do_not_enter_any_password_into_password_field() {
    	
    	loginpage.enterPasswordField("");
    }

    
  


	
}
