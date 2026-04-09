package testRunnerForNinzaHRM;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/featureFilesForNinzaHRM/PostFeat.feature",
	    glue = "stepDefinitions",
	    plugin = {"pretty", "html:target/NinzaHRM_cucumber-report3.html"},
	    monochrome = true
	)

public class PostTest extends AbstractTestNGCucumberTests{

}
