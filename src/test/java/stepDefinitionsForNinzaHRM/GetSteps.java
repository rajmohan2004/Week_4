package stepDefinitionsForNinzaHRM;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSteps {

    Response response;

    @Given("The get Base URI for Ninza HRM is set {string}")
    public void setBaseURI(String baseUri) {
        RestAssured.baseURI = baseUri;
    }

    @When("get user sends GET request to {string}")
    public void sendGetRequest(String endpoint) {
        response = given()
                    .when()
                    .get(endpoint);
    }

    @Then("get response status should be {int}")
    public void validateStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("get response time should be less than {int} ms")
    public void validateResponseTime(int time) {
        response.then().time(lessThan((long) time));
    }
}