package api.payload;

import api.utilities.FakeDataManager;
import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "username",
        "firstName",
        "lastName",
        "email",
        "password",
        "phone",
        "userStatus"
})
@Generated("jsonschema2pojo")
public class User {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("userStatus")
    private Integer userStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    private static String apiKey;

    /**
     * No args constructor for use in serialization
     */
    public User() {
    }

    /**
     * @param firstName
     * @param lastName
     * @param password
     * @param userStatus
     * @param phone
     * @param id
     * @param email
     * @param username
     */
    public User(Integer id, String username, String firstName, String lastName, String email, String password, String phone, Integer userStatus) {
        super();
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    public static User[] createArrayUsers(int n) {
        User[] userArray = new User[n];
        for (int i = 0; i < n; i++) {
            int id = FakeDataManager.getRandomID();
            int userStatus = FakeDataManager.getRandomID();
            String username = FakeDataManager.getRandomUserName();
            String firstName = FakeDataManager.getRandomFirstName();
            String lastName = FakeDataManager.getRandomLastName();
            String email = FakeDataManager.getRandomEmail();
            String password = FakeDataManager.getRandomPassword(5, 10);
            String phone = FakeDataManager.getRandomPhone();
            userArray[i] = new User(id, username, firstName, lastName, email, password, phone, userStatus);
        }
        return userArray;
    }

    public static List<User> createListUsers(int n) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = FakeDataManager.getRandomID();
            int userStatus = FakeDataManager.getRandomID();
            String username = FakeDataManager.getRandomUserName();
            String firstName = FakeDataManager.getRandomFirstName();
            String lastName = FakeDataManager.getRandomLastName();
            String email = FakeDataManager.getRandomEmail();
            String password = FakeDataManager.getRandomPassword(5, 10);
            String phone = FakeDataManager.getRandomPhone();
            userList.add(new User(id, username, firstName, lastName, email, password, phone, userStatus));
        }
        return userList;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("userStatus")
    public Integer getUserStatus() {
        return userStatus;
    }

    @JsonProperty("userStatus")
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static void setApiKey(String apiKey) {
        apiKey = apiKey;
    }

}