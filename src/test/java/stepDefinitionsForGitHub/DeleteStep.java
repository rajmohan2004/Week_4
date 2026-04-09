package stepDefinitionsForGitHub;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteStep {

    Response response;
    String token;

    @Given("The delete base URL for The GitHub is set {string}")
    public void setBaseURL(String url) {
        RestAssured.baseURI = url;
    }

    @Given("the delete user sets authorization token {string}")
    public void setToken(String tokenValue) {
        token = tokenValue;
    }

    @When("the delete user sends DELETE request to {string} with {string},{string}")
    public void sendDeleteRequest(String endpoint, String owner, String repo) {

        // Replace path parameters
        endpoint = endpoint.replace("{owner}", owner)
                           .replace("{repo}", repo);

        response = given()
                    .header("Authorization", "Bearer " + token)
                    .when()
                    .delete(endpoint);

        
    }

    @Then("the delete response statuscode is {int}")
    public void validateStatusCode(int code) {
        response.then().statusCode(code);
    }

    @And("the delete response time is less than {int} ms")
    public void validateResponseTime(int time) {
        response.then().time(lessThan((long) time));
    }
}