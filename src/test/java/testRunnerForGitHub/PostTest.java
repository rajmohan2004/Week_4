package testRunnerForGitHub;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/featureFilesForGitHub/PostFeat.feature",
	    glue = "stepDefinitions",
	    plugin = {"pretty", "html:target/GitHub_cucumber-report4.html"},
	    monochrome = true
	)

public class PostTest extends AbstractTestNGCucumberTests{

}
