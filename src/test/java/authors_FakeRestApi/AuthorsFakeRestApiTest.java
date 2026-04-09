package authors_FakeRestApi;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "./src/test/java/authors_fakeRestApi/AuthorsFakeRestApi.feature",
	    glue = "authors_FakeRestApi",
	    plugin = {"pretty", "html:target/FakeRestApi_cucumber-report2.html"},
	    monochrome = true
	)
public class AuthorsFakeRestApiTest extends AbstractTestNGCucumberTests {

}
