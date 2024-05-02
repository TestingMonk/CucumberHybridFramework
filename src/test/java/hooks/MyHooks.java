package hooks;

import java.util.Properties;

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
	
	@Before
	public void setup() {
		
	configreader = new ConfigReader();
	Properties prop =  configreader.initializeProperties();// calling this method to use properties file 
	
	
	
	driverfactory = new Driverfactory();
	driver=driverfactory.IntitializeBrowser("chrome");  // this will intialize browser
	//driver=driverfactory.IntitializeBrowser(prop.getProperty("browser"));
	driver.get(prop.getProperty("url"));
	
		
	}
	
	@After
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
