package testRunnerForNinzaHRM;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/featureFilesForNinzaHRM/GetFeat.feature",
	    glue = "stepDefinitions",
	    plugin = {"pretty", "html:target/NinzaHRM_cucumber-report2.html"},
	    monochrome = true
	)
public class GetTest extends AbstractTestNGCucumberTests {

}
