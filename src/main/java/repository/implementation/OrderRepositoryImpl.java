package repository.implementation;

import entity.Order;
import repository.BaseRepository;
import repository.OrderRepository;
import service.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepositoryImpl implements OrderRepository , BaseRepository<Order> {
    @Override
    public Order create(Order order) {

        return null;
    }

    @Override
    public Order read(Order order) throws SQLException {
        Order resultOrder = null;
        String sqlQuery = """
                SELECT * FROM order_table
                WHERE id = ?
                """;
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sqlQuery);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            resultOrder = new Order(rs.getLong(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getLong(4));
        }
            return resultOrder;
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(Order order) {

    }



    @Override
    public Order fingOrderByCustomerId() {

        return null;

    }
}
