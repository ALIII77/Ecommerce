package repository.implementation;

import entity.ProductOrder;
import repository.BaseRepository;
import repository.ProductOrderRepository;
import service.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducOrderRepositoryImpl implements ProductOrderRepository , BaseRepository<ProductOrder> {


    @Override
    public ProductOrder create(ProductOrder productOrder) throws SQLException {
        return null;
    }

    @Override
    public ProductOrder read(ProductOrder productOrder) throws SQLException {
        return null;
    }

    @Override
    public void update(ProductOrder productOrder) {

    }

    @Override
    public void delete(ProductOrder productOrder) {

    }



    @Override
    public List<ProductOrder> readAllProductOrder(long orderId) throws SQLException {
        List<ProductOrder>resultProductOrder   =new ArrayList<>();


        String sql = """
                select * from product_order as po
                INNER JOIN product as p on p.id = po.product_id
                INNER JOIN order_table o on o.id = po.order_id
                where order_id =?
                """;
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            ProductOrder productOrder = new ProductOrder(rs.getLong("po.id"),
                    rs.getLong("order_id"),
                    rs.getLong("product_id"),
                    rs.getString("name"),
                    rs.getString("category"),
                    rs.getString("description"),
                    rs.getDouble("po.price"),
                    rs.getLong("count"));

            resultProductOrder.add(productOrder);
        }

        return resultProductOrder;


    }
}
