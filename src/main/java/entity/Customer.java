package entity;

import java.util.List;

public class Customer {
    private long id;
    private String name;
    private String username;
    private String password;
    private List<Order> orderList;

    public Customer() {
    }
    public Customer(String username , String password)
    {
        this.username=username;
        this.password=password;
    }

    public Customer(long id, String username, String password, List<Order> orderList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.orderList = orderList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
