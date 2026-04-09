package stepDefinitionsForGitHub;
import static io.restassured.RestAssured.*;



import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;


public class GetStep {
	Response response;
	String token;

	@Given("The get base URL for The GitHub is set {string}")
    public void setBaseURL(String url) {
        RestAssured.baseURI = url;
    }

    @Given("the get user sets authorization token {string}")
    public void setToken(String tokenValue) {
        token = tokenValue;
    }

    @When("the get user sends GET request to {string} with {string}")
    public void sendPostRequest(String endpoint,String username) {
 
    	endpoint=endpoint.replace("{username}", username);

        response = given()
                    .header("Authorization","Bearer "+ token)
                    .when()
                    .get(endpoint);

        response.then().log().all();
    }

    @Then("the get response statuscode is {int}")
    public void validateStatusCode(int code) {
       response.then().statusCode(code);
    }

    @And("the get response time is less than {int} ms")
    public void validateResponseTime(int time) {
        response.then().time(lessThan((long)time));
    }
	
}
