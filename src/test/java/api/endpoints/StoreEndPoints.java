package api.endpoints;

import api.payload.Order;
import api.utilities.PropertiesConfigReader;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StoreEndPoints {


    public static Response placeAnOrder(Order payload) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Content-Type", "application/json");
        return given()
                .headers(headers)
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .body(payload)
                .when()
                .post(PropertiesConfigReader.getProperty("PLACE_ORDER_URL"));

    }

    public static Response getAnOrderById(int id) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("accept", "application/json");
        return given()
                .headers(headers)
                .pathParam("orderId",id)
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .when()
                .get(PropertiesConfigReader.getProperty("FIND_ORDER_BY_ID_URL"));

    }

    public static Response deleteAnOrderById(int id){
        Map<String, Object> headers = new HashMap<>();
        headers.put("accept", "application/json");
        return given()
                .headers(headers)
                .pathParam("orderId",id)
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .when()
                .delete(PropertiesConfigReader.getProperty("DELETE_ORDER_BY_ID_URL"));

    }

    public static Response returnPetInventory(){
        Map<String, Object> headers = new HashMap<>();
        headers.put("accept", "application/json");
        return given()
                .headers(headers)
                .baseUri(PropertiesConfigReader.getProperty("BASE_URL"))
                .when()
                .get(PropertiesConfigReader.getProperty("GET_PET_INVENTORY_URL"));

    }

}
