package alkfejl.model;

import java.security.InvalidParameterException;
import java.time.LocalDate;

public class Order {

    private int ID;
    private String customer;
    private String tiltle;
    private int portion;
    private LocalDate delivery;
private String payment;

    public Order(int ID, String customer, String tiltle, int portion, LocalDate delivery, String payment) {
        this.ID = ID;
        this.customer = customer;
        this.tiltle = tiltle;
        this.portion = portion;
        this.delivery = delivery;
        this.payment = payment;
    }


    public Order(String customer, String tiltle, int portion, LocalDate delivery, String payment) {
        this.customer = customer;
        this.tiltle = tiltle;
        this.portion = portion;
        this.delivery = delivery;
        this.payment = payment;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getTiltle() {
        return tiltle;
    }

    public void setTiltle(String tiltle) {
        this.tiltle = tiltle;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        if (portion<1||portion>6){
            throw new InvalidParameterException("nem megfelelo adagot adtal meg. 1-6 kozott kell lennie");
        }
        this.portion = portion;
    }

    public LocalDate getDelivery() {
        return delivery;
    }

    public void setDelivery(LocalDate delivery) {
        this.delivery = delivery;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }


}
