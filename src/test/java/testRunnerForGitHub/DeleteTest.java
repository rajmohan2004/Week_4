package testRunnerForGitHub;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
	    features = "./src/test/java/featureFilesForGitHub/DeleteFeat.feature",
	    glue = "stepDefinitions",
	    plugin = {"pretty", "html:target/GitHub_cucumber-report1.html"},
	    monochrome = true
	)
public class DeleteTest extends AbstractTestNGCucumberTests {

}
