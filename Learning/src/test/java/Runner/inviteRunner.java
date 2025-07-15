package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "D:\\JumpSpark\\JumpSpark\\Learning\\src\\test\\java\\Features\\inviteEmailAffliate.feature",
	    glue = {"StepDefination"}, // linking the step definition
	    plugin = {
	    	    "pretty",
	    	    "html:target/cucumber-reports.html",
	    	    "json:target/cucumber.json",
	    	    "junit:target/cucumber.xml"
	    	}, // to generate reports
	   // monochrome = false ,display the console output in readable format
	    dryRun = false, // keep it false to test the scenario in real life
	    // keeping it true only check the mapping
	    tags = "@LoginInfo"
	    	
	   
	)


public class inviteRunner{
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
