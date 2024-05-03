package hooks;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	
 WebDriver driver;
 private ConfigReader configreader;
 private Driverfactory driverfactory;
	
	@Before(order=0)
	public void setup() {
		
	configreader = new ConfigReader();
	Properties prop =  configreader.initializeProperties();// calling this method to use properties file 
	
	
	
	driverfactory = new Driverfactory();
	driver=driverfactory.IntitializeBrowser("chrome");  // this will intialize browser
	//driver=driverfactory.IntitializeBrowser(prop.getProperty("browser"));
	driver.get(prop.getProperty("url"));
	
		
	}
	
	// below code will skip scenario on the basis of the tags & it will reflect in pdf report as well
	@Before(value= "@skip_scenario")
	public void skip_scenario(Scenario scenario) {
		
	System.out.println("Skipped scenario is " + scenario.getName());
	Assume.assumeTrue(false);
	}
	
	
	
	@After(order=0)
	public  void tearDown(Scenario scenario) {
		
		//getname return name of failed test
		
		 String scenarioName =scenario.getName().replace("", "_");
		 
		if (scenario.isFailed()) {
			
	    byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(srcScreenshot, "image/png", scenarioName);
		 }
		
		driver.quit();
		
	}

}
