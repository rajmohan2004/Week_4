package stepDefinitionsForGitHub;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;



public class PostStep {

    Response response;
    String token;
    Map<String, Object> body;

    @Given("The post base URL for The GitHub is set {string}")
    public void setBaseURL(String url) {
        RestAssured.baseURI = url;
    }

    @Given("the post user sets authorization token {string}")
    public void setToken(String tokenValue) {
        token = tokenValue;
    }

    @When("the post user sends POST request to {string} with {string},{string}")
    public void sendPostRequest(String endpoint, String name, String description) {

        body = new HashMap<>();
        body.put("name", name);
        body.put("description", description);

        response = given()
                    .header("Authorization","Bearer "+ token)
                    .contentType(ContentType.JSON)
                    .body(body)
                    .when()
                    .post(endpoint);

        response.then().log().all();
    }

    @Then("the post response statuscode is {int}")
    public void validateStatusCode(int code) {
       response.then().statusCode(code);
    }

    @And("the post response time is less than {int} ms")
    public void validateResponseTime(int time) {
        response.then().time(lessThan((long)time));
    }
}