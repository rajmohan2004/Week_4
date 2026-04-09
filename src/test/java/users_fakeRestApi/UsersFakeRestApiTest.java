package users_fakeRestApi;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "./src/test/java/users_fakeRestApi/UsersFakeRestApiFeat.feature",
	    glue = "users_FakeRestApi",
	    plugin = {"pretty", "html:target/cucumber-report.html"},
	    monochrome = true
	)

public class UsersFakeRestApiTest extends AbstractTestNGCucumberTests {

}
