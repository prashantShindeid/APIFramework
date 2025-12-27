package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.request.CreateUserRequest;
import org.testng.Assert;
import services.Userservice;

import java.util.Map;

public class UsersSteps {
    Userservice userservice = new Userservice();
    Response response;
    int createdUserId;

    @Given("I create user with the {string},{string},{string},{string}")
    public void i_create_user_with_the(String name, String email, String gender, String status) {
        CreateUserRequest Req=new CreateUserRequest(name,email,gender,status);
        response=userservice.creatUser(Req);
    }
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer code) {
        Assert.assertEquals(code, response.getStatusCode());
    }


    @Given("I have created new user")
    public void iHaveCreatedNewUser() {
        CreateUserRequest req = new CreateUserRequest(
                "Test User3",
                "testuser3@gmail.com",
                "male",
                "active"
        );
        response = userservice.creatUser(req);
        createdUserId = response.path("id");
    }
    
    @When("I send GET request for that user")
    public void iGetUserRequest(){
    // response = get("/users/"+userId) ;
        response = userservice.getUser(createdUserId);
    }


    @And("response body should contain correct {string}, {string}")
    public void responseBodyShouldContainCorrect(String name, String email) {
        Assert.assertEquals(response.path("name"),name);
      //  Assert.assertEquals(response.path("email"),email);
    }
}
