package users_fakeRestApi;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UsersFakeRestApiSteps {

    Response response;
    public static int id = 1;

    @Given("The user Base API Base URI is set {string}")
    public void setUrl(String url) {
        RestAssured.baseURI = url;
    }

    @When("user sends POST request to create user record at {string}")
    public void createUser(String endpoint) {
        response = given()
   
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"userName\": \"Raj\",\n" +
                        "  \"password\": \"1234\"\n" +
                        "}")
                .when()
                .post(endpoint);
    }

    @When("user sends GET request to fetch the user record at {string}")
    public void getUser(String endpoint) {
        response = given()
 
                .pathParam("id", id)
                .when()
                .get(endpoint);
    }

    @When("user sends PUT request to modify the user record at {string}")
    public void updateUser(String endpoint) {
        response = given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": " + id + ",\n" +
                        "  \"userName\": \"UpdatedUser\",\n" +
                        "  \"password\": \"5678\"\n" +
                        "}")
                .when()
                .put(endpoint);
    }

    @When("user sends DELETE request to remove the user record at {string}")
    public void deleteUser(String endpoint) {
        response = given()
                
                .pathParam("id", id)
                .when()
                .delete(endpoint);
    }

    @Then("user the response status should be {int}")
    public void validateStatusCode(int code) {
        response.then().statusCode(code);
    }
}