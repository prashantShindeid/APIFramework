package models.request;

public class CreateUserRequest {
    public String name;
    public String email;
    public String gender;
    public String status;

    public CreateUserRequest(String name, String email, String gender, String status) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }


}
