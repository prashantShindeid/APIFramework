package services;

import base.Base;
import io.restassured.response.Response;
import models.request.CreateUserRequest;

public class Userservice extends Base {

    public Response creatUser(CreateUserRequest request){
        return post("/users",request);
    }
    public  Response getUser(int userId){
        return get("/users/"+userId);
    }
}
