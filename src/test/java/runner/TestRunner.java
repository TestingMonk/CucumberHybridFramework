package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resource/features/Search.feature",
                 glue= {"stepdefinations","hooks"},
                 publish=true,  // gives cloud link of reports
                 plugin ={"pretty","html:target/CucumberReports/CucumberReport.html"}  // result in nice detailed format 
                 
		)
                 
                             
		                    
		
public class TestRunner {
	
	


}
