package services;

import base.Base;
import io.restassured.response.Response;
import models.request.CreateUserRequest;
import models.request.UpdateUserRequest;

public class Userservice extends Base {

    public Response creatUser(CreateUserRequest request){
        return post("/users",request);
    }
    public  Response getUser(int userId) {
        return get("/users/" + userId);
    }

    public Response updateUser(int createdUserId, String payload) {
        return put("/users/"+createdUserId,payload);

    }

    public Response deleteUser(int userId){
        return delete("/users/"+userId);
    }
}
