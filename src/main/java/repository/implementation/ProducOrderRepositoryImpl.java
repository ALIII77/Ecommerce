package repository.implementation;

import entity.Product;
import entity.ProductOrder;
import repository.BaseRepository;
import repository.ProductOrderRepository;
import service.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class ProducOrderRepositoryImpl implements ProductOrderRepository  {

    @Override
    public void create(ProductOrder productOrder) throws SQLException {
        String sqlQuery= """
                INSERT INTO product_order (order_id,product_id,count,price)
                VALUES (?,?,?,?)
                
                """;
        PreparedStatement ps =ApplicationConstant.getConnection().prepareStatement(sqlQuery);
        ps.setLong(1,productOrder.getOrderId());
        ps.setLong(2,productOrder.getProductId());
        ps.setLong(3,productOrder.getCount());
        ps.setDouble(1,productOrder.getPrice());
        int check=ps.executeUpdate();
        if(check==0)
        {
           throw  new RuntimeException("Unsuccess add product to order!!");
        }

    }

    @Override
    public ProductOrder read(Long id)  {
        ProductOrder resultProductOrder = new ProductOrder();
        String sqlQuery= """
                SELECT * FROM  product_order
                """;

        try (PreparedStatement ps =ApplicationConstant.getConnection().prepareStatement(sqlQuery);){
            ResultSet rs =  ps.executeQuery();
            resultProductOrder.setOrderId(rs.getLong("order_id"));
            resultProductOrder.setProductId(rs.getLong("product_id"));
            resultProductOrder.setCount(rs.getLong("count"));
            resultProductOrder.setOrderId(rs.getLong("price"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultProductOrder;

    }

    @Override
    public void update(ProductOrder productOrder) throws SQLException {
        String sqlQuery = """
                UPDATE product_order
                SET order_id=? , product_id=? , count=? price = ?
                WHERE id=?
                """;
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sqlQuery);
        ps.setLong(1,productOrder.getOrderId());
        ps.setLong(2,productOrder.getProductId());
        ps.setLong(3,productOrder.getCount());
        ps.setDouble(4,productOrder.getPrice());
        ps.setLong(5,productOrder.getId());

        int check =ps.executeUpdate();
        if(check==0)
        {
            throw new RuntimeException("Unsuccess Update!!");
        }
        System.out.println("Order  Updated");

    }

    @Override
    public void delete(ProductOrder productOrder)  {
        String sqlQuery = """
                DELETE FROM product_order
                WHERE id = ? 
                """;

        try (PreparedStatement ps =ApplicationConstant.getConnection().prepareStatement(sqlQuery);){
            ps.setLong(1,productOrder.getId());
        } catch (SQLException e) {
            throw new RuntimeException("unsuccess delete ");
        }
    }
    @Override
    public void deleteAll(long id)
    {
        String sqlQuery = """ 
                DELETE FROM product_order
                WHERE order_id=? and order_status=true
                """;
        try(PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sqlQuery)) {
            ps.setLong(1,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
