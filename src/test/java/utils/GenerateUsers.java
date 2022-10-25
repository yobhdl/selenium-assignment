package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Users;


public class GenerateUsers {

    public static Users getUserData(){

        return RestAssured.given().baseUri("https://randomuser.me/")
                .accept(ContentType.JSON)
                .queryParam("nat","US")
                .queryParam("password","special,upper,lower,number")
                .when()
                .get("/api")
                .then().extract().as(Users.class);
    }

}
