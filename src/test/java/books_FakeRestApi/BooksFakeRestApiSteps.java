package books_FakeRestApi;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class BooksFakeRestApiSteps {
    Response response;
    public static int id = 1;

    @Given("The book Base API Base URI is set {string}")
	public void setUrl(String Url)
	{
		RestAssured.baseURI=Url;
	}
    
    @When("book sends POST request to create book record at {string}")
    public void createBookRecord(String endpoint) {
        response = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"title\": \"Java Basics\",\n" +
                        "  \"description\": \"Learning Java\",\n" +
                        "  \"pageCount\": 200,\n" +
                        "  \"excerpt\": \"Intro\",\n" +
                        "  \"publishDate\": \"2026-03-24T00:00:00Z\"\n" +
                        "}")
                .when()
                .post(endpoint);
    }

    @When("book sends GET request to fetch the book record at {string}")
    public void fetchBookRecord(String endpoint) {
        response = given()
                .log().all()
                .pathParam("id", id)
                .when()
                .get(endpoint);
    }

    @When("book sends PUT request to modify the book record at {string}")
    public void modifyBookRecord(String endpoint) {
        response = given()
                .log().all()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": " + id + ",\n" +
                        "  \"title\": \"Updated Java\",\n" +
                        "  \"description\": \"Updated\",\n" +
                        "  \"pageCount\": 250,\n" +
                        "  \"excerpt\": \"Advanced\",\n" +
                        "  \"publishDate\": \"2026-03-24T00:00:00Z\"\n" +
                        "}")
                .when()
                .put(endpoint);
    }

    @When("book sends DELETE request to remove the book record at {string}")
    public void removeBookRecord(String endpoint) {
        response = given()
                .log().all()
                .pathParam("id", id)
                .when()
                .delete(endpoint);
    }

    @Then("book the response status should be {int}")
    public void validateStatusCode(int code) {
        response.then().statusCode(code);
    }

}
