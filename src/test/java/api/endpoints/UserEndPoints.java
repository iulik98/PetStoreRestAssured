package api.endpoints;

//Created for performing CRUD requests to the user API.

import api.payload.User;
import api.utilities.PropertiesConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserEndPoints {

    public static Response createUser(String payload) {

        return given()
                .contentType(ContentType.JSON)
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .body(payload)
                .when()
                .post(PropertiesConfigReader.getProperty("POST_URL"));
    }
    public static Response createUser(User payload) {
        System.out.println(payload.toString());
        return given()
                .contentType(ContentType.JSON)
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .body(payload)
                .when()
                .post(PropertiesConfigReader.getProperty("POST_URL"));
    }
    public static Response createUserWithArray(String payload){
        return given()
                .contentType(ContentType.JSON)
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .body(payload)
                .when()
                .post(PropertiesConfigReader.getProperty("CREATE_USER_WITH_ARRAY_URL"));

    }
    public static Response createUserWithList(String payload){
        return given()
                .contentType(ContentType.JSON)
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .body(payload)
                .when()
                .post(PropertiesConfigReader.getProperty("CREATE_USER_WITH_LIST_URL"));

    }

    public static Response readUser(String userName) {
        return given()
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .pathParam("username", userName)
                .when()
                .get(PropertiesConfigReader.getProperty("GET_URL"));
    }

    public static Response updateUser(String userName, String payload) {

        return given()
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)
                .when()
                .put(PropertiesConfigReader.getProperty("PUT_URL"));
    }

    public static Response deleteUser(String userName) {

        return given()
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .pathParam("username", userName)
                .when()
                .delete(PropertiesConfigReader.getProperty("DELETE_URL"));
    }

    public static Response loginUser(String userName, String password){
        return given()
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .queryParam("username",userName)
                .queryParam("password",password)
                .when()
                .get(PropertiesConfigReader.getProperty("LOGIN_URL"));
    }

    public static Response logoutUser(){
        return given()
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .when()
                .get(PropertiesConfigReader.getProperty("LOGOUT_URL"));
    }

}
