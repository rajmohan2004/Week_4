package coverPhoto_FakeRestApi;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CoverPhotosFakeRestApiSteps {
	Response response;
    public static int id = 1;
    public static int idBook = 1;
    @Given("The Cover Photos Base API Base URI is set {string}")
    public void setUrl(String url) {
        RestAssured.baseURI = url;
    }

    @When("Cover Photos sends POST request to create user record at {string}")
    public void createUser(String endpoint) {
        response = given()
                .contentType(ContentType.JSON)
                .body("{\r\n"
                		+ "  \"id\":"+id+",\r\n"
                		+ "  \"idBook\":"+idBook+",\r\n"
                		+ "  \"url\": \"string\"\r\n"
                		+ "}")
                .when()
                .post(endpoint);
    }

    @When("Cover Photos sends GET request to fetch the user record at {string}")
    public void getUser(String endpoint) {
        response = given()
                .pathParam("id", id)
                .when()
                .get(endpoint);
    }

    @When("Cover Photos sends PUT request to modify the user record at {string}")
    public void updateUser(String endpoint) {
        response = given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body("{\r\n"
                		+ "  \"id\":"+id+",\r\n"
                		+ "  \"idBook\":"+idBook+",\r\n"
                		+ "  \"url\": \"string\"\r\n"
                		+ "}")
                .when()
                .put(endpoint);
    }

    @When("Cover Photos sends DELETE request to remove the user record at {string}")
    public void deleteUser(String endpoint) {
        response = given()
                .pathParam("id", id)
                .when()
                .delete(endpoint);
    }

    @Then("Cover Photos the response status should be {int}")
    public void validateStatusCode(int code) {
        response.then().statusCode(code);
    }
}
