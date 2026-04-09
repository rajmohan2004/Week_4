package testRunnerForGitHub;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/featureFilesForGitHub/PatchFeat.feature",
	    glue = "stepDefinitions",
	    plugin = {"pretty", "html:target/GitHub_cucumber-report3.html"},
	    monochrome = true
	)

public class PatchTest extends AbstractTestNGCucumberTests{

}
