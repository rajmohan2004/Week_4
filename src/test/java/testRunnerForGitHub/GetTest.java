package testRunnerForGitHub;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/featureFilesForGitHub/GetFeat.feature",
	    glue = "stepDefinitions",
	    plugin = {"pretty", "html:target/GitHub_cucumber-report2.html"},
	    monochrome = true
	)

public class GetTest extends AbstractTestNGCucumberTests {

}
