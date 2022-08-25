package repository.implementation;

import entity.Order;
import repository.BaseRepository;
import repository.OrderRepository;
import service.ApplicationConstant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public void create(Order order) {


    }

    @Override
    public Order read(Long id) {
        Order resultOrder = new Order();
        String sqlQuery = """
                SELECT * FROM order_table
                WHERE id = ?
                """;

        try (PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sqlQuery)) {

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resultOrder = new Order(rs.getLong(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getLong(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultOrder;
    }

    @Override
    public void update(Order order) throws SQLException {
        String sqlQuery = """
                UPDATE order_table
                SET order_status = ? ,total_price=?
                WHERE id = ?
                """;
        PreparedStatement ps = ApplicationConstant.getConnection().prepareStatement(sqlQuery);
        ps.setBoolean(1, order.isOrderStatus());
        ps.setDouble(2, order.getTotalPrice());
        ps.setLong(3, order.getId());
        int check = ps.executeUpdate();
        if (check == 0) {
            throw new RuntimeException("Unsuccess Update!");
        }


    }

    @Override
    public void delete(Order order) throws SQLException {

        throw new RuntimeException();
    }


    @Override
    public Order fingOrderByCustomerId() {

        return null;

    }
}
