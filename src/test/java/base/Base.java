package base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Base {

    String TOKEN="e67aa8990990f1ba8a46dd896f5aab0731e03db2607f8e7a1265047d16b1948f";

    public Base(){
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
    }

    protected Response post(String endpoint, Object payload){
        return RestAssured.given().log().all()
                .header("Authorization", "Bearer " + TOKEN)  // 🔥 Required
                .contentType(ContentType.JSON)
                .body(payload)
                .post(endpoint)
                .then().extract().response();
    }

    protected Response get(String endpoint){
        return RestAssured.given().log().all()
                .header("Authorization", "Bearer " + TOKEN)
                .get(endpoint)
                .then().extract().response();
    }
}
