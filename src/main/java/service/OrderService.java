package service;

import entity.Order;

public interface OrderService {
    public void setConfirm(Order order);
    public void setTotalPrice(Order order,double price);
}
