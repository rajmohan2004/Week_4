package stepDefinitionsForNinzaHRM;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

public class PutSteps {

    Response response;

    @Given("The put Base URI for Ninza HRM is set {string}")
    public void setBaseURI(String baseUri) {
        RestAssured.baseURI = baseUri;
    }

    @When("put user sends PUT request to {string} with {string}, {string}, {string}, {string}, {int}, {string}, {string}, {string}, {string}")
    public void sendPutRequest(String endpoint,
                               String designation,
                               String dob,
                               String email,
                               String empName,
                               int experience,
                               String mobileNo,
                               String project,
                               String role,
                               String username) {

        // Prepare request body
        HashMap<String, Object> body = new HashMap<>();
        body.put("designation", designation);
        body.put("dob", dob);
        body.put("email", email);
        body.put("empName", empName);
        body.put("experience", experience);
        body.put("mobileNo", mobileNo);
        body.put("project", project);
        body.put("role", role);
        body.put("username", username);

        // Send PUT request
        response = given()
                    .header("Content-Type", "application/json")
                    .body(body)
                   .when()
                    .put(endpoint);
    }

    @Then("put response status should be {int}")
    public void validateStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("put response time should be less than {int} ms")
    public void validateResponseTime(int time) {
        response.then().time(lessThan((long) time));
    }
}
