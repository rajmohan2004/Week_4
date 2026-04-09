package authors_FakeRestApi;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AuthorsFakeRestApiSteps {

    Response response;
    public static int id=1;
    
    @Given("API Base URL is set {string}")
	public void setUrl(String Url)
	{
		RestAssured.baseURI=Url;
	}

    @When("send POST request to create author at {string}")
    public void createAuthor(String endpoint) {
        response = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"idBook\": 1,\n" +
                        "  \"firstName\": \"Raj\",\n" +
                        "  \"lastName\": \"Mohan\"\n" +
                        "}")
                .when()
                .post(endpoint);
    }

    @When("send GET request to get the author at {string}")
    public void getAuthor(String endpoint) {
        response = given().pathParam("id", id)
                .when()
                .get(endpoint);
    }

    @When("send PUT request to update author at {string}")
    public void updateAuthor(String endpoint) {
        response = given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": "+id+",\n" +
                        "  \"idBook\": 1,\n" +
                        "  \"firstName\": \"Updated\",\n" +
                        "  \"lastName\": \"Author\"\n" +
                        "}")
                .when()
                .put(endpoint);
    }

    @When("send DELETE request to delete the author at {string}")
    public void deleteAuthor(String endpoint) {
        response = given()
        		 .pathParam("id",id)
                .when()
                .delete(endpoint);
    }

    @Then("response status should be {int}")
    public void validateStatusCode(int code) {
        response.then().statusCode(code);
    }
}
