package api.payload;

import api.utilities.FakeDataManager;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class User {
    @JsonProperty
    private String userName;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String email;
    @JsonProperty
    private String password;
    @JsonProperty
    private String phone;
    @JsonProperty
    private int userStatus = 0;
    @JsonProperty
    private transient int id = 0;

    public User(String userName, String firstName, String lastName, String email, String password, String phone, int id) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.id = id;
    }

    public static String createJSONArray(User[] users) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < users.length; i++) {
            if (i < users.length - 1) {
                sb.append("{\n" +
                        "  \"id\": " + users[i].id + ",\n" +
                        "  \"username\": \"" + users[i].userName + "\",\n" +
                        "  \"firstName\": \"" + users[i].firstName + "\",\n" +
                        "  \"lastName\": \"" + users[i].lastName + "\",\n" +
                        "  \"email\": \"" + users[i].email + "\",\n" +
                        "  \"password\": \"" + users[i].password + "\",\n" +
                        "  \"phone\": \"" + users[i].phone + "\",\n" +
                        "  \"userStatus\": " + users[i].userStatus + "\n" +
                        "},\n");
            } else {
                sb.append("{\n" +
                        "  \"id\": " + users[i].id + ",\n" +
                        "  \"username\": \"" + users[i].userName + "\",\n" +
                        "  \"firstName\": \"" + users[i].firstName + "\",\n" +
                        "  \"lastName\": \"" + users[i].lastName + "\",\n" +
                        "  \"email\": \"" + users[i].email + "\",\n" +
                        "  \"password\": \"" + users[i].password + "\",\n" +
                        "  \"phone\": \"" + users[i].phone + "\",\n" +
                        "  \"userStatus\": " + users[i].userStatus + "\n" +
                        "}\n");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String createJSONList(List<User> users) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < users.size(); i++) {
            if (i < users.size() - 1) {
                sb.append("{\n" +
                        "  \"id\": " + users.get(i).id + ",\n" +
                        "  \"username\": \"" + users.get(i).userName + "\",\n" +
                        "  \"firstName\": \"" + users.get(i).firstName + "\",\n" +
                        "  \"lastName\": \"" + users.get(i).lastName + "\",\n" +
                        "  \"email\": \"" + users.get(i).email + "\",\n" +
                        "  \"password\": \"" + users.get(i).password + "\",\n" +
                        "  \"phone\": \"" + users.get(i).phone + "\",\n" +
                        "  \"userStatus\": " + users.get(i).userStatus + "\n" +
                        "},\n");
            } else {
                sb.append("{\n" +
                        "  \"id\": " + users.get(i).id + ",\n" +
                        "  \"username\": \"" + users.get(i).userName + "\",\n" +
                        "  \"firstName\": \"" + users.get(i).firstName + "\",\n" +
                        "  \"lastName\": \"" + users.get(i).lastName + "\",\n" +
                        "  \"email\": \"" + users.get(i).email + "\",\n" +
                        "  \"password\": \"" + users.get(i).password + "\",\n" +
                        "  \"phone\": \"" + users.get(i).phone + "\",\n" +
                        "  \"userStatus\": " + users.get(i).userStatus + "\n" +
                        "}\n");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static User[] createArrayUsers(int n) {
        User[] userArray = new User[n];
        for (int i = 0; i < n; i++) {
            int id = FakeDataManager.getRandomID();
            String username = FakeDataManager.getRandomUserName();
            String firstName = FakeDataManager.getRandomFirstName();
            String lastName = FakeDataManager.getRandomLastName();
            String email = FakeDataManager.getRandomEmail();
            String password = FakeDataManager.getRandomPassword(5, 10);
            String phone = FakeDataManager.getRandomPhone();
            userArray[i] = new User(username, firstName, lastName, email, password, phone, id);
        }
        return userArray;
    }

    public static List<User> createListUsers(int n) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = FakeDataManager.getRandomID();
            String username = FakeDataManager.getRandomUserName();
            String firstName = FakeDataManager.getRandomFirstName();
            String lastName = FakeDataManager.getRandomLastName();
            String email = FakeDataManager.getRandomEmail();
            String password = FakeDataManager.getRandomPassword(5, 10);
            String phone = FakeDataManager.getRandomPhone();
            userList.add(new User(username, firstName, lastName, email, password, phone, id));
        }
        return userList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", userStatus=" + userStatus +
                ", id=" + id +
                '}';
    }

    public String createJSON() {

        return "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"username\": \"" + userName + "\",\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\",\n" +
                "  \"phone\": \"" + phone + "\",\n" +
                "  \"userStatus\": " + userStatus + "\n" +
                "}";
    }

}
