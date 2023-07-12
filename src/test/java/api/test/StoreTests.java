package api.test;

import api.payload.Order;
import api.utilities.FakeDataManager;
import io.restassured.response.Response;
import org.joda.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static api.endpoints.StoreEndPoints.*;
import static api.payload.OrderSatus.randomOrderSatus;

public class StoreTests {

    Order order;

    @BeforeClass
    public void setup() {
        int id = FakeDataManager.getRandomID();
        int petId = FakeDataManager.getRandomID();
        int quantity = FakeDataManager.getRandomID();
        String date = String.valueOf(LocalDateTime.now());
        String status = randomOrderSatus().toString();
        boolean complete = FakeDataManager.getRandomBoolean();
        order = new Order(id, petId, quantity, date, status, complete);

    }

    @Test(priority = 1)
    public void testPlacingAnOrder() {
        Response response = placeAnOrder(order);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);


    }

    @Test(priority = 2)
    public void testGettingAnOrderByID() {
        Response response = getAnOrderById(order.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 3)
    public void testDeletingAnOrderByID() {
        Response response = deleteAnOrderById(order.getId());
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
