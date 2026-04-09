package testRunnerForNinzaHRM;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
	    features = "src/test/java/featureFilesForNinzaHRM/DeleteFeat.feature",
	    glue = "stepDefinitions",
	    plugin = {"pretty", "html:target/NinzaHRM_cucumber-report1.html"},
	    monochrome = true
	)
public class DeleteTest extends AbstractTestNGCucumberTests {

}
