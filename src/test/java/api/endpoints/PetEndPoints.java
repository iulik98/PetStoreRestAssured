package api.endpoints;

import api.payload.Pet;
import api.payload.User;
import api.utilities.PropertiesConfigReader;
import io.restassured.response.Response;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PetEndPoints {
    public static Response addNewPet(Pet payload) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Content-Type", "application/json");
        return given()
                .headers(headers)
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .body(payload)
                .when()
                .post(PropertiesConfigReader.getProperty("CREATE_PET_URL"));

    }

    public static Response uploadPhoto(int id) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Content-Type", "multipart/form-data");
        return given()
                .headers(headers)
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .pathParam("petId",id)
                .multiPart("additionalMetadata","metadata")
                .multiPart("file",new File("src/test/resources/photos/pets.png"),"image/png")                .when()
                .post(PropertiesConfigReader.getProperty("UPLOAD_IMAGE_URL"));

    }
    public static Response updateExistingPet(Pet payload) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Content-Type", "application/json");
        return given()
                .headers(headers)
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .body(payload)
                .when()
                .post(PropertiesConfigReader.getProperty("UPDATE_PET_URL"));
    }

    public static Response findPetByStatus(String status) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("accept", "application/json");
        return given()
                .headers(headers)
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .queryParam("status",status)
                .when()
                .get(PropertiesConfigReader.getProperty("FIND_BY_STATUS_PET_URL"));
    }

    public static Response findPetById(int id) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("accept", "application/json");
        return given()
                .headers(headers)
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .pathParam("petId",id)
                .when()
                .get(PropertiesConfigReader.getProperty("FIND_BY_ID_PET_URL"));
    }
    public static Response updatePetWithForm(int id, String name,String status) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return given()
                .headers(headers)
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .pathParam("petId",id)
                .formParam("name",name)
                .formParam("status",status)

                .when()
                .post(PropertiesConfigReader.getProperty("UPDATE_FORM_DATA_URL"));
    }

    public static Response deletePetById(int id) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("api_key", User.getApiKey());
        return given()
                .headers(headers)
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .pathParam("petId",id)
                .when()
                .delete(PropertiesConfigReader.getProperty("DELETE_PET_URL"));
    }
}
