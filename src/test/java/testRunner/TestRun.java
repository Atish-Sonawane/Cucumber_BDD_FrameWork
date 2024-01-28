package testRunner;



import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
  //cucumber.api.CucumberOptions

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty","html:test-output"},
		features= {".//Features/Login.feature"},
		glue= {"stepDefination"},
		dryRun=true,  // it true getting output only on console not open chrome.
		monochrome=true,  // get console output much more readable.
		tags= "@Sanity and @Regression"
		
		)
public class TestRun {

}
