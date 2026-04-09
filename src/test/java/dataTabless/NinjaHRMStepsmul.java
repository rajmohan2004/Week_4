package dataTabless;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

public class NinjaHRMStepsmul {

    private String baseUrl;
    private Response response;
    private List<String> projectIds = new ArrayList<>();

    @Given("NinjaHRM base URL for multiple projects")
    public void setBaseUrl() {
        baseUrl = "http://49.249.28.218:8091";
    }

    @When("I create multiple project records")
    public void createMultipleProjects(DataTable dataTable) {

        List<Map<String, String>> rows = dataTable.asMaps();

        for (Map<String, String> row : rows) {

            
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

            if (json.containsKey("projectId")) {
                projectIds.add(String.valueOf(json.get("projectId")));
            } else if (json.containsKey("id")) {
                projectIds.add(String.valueOf(json.get("id")));
            } else {
                throw new RuntimeException("Project ID not found: " + response.asPrettyString());
            }

            response.then().statusCode(201);
        }
    }

    @Then("I should get response code {int}")
    public void validateResponseCode(int code) {
        response.then().statusCode(code);
    }

    @When("I fetch all created projects")
    public void getAllProjects() {

        for (String id : projectIds) {
            response = given()
                    .get(baseUrl + "/projects/" + id);

            response.then().statusCode(200);
        }
    }

    @When("I modify all created projects")
    public void updateAllProjects(DataTable dataTable) {

        List<Map<String, String>> rows = dataTable.asMaps();

        for (int i = 0; i < projectIds.size(); i++) {

            Map<String, String> row = rows.get(i);

            Map<String, Object> body = new HashMap<>();
            body.put("createdBy", row.get("createdBy"));
            body.put("projectName", row.get("projectName"));
            body.put("status", row.get("status"));
            body.put("teamSize", 0);

            response = given()
                    .contentType(ContentType.JSON)
                    .body(body)
                    .put(baseUrl + "/project/" + projectIds.get(i));

            response.then().statusCode(200);
        }
    }

    @When("I remove all created projects")
    public void deleteAllProjects() {

        for (String id : projectIds) {
            response = given()
                    .delete(baseUrl + "/project/" + id);

            response.then().statusCode(204);
        }
    }

    @Then("I verify response time is below {int} ms")
    public void validateResponseTime(int time) {
        response.then().time(lessThan((long) time));
    }
}