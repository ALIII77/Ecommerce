package entity;

import java.util.List;

public class Order {
    private long id;
    private boolean orderStatus; //okye  ba zabane eshare daram sohbat mikonam
    private List<Product> products;
    private double totalPrice;
    private long customer_id;

    public Order() {
    }

    public Order(long id, boolean orderStatus, List<Product> products, double totalPrice, long customer_id) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.products = products;
        this.totalPrice = totalPrice;
        this.customer_id = customer_id;
    }

    public Order(long id, String orderStatus, double totalPrice, long customer_id) {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Product> getDrugs() {
        return products;
    }

    public void setDrugs(List<Product> drugs) {
        this.products = drugs;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

}
