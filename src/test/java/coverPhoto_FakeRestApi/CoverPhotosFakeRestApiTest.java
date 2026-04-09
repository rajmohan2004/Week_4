package coverPhoto_FakeRestApi;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "./src/test/java/coverPhotos_fakeRestApi/CoverPhotoFakeRest.feature",
	    glue = "coverPhotos_FakeRestApi",
	    plugin = {"pretty", "html:target/FakeRestApi_cucumber-report4.html"},
	    monochrome = true
	)
public class CoverPhotosFakeRestApiTest extends AbstractTestNGCucumberTests{

}
