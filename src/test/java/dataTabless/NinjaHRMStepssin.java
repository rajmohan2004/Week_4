package dataTabless;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.*;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

public class NinjaHRMStepssin {

    private String baseUrl;
    private Response response;
    private String projectId;

    @Given("NinjaHRM base URL")
    public void setBaseUrl() {
        baseUrl = "http://49.249.28.218:8091";
    }

    @When("I create a project")
    public void createProject(DataTable dataTable) {
        Map<String, String> row = dataTable.asMaps().get(0);

       

        Map<String, Object> body = new HashMap<>();
        body.put("createdBy", row.get("createdBy"));
        body.put("projectName", row.get("projectName"));
        body.put("status", row.get("status"));
        body.put("teamSize", 0); 

        response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .post(baseUrl + "/addProject");

        Map<String, Object> json = response.jsonPath().getMap("");
        if (json.containsKey("id")) {
            projectId = String.valueOf(json.get("id"));
        } else if (json.containsKey("projectId")) {
            projectId = String.valueOf(json.get("projectId"));
        } else {
            throw new RuntimeException("Project ID could not be found in API response: " + response.asPrettyString());
        }
    }

    @When("I retrieve the project")
    public void getProject() {
        response = given()
                .get(baseUrl + "/projects/" + projectId);
    }

    @When("I update the project")
    public void updateProject(DataTable dataTable) {
        Map<String, String> row = dataTable.asMaps().get(0);

        Map<String, Object> body = new HashMap<>();
        body.put("createdBy", row.get("createdBy"));
        body.put("projectName", row.get("projectName"));
        body.put("status", row.get("status"));
        body.put("teamSize", 0);

        response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .put(baseUrl + "/project/" + projectId);
    }

    @When("I delete the project")
    public void deleteProject() {
        response = given()
                .delete(baseUrl + "/project/" + projectId);
    }

    @Then("the response code should be {int}")
    public void validateResponseCode(int code) {
        response.then().statusCode(code);
    }

    @Then("the response time should be less than {int} ms")
    public void validateResponseTime(int time) {
        response.then().time(lessThan((long) time));
    }
}