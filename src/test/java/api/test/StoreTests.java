package api.test;

import api.payload.OrderSatus;
import api.payload.Store;
import api.utilities.FakeDataManager;
import api.utilities.JSONUtil;
import io.restassured.response.Response;
import org.joda.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static api.endpoints.StoreEndPoints.*;

public class StoreTests {

    static Store storePayload;

    @BeforeClass
    public void setup() {
        int id = FakeDataManager.getRandomID();
        int petId = FakeDataManager.getRandomID();
        int quantity = FakeDataManager.getRandomID();
        String date = String.valueOf(LocalDateTime.now());
        String status = OrderSatus.placed.toString();
        boolean complete = FakeDataManager.getRandomBoolean();
        storePayload = new Store(id, petId, quantity, date, status, complete);

    }

    @Test(priority = 1)
    public void testPlacingAnOrder() {
        Response response = placeAnOrder(JSONUtil.createJSON(storePayload.getId(), storePayload.getPetID(),
                storePayload.getQuantity(), storePayload.getDateTime(), storePayload.getStatus(), storePayload.isComplete()));
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);


    }

    @Test(priority = 2)
    public void testGettingAnOrderByID() {
        Response response = getAnOrderById(storePayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 3)
    public void testDeletingAnOrderByID() {
        Response response = deleteAnOrderById(storePayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 4)
    public void testReturningInventory() {
        Response response = returnPetInventory();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }


}
