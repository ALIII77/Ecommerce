package repository;

import entity.Product;
import entity.ProductOrder;

import java.sql.SQLException;
import java.util.List;

public interface ProductOrderRepository extends BaseRepository<ProductOrder,Long> {

    public List<ProductOrder> readAllProductOrder(long orderId) throws SQLException;

    public void deleteAll(long id);


}
