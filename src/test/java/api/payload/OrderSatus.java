package api.payload;

import java.util.Random;

public enum OrderSatus {
    placed, approved,delivered;

    private static final Random random = new Random();

    public static OrderSatus randomOrderSatus()  {
        OrderSatus[] orderStatus = values();
        return orderStatus[random.nextInt(orderStatus.length)];
    }
}
