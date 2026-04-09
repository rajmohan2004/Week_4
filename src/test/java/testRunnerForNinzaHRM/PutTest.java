package testRunnerForNinzaHRM;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
	    features = "src/test/java/featureFilesForNinzaHRM/PutFeat.feature",
	    glue = "stepDefinitions",
	    plugin = {"pretty", "html:target/NinzaHRM_cucumber-report4.html"},
	    monochrome = true
	)
public class PutTest extends AbstractTestNGCucumberTests {

}
