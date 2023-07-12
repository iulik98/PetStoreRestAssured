package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.ExcelUtility;
import api.utilities.PropertiesConfigReader;
import com.github.javafaker.Faker;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserTests {

    Faker faker;
    User user;
    User[] userArray = User.createArrayUsers(5);
    List<User> userList = User.createListUsers(7);

    @DataProvider(name = "userData")
    public static Object[][] userData() throws IOException {
        String path = "src/test/resources/datadriventesting/Users.xlsx";
        int rownum = ExcelUtility.getRowCount(path, "Sheet1");
        int colnum = ExcelUtility.getCellCount(path, "Sheet1", 1);
        String[][] userData = new String[rownum][colnum];
        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colnum; j++) {
                userData[i - 1][j] = ExcelUtility.getCellData(path, "Sheet1", i, j);
            }
        }
        return userData;
    }

    @BeforeClass
    public void setUpData() {
        faker = new Faker();
        int id = faker.idNumber().hashCode();
        String username = faker.name().username();
        System.out.println(username);
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().safeEmailAddress();
        String password = faker.internet().password(5, 10);
        String phone = faker.phoneNumber().cellPhone();
        int userStatus = faker.idNumber().hashCode();
        user = new User(id, username, firstName, lastName, email, password, phone, userStatus);

    }

    @Test(priority = 1)
    public void testCreateUser() {
        Response response = UserEndPoints.createUser(user);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void testGetUserByName() {
        Response response = UserEndPoints.readUser(this.user.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void testUpdateUser() {
        user.setEmail(faker.internet().emailAddress());
        Response response = UserEndPoints.updateUser(this.user.getUsername(), user);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void testDeleteUser() {
        Response response = UserEndPoints.deleteUser(this.user.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 5)
    public void testPostArrayUser() {
        Response response = UserEndPoints.createUserWithArray(userArray);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 6)
    public void testPostListUser() {
        Response response = UserEndPoints.createUserWithList(userList);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 7)
    public void testLoginUser() {
        Response response = UserEndPoints.loginUser(user.getUsername(), user.getPassword());
        String sessionId = response.path("message").toString().split(":")[1];
        User.setApiKey(sessionId);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 8)
    public void testLogoutUser() {
        Response response = UserEndPoints.logoutUser();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(dataProvider = "userData", priority = 9)
    public void testCreateUserDDT(String id, String username, String firstName, String lastName, String email,
                                  String password, String phone, String userStatus) {
        JSONObject requestparams = new JSONObject();
        requestparams.put("id", Integer.valueOf(id));
        requestparams.put("username", username);
        requestparams.put("firstName", firstName);
        requestparams.put("lastName", lastName);
        requestparams.put("email", email);
        requestparams.put("password", password);
        requestparams.put("phone", phone);
        requestparams.put("userStatus", Integer.valueOf(userStatus));
        RequestSpecification request = given().filter(new AllureRestAssured())
                .header("Content-Type", ContentType.JSON)
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .body(requestparams.toJSONString());
        Response response = request.when().post(PropertiesConfigReader.getProperty("POST_URL"));
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
