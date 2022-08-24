package repository;

import entity.ProductOrder;

import java.sql.SQLException;
import java.util.List;

public interface ProductOrderRepository {

    public List<ProductOrder> readAllProductOrder(long orderId) throws SQLException;

}
