package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

public class UserTests {

    Faker faker;
    User userPayload;
    User[] userArray = User.createArrayUsers(5);
    List<User> userList = User.createListUsers(7);

    @BeforeClass
    public void setUpData() {
        faker = new Faker();
        int id = faker.idNumber().hashCode();
        String username = faker.name().username();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().safeEmailAddress();
        String password = faker.internet().password(5, 10);
        String phone = faker.phoneNumber().cellPhone();
        userPayload = new User(username, firstName, lastName, email, password, phone, id);


    }

    @Test(priority = 1)
    public void testPostUser() {
        Response response = UserEndPoints.createUser(userPayload.createJSON());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 8)
    public void testPostUserPOJO() {
        Response response = UserEndPoints.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void testGetUserByName() {
        Response response = UserEndPoints.readUser(this.userPayload.getUserName());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void testUpdateUser() {
        userPayload.setEmail(faker.internet().emailAddress());
        Response response = UserEndPoints.updateUser(this.userPayload.getUserName(), userPayload.createJSON());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void testDeleteUser() {
        Response response = UserEndPoints.deleteUser(this.userPayload.getUserName());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 5)
    public void testPostArrayUser() {
        Response response = UserEndPoints.createUserWithArray(User.createJSONArray(userArray));
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 6)
    public void testPostListUser() {
        Response response = UserEndPoints.createUserWithList(User.createJSONList(Objects.requireNonNull(userList)));
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 7)
    public void testLoginUser() {
        Response response = UserEndPoints.loginUser(userPayload.getUserName(), userPayload.getPassword());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 8)
    public void testLogoutUser() {
        Response response = UserEndPoints.logoutUser();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
