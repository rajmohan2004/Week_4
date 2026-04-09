package stepDefinitionsForGitHub;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class PatchStep {
	
	Response response;
    String token;
    Map<String, Object> body;

    @Given("The patch base URL for The GitHub is set {string}")
    public void setBaseURL(String url) {
        RestAssured.baseURI = url;
    }

    @Given("the patch user sets authorization token {string}")
    public void setToken(String tokenValue) {
        token = tokenValue;
    }

	
	
	@When("the patch user sends PATCH request to {string} with {string}")
	public void sendPatchRequest(String endpoint, String description) {

	    Map<String, Object> body = new HashMap<>();
	    body.put("description", description);

	    response = given()
	                .header("Authorization","Bearer "+ token)
	                .contentType(ContentType.JSON)
	                .body(body)
	                .when()
	                .patch(endpoint);

	    response.then().log().all();
	}
	
	@Then("the patch response statuscode is {int}")
    public void validateStatusCode(int code) {
       response.then().statusCode(code);
    }

    @And("the patch response time is less than {int} ms")
    public void validateResponseTime(int time) {
        response.then().time(lessThan((long)time));
    }
	
}
