package runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/Search.feature",
                 glue= {"stepdefinations","hooks"},
                // tags = "@Smoke and not @Skip",   //@Before skip will run
                 publish=true,  // gives cloud link of reports
                 plugin ={"pretty","html:target/CucumberReports/CucumberReport.html", // result in nice detailed format
                		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",//extent report
                		"timeline:test-output-thread/" ,// plugin used during parallel report generation
                		
                		"rerun:target/ReRun/failedrun.txt"
                		
                		
         				}  
                 
		)
                 
                             
		                    
		
public class TestRunner{
	
	


}
