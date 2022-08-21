package entity;

import java.util.List;

public class Customer {
    private long id;
    private String username;
    private String password;
    private List<Order> orderList;



    public Customer() {
    }

    public Customer(long id, String username, String password, List<Order> orderList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.orderList = orderList;
    }


}
