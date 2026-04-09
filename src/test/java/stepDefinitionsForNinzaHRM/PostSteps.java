package stepDefinitionsForNinzaHRM;

import pojoclasses.PostPojo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class PostSteps {

	 PostPojo emp;
	    Response response;

	   
	    @Given("The Base URI for Ninza HRM is set {string}")
	    public void setBaseURL(String url) {
	        RestAssured.baseURI = url;
	    }

	    
	    @Given("request body is prepared with {string}, {string}, {string}, {string}, {int}, {string}, {string}, {string}, {string}")
	    public void prepareRequestBody(String designation, String dob, String email, String empName,
	                                   int experience, String mobileNo, String project,
	                                   String role, String username) {

	        emp = new PostPojo();
	        emp.setDesignation(designation);
	        emp.setDob(dob);
	        emp.setEmail(email);
	        emp.setEmpName(empName);
	        emp.setExperience(experience);
	        emp.setMobileNo(mobileNo);
	        emp.setProject(project);
	        emp.setRole(role);
	        emp.setUsername(username);
	    }

	    
	    @When("user sends POST request to {string}")
	    public void sendPostRequest(String endpoint) {

	        response = given().contentType(ContentType.JSON)
	                   .body(emp)
	                   .when()
	                        .post(endpoint);
	        response.then().log().all();
	    }

	    
	    @Then("response status should be {int}")
	    public void validateStatusCode(int statusCode) {
	        response.then().statusCode(statusCode);
	    }

	    
	    @Then("response time should be less than {int} ms")
	    public void validateResponseTime(int time) {
	        response.then().time(lessThan((long)time));
	    }
	
	
}
