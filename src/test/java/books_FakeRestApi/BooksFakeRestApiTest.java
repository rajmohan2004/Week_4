package books_FakeRestApi;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "./src/test/java/books_fakeRestApi/BooksFakeRestApi.feature",
	    glue = "books_FakeRestApi",
	    plugin = {"pretty", "html:target/FakeRestApi_cucumber-report3.html"},
	    monochrome = true
	)
public class BooksFakeRestApiTest {

}
