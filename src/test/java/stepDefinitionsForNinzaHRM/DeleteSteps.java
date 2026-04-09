package stepDefinitionsForNinzaHRM;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteSteps {

    Response response;

    @Given("The delete Base URI for Ninza HRM is set {string}")
    public void setBaseURI(String baseUri) {
        RestAssured.baseURI = baseUri;
    }

    @When("delete user sends DELETE request to {string}")
    public void sendDeleteRequest(String endpoint) {
        response = given()
                    .when()
                    .delete(endpoint);
    }

    @Then("delete response status should be {int}")
    public void validateStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("delete response time should be less than {int} ms")
    public void validateResponseTime(int time) {
        response.then().time(lessThan((long) time));
    }
}