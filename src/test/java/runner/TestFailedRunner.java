package runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="@target/rerun/failedrun.txt",
                 glue= {"stepdefinations","hooks"},
                 publish=true,  // gives cloud link of reports
                 plugin ={"pretty","html:target/CucumberReports/CucumberReport.html", // result in nice detailed format
                		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",//extent report
                		"timeline:test-output-thread/" ,// plugin used during parallel report generation
                		
                		"rerun:target/rerun/failedrun.txt"
                		
                		
         				}  
                 
		)
                 
                             
		                    
		
public class TestFailedRunner{
	
	


}
