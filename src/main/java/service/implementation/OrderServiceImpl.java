package service.implementation;

import entity.Order;
import repository.OrderRepository;
import repository.implementation.OrderRepositoryImpl;
import service.ApplicationConstant;
import service.OrderService;

import java.sql.SQLException;

public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository = new OrderRepositoryImpl();

    @Override
    public void setConfirm(Order order) {
        try {
            order.setOrderStatus(true);
            orderRepository.update(order);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setTotalPrice(Order order, double price) {
        try {
            order.setTotalPrice(price);
            orderRepository.update(order);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
