package api.payload;

import org.joda.time.DateTime;
public class Store {
    private int id;
    private int petID;
    private int quantity;
    private String dateTime;
    private String status;
    private boolean complete;

    public Store(int id, int petID, int quantity, String dateTime, String status, boolean complete) {
        this.id = id;
        this.petID = petID;
        this.quantity = quantity;
        this.dateTime = dateTime;
        this.status = status;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
