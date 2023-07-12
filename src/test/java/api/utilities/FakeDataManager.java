package api.utilities;

import com.github.javafaker.Faker;

public class FakeDataManager {
    private static final Faker fakerObject = new Faker();

    public static int getRandomID(){
        return fakerObject.random().nextInt(1,9);
    }
    public static boolean getRandomBoolean(){
        return fakerObject.random().nextBoolean();
    }
    public static String getRandomUserName() {
        return fakerObject.name().username();
    }
    public static String getRandomFirstName() {
        return fakerObject.funnyName().name();
    }
    public static String getRandomLastName() {
        return fakerObject.funnyName().name();
    }

    public static String getRandomPassword(int min, int max) {
        return fakerObject.internet().password(min, max);
    }

    public static String getRandomPassword() {
        return fakerObject.internet().password();
    }
    public static String getRandomEmail() {
        return fakerObject.internet().safeEmailAddress();
    }

    public static String getRandomPhone() {
        return fakerObject.phoneNumber().cellPhone();
    }
    public static String getRandomName() {
        return fakerObject.funnyName().name();
    }
    public static String getRandomData(String fieldName) {
        if (fieldName!=null) {
            if (fieldName.toLowerCase().contains("email")) {
                return getRandomEmail();
            } else if (fieldName.toLowerCase().contains("name")) {
                return getRandomName();
            } else if (fieldName.toLowerCase().contains("pass") || fieldName.toLowerCase().contains("password")) {
                return getRandomPassword();
            }
        }


        return "";
    }
}
