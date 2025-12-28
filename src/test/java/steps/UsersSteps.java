package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.request.CreateUserRequest;
import models.request.UpdateUserRequest;
import org.testng.Assert;
import services.Userservice;

import java.util.Map;

public class UsersSteps {
    Userservice userservice = new Userservice();
    Response response;
    int createdUserId;
    String payload;

    @Given("I create user with the {string},{string},{string},{string}")
    public void i_create_user_with_the(String name, String email, String gender, String status) {
        CreateUserRequest Req=new CreateUserRequest(name,email,gender,status);
        response=userservice.creatUser(Req);
    }
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer code) {
       response.then().statusCode(code);
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

    @Given("the user id is {string}")
    public void theUserIdIs(String id) {
        createdUserId= Integer.parseInt(id);
    }

    @And("the update payload is:")
    public void theUpdatePayloadIs(String body) {
        payload=body;
    }

    @When("I send a PUT request to {string}")
    public void iSendAPUTRequestTo(String endpoint) {
     response = userservice.updateUser(createdUserId,payload);

    }


    @And("the response body field name should be {string}")
    public void theResponseBodyFieldNameShouldBe(String Expected) {
        response=userservice.getUser(createdUserId);
        Assert.assertEquals(response.path("name"), Expected, "name is not matched");
    }

    @When("I send a delete request to {string}")
    public void iSendADeleteRequestTo(String endpoint) {
       response =userservice.deleteUser(createdUserId);
    }
}
